/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

import java.util.List;
import java.util.Optional;

//	tipoStruct:tipo -> nombre:String  campos:campo*

public class TipoStruct extends AbstractTipo {

    public TipoStruct(String nombre, List<Campo> campos) {
        this.nombre = nombre;
        this.campos = campos;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(campos);
    }

    public TipoStruct(Object nombre, Object campos) {
        this.nombre = (nombre instanceof Token) ? ((Token) nombre).getText() : (String) nombre;
        this.campos = this.<Campo>getAstFromContexts(campos);

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

    public List<Campo> getCampos() {
        return campos;
    }

    public Campo getCampo(String nombre) {
        Optional<Campo> campo = getCampos().stream().filter(c -> c.getNombre().equals(nombre)).findFirst();
        return campo.orElse(null);
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private String nombre;
    private List<Campo> campos;

    public String toString() {
        return "{nombre:" + getNombre() + ", campos:" + getCampos() + "}";
    }

    public void addCampo(Campo c) {
        this.campos.add(c);
    }

    @Override
    public int getTamaño() {
        int tamaño = 0;
        for (Campo c: getCampos())
            tamaño += c.getTipo().getTamaño();
        return tamaño;
    }
}
