/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

public abstract class AbstractExpresion extends AbstractAST implements Expresion {
    private Tipo tipo;
    public Tipo getTipo(){
        return tipo;
    }

    public void setTipo(Tipo t){
        this.tipo=t;
    }

    private boolean modificable;

    public boolean isModificable() {
        return modificable;
    }

    public void setModificable(boolean modificable) {
        this.modificable = modificable;
    }
}
