/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.Visitor;

//	tipoReal:tipo -> 

public class TipoReal extends AbstractTipo {

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }


    public String toString() {
        return "{TipoReal}";
    }

    @Override
    public int getTamaño() {
        return 4;
    }

    @Override
    public String getSufijo() {
        return "f";
    }
}
