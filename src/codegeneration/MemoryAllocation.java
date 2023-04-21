/**
 * Tutorial de Diseño de Lenguajes de Programación
 *
 * @author Raúl Izquierdo
 */

package codegeneration;

import ast.Campo;
import ast.DefinicionFuncion;
import ast.DefinicionStruct;
import ast.DefinicionVariable;
import visitor.DefaultVisitor;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {
    private int direccion = 0;

    @Override
    public Object visit(DefinicionFuncion node, Object param) {
        int relativa = 0;
        for (DefinicionVariable var : node.getVariablesLocales()) {
            relativa = (int) var.accept(this, relativa);
        }

        relativa = 4;
        for (int i = node.getParams().size() - 1; i >= 0; i--) {
            relativa = (int) node.getParams().get(i).accept(this, relativa);
        }

        return null;
    }

    @Override
    public Object visit(DefinicionVariable node, Object param) {
        int relativa = 0;
        if (param != null)
            relativa = (Integer) param;

        switch (node.getAmbito()) {
            case LOCAL:
                int dir = relativa + node.getTipo().getTamaño();
                node.setDireccion(dir * -1);
                return dir;

            case PARAM:
                node.setDireccion(relativa);
                return relativa + node.getTipo().getTamaño();

            case GLOBAL:
                node.setDireccion(this.direccion);
                direccion += node.getTipo().getTamaño();
                break;
        }

        return node.getTipo().getTamaño();
    }

    @Override
    public Object visit(DefinicionStruct node, Object param) {
        int tamaño = 0;
        for (Campo c : node.getCampos()) {
            c.setDireccion(tamaño);
            tamaño += c.getTipo().getTamaño();
        }
        return null;
    }
}
