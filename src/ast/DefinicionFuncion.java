/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	definicionFuncion -> params:definicionVariable*  tipo:tipo  variablesLocales:definicionVariable*  sentencia:sentencia*

public class DefinicionFuncion extends AbstractAST  {

	public DefinicionFuncion(List<DefinicionVariable> params, Tipo tipo, List<DefinicionVariable> variablesLocales, List<Sentencia> sentencia) {
		this.params = params;
		this.tipo = tipo;
		this.variablesLocales = variablesLocales;
		this.sentencia = sentencia;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(params, tipo, variablesLocales, sentencia);
	}

	public DefinicionFuncion(Object params, Object tipo, Object variablesLocales, Object sentencia) {
		this.params = this.<DefinicionVariable>getAstFromContexts(params);
		this.tipo = (Tipo) getAST(tipo);
		this.variablesLocales = this.<DefinicionVariable>getAstFromContexts(variablesLocales);
		this.sentencia = this.<Sentencia>getAstFromContexts(sentencia);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(params, tipo, variablesLocales, sentencia);
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

	public List<Sentencia> getSentencia() {
		return sentencia;
	}
	public void setSentencia(List<Sentencia> sentencia) {
		this.sentencia = sentencia;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private List<DefinicionVariable> params;
	private Tipo tipo;
	private List<DefinicionVariable> variablesLocales;
	private List<Sentencia> sentencia;

	public String toString() {
       return "{params:" + getParams() + ", tipo:" + getTipo() + ", variablesLocales:" + getVariablesLocales() + ", sentencia:" + getSentencia() + "}";
   }
}
