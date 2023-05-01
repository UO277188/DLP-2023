/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;

import ast.*;

import java.util.List;

/*
DefaultVisitor. Implementación base del visitor para ser derivada por nuevos visitor.
    No modificar esta clase. Para crear nuevos visitor usar el fichero "_PlantillaParaVisitors.txt".
    DefaultVisitor ofrece una implementación por defecto de cada nodo que se limita a visitar los nodos hijos.
*/
public class DefaultVisitor implements Visitor {

    //	class Programa { List<Definicion> definiciones; }
    public Object visit(Programa node, Object param) {
        visitChildren(node.getDefiniciones(), param);
        return null;
    }

    //	class DefinicionFuncion { String nombre;  List<DefinicionVariable> params;  Tipo tipo;  List<DefinicionVariable> variablesLocales;  List<Sentencia> sentencias; }
    public Object visit(DefinicionFuncion node, Object param) {
        visitChildren(node.getParams(), param);
        if (node.getTipo() != null)
            node.getTipo().accept(this, param);
        visitChildren(node.getVariablesLocales(), param);
        visitChildren(node.getSentencias(), param);
        return null;
    }

    //	class DefinicionVariable { String nombre;  Tipo tipo; }
    public Object visit(DefinicionVariable node, Object param) {
        if (node.getTipo() != null)
            node.getTipo().accept(this, param);
        return null;
    }

    //	class DefinicionStruct { String nombre;  List<Campo> campos; }
    public Object visit(DefinicionStruct node, Object param) {
        visitChildren(node.getCampos(), param);
        return null;
    }

    //	class Campo { String nombre;  Tipo tipo; }
    public Object visit(Campo node, Object param) {
        if (node.getTipo() != null)
            node.getTipo().accept(this, param);
        return null;
    }

    //	class TipoEntero {  }
    public Object visit(TipoEntero node, Object param) {
        return null;
    }

    //	class TipoReal {  }
    public Object visit(TipoReal node, Object param) {
        return null;
    }

    //	class TipoChar {  }
    public Object visit(TipoChar node, Object param) {
        return null;
    }

    //	class TipoArray { int longitud;  Tipo tipo; }
    public Object visit(TipoArray node, Object param) {
        if (node.getTipo() != null)
            node.getTipo().accept(this, param);
        return null;
    }

    //	class TipoStruct { String nombre;  List<Campo> campos; }
    public Object visit(TipoStruct node, Object param) {
        visitChildren(node.getCampos(), param);
        return null;
    }

    //	class TipoVoid {  }
    public Object visit(TipoVoid node, Object param) {
        return null;
    }

    //	class Print { Expresion expresion;  String tipo_print; }
    public Object visit(Print node, Object param) {
        visitChildren(node.getExpresiones(), param);
        return null;
    }

    //	class Read { Expresion expresion; }
    public Object visit(Read node, Object param) {
        if (node.getExpresion() != null)
            node.getExpresion().accept(this, param);
        return null;
    }

    //	class Asignacion { Expresion izquierda;  Expresion derecha; }
    public Object visit(Asignacion node, Object param) {
        if (node.getIzquierda() != null)
            node.getIzquierda().accept(this, param);
        if (node.getDerecha() != null)
            node.getDerecha().accept(this, param);
        return null;
    }

    //	class If { Expresion condicion;  List<Sentencia> verdadero;  List<Sentencia> falso; }
    public Object visit(If node, Object param) {
        if (node.getCondicion() != null)
            node.getCondicion().accept(this, param);
        visitChildren(node.getVerdadero(), param);
        visitChildren(node.getFalso(), param);
        return null;
    }

    //	class While { Expresion condicion;  List<Sentencia> sentencia; }
    public Object visit(While node, Object param) {
        if (node.getCondicion() != null)
            node.getCondicion().accept(this, param);
        visitChildren(node.getSentencia(), param);
        return null;
    }

    //	class Invocacion { String nombre;  List<Expresion> params; }
    public Object visit(Invocacion node, Object param) {
        visitChildren(node.getParams(), param);
        return null;
    }

    //	class Return { List<Expresion> expresion; }
    public Object visit(Return node, Object param) {
        visitChildren(node.getExpresion(), param);
        return null;
    }

    //	class ConstanteEntero { int valor; }
    public Object visit(ConstanteEntero node, Object param) {
        return null;
    }

    //	class ConstanteReal { double valor; }
    public Object visit(ConstanteReal node, Object param) {
        return null;
    }

    //	class ConstanteChar { String valor; }
    public Object visit(ConstanteChar node, Object param) {
        return null;
    }

    //	class Variable { String nombre; }
    public Object visit(Variable node, Object param) {
        return null;
    }

    //	class ExpresionAritmetica { Expresion izq;  String operador;  Expresion der; }
    public Object visit(ExpresionAritmetica node, Object param) {
        if (node.getIzq() != null)
            node.getIzq().accept(this, param);
        if (node.getDer() != null)
            node.getDer().accept(this, param);
        return null;
    }

    //	class ExpresionLogica { Expresion izq;  String operador;  Expresion der; }
    public Object visit(ExpresionLogica node, Object param) {
        if (node.getIzq() != null)
            node.getIzq().accept(this, param);
        if (node.getDer() != null)
            node.getDer().accept(this, param);
        return null;
    }

    //	class Comparacion { Expresion izq;  String operador;  Expresion der; }
    public Object visit(Comparacion node, Object param) {
        if (node.getIzq() != null)
            node.getIzq().accept(this, param);
        if (node.getDer() != null)
            node.getDer().accept(this, param);
        return null;
    }

    //	class ExpresionUnaria { Expresion expresion;  String operador; }
    public Object visit(ExpresionUnaria node, Object param) {
        if (node.getExpresion() != null)
            node.getExpresion().accept(this, param);
        return null;
    }

    //	class Conversion { Tipo nuevoTipo;  Expresion expresion; }
    public Object visit(Conversion node, Object param) {
        if (node.getNuevoTipo() != null)
            node.getNuevoTipo().accept(this, param);
        if (node.getExpresion() != null)
            node.getExpresion().accept(this, param);
        return null;
    }

    //	class InvocacionExpresion { String nombre;  List<Expresion> params; }
    public Object visit(InvocacionExpresion node, Object param) {
        visitChildren(node.getParams(), param);
        return null;
    }

    //	class AccesoArray { Expresion array;  Expresion indice; }
    public Object visit(AccesoArray node, Object param) {
        if (node.getArray() != null)
            node.getArray().accept(this, param);
        if (node.getIndice() != null)
            node.getIndice().accept(this, param);
        return null;
    }

    //	class AccesoCampo { Expresion struct;  Expresion campo; }
    public Object visit(AccesoCampo node, Object param) {
        if (node.getStruct() != null)
            node.getStruct().accept(this, param);
        if (node.getCampo() != null)
            node.getCampo().accept(this, param);
        return null;
    }

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }
}
