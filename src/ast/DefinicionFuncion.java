/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	definicionFuncion:definicion -> nombre:String  params:definicionVariable*  tipo:tipo  variablesLocales:definicionVariable*  sentencias:sentencia*

public class DefinicionFuncion extends AbstractDefinicion {

	public DefinicionFuncion(String nombre, List<DefinicionVariable> params, Tipo tipo, List<DefinicionVariable> variablesLocales, List<Sentencia> sentencias) {
		this.nombre = nombre;
		this.params = params;
		this.tipo = tipo;
		this.variablesLocales = variablesLocales;
		this.sentencias = sentencias;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(params, tipo, variablesLocales, sentencias);
	}

	public DefinicionFuncion(Object nombre, Object params, Object tipo, Object variablesLocales, Object sentencias) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.params = this.<DefinicionVariable>getAstFromContexts(params);
		this.tipo = (Tipo) getAST(tipo);
		this.variablesLocales = this.<DefinicionVariable>getAstFromContexts(variablesLocales);
		this.sentencias = this.<Sentencia>getAstFromContexts(sentencias);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(nombre, params, tipo, variablesLocales, sentencias);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<DefinicionVariable> getParams() {
		return params;
	}
	public void setParams(List<DefinicionVariable> params) {
		this.params = params;
	}

	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<DefinicionVariable> getVariablesLocales() {
		return variablesLocales;
	}
	public void setVariablesLocales(List<DefinicionVariable> variablesLocales) {
		this.variablesLocales = variablesLocales;
	}

	public List<Sentencia> getSentencias() {
		return sentencias;
	}
	public void setSentencias(List<Sentencia> sentencias) {
		this.sentencias = sentencias;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private List<DefinicionVariable> params;
	private Tipo tipo;
	private List<DefinicionVariable> variablesLocales;
	private List<Sentencia> sentencias;

	public String toString() {
       return "{nombre:" + getNombre() + ", params:" + getParams() + ", tipo:" + getTipo() + ", variablesLocales:" + getVariablesLocales() + ", sentencias:" + getSentencias() + "}";
   }
}
