/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	read:sentencia -> expresion:expresion

public class Read extends AbstractSentencia {

	public Read(Expresion expresion) {
		this.expresion = expresion;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expresion);
	}

	public Read(Object expresion) {
		this.expresion = (Expresion) getAST(expresion);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expresion);
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

	private Expresion expresion;

	public String toString() {
       return "{expresion:" + getExpresion() + "}";
   }
}
