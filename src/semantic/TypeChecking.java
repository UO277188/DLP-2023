/**
 * Tutorial de Diseño de Lenguajes de Programación
 *
 * @author Raúl Izquierdo
 */

package semantic;

import ast.*;
import main.ErrorManager;
import visitor.DefaultVisitor;

public class TypeChecking extends DefaultVisitor {

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    // # ----------------------------------------------------------
    /*
     * Poner aquí los visit.
     *
     * Si se ha usado VGen, solo hay que copiarlos de la clase 'visitor/_PlantillaParaVisitors.txt'.
     */

    @Override
    public Object visit(DefinicionFuncion node, Object param) {
        node.getTipo().accept(this, param);
        if (!(node.getTipo() instanceof TipoVoid))
            predicado(esTipoPrimitivo(node.getTipo()), "El tipo de retorno de la función no es primitivo", node);

        for (DefinicionVariable var : node.getParams())
            var.accept(this, param);
        for (DefinicionVariable var : node.getVariablesLocales())
            var.accept(this, param);

        for (Sentencia sentencia : node.getSentencias())
            sentencia.accept(this, node.getTipo());
        return null;
    }

    @Override
    public Object visit(DefinicionVariable node, Object param) {
        node.getTipo().accept(this, param);

        if (node.getAmbito().equals(Ambito.PARAM))
            predicado(esTipoPrimitivo(node.getTipo()),
                    "El tipo no es primitivo", node);

        return null;
    }

    @Override
    public Object visit(Print node, Object param) {
        node.getExpresion().accept(this, param);
        predicado(esTipoPrimitivo(node.getExpresion().getTipo()),
                "El tipo del Print no es primitivo", node);
        return null;
    }

    @Override
    public Object visit(Read node, Object param) {
        node.getExpresion().accept(this, param);
        predicado(esTipoPrimitivo(node.getExpresion().getTipo()), "El tipo del Read no es primitivo", node);
        predicado(node.getExpresion().isModificable(), "El tipo no es modificable", node);
        return null;
    }

    @Override
    public Object visit(Asignacion node, Object param) {
        node.getIzquierda().accept(this, param);
        node.getDerecha().accept(this, param);

        predicado(esTipoPrimitivo(node.getIzquierda().getTipo()), "El tipo de la izquierda no es primitivo", node);
        predicado(esTipoPrimitivo(node.getDerecha().getTipo()), "El tipo de la derecha no es primitivo", node);
        predicado(node.getIzquierda().isModificable(), "El valor de la izquierda no es modificable", node);
        predicado(mismoTipo(node.getIzquierda().getTipo(), node.getDerecha().getTipo()), "No coinciden los tipos", node);
        return null;
    }

    @Override
    public Object visit(If node, Object param) {
        node.getCondicion().accept(this, param);
        predicado(node.getCondicion().getTipo() instanceof TipoEntero, "El tipo de la condición no es entero", node);

        for (Sentencia s : node.getVerdadero())
            s.accept(this, param);
        for (Sentencia s : node.getFalso())
            s.accept(this, param);

        return null;
    }

    @Override
    public Object visit(While node, Object param) {
        node.getCondicion().accept(this, param);
        predicado(node.getCondicion().getTipo() instanceof TipoEntero, "El tipo de la condición no es entero", node);

        for (Sentencia s : node.getSentencia())
            s.accept(this, param);
        return null;
    }

    @Override
    public Object visit(Invocacion node, Object param) {
        for (Expresion e : node.getParams())
            e.accept(this, param);
        for (DefinicionVariable def : node.getDefinicion().getParams())
            def.accept(this, true);

        predicado(node.getDefinicion().getParams().size() == node.getParams().size(),
                "Número incorrecto de parámetros", node);

        if (node.getDefinicion().getParams().size() == node.getParams().size())
            for (int i = 0; i < node.getParams().size(); i++) {
                predicado(mismoTipo(node.getDefinicion().getParams().get(i).getTipo(),
                                node.getParams().get(i).getTipo()),
                        "No coinciden los tipos de los parámetros", node);
                if (!mismoTipo(node.getDefinicion().getParams().get(i).getTipo(),
                        node.getParams().get(i).getTipo()))
                    break;
            }

        return null;
    }

    @Override
    public Object visit(Return node, Object param) {
        Tipo tipoRetornoFuncion = (Tipo) param;
        if (node.getExpresion().size() == 0)
            predicado(tipoRetornoFuncion instanceof TipoVoid,
                    "El tipo devuelto no coincide con el de la función", node);
        else {
            node.getExpresion().get(0).accept(this, param);
            predicado(mismoTipo(tipoRetornoFuncion, node.getExpresion().get(0).getTipo()),
                    "El tipo devuelto no coincide con el de la función", node);
        }

        return null;
    }

    @Override
    public Object visit(ConstanteEntero node, Object param) {
        node.setTipo(new TipoEntero());
        node.setModificable(false);

        return null;
    }

    @Override
    public Object visit(ConstanteReal node, Object param) {
        node.setTipo(new TipoReal());
        node.setModificable(false);

        return null;
    }

    @Override
    public Object visit(ConstanteChar node, Object param) {
        node.setTipo(new TipoChar());
        node.setModificable(false);

        return null;
    }

    @Override
    public Object visit(Variable node, Object param) {
        // si es un campo de una struct
        if (param instanceof TipoStruct) {
            TipoStruct struct = (TipoStruct) param;
            Campo c = struct.getCampo(node.getNombre());
            predicado(c != null, "No existe el campo " + node.getNombre(), node.getStart());
            if (c != null)
                node.setTipo(c.getTipo());
        } else {
            node.setTipo(node.getDefinicion().getTipo());
            node.setModificable(true);
        }

        return null;
    }

    @Override
    public Object visit(ExpresionAritmetica node, Object param) {
        node.getIzq().accept(this, param);
        node.getDer().accept(this, param);

        predicado(esTipoPrimitivo(node.getIzq().getTipo()) && !(node.getIzq().getTipo() instanceof TipoChar),
                "El tipo de la izquierda no es primitivo o es Char", node);
        predicado(esTipoPrimitivo(node.getDer().getTipo()) && !(node.getIzq().getTipo() instanceof TipoChar)
                , "El tipo de la derecha no es primitivo o es Char", node);
        predicado(mismoTipo(node.getIzq().getTipo(), node.getDer().getTipo()),
                "No coinciden los tipos", node);

        node.setTipo(node.getIzq().getTipo());
        node.setModificable(false);
        return null;
    }

    @Override
    public Object visit(ExpresionLogica node, Object param) {
        node.getIzq().accept(this, param);
        node.getDer().accept(this, param);

        predicado(node.getIzq().getTipo() instanceof TipoEntero,
                "El tipo de la izquierda no es entero", node);
        predicado(node.getDer().getTipo() instanceof TipoEntero,
                "El tipo de la derecha no es entero", node);

        node.setTipo(node.getIzq().getTipo());
        node.setModificable(false);
        return null;
    }

    public Object visit(Comparacion node, Object param) {
        node.getIzq().accept(this, param);
        node.getDer().accept(this, param);

        predicado(esTipoPrimitivo(node.getIzq().getTipo()) && !(node.getIzq().getTipo() instanceof TipoChar),
                "El tipo de la izquierda no es primitivo o es Char", node);
        predicado(esTipoPrimitivo(node.getDer().getTipo()) && !(node.getIzq().getTipo() instanceof TipoChar)
                , "El tipo de la derecha no es primitivo o es Char", node);
        predicado(mismoTipo(node.getIzq().getTipo(), node.getDer().getTipo()),
                "No coinciden los tipos de la comparación", node);

        node.setTipo(new TipoEntero());
        node.setModificable(false);
        return null;
    }

    @Override
    public Object visit(ExpresionUnaria node, Object param) {
        node.getExpresion().accept(this, param);
        predicado(node.getExpresion().getTipo() instanceof TipoEntero,
                "El tipo de la expresión no es entero", node);
        node.setTipo(node.getExpresion().getTipo());
        node.setModificable(false);
        return null;
    }

    @Override
    public Object visit(Conversion node, Object param) {
        node.getNuevoTipo().accept(this, param);
        node.getExpresion().accept(this, param);

        predicado(esTipoPrimitivo(node.getNuevoTipo()),
                "El nuevo tipo no es primitivo", node);
        predicado(esTipoPrimitivo(node.getExpresion().getTipo()),
                "El tipo de la expresión no es primitivo", node);
        predicado(!mismoTipo(node.getNuevoTipo(), node.getExpresion().getTipo()),
                "Los tipos no son distintos", node);

        node.setTipo(node.getNuevoTipo());
        node.setModificable(false);
        return null;
    }

    @Override
    public Object visit(InvocacionExpresion node, Object param) {
        for (Expresion e : node.getParams())
            e.accept(this, param);

        predicado(node.getDefinicion().getParams().size() == node.getParams().size(),
                "Número incorrecto de parámetros", node);

        if (node.getDefinicion().getParams().size() == node.getParams().size())
            for (int i = 0; i < node.getParams().size(); i++) {
                predicado(mismoTipo(node.getDefinicion().getParams().get(i).getTipo(),
                                node.getParams().get(i).getTipo()),
                        "No coinciden los tipos de los parámetros", node);
                if (!mismoTipo(node.getDefinicion().getParams().get(i).getTipo(),
                        node.getParams().get(i).getTipo()))
                    break;
            }

        predicado(!(node.getDefinicion().getTipo() instanceof TipoVoid), "El tipo de retorno no puede ser void", node);

        node.setTipo(node.getDefinicion().getTipo());
        node.setModificable(false);
        return null;
    }

    @Override
    public Object visit(AccesoArray node, Object param) {
        node.getArray().accept(this, false);
        node.getIndice().accept(this, param);

        predicado(node.getArray().getTipo() instanceof TipoArray,
                "El tipo debe ser Array", node);
        predicado(node.getIndice().getTipo() instanceof TipoEntero,
                "El tipo del índice debe ser Entero", node);

        if (node.getArray().getTipo() instanceof TipoArray) {
            TipoArray tipo = (TipoArray) node.getArray().getTipo();
            node.setTipo(tipo.getTipo());
            node.setModificable(true);
        }

        return null;
    }

    @Override
    public Object visit(AccesoCampo node, Object param) {
        node.getStruct().accept(this, false);
        predicado(node.getStruct().getTipo() instanceof TipoStruct, "El tipo debe ser Struct", node);

        if (node.getStruct().getTipo() instanceof TipoStruct) {
            node.getCampo().accept(this, node.getStruct().getTipo());
            node.setTipo(node.getCampo().getTipo());
            node.setModificable(true);
        }
        return null;
    }

    // # ----------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------
    boolean esTipoPrimitivo(Tipo t) {
        return t instanceof TipoEntero || t instanceof TipoReal || t instanceof TipoChar;
    }

    boolean mismoTipo(Tipo t1, Tipo t2) {
        return t1 instanceof TipoEntero && t2 instanceof TipoEntero
                || t1 instanceof TipoReal && t2 instanceof TipoReal
                || t1 instanceof TipoChar && t2 instanceof TipoChar;
    }


    /**
     * predicado. Método auxiliar para implementar los predicados. Borrar si no se quiere usar.
     * <p>
     * Ejemplos de uso (suponiendo que existe un método "esPrimitivo(expr)"):
     * <p>
     * 1. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo", expr.getStart());
     * 2. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo", expr); // Se asume getStart()
     * 3. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo");
     * <p>
     * NOTA: El método getStart() (ejemplo 1) indica la linea/columna del fichero fuente donde estaba el nodo
     * (y así poder dar información más detallada de la posición del error). Si se usa VGen, dicho método
     * habrá sido generado en todos los nodos del AST.
     * No es obligatorio llamar a getStart() (ejemplo 2), ya que si se pasa el nodo, se usará por defecto dicha
     * posición.
     * Si no se quiere imprimir la posición del fichero, se puede omitir el tercer argumento (ejemplo 3).
     *
     * @param condition     Debe cumplirse para que no se produzca un error
     * @param errorMessage  Se imprime si no se cumple la condición
     * @param posicionError Fila y columna del fichero donde se ha producido el error.
     */

    private void predicado(boolean condition, String errorMessage, AST node) {
        predicado(condition, errorMessage, node.getStart());
    }

    private void predicado(boolean condition, String errorMessage, Position position) {
        if (!condition)
            errorManager.notify("Type Checking", errorMessage, position);
    }

    private void predicado(boolean condition, String errorMessage) {
        predicado(condition, errorMessage, (Position) null);
    }

    private ErrorManager errorManager;
}
