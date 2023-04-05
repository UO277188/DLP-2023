/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;

import ast.*;

public interface Visitor {
	public Object visit(Programa node, Object param);
	public Object visit(DefinicionFuncion node, Object param);
	public Object visit(DefinicionVariable node, Object param);
	public Object visit(DefinicionStruct node, Object param);
	public Object visit(Campo node, Object param);
	public Object visit(TipoEntero node, Object param);
	public Object visit(TipoReal node, Object param);
	public Object visit(TipoChar node, Object param);
	public Object visit(TipoArray node, Object param);
	public Object visit(TipoStruct node, Object param);
	public Object visit(TipoVoid node, Object param);
	public Object visit(Print node, Object param);
	public Object visit(Read node, Object param);
	public Object visit(Asignacion node, Object param);
	public Object visit(If node, Object param);
	public Object visit(While node, Object param);
	public Object visit(Invocacion node, Object param);
	public Object visit(Return node, Object param);
	public Object visit(ConstanteEntero node, Object param);
	public Object visit(ConstanteReal node, Object param);
	public Object visit(ConstanteChar node, Object param);
	public Object visit(Variable node, Object param);
	public Object visit(ExpresionAritmetica node, Object param);
	public Object visit(ExpresionLogica node, Object param);
	public Object visit(Comparacion node, Object param);
	public Object visit(ExpresionUnaria node, Object param);
	public Object visit(Conversion node, Object param);
	public Object visit(InvocacionExpresion node, Object param);
	public Object visit(AccesoArray node, Object param);
	public Object visit(AccesoCampo node, Object param);
}
