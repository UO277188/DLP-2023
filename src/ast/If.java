/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	if:sentencia -> condicion:expresion  verdadero:expresion*  falso:expresion*

public class If extends AbstractSentencia {

	public If(Expresion condicion, List<Expresion> verdadero, List<Expresion> falso) {
		this.condicion = condicion;
		this.verdadero = verdadero;
		this.falso = falso;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condicion, verdadero, falso);
	}

	public If(Object condicion, Object verdadero, Object falso) {
		this.condicion = (Expresion) getAST(condicion);
		this.verdadero = this.<Expresion>getAstFromContexts(verdadero);
		this.falso = this.<Expresion>getAstFromContexts(falso);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condicion, verdadero, falso);
	}

	public Expresion getCondicion() {
		return condicion;
	}
	public void setCondicion(Expresion condicion) {
		this.condicion = condicion;
	}

	public List<Expresion> getVerdadero() {
		return verdadero;
	}
	public void setVerdadero(List<Expresion> verdadero) {
		this.verdadero = verdadero;
	}

	public List<Expresion> getFalso() {
		return falso;
	}
	public void setFalso(List<Expresion> falso) {
		this.falso = falso;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion condicion;
	private List<Expresion> verdadero;
	private List<Expresion> falso;

	public String toString() {
       return "{condicion:" + getCondicion() + ", verdadero:" + getVerdadero() + ", falso:" + getFalso() + "}";
   }
}
