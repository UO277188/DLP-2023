/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	constanteReal:expresion -> valor:double

public class ConstanteReal extends AbstractExpresion {

	public ConstanteReal(double valor) {
		this.valor = valor;
	}

	public ConstanteReal(Object valor) {
		this.valor = (valor instanceof Token) ? Double.parseDouble(((Token)valor).getText()) : (Double) valor;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(valor);
	}

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private double valor;

	public String toString() {
       return "{valor:" + getValor() + "}";
   }
}
