/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	expresionBinaria:expresion -> izq:expresion  operador:String  der:expresion

public class ExpresionBinaria extends AbstractExpresion {

	public ExpresionBinaria(Expresion izq, String operador, Expresion der) {
		this.izq = izq;
		this.operador = operador;
		this.der = der;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(izq, der);
	}

	public ExpresionBinaria(Object izq, Object operador, Object der) {
		this.izq = (Expresion) getAST(izq);
		this.operador = (operador instanceof Token) ? ((Token)operador).getText() : (String) operador;
		this.der = (Expresion) getAST(der);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(izq, operador, der);
	}

	public Expresion getIzq() {
		return izq;
	}
	public void setIzq(Expresion izq) {
		this.izq = izq;
	}

	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}

	public Expresion getDer() {
		return der;
	}
	public void setDer(Expresion der) {
		this.der = der;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion izq;
	private String operador;
	private Expresion der;

	public String toString() {
       return "{izq:" + getIzq() + ", operador:" + getOperador() + ", der:" + getDer() + "}";
   }
}
