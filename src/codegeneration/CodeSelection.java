/**
 * Tutorial de Diseño de Lenguajes de Programación
 *
 * @author Raúl Izquierdo
 */

package codegeneration;

import ast.*;
import visitor.DefaultVisitor;

import java.io.PrintWriter;
import java.io.Writer;


public class CodeSelection extends DefaultVisitor {

    public CodeSelection(Writer writer, String sourceFile) {
        this.writer = new PrintWriter(writer);
        this.sourceFile = sourceFile;
    }


    // # ----------------------------------------------------------
    // ------------------      PROGRAMA       ---------------------

    @Override
    public Object visit(Programa node, Object param) {
        out("#source \"" + sourceFile + "\"");
        out("call main");
        out("halt");
        node.getDefiniciones().forEach(d -> d.accept(this, param));
        return null;
    }


    // # ----------------------------------------------------------
    // ----------------      DEFINICIONES       -------------------

    @Override
    public Object visit(DefinicionFuncion node, Object param) {
        out(node.getNombre() + ":");
        out("#func " + node.getNombre());

        node.getParams().forEach(s -> {
            out("#param " + s.getNombre() + " : "
                    + s.getTipo().accept(this, param));
        });

        out("#ret " + node.getTipo().accept(this, param));

        node.getVariablesLocales().forEach(s -> {
            out("#local " + s.getNombre() + " : "
                    + s.getTipo().accept(this, param));
        });

        int tamañoLocales;
        if (node.getVariablesLocales().isEmpty())
            tamañoLocales = 0;
        else
            tamañoLocales = node.getVariablesLocales().get(node.getVariablesLocales().size() - 1).getDireccion();
        out("enter " + Math.abs(tamañoLocales));

        int tamañoParams = node.getParams().stream().mapToInt(p -> p.getTipo().getTamaño()).sum();
        int tamañoReturn = node.getTipo().getTamaño();

        node.getSentencias().forEach(s -> s.accept(this, new int[]{tamañoReturn, tamañoLocales, tamañoParams}));

        if (node.getTipo() instanceof TipoVoid)
            out("ret "
                    + tamañoReturn
                    + ", " + Math.abs(tamañoLocales)
                    + ", " + tamañoParams);

        return null;
    }

    @Override
    public Object visit(DefinicionVariable node, Object param) {
        out("#global " + node.getNombre() + " : "
                + node.getTipo().accept(this, param));
        return null;
    }

    @Override
    public Object visit(DefinicionStruct node, Object param) {
        out("#type " + node.getNombre() + " : {");
        node.getCampos().forEach(c -> c.accept(this, param));
        out("}");
        return null;
    }

    @Override
    public Object visit(Campo node, Object param) {
        out("\t" + node.getNombre() + " : "
                + node.getTipo().accept(this, param));
        return null;
    }


    // # ----------------------------------------------------------
    // --------------------      TIPOS       ----------------------

    @Override
    public Object visit(TipoEntero node, Object param) {
        return "int";
    }

    @Override
    public Object visit(TipoReal node, Object param) {
        return "float";
    }

    @Override
    public Object visit(TipoChar node, Object param) {
        return "char";
    }

    @Override
    public Object visit(TipoArray node, Object param) {
        return node.getLongitud() + " * " + node.getTipo().accept(this, param);
    }

    @Override
    public Object visit(TipoStruct node, Object param) {
        return node.getNombre();
    }

    @Override
    public Object visit(TipoVoid node, Object param) {
        return "void";
    }


    // # ----------------------------------------------------------
    // -----------------      SENTENCIAS       --------------------

    @Override
    public Object visit(Print node, Object param) {
        line(node);
        node.getExpresion().accept(this, Funcion.VALOR);
        out("out" + node.getExpresion().getTipo().getSufijo());

        if (node.getTipo_print().equals("printsp")) {
            out("pushb 32");
            out("outb"); // imprime espacio
        } else if (node.getTipo_print().equals("println")) {
            out("pushb 10");
            out("outb"); // imprime salto de linea
        }
        return null;
    }

    @Override
    public Object visit(Read node, Object param) {
        line(node);
        node.getExpresion().accept(this, Funcion.DIRECCION);
        out("in" + node.getExpresion().getTipo().getSufijo());
        out("store" + node.getExpresion().getTipo().getSufijo());
        return null;
    }

    @Override
    public Object visit(Asignacion node, Object param) {
        line(node);
        node.getIzquierda().accept(this, Funcion.DIRECCION);
        node.getDerecha().accept(this, Funcion.VALOR);
        out("store" + node.getIzquierda().getTipo().getSufijo());

        return null;
    }

    @Override
    public Object visit(If node, Object param) {
        int etiqueta = getEtiquetas(2);

        node.getCondicion().accept(this, Funcion.VALOR);
        out("jnz e" + etiqueta);
        node.getFalso().forEach(s -> s.accept(this, param));
        out("jmp e" + etiqueta + 1);
        out("e" + etiqueta + ":");
        node.getVerdadero().forEach(s -> s.accept(this, param));
        out("e" + etiqueta + 1 + ":");

        return null;
    }

    @Override
    public Object visit(While node, Object param) {
        int etiqueta = getEtiquetas(2);

        out("e" + etiqueta + ":");
        node.getCondicion().accept(this, Funcion.VALOR);
        out("jz e" + etiqueta + 1);
        node.getSentencia().forEach(s -> s.accept(this, param));
        out("jmp e" + etiqueta);
        out("e" + etiqueta + 1 + ":");

        return null;
    }

    @Override
    public Object visit(Return node, Object param) {
        line(node);

        int[] retValues = (int[]) param;
        if (node.getExpresion().size() > 0) {
            node.getExpresion().get(0).accept(this, Funcion.VALOR);
            out("ret " + retValues[0] + ", " + Math.abs(retValues[1]) + ", " + retValues[2]);
        }

        return null;
    }

    @Override
    public Object visit(Invocacion node, Object param) {
        for (Expresion e : node.getParams()) {
            e.accept(this, Funcion.VALOR);
        }
        out("call " + node.getNombre());

        if (!(node.getDefinicion().getTipo() instanceof TipoVoid))
            out("pop" + node.getDefinicion().getTipo().getSufijo());

        return null;
    }


    // # ----------------------------------------------------------
    // ----------------      EXPRESIONES       --------------------

    @Override
    public Object visit(ConstanteEntero node, Object param) {
        switch ((Funcion) param) {
            case VALOR:
                out("push " + node.getValor());
                break;
        }
        return null;
    }

    @Override
    public Object visit(ConstanteReal node, Object param) {
        switch ((Funcion) param) {
            case VALOR:
                out("pushf " + node.getValor());
                break;
        }
        return null;
    }

    @Override
    public Object visit(ConstanteChar node, Object param) {
        switch ((Funcion) param) {
            case VALOR:
                out("pushb " + (int) node.getValor().substring(1, 2).charAt(0));
                break;
        }
        return null;
    }

    @Override
    public Object visit(Variable node, Object param) {
        switch ((Funcion) param) {
            case VALOR:
                node.accept(this, Funcion.DIRECCION);
                out("load" + node.getTipo().getSufijo());
                break;

            case DIRECCION:
                if (node.getDefinicion().getAmbito() != Ambito.GLOBAL) {
                    out("pusha BP");
                    out("push " + node.getDefinicion().getDireccion());
                    out("add");
                } else
                    out("push " + node.getDefinicion().getDireccion());
                break;
        }
        return null;
    }

    @Override
    public Object visit(ExpresionAritmetica node, Object param) {
        switch ((Funcion) param) {
            case VALOR:
                node.getIzq().accept(this, Funcion.VALOR);
                node.getDer().accept(this, Funcion.VALOR);

                if (node.getOperador().equals("+"))
                    out("add" + node.getTipo().getSufijo());
                else if (node.getOperador().equals("-"))
                    out("sub" + node.getTipo().getSufijo());
                else if (node.getOperador().equals("*"))
                    out("mul" + node.getTipo().getSufijo());
                else if (node.getOperador().equals("/"))
                    out("div" + node.getTipo().getSufijo());
                else if (node.getOperador().equals("%"))
                    out("mod");
        }
        return null;
    }

    @Override
    public Object visit(ExpresionLogica node, Object param) {
        switch ((Funcion) param) {
            case VALOR:
                node.getIzq().accept(this, Funcion.VALOR);
                node.getDer().accept(this, Funcion.VALOR);

                if (node.getOperador().equals("&&"))
                    out("and");
                else if (node.getOperador().equals("||"))
                    out("or");

                break;
        }
        return null;
    }

    @Override
    public Object visit(Comparacion node, Object param) {
        switch ((Funcion) param) {
            case VALOR:
                node.getIzq().accept(this, Funcion.VALOR);
                node.getDer().accept(this, Funcion.VALOR);

                if (node.getOperador().equals("<"))
                    out("lt" + node.getIzq().getTipo().getSufijo());
                else if (node.getOperador().equals(">"))
                    out("gt" + node.getIzq().getTipo().getSufijo());
                else if (node.getOperador().equals(">=")) {
                    out("gt" + node.getIzq().getTipo().getSufijo());
                    node.getIzq().accept(this, Funcion.VALOR);
                    node.getDer().accept(this, Funcion.VALOR);
                    out("eq" + node.getIzq().getTipo().getSufijo());
                    out("or");
                } else if (node.getOperador().equals("<=")) {
                    out("lt" + node.getIzq().getTipo().getSufijo());
                    node.getIzq().accept(this, Funcion.VALOR);
                    node.getDer().accept(this, Funcion.VALOR);
                    out("eq" + node.getIzq().getTipo().getSufijo());
                    out("or");
                } else if (node.getOperador().equals("=="))
                    out("eq" + node.getIzq().getTipo().getSufijo());
                else if (node.getOperador().equals("!="))
                    out("neq" + node.getIzq().getTipo().getSufijo());

                break;
        }
        return null;
    }

    @Override
    public Object visit(ExpresionUnaria node, Object param) {
        switch ((Funcion) param) {
            case VALOR:
                node.getExpresion().accept(this, Funcion.VALOR);
                out("not");
                break;
        }
        return null;
    }

    @Override
    public Object visit(Conversion node, Object param) {
        switch ((Funcion) param) {
            case VALOR:
                node.getExpresion().accept(this, Funcion.VALOR);
                if (node.getExpresion().getTipo() instanceof TipoEntero) {
                    if (node.getNuevoTipo() instanceof TipoReal)
                        out("i2f");
                    if (node.getNuevoTipo() instanceof TipoChar)
                        out("i2b");
                } else if (node.getExpresion().getTipo() instanceof TipoReal) {
                    if (node.getNuevoTipo() instanceof TipoEntero)
                        out("f2i");
                    if (node.getNuevoTipo() instanceof TipoChar) {
                        out("f2i");
                        out("i2b");
                    }
                } else if (node.getExpresion().getTipo() instanceof TipoChar) {
                    if (node.getNuevoTipo() instanceof TipoEntero)
                        out("b2i");
                    if (node.getNuevoTipo() instanceof TipoReal) {
                        out("b2i");
                        out("i2f");
                    }
                }
                break;
        }
        return null;
    }

    @Override
    public Object visit(InvocacionExpresion node, Object param) {
        switch ((Funcion) param) {
            case VALOR:
                for (Expresion e : node.getParams()) {
                    e.accept(this, Funcion.VALOR);
                }
                out("call " + node.getNombre());
                break;
        }
        return null;
    }

    @Override
    public Object visit(AccesoArray node, Object param) {
        switch ((Funcion) param) {
            case VALOR:
                node.accept(this, Funcion.DIRECCION);
                out("load" + node.getTipo().getSufijo());
                break;

            case DIRECCION:
                node.getArray().accept(this, Funcion.DIRECCION);
                node.getIndice().accept(this, Funcion.VALOR);
                out("push " + node.getTipo().getTamaño());
                out("mul");
                out("add");
                break;
        }
        return null;
    }

    @Override
    public Object visit(AccesoCampo node, Object param) {
        switch ((Funcion) param) {
            case VALOR:
                node.accept(this, Funcion.DIRECCION);
                out("load" + node.getTipo().getSufijo());
                break;

            case DIRECCION:
                node.getStruct().accept(this, Funcion.DIRECCION);
                TipoStruct tipo = (TipoStruct) node.getStruct().getTipo();
                Variable campo = (Variable) node.getCampo();
                out("push " + tipo.getCampo(campo.getNombre()).getDireccion());
                out("add");
                break;
        }
        return null;
    }

    // # ----------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    public enum Funcion {
        DIRECCION, VALOR, EJECUTAR;
    }

    static private int etiquetas = 1;

    static public int getEtiquetas(int numero) {
        int temp = etiquetas;
        etiquetas += numero;
        return temp;
    }

    // Imprime una línea en el fichero de salida
    private void out(String instruction) {
        writer.println(instruction);
    }

    private void line(AST node) {
        line(node.getEnd());
    }

    private void line(Position pos) {
        if (pos != null)
            out("\n#line " + pos.getLine());
        else
            System.out.println("#line no generado. Se ha pasado una Position null. Falta información en el AST");
    }

    private PrintWriter writer;
    private String sourceFile;
}
