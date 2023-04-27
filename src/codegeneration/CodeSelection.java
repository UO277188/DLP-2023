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
        out("#source "+sourceFile);
        out("call main");
        out("halt");
        node.getDefiniciones().forEach(d -> d.accept(this, param));
        return null;
    }


    // # ----------------------------------------------------------
    // ----------------      DEFINICIONES       -------------------

    @Override
    public Object visit(DefinicionFuncion node, Object param) {
        node.getSentencias().forEach(s -> s.accept(this, null));
        return null;
    }


    // # ----------------------------------------------------------
    // -----------------      SENTENCIAS       --------------------

    @Override
    public Object visit(Print node, Object param) {
        line(node);
        out("out");
        out(node.getExpresion().getTipo().getSufijo());
        node.getExpresion().accept(this, Funcion.VALUE);

        if (node.getTipo_print().equals("printsp"))
            out("outb 32"); // imprime espacio
        else if (node.getTipo_print().equals("println"))
            out("outb 10"); // imprime salto de linea

        return null;
    }

    @Override
    public Object visit(Read node, Object param) {
        line(node);
        out("in" + node.getExpresion().getTipo().getSufijo());

        return null;
    }

    @Override
    public Object visit(Asignacion node, Object param) {
        line(node);
        node.getIzquierda().accept(this, Funcion.ADDRESS);
        node.getDerecha().accept(this, Funcion.VALUE);
        out("store" + node.getIzquierda().getTipo().getSufijo());

        return null;
    }

    @Override
    public Object visit(Invocacion node, Object param) {
        for (Expresion e : node.getParams()) {
            e.accept(this, Funcion.VALUE);
        }
        out("call " + node.getNombre());

        return null;
    }

    // # ----------------------------------------------------------
    // ----------------      EXPRESIONES       --------------------

    @Override
    public Object visit(ConstanteEntero node, Object param) {
        switch ((Funcion) param) {
            case VALUE:
                out("push " + node.getValor());
                break;
        }
        return null;
    }

    @Override
    public Object visit(ConstanteReal node, Object param) {
        switch ((Funcion) param) {
            case VALUE:
                out("pushf " + node.getValor());
                break;
        }
        return null;
    }

    @Override
    public Object visit(ConstanteChar node, Object param) {
        switch ((Funcion) param) {
            case VALUE:
                out("pushb " + node.getValor());
                break;
        }
        return null;
    }

    @Override
    public Object visit(ExpresionAritmetica node, Object param) {
        switch ((Funcion) param) {
            case VALUE:
                node.getIzq().accept(this, Funcion.VALUE);
                node.getDer().accept(this, Funcion.VALUE);

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
            case VALUE:
                node.getIzq().accept(this, Funcion.VALUE);
                node.getDer().accept(this, Funcion.VALUE);

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
            case VALUE:
                node.getIzq().accept(this, Funcion.VALUE);
                node.getDer().accept(this, Funcion.VALUE);

                if (node.getOperador().equals("<"))
                    out("lt");
                else if (node.getOperador().equals(">"))
                    out("gt");
                else if (node.getOperador().equals(">=")) {
                    out("gt");
                    node.getIzq().accept(this, Funcion.VALUE);
                    node.getDer().accept(this, Funcion.VALUE);
                    out("eq");
                    out("or");
                } else if (node.getOperador().equals("<=")) {
                    out("lt");
                    node.getIzq().accept(this, Funcion.VALUE);
                    node.getDer().accept(this, Funcion.VALUE);
                    out("eq");
                    out("or");
                }
                break;
        }
        return null;
    }

    @Override
    public Object visit(ExpresionUnaria node, Object param) {
        switch ((Funcion) param) {
            case VALUE:
                node.getExpresion().accept(this, Funcion.VALUE);
                out("not");
                break;
        }
        return null;
    }

    @Override
    public Object visit(Conversion node, Object param) {
        switch ((Funcion) param) {
            case VALUE:
                node.getExpresion().accept(this, Funcion.VALUE);
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
            case VALUE:
                for (Expresion e : node.getParams()) {
                    e.accept(this, Funcion.VALUE);
                }
                out("call " + node.getNombre());
                break;
        }
        return null;
    }

    @Override
    public Object visit(AccesoArray node, Object param) {
        switch ((Funcion) param) {
            case VALUE:
                node.accept(this, Funcion.ADDRESS);
                out("load" + node.getTipo().getSufijo());
                break;
        }
        return null;
    }

    @Override
    public Object visit(AccesoCampo node, Object param) {
        switch ((Funcion) param) {
            case VALUE:
                node.accept(this, Funcion.ADDRESS);
                out("load" + node.getTipo().getSufijo());
                break;
        }
        return null;
    }

    // # ----------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    public enum Funcion {
        ADDRESS, VALUE, EXECUTE;
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
