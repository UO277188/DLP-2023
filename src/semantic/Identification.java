/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import ast.*;
import main.*;
import visitor.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Identification extends DefaultVisitor {

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    // # --------------------      FUNCIONES        ---------------------

    public Object visit(DefinicionFuncion node, Object param){
        DefinicionFuncion definicion = funciones.get(node.getNombre());
        predicado(definicion == null, "Función ya definida: " + node.getNombre(), node);
        funciones.put(node.getNombre(), node);
        node.getSentencia().stream().forEach(n -> n.accept(this, param));
        return null;
    }

    public Object visit(Invocacion node, Object param){
        DefinicionFuncion definicion = funciones.get(node.getNombre());
        predicado(definicion != null, "Función no definida: " + node.getNombre(), node);
        node.setDefinicion(definicion);
        return null;
    }

    public Object visit(InvocacionExpresion node, Object param){
        DefinicionFuncion definicion = funciones.get(node.getNombre());
        predicado(definicion != null, "Función no definida: " + node.getNombre(), node);
        node.setDefinicion(definicion);
        return null;
    }

    // # --------------------      ESTRUCTURAS        ---------------------

    public Object visit(DefinicionStruct node, Object param){
        DefinicionStruct struct = structs.get(node.getNombre());
        predicado(struct == null, "Estructura ya definida: " + node.getNombre(), node);
        structs.put(node.getNombre(), node);

        Map<String, Long> campos = node.getCampos().stream()
                .collect(Collectors.groupingBy(c -> c.getNombre(), Collectors.counting()));
        campos.forEach((c, count) -> {
            predicado(count==1, "Campo repetido: "+c, node);
        });
        return null;
    }

    public Object visit(TipoStruct node, Object param){
        DefinicionStruct definicion = structs.get(node.getNombre());
        predicado(definicion != null, "Estructura no definida: " + node.getNombre(), node);
        node.setDefinicion(definicion);
        return null;
    }

    // # --------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    private void error(String msg) {
        error(msg, null);
    }

    private void error(String msg, Position position) {
        errorManager.notify("Identification", msg, position);
    }

    private void predicado(boolean condition, String errorMessage, AST node) {
        if (!condition)
            error(errorMessage, node.getStart());
    }

    private ErrorManager errorManager;

    private Map<String, DefinicionFuncion> funciones = new HashMap<String, DefinicionFuncion>();
    private Map<String, DefinicionStruct> structs = new HashMap<String, DefinicionStruct>();
}
