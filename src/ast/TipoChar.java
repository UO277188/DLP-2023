/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.*;

//	tipoChar:tipo -> 

public class TipoChar extends AbstractTipo {

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{TipoChar}";
   }

	@Override
	public int getTamaño() {
		return 1;
	}
}
