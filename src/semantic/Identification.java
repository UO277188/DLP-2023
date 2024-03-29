/**
 * Tutorial de Diseño de Lenguajes de Programación
 *
 * @author Raúl Izquierdo
 */

package semantic;

import ast.*;
import main.ErrorManager;
import visitor.DefaultVisitor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Identification extends DefaultVisitor {

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }


    @Override
    public Object visit(Programa node, Object param) {
        st.set();
        for (Definicion def : node.getDefiniciones())
            def.accept(this, param);
        st.reset();
        return null;
    }

    @Override
    public Object visit(DefinicionFuncion node, Object param) {
        if (st.getFromAny(node.getNombre()) != null)
            error("Función ya definida: " + node.getNombre(), node.getStart());
        else
            st.put(node.getNombre(), node);
        st.set();
        for (DefinicionVariable var : node.getParams()) {
            var.accept(this, param);
            var.setAmbito(Ambito.PARAM);
        }
        for (DefinicionVariable var : node.getVariablesLocales()) {
            var.accept(this, param);
            var.setAmbito(Ambito.LOCAL);
        }
        for (Sentencia sentencia : node.getSentencias())
            sentencia.accept(this, param);
        st.reset();
        return null;
    }

    @Override
    public Object visit(DefinicionVariable node, Object param) {
        node.setAmbito(Ambito.GLOBAL);
        if (st.getFromTop(node.getNombre()) != null) {
            error("Variable ya definida: " + node.getNombre(), node.getStart());
            return null;
        } else {
            st.put(node.getNombre(), node);
            node.getTipo().accept(this, param);
            return null;
        }
    }

    @Override
    public Object visit(DefinicionStruct node, Object param) {
        predicado(structs.put(node.getNombre(), node) == null,
                "Struct ya definido: " + node.getNombre(), node);
        st.set();

        // comprueba campos duplicados
        Map<String, Long> campos = node.getCampos().stream()
                .collect(Collectors.groupingBy(c -> c.getNombre(), Collectors.counting()));
        campos.forEach((c, count) -> {
            predicado(count == 1, "Campo repetido: " + c, node);
        });

        st.reset();
        node.getCampos().forEach(c -> c.accept(this, param));
        return null;
    }

    @Override
    public Object visit(Campo node, Object param) {
        node.getTipo().accept(this, param);
        return null;
    }

    public Object visit(TipoStruct node, Object param) {
        DefinicionStruct definicion = structs.get(node.getNombre());
        if (definicion != null) {
            for (Campo c : definicion.getCampos())
                node.addCampo(c);
        } else
            error("Estructura no definida: " + node.getNombre(), node.getStart());
        return null;
    }

    @Override
    public Object visit(Invocacion node, Object param) {
        DefinicionFuncion def = (DefinicionFuncion) st.getFromAny(node.getNombre());
        if (def != null)
            node.setDefinicion(def);
        else
            error("No se ha encontrado la función " + node.getNombre(), node.getStart());
        super.visit(node, param);
        return null;
    }

    @Override
    public Object visit(InvocacionExpresion node, Object param) {
        DefinicionFuncion def = (DefinicionFuncion) st.getFromAny(node.getNombre());
        if (def != null)
            node.setDefinicion(def);
        else
            error("No se ha encontrado la función " + node.getNombre(), node.getStart());
        super.visit(node, param);
        return null;
    }

    @Override
    public Object visit(Variable node, Object param) {
        // si se viene de un acceso a campo
        if (param != null) {
            // si es la parte izquierda
            if ((boolean) param) {
                if (st.getFromAny(node.getNombre()) != null)
                    node.setDefinicion((DefinicionVariable) st.getFromAny(node.getNombre()));
            }
        } else {
            if (st.getFromAny(node.getNombre()) != null)
                node.setDefinicion((DefinicionVariable) st.getFromAny(node.getNombre()));
            else
                error("Variable no definida: " + node.getNombre(), node.getStart());
        }

        return null;
    }

    @Override
    public Object visit(AccesoCampo node, Object param) {
        node.getStruct().accept(this, true);
        node.getCampo().accept(this, false);
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

    private Map<String, DefinicionStruct> structs = new HashMap<String, DefinicionStruct>();
    private ContextMap<String, Definicion> st = new ContextMap<>();
}
