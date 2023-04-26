/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.Visitor;

//	tipoVoid:tipo -> 

public class TipoVoid extends AbstractTipo {

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }


    public String toString() {
        return "{TipoVoid}";
    }

    @Override
    public int getTamaño() {
        return 0;
    }

    @Override
    public String getSufijo() {
        return "";
    }
}
