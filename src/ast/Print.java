/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

import java.util.List;

//	print:sentencia -> expresion:expresion  tipo_print:String

public class Print extends AbstractSentencia {

    public Print(List<Expresion> expresiones, String tipo_print) {
        this.expresiones = expresiones;
        this.tipo_print = tipo_print;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(expresiones);
    }

    public Print(Object expresion, Object tipo_print) {
        this.expresiones = this.<Expresion>getAstFromContexts(expresion);
        this.tipo_print = (tipo_print instanceof Token) ? ((Token) tipo_print).getText() : (String) tipo_print;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(expresion, tipo_print);
    }

    public List<Expresion> getExpresiones() {
        return expresiones;
    }

    public void setExpresiones(List<Expresion> expresiones) {
        this.expresiones = expresiones;
    }

    public String getTipo_print() {
        return tipo_print;
    }

    public void setTipo_print(String tipo_print) {
        this.tipo_print = tipo_print;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private List<Expresion> expresiones;
    private String tipo_print;

    public String toString() {
        return "{expresiones:" + getExpresiones() + ", tipo_print:" + getTipo_print() + "}";
    }
}
