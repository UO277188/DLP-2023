/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

//	campo:definicion -> nombre:String  tipo:tipo

public class Campo extends AbstractDefinicion {

    public Campo(String nombre, Tipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(tipo);
    }

    public Campo(Object nombre, Object tipo) {
        this.nombre = (nombre instanceof Token) ? ((Token) nombre).getText() : (String) nombre;
        this.tipo = (Tipo) getAST(tipo);

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(nombre, tipo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private String nombre;
    private Tipo tipo;

    public int direccion;

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public String toString() {
        return "{nombre:" + getNombre() + ", tipo:" + getTipo() + "}";
    }
}
