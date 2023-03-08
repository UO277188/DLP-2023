/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	definicionStruct -> nombre:String  campos:definicionVariable*

public class DefinicionStruct extends AbstractAST  {

	public DefinicionStruct(String nombre, List<DefinicionVariable> campos) {
		this.nombre = nombre;
		this.campos = campos;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(campos);
	}

	public DefinicionStruct(Object nombre, Object campos) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.campos = this.<DefinicionVariable>getAstFromContexts(campos);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(nombre, campos);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<DefinicionVariable> getCampos() {
		return campos;
	}
	public void setCampos(List<DefinicionVariable> campos) {
		this.campos = campos;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private List<DefinicionVariable> campos;

	public String toString() {
       return "{nombre:" + getNombre() + ", campos:" + getCampos() + "}";
   }
}
