/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import ast.*;
import visitor.*;

import javax.sound.midi.SysexMessage;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {
    int direccion = 0;
    int direccionGlobales = 0;

    @Override
    public Object visit(DefinicionFuncion node, Object param) {
        direccion = 0;
        for (DefinicionVariable var : node.getVariablesLocales()) {
            var.accept(this, param);
            direccion += var.getTipo().getTamaño();
        }

        direccion = 4;
        for (DefinicionVariable var : node.getParams()) {
            var.accept(this, param);
            direccion += var.getTipo().getTamaño();
        }

        return null;
    }

    @Override
    public Object visit(DefinicionVariable node, Object param) {
        switch (node.getAmbito()){
            case LOCAL:
                node.setDireccion(-(direccion + node.getTipo().getTamaño()));
                break;

            case PARAM:
                node.setDireccion(direccion);
                break;

            case GLOBAL:
                node.setDireccion(direccionGlobales);
                direccionGlobales += node.getTipo().getTamaño();
                break;
        }
        return null;
    }

    // PARAMS =
    // dir param = bp +4 + suma tamaños param de detras


}
