/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	accesoArray:expresion -> array:expresion  indice:expresion

public class AccesoArray extends AbstractExpresion {

	public AccesoArray(Expresion array, Expresion indice) {
		this.array = array;
		this.indice = indice;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(array, indice);
	}

	public AccesoArray(Object array, Object indice) {
		this.array = (Expresion) getAST(array);
		this.indice = (Expresion) getAST(indice);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(array, indice);
	}

	public Expresion getArray() {
		return array;
	}
	public void setArray(Expresion array) {
		this.array = array;
	}

	public Expresion getIndice() {
		return indice;
	}
	public void setIndice(Expresion indice) {
		this.indice = indice;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion array;
	private Expresion indice;

	public String toString() {
       return "{array:" + getArray() + ", indice:" + getIndice() + "}";
   }
}
