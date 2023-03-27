/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.*;

//	conversion:expresion -> tipo:tipo  expresion:expresion

public class Conversion extends AbstractExpresion {

	public Conversion(Tipo tipo, Expresion expresion) {
		this.nuevoTipo = tipo;
		this.expresion = expresion;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tipo, expresion);
	}

	public Conversion(Object tipo, Object expresion) {
		this.nuevoTipo = (Tipo) getAST(tipo);
		this.expresion = (Expresion) getAST(expresion);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tipo, expresion);
	}

	public Tipo getNuevoTipo() {
		return nuevoTipo;
	}
	public void setNuevoTipo(Tipo nuevoTipo) {
		this.nuevoTipo = nuevoTipo;
	}

	public Expresion getExpresion() {
		return expresion;
	}
	public void setExpresion(Expresion expresion) {
		this.expresion = expresion;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Tipo nuevoTipo;
	private Expresion expresion;

	public String toString() {
       return "{tipo:" + getNuevoTipo() + ", expresion:" + getExpresion() + "}";
   }
}
