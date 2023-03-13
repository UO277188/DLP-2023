package visitor;

import ast.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextVisitor extends DefaultVisitor {

    private List<String> sourceLines;
    private static String ls = System.getProperty("line.separator");
    private PrintWriter writer;

    private TextVisitor(PrintWriter writer, List<String> sourceLines) {
        this.writer = writer;
        this.sourceLines = sourceLines;
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

    //	class Programa { List<DefinicionVariable> variables;  List<DefinicionStruct> structs;  List<DefinicionFuncion> funciones; }
    public Object visit(Programa node, Object param) {

        // super.visit(node, param);

        if (node.getVariables() != null)
            for (DefinicionVariable child : node.getVariables()) {
                child.accept(this, param);
                writer.print(";\n");
            }

        if (node.getStructs() != null)
            for (DefinicionStruct child : node.getStructs())
                child.accept(this, param);

        if (node.getFunciones() != null)
            for (DefinicionFuncion child : node.getFunciones())
                child.accept(this, param);

        return null;
    }

    //	class DefinicionFuncion { String nombre;  List<DefinicionVariable> params;  Tipo tipo;  List<DefinicionVariable> variablesLocales;  List<Sentencia> sentencia; }
    public Object visit(DefinicionFuncion node, Object param) {

        // super.visit(node, param);
        writer.print(node.getNombre());
        writer.print("(");

        if (node.getParams() != null)
            for (DefinicionVariable child : node.getParams()) {
                child.accept(this, param);
                writer.print(", ");
            }

        writer.print(")");

        if (node.getTipo() != null) {
            if(!(node.getTipo() instanceof TipoVoid))
                writer.print(":");
            node.getTipo().accept(this, param);
        }

        writer.print("{\n");

        if (node.getVariablesLocales() != null)
            for (DefinicionVariable child : node.getVariablesLocales()) {
                writer.print("\t");
                child.accept(this, param);
                writer.print(";\n");
            }

        if (node.getSentencia() != null)
            for (Sentencia child : node.getSentencia()) {
                writer.print("\t");
                child.accept(this, param);
            }

        writer.print("}\n");
        return null;
    }

    //	class DefinicionVariable { String nombre;  Tipo tipo; }
    public Object visit(DefinicionVariable node, Object param) {

        // super.visit(node, param);
        writer.print(node.getNombre());
        writer.print(":");
        if (node.getTipo() != null)
            node.getTipo().accept(this, param);

        return null;
    }

    //	class DefinicionStruct { String nombre;  List<DefinicionVariable> campos; }
    public Object visit(DefinicionStruct node, Object param) {

        // super.visit(node, param);
        writer.print("struct ");
        writer.print(node.getNombre());
        writer.print("{\n");

        if (node.getCampos() != null)
            for (DefinicionVariable child : node.getCampos()) {
                writer.print("\t");
                child.accept(this, param);
                writer.print(";\n");
            }

        writer.print("}\n");
        return null;
    }

    //	class TipoEntero {  }
    public Object visit(TipoEntero node, Object param) {
        writer.print("int");
        return null;
    }

    //	class TipoReal {  }
    public Object visit(TipoReal node, Object param) {
        writer.print("float");
        return null;
    }

    //	class TipoChar {  }
    public Object visit(TipoChar node, Object param) {
        writer.print("char");
        return null;
    }

    //	class TipoArray { int longitud;  Tipo tipo; }
    public Object visit(TipoArray node, Object param) {

        // super.visit(node, param);

        if (node.getTipo() != null)
            node.getTipo().accept(this, param);

        return null;
    }

    //	class TipoStruct { String nombre; }
    public Object visit(TipoStruct node, Object param) {
        writer.print(node.getNombre());
        return null;
    }

    //	class TipoVoid {  }
    public Object visit(TipoVoid node, Object param) {
        return null;
    }

    //	class Print { Expresion expresion;  String tipo_print; }
    public Object visit(Print node, Object param) {

        // super.visit(node, param);
        writer.print(node.getTipo_print()+" ");

        if (node.getExpresion() != null)
            node.getExpresion().accept(this, param);

        writer.print(";\n");
        return null;
    }

    //	class Read { Expresion expresion; }
    public Object visit(Read node, Object param) {

        // super.visit(node, param);
        writer.print("read ");

        if (node.getExpresion() != null)
            node.getExpresion().accept(this, param);

        writer.print(";\n");
        return null;
    }

    //	class Asignacion { Expresion izquierda;  Expresion derecha; }
    public Object visit(Asignacion node, Object param) {

        // super.visit(node, param);

        if (node.getIzquierda() != null)
            node.getIzquierda().accept(this, param);

        writer.print(" = ");

        if (node.getDerecha() != null)
            node.getDerecha().accept(this, param);

        writer.print(";\n");
        return null;
    }

    //	class If { Expresion condicion;  List<Sentencia> verdadero;  List<Sentencia> falso; }
    public Object visit(If node, Object param) {

        // super.visit(node, param);

        writer.print("if(");

        if (node.getCondicion() != null)
            node.getCondicion().accept(this, param);

        writer.print(")");
        writer.print("{\n");

        if (node.getVerdadero() != null)
            for (Sentencia child : node.getVerdadero()) {
                writer.print("\t");
                child.accept(this, param);
            }

        writer.print("\n}");

        if (node.getFalso() != null) {
            writer.print(" else {\n");
            for (Sentencia child : node.getFalso()) {
                writer.print("\t");
                child.accept(this, param);
            }
            writer.print("}\n");
        }

        return null;
    }

    //	class While { Expresion condicion;  List<Sentencia> sentencia; }
    public Object visit(While node, Object param) {

        // super.visit(node, param);
        writer.print("while(");

        if (node.getCondicion() != null)
            node.getCondicion().accept(this, param);

        writer.print(")");
        writer.print("{\n");

        if (node.getSentencia() != null)
            for (Sentencia child : node.getSentencia()) {
                writer.print("\t");
                child.accept(this, param);
            }

        writer.print("}\n");
        return null;
    }

    //	class Invocacion { String nombre;  List<Expresion> params; }
    public Object visit(Invocacion node, Object param) {

        // super.visit(node, param);

        writer.print(node.getNombre() + "(");

        if (node.getParams() != null)
            for (Expresion child : node.getParams())
                child.accept(this, param);

        writer.print(");");
        return null;
    }

    //	class Return { List<Expresion> expresion; }
    public Object visit(Return node, Object param) {

        // super.visit(node, param);
        writer.print("return ");

        if (node.getExpresion() != null)
            for (Expresion child : node.getExpresion())
                child.accept(this, param);

        writer.print(";\n");
        return null;
    }

    //	class ConstanteEntero { int valor; }
    public Object visit(ConstanteEntero node, Object param) {
        writer.print(node.getValor());
        return null;
    }

    //	class ConstanteReal { double valor; }
    public Object visit(ConstanteReal node, Object param) {
        writer.print(node.getValor());
        return null;
    }

    //	class ConstanteChar { String valor; }
    public Object visit(ConstanteChar node, Object param) {
        writer.print(node.getValor());
        return null;
    }

    //	class Variable { String nombre; }
    public Object visit(Variable node, Object param) {
        writer.print(node.getNombre());
        return null;
    }

    //	class ExpresionBinaria { Expresion izq;  String operador;  Expresion der; }
    public Object visit(ExpresionBinaria node, Object param) {

        // super.visit(node, param);
        writer.print("(");

        if (node.getIzq() != null)
            node.getIzq().accept(this, param);

        writer.print(node.getOperador());

        if (node.getDer() != null)
            node.getDer().accept(this, param);

        writer.print(")");
        return null;
    }

    //	class ExpresionUnaria { Expresion expresion;  String operador; }
    public Object visit(ExpresionUnaria node, Object param) {

        // super.visit(node, param);
        writer.print(node.getOperador());
        if (node.getExpresion() != null)
            node.getExpresion().accept(this, param);

        return null;
    }

    //	class Conversion { Tipo tipo;  Expresion expresion; }
    public Object visit(Conversion node, Object param) {

        // super.visit(node, param);
        writer.print("<");

        if (node.getTipo() != null)
            node.getTipo().accept(this, param);

        writer.print(">(");

        if (node.getExpresion() != null)
            node.getExpresion().accept(this, param);

        writer.print(")");
        return null;
    }

    //	class InvocacionExpresion { String nombre;  List<Expresion> params; }
    public Object visit(InvocacionExpresion node, Object param) {

        // super.visit(node, param);
        writer.print(node.getNombre() + "(");

        if (node.getParams() != null)
            for (Expresion child : node.getParams())
                child.accept(this, param);

        writer.print(")");
        return null;
    }

    //	class AccesoArray { Expresion array;  Expresion indice; }
    public Object visit(AccesoArray node, Object param) {

        // super.visit(node, param);

        if (node.getArray() != null)
            node.getArray().accept(this, param);

        writer.print("[");
        if (node.getIndice() != null)
            node.getIndice().accept(this, param);
        writer.print("]");

        return null;
    }

    //	class AccesoCampo { Expresion struct;  Expresion campo; }
    public Object visit(AccesoCampo node, Object param) {

        // super.visit(node, param);

        if (node.getStruct() != null)
            node.getStruct().accept(this, param);
        writer.print(".");
        if (node.getCampo() != null)
            node.getCampo().accept(this, param);

        return null;
    }
}
