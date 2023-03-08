/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	expresionUnaria:expresion -> expresion:expresion  operador:String

public class ExpresionUnaria extends AbstractExpresion {

	public ExpresionUnaria(Expresion expresion, String operador) {
		this.expresion = expresion;
		this.operador = operador;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expresion);
	}

	public ExpresionUnaria(Object expresion, Object operador) {
		this.expresion = (Expresion) getAST(expresion);
		this.operador = (operador instanceof Token) ? ((Token)operador).getText() : (String) operador;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expresion, operador);
	}

	public Expresion getExpresion() {
		return expresion;
	}
	public void setExpresion(Expresion expresion) {
		this.expresion = expresion;
	}

	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion expresion;
	private String operador;

	public String toString() {
       return "{expresion:" + getExpresion() + ", operador:" + getOperador() + "}";
   }
}
