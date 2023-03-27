package visitor;

import ast.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextVisitor extends DefaultVisitor {

    private static String ls = System.getProperty("line.separator");
    private static PrintWriter writer;

    private TextVisitor(PrintWriter writer, List<String> sourceLines) {
        this.writer = writer;
    }

    public static void toText(String inputFile, AST raiz, String filename) {
        try {
            PrintWriter writer = new PrintWriter(
                    new FileWriter(filename.endsWith(".txt") ? filename : filename + ".txt"));
            writer.println("[TextVisitor]");
            if (raiz != null) {
                TextVisitor tracer = new TextVisitor(writer, loadLines(inputFile, 4));
                raiz.accept(tracer, Integer.valueOf(0));
            } else
                writer.println("raiz == null");
            writer.println(ls + ls + "[TextVisitor]");
            writer.close();
            System.out.println(ls + "TextVisitor: Fichero '" + filename
                    + ".txt' generado. Abra dicho fichero para validar el AST generado.");
        } catch (IOException e) {
            System.out.println(ls + "TextVisitor: No se ha podido crear el fichero " + filename);
            e.printStackTrace();
        }
    }

    private static List<String> loadLines(String sourceFile, int tabWidth) {
        if (sourceFile == null)
            return null;
        try {
            String spaces = new String(new char[tabWidth]).replace("\0", " ");

            List<String> lines = new ArrayList<String>();
            BufferedReader br = new BufferedReader(new FileReader(sourceFile));
            String line;
            while ((line = br.readLine()) != null) {
                //	lines.add(line.replace("\t", spaces)); // Si tab = 4 espaces (Eclipse)
                lines.add(line);
            }
            br.close();
            return lines;
        } catch (FileNotFoundException e) {
            System.out.println("Warning. No se pudo encontrar el fichero fuente '" + sourceFile);
            return null;
        } catch (IOException e) {
            System.out.println("Warning. Error al leer del fichero fuente '" + sourceFile);
            return null;
        }
    }

    public static void printIndent(int indentation, String string) {
        for (int i = 0; i < indentation; i++) {
            writer.print("\t");
        }
        writer.print(string);
    }

    //	class Programa { List<DefinicionVariable> variables;  List<DefinicionStruct> structs;  List<DefinicionFuncion> funciones; }
    public Object visit(Programa node, Object param) {

        // super.visit(node, param);
        for (Definicion def : node.getDefiniciones()) {
            if (def instanceof DefinicionVariable) {
                printIndent(0, "var ");
                def.accept(this, 0);
                printIndent(0, ";\n");
            } else
                def.accept(this, 0);
        }

        return null;
    }

    //	class DefinicionFuncion { String nombre;  List<DefinicionVariable> params;  Tipo tipo;  List<DefinicionVariable> variablesLocales;  List<Sentencia> sentencia; }
    public Object visit(DefinicionFuncion node, Object param) {

        // super.visit(node, param);
        printIndent((Integer) param, node.getNombre());
        printIndent(0, "(");

        if (node.getParams() != null && !node.getParams().isEmpty()) {
            for (int i = 0; i < node.getParams().size() - 1; i++) {
                node.getParams().get(i).accept(this, param);
                printIndent(0, ", ");
            }
            node.getParams().get(node.getParams().size() - 1).accept(this, param);
        }

        printIndent(0, ")");

        if (node.getTipo() != null) {
            if (!(node.getTipo() instanceof TipoVoid))
                printIndent(0, ":");
            node.getTipo().accept(this, param);
        }

        printIndent((Integer) param, "{\n");

        if (node.getVariablesLocales() != null)
            for (DefinicionVariable child : node.getVariablesLocales()) {
                printIndent((Integer) param + 1, "var ");
                child.accept(this, 0);
                printIndent(0, ";\n");
            }

        if (node.getSentencias() != null)
            for (Sentencia child : node.getSentencias()) {
                child.accept(this, (Integer) (param) + 1);
            }

        printIndent((Integer) param, "\n}\n");
        return null;
    }

    //	class DefinicionVariable { String nombre;  Tipo tipo; }
    public Object visit(DefinicionVariable node, Object param) {

        // super.visit(node, param);
        printIndent((Integer) param, node.getNombre());
        printIndent(0, ":");
        if (node.getTipo() != null)
            node.getTipo().accept(this, 0);

        return null;
    }

    //	class DefinicionStruct { String nombre;  List<DefinicionVariable> campos; }
    public Object visit(DefinicionStruct node, Object param) {

        // super.visit(node, param);
        printIndent((Integer) param, "struct ");
        printIndent((Integer) param, node.getNombre());
        printIndent((Integer) param, "{\n");

        for (DefinicionCampo child : node.getCampos()) {
            child.accept(this, (Integer) param + 1);
            printIndent(0, ";\n");
        }

        printIndent((Integer) param, "};\n");
        return null;
    }

    public Object visit(DefinicionCampo node, Object param) {
        printIndent((Integer) param, node.getNombre());
        printIndent(0, ":");
        if (node.getTipo() != null)
            node.getTipo().accept(this, 0);

        return null;
    }

    //	class TipoEntero {  }
    public Object visit(TipoEntero node, Object param) {
        printIndent((Integer) param, "int");
        return null;
    }

    //	class TipoReal {  }
    public Object visit(TipoReal node, Object param) {
        printIndent((Integer) param, "float");
        return null;
    }

    //	class TipoChar {  }
    public Object visit(TipoChar node, Object param) {
        printIndent((Integer) param, "char");
        return null;
    }

    //	class TipoArray { int longitud;  Tipo tipo; }
    public Object visit(TipoArray node, Object param) {

        // super.visit(node, param);
        printIndent((Integer) param, "[");
        printIndent(0, node.getLongitud() + "");
        printIndent(0, "]");
        if (node.getTipo() != null)
            node.getTipo().accept(this, param);

        return null;
    }

    //	class TipoStruct { String nombre; }
    public Object visit(TipoStruct node, Object param) {
        printIndent((Integer) param, node.getNombre());
        return null;
    }

    //	class TipoVoid {  }
    public Object visit(TipoVoid node, Object param) {
        return null;
    }

    //	class Print { Expresion expresion;  String tipo_print; }
    public Object visit(Print node, Object param) {

        // super.visit(node, param);
        printIndent((Integer) param, node.getTipo_print() + " ");

        if (node.getExpresion() != null)
            node.getExpresion().accept(this, 0);

        printIndent(0, ";\n");
        return null;
    }

    //	class Read { Expresion expresion; }
    public Object visit(Read node, Object param) {

        // super.visit(node, param);
        printIndent((Integer) param, "read ");

        if (node.getExpresion() != null)
            node.getExpresion().accept(this, 0);

        printIndent(0, ";\n");
        return null;
    }

    //	class Asignacion { Expresion izquierda;  Expresion derecha; }
    public Object visit(Asignacion node, Object param) {

        // super.visit(node, param);
        printIndent((Integer) param, "");

        if (node.getIzquierda() != null)
            node.getIzquierda().accept(this, param);

        printIndent(0, " = ");

        if (node.getDerecha() != null)
            node.getDerecha().accept(this, 0);

        printIndent(0, ";\n");
        return null;
    }

    //	class If { Expresion condicion;  List<Sentencia> verdadero;  List<Sentencia> falso; }
    public Object visit(If node, Object param) {

        // super.visit(node, param);

        printIndent((Integer) param, "if(");

        if (node.getCondicion() != null)
            node.getCondicion().accept(this, 0);

        printIndent(0, ")");
        printIndent(0, "{\n");

        if (node.getVerdadero() != null)
            for (Sentencia child : node.getVerdadero()) {
                child.accept(this, (Integer) param + 1);
            }

        printIndent((Integer) param, "}");

        if (!node.getFalso().isEmpty()) {
            printIndent(0, " else {\n");
            for (Sentencia child : node.getFalso()) {
                child.accept(this, (Integer) param + 1);
            }
            printIndent((Integer) param, "}\n");
        }

        return null;
    }

    //	class While { Expresion condicion;  List<Sentencia> sentencia; }
    public Object visit(While node, Object param) {

        // super.visit(node, param);
        printIndent((Integer) param, "while(");

        if (node.getCondicion() != null)
            node.getCondicion().accept(this, 0);

        printIndent(0, ")");
        printIndent(0, "{\n");

        if (node.getSentencia() != null)
            for (Sentencia child : node.getSentencia()) {
                child.accept(this, (Integer) param + 1);
            }

        printIndent((Integer) param, "}\n");
        return null;
    }

    //	class Invocacion { String nombre;  List<Expresion> params; }
    public Object visit(Invocacion node, Object param) {

        // super.visit(node, param);

        printIndent((Integer) param, node.getNombre() + "(");

        if (node.getParams() != null && !node.getParams().isEmpty()) {
            for (int i = 0; i < node.getParams().size() - 1; i++) {
                node.getParams().get(i).accept(this, param);
                printIndent(0, ", ");
            }
            node.getParams().get(node.getParams().size() - 1).accept(this, param);
        }

        printIndent(0, ");\n");
        return null;
    }

    //	class Return { List<Expresion> expresion; }
    public Object visit(Return node, Object param) {

        // super.visit(node, param);
        printIndent((Integer) param, "return ");

        if (node.getExpresion() != null)
            for (Expresion child : node.getExpresion())
                child.accept(this, param);

        printIndent(0, ";\n");
        return null;
    }

    //	class ConstanteEntero { int valor; }
    public Object visit(ConstanteEntero node, Object param) {
        printIndent(0, node.getValor() + "");
        return null;
    }

    //	class ConstanteReal { double valor; }
    public Object visit(ConstanteReal node, Object param) {
        printIndent(0, node.getValor() + "");
        return null;
    }

    //	class ConstanteChar { String valor; }
    public Object visit(ConstanteChar node, Object param) {
        printIndent(0, node.getValor());
        return null;
    }

    //	class Variable { String nombre; }
    public Object visit(Variable node, Object param) {
        printIndent(0, node.getNombre());
        return null;
    }

    //	class ExpresionBinaria { Expresion izq;  String operador;  Expresion der; }
    public Object visit(ExpresionAritmetica node, Object param) {

        // super.visit(node, param);
        printIndent(0, "(");

        if (node.getIzq() != null)
            node.getIzq().accept(this, param);

        printIndent(0, node.getOperador());

        if (node.getDer() != null)
            node.getDer().accept(this, param);

        printIndent(0, ")");
        return null;
    }

    public Object visit(ExpresionLogica node, Object param) {

        // super.visit(node, param);
        printIndent(0, "(");

        if (node.getIzq() != null)
            node.getIzq().accept(this, param);

        printIndent(0, node.getOperador());

        if (node.getDer() != null)
            node.getDer().accept(this, param);

        printIndent(0, ")");
        return null;
    }

    //	class ExpresionUnaria { Expresion expresion;  String operador; }
    public Object visit(ExpresionUnaria node, Object param) {

        // super.visit(node, param);
        printIndent(0, node.getOperador());
        if (node.getExpresion() != null)
            node.getExpresion().accept(this, param);

        return null;
    }

    //	class Conversion { Tipo tipo;  Expresion expresion; }
    public Object visit(Conversion node, Object param) {

        // super.visit(node, param);
        printIndent(0, "<");

        if (node.getNuevoTipo() != null)
            node.getNuevoTipo().accept(this, param);

        printIndent(0, ">(");

        if (node.getExpresion() != null)
            node.getExpresion().accept(this, param);

        printIndent(0, ")");
        return null;
    }

    //	class InvocacionExpresion { String nombre;  List<Expresion> params; }
    public Object visit(InvocacionExpresion node, Object param) {

        // super.visit(node, param);
        printIndent(0, node.getNombre() + "(");

        if (node.getParams() != null && !node.getParams().isEmpty()) {
            for (int i = 0; i < node.getParams().size() - 1; i++) {
                node.getParams().get(i).accept(this, param);
                printIndent(0, ", ");
            }
            node.getParams().get(node.getParams().size() - 1).accept(this, param);
        }

        printIndent(0, ")");
        return null;
    }

    //	class AccesoArray { Expresion array;  Expresion indice; }
    public Object visit(AccesoArray node, Object param) {

        // super.visit(node, param);

        if (node.getArray() != null)
            node.getArray().accept(this, 0);

        printIndent(0, "[");
        if (node.getIndice() != null)
            node.getIndice().accept(this, 0);
        printIndent(0, "]");

        return null;
    }

    //	class AccesoCampo { Expresion struct;  Expresion campo; }
    public Object visit(AccesoCampo node, Object param) {

        // super.visit(node, param);

        if (node.getStruct() != null)
            node.getStruct().accept(this, 0);
        printIndent(0, ".");
        if (node.getCampo() != null)
            node.getCampo().accept(this, 0);

        return null;
    }
}
