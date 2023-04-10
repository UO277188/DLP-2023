/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import ast.*;
import main.*;
import visitor.*;

import java.beans.Expression;
import java.util.List;

public class TypeChecking extends DefaultVisitor {

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    // # ----------------------------------------------------------
    @Override
    public Object visit(Conversion node, Object param) {
        predicado(esTipoPrimitivo(node.getNuevoTipo()), "El nuevo tipo no es primitivo", node);
        predicado(esTipoPrimitivo(node.getTipo()), "El tipo de la expresión no es primitivo", node);
        return null;
    }

    @Override
    public Object visit(Variable node, Object param) {
        if(node.getDefinicion() == null){
            TipoStruct tipo = (TipoStruct)(((Variable) param).getTipo());
                predicado(tipo.getCampos().contains(new Campo(node.getNombre(), node.getTipo())),
                        "El campo no es del tipo adecuado", node.getStart());

        } else {
            node.setTipo(node.getDefinicion().getTipo());
        }
        return null;
    }

    @Override
    public Object visit(AccesoCampo node, Object param) {
        node.getStruct().accept(this, param);
        node.getCampo().accept(this, node.getStruct());
        predicado(node.getStruct().getTipo() instanceof TipoStruct, "El tipo debe ser Struct", node);
        return null;
    }

    // # ----------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------
    boolean esTipoPrimitivo(Tipo t){
        return t instanceof TipoEntero || t instanceof TipoReal || t instanceof TipoChar;
    }

    boolean mismoTipo(Tipo t1, Tipo t2){
        return t1 instanceof TipoEntero && t2 instanceof TipoEntero
                || t1 instanceof TipoReal && t2 instanceof TipoReal
                || t1 instanceof TipoChar && t2 instanceof TipoChar;
    }

    boolean coincidenTiposParametros(DefinicionFuncion f, List<Expresion> params){
        if(f.getParams().size() != params.size())
            return false;

        for(int i=0; i<params.size(); i++)
            if(!mismoTipo(f.getParams().get(i).getTipo(), params.get(i).getTipo()))
                return false;

        return true;
    }

    /**
     * predicado. Método auxiliar para implementar los predicados. Borrar si no se quiere usar.
     *
     * Ejemplos de uso (suponiendo que existe un método "esPrimitivo(expr)"):
     *
     *      1. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo", expr.getStart());
     *      2. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo", expr); // Se asume getStart()
     *      3. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo");
     *
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
