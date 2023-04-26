/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.Visitor;

//	tipoEntero:tipo -> 

public class TipoEntero extends AbstractTipo {

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }


    public String toString() {
        return "{TipoEntero}";
    }

    @Override
    public int getTamaño() {
        return 2;
    }

    @Override
    public String getSufijo() {
        return "i";
    }
}
