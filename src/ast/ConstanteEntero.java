/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.Token;
import visitor.Visitor;

//	constanteEntero:expresion -> valor:int

public class ConstanteEntero extends AbstractExpresion {

    public ConstanteEntero(int valor) {
        this.valor = valor;
    }

    public ConstanteEntero(Object valor) {
        this.valor = (valor instanceof Token) ? Integer.parseInt(((Token) valor).getText()) : (Integer) valor;

        // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
        // Obtiene la linea/columna a partir de las de los hijos.
        setPositions(valor);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    private int valor;

    public String toString() {
        return "{valor:" + getValor() + "}";
    }
}
