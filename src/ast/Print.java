/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	print:sentencia -> expresion:expresion  tipo_print:String

public class Print extends AbstractSentencia {

	public Print(Expresion expresion, String tipo_print) {
		this.expresion = expresion;
		this.tipo_print = tipo_print;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expresion);
	}

	public Print(Object expresion, Object tipo_print) {
		this.expresion = (Expresion) getAST(expresion);
		this.tipo_print = (tipo_print instanceof Token) ? ((Token)tipo_print).getText() : (String) tipo_print;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expresion, tipo_print);
	}

	public Expresion getExpresion() {
		return expresion;
	}
	public void setExpresion(Expresion expresion) {
		this.expresion = expresion;
	}

	public String getTipo_print() {
		return tipo_print;
	}
	public void setTipo_print(String tipo_print) {
		this.tipo_print = tipo_print;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion expresion;
	private String tipo_print;

	public String toString() {
       return "{expresion:" + getExpresion() + ", tipo_print:" + getTipo_print() + "}";
   }
}
