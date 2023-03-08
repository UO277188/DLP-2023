/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	accesoCampo:expresion -> struct:expresion  campo:String

public class AccesoCampo extends AbstractExpresion {

	public AccesoCampo(Expresion struct, String campo) {
		this.struct = struct;
		this.campo = campo;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(struct);
	}

	public AccesoCampo(Object struct, Object campo) {
		this.struct = (Expresion) getAST(struct);
		this.campo = (campo instanceof Token) ? ((Token)campo).getText() : (String) campo;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(struct, campo);
	}

	public Expresion getStruct() {
		return struct;
	}
	public void setStruct(Expresion struct) {
		this.struct = struct;
	}

	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion struct;
	private String campo;

	public String toString() {
       return "{struct:" + getStruct() + ", campo:" + getCampo() + "}";
   }
}
