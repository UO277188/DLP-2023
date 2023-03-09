/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import visitor.*;

//	return:sentencia -> expresion:expresion*

public class Return extends AbstractSentencia {

	public Return(List<Expresion> expresion) {
		this.expresion = expresion;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expresion);
	}

	public Return(Object expresion) {
		this.expresion = this.<Expresion>getAstFromContexts(expresion);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expresion);
	}

	public List<Expresion> getExpresion() {
		return expresion;
	}
	public void setExpresion(List<Expresion> expresion) {
		this.expresion = expresion;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private List<Expresion> expresion;

	public String toString() {
       return "{expresion:" + getExpresion() + "}";
   }
}
