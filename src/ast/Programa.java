/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import visitor.*;

//	programa -> variables:definicionVariable*  structs:definicionStruct*  funciones:definicionFuncion*

public class Programa extends AbstractAST  {

	public Programa(List<DefinicionVariable> variables, List<DefinicionStruct> structs, List<DefinicionFuncion> funciones) {
		this.variables = variables;
		this.structs = structs;
		this.funciones = funciones;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(variables, structs, funciones);
	}

	public Programa(Object variables, Object structs, Object funciones) {
		this.variables = this.<DefinicionVariable>getAstFromContexts(variables);
		this.structs = this.<DefinicionStruct>getAstFromContexts(structs);
		this.funciones = this.<DefinicionFuncion>getAstFromContexts(funciones);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(variables, structs, funciones);
	}

	public List<DefinicionVariable> getVariables() {
		return variables;
	}
	public void setVariables(List<DefinicionVariable> variables) {
		this.variables = variables;
	}

	public List<DefinicionStruct> getStructs() {
		return structs;
	}
	public void setStructs(List<DefinicionStruct> structs) {
		this.structs = structs;
	}

	public List<DefinicionFuncion> getFunciones() {
		return funciones;
	}
	public void setFunciones(List<DefinicionFuncion> funciones) {
		this.funciones = funciones;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private List<DefinicionVariable> variables;
	private List<DefinicionStruct> structs;
	private List<DefinicionFuncion> funciones;

	public String toString() {
       return "{variables:" + getVariables() + ", structs:" + getStructs() + ", funciones:" + getFunciones() + "}";
   }
}
