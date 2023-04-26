/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

//	tipoArray:tipo -> longitud:int  tipo:tipo

public class TipoArray extends AbstractTipo {

    public TipoArray(int longitud, Tipo tipo) {
        this.longitud = longitud;
        this.tipo = tipo;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(tipo);
    }

    public TipoArray(Object longitud, Object tipo) {
        this.longitud = (longitud instanceof Token) ? Integer.parseInt(((Token) longitud).getText()) : (Integer) longitud;
        this.tipo = (Tipo) getAST(tipo);

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(longitud, tipo);
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
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

    private int longitud;
    private Tipo tipo;

    public String toString() {
        return "{longitud:" + getLongitud() + ", tipo:" + getTipo() + "}";
    }

    @Override
    public int getTamaño() {
        return getTipo().getTamaño() * getLongitud();
    }

    @Override
    public String getSufijo() {
        return "";
    }
}
