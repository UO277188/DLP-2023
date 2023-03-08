/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	invocacionExpresion:expresion -> nombre:String  params:expresion*

public class InvocacionExpresion extends AbstractExpresion {

	public InvocacionExpresion(String nombre, List<Expresion> params) {
		this.nombre = nombre;
		this.params = params;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(params);
	}

	public InvocacionExpresion(Object nombre, Object params) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.params = this.<Expresion>getAstFromContexts(params);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(nombre, params);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Expresion> getParams() {
		return params;
	}
	public void setParams(List<Expresion> params) {
		this.params = params;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private List<Expresion> params;

	public String toString() {
       return "{nombre:" + getNombre() + ", params:" + getParams() + "}";
   }
}
