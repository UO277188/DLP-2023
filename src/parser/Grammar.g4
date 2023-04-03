grammar Grammar;
import Lexicon;

@parser::header {
    import ast.*;
}

start returns[Programa ast]
     : {  List<Definicion> defs = new ArrayList<Definicion>(); }
    ('var' defVar ';'   { defs.add($defVar.ast); }
        | defStruct     { defs.add($defStruct.ast); }
        | defFunc       { defs.add($defFunc.ast); }
    )* EOF
    {$ast = new Programa(defs); }
    ;

defVar returns[DefinicionVariable ast]
    : IDENT ':' tipo { $ast = new DefinicionVariable($IDENT, $tipo.ast); }
    ;

defFunc returns[DefinicionFuncion ast]
    : { List<DefinicionVariable> varDefs = new ArrayList<DefinicionVariable>();
        List<Sentencia> sentencias = new ArrayList<Sentencia>();
        Tipo tipo = new TipoVoid();
    }
    IDENT '(' funcDefParams ')' (':' tipo { tipo = $tipo.ast; } )? '{'
        ('var' defVar ';' { varDefs.add($defVar.ast); } )*
        (sentencia { sentencias.add($sentencia.ast); } )*
    '}'
    { $ast = new DefinicionFuncion($IDENT, $funcDefParams.ast, tipo, varDefs, sentencias); }
    ;

defStruct returns[DefinicionStruct ast]
    : { List<DefinicionCampo> defsCampo = new ArrayList<DefinicionCampo>(); }
    'struct' IDENT '{' (defCampo ';' { defsCampo.add($defCampo.ast); } )* '}' ';'
    { $ast = new DefinicionStruct($IDENT, defsCampo); }
    ;

defCampo returns[DefinicionCampo ast]
    : IDENT ':' tipo { $ast = new DefinicionCampo($IDENT, $tipo.ast); }
    ;

tipo returns[Tipo ast]
    : 'int'                     { $ast = new TipoEntero(); }
	| 'float'                   { $ast = new TipoReal(); }
	| 'char'                    { $ast = new TipoChar(); }
	| IDENT                     { $ast = new TipoStruct($IDENT); }
    | '[' LITENT ']' tipo      { $ast = new TipoArray($LITENT, $tipo.ast); }
    ;

sentencia returns[Sentencia ast]
    : TIPO_PRINT=('print'|'printsp'|'println') expr? ';'
        { $ast = new Print($expr.ast, $TIPO_PRINT); }
	| 'read' expr ';'
        { $ast = new Read($expr.ast); }
	| e1=expr '=' e2=expr ';'
        { $ast = new Asignacion($e1.ast, $e2.ast); }
	| { List<Sentencia> verdadero = new ArrayList<Sentencia>(); }
      { List<Sentencia> falso = new ArrayList<Sentencia>(); }
      'if' '(' expr ')' '{'
	        (v=sentencia { verdadero.add($v.ast); } )*
	   '}'  ('else' '{'
	        (f=sentencia { falso.add($f.ast); } )*
	   '}')?
        { $ast = new If($expr.ast, verdadero, falso); }
	| 'while' '(' expr ')'
        { List<Sentencia> cuerpo = new ArrayList<Sentencia>(); }
	    '{' (sentencia { cuerpo.add($sentencia.ast); } )* '}'
	    { $ast = new While($expr.ast, cuerpo); }
	| IDENT '(' params ')' ';'
	    { $ast = new Invocacion($IDENT, $params.ast); }
	| { List<Expresion> valor = new ArrayList<Expresion>(); }
      'return' (expr { valor.add($expr.ast); } )? ';'
	    { $ast = new Return(valor); }
	;

expr returns[Expresion ast]
    : LITENT    { $ast = new ConstanteEntero($LITENT); }
	| LITREAL   { $ast = new ConstanteReal($LITREAL); }
	| LITCHAR   { $ast = new ConstanteChar($LITCHAR); }
	| IDENT     { $ast = new Variable($IDENT); }
	| e1=expr '.' e2=expr
	    { $ast = new AccesoCampo($e1.ast, $e2.ast); }
	| e1=expr '[' e2=expr ']'
	    { $ast = new AccesoArray($e1.ast, $e2.ast); }
	| '<' tipo '>' '(' expr ')'
	    { $ast = new Conversion($tipo.ast, $expr.ast); }
	| '(' expr ')'
	    { $ast = $expr.ast; }
	| OP='!' expr
	    { $ast = new ExpresionUnaria($expr.ast, $OP); }
	| e1=expr OP=('*'|'/'|'%') e2=expr
	    { $ast = new ExpresionAritmetica($e1.ast, $OP, $e2.ast); }
	| e1=expr OP=('+'|'-') e2=expr
	    { $ast = new ExpresionAritmetica($e1.ast, $OP, $e2.ast); }
	| e1=expr OP=('<'|'>'|'>='|'<=') e2=expr
	    { $ast = new Comparacion($e1.ast, $OP, $e2.ast); }
	| e1=expr OP=('=='|'!=') e2=expr
	    { $ast = new Comparacion($e1.ast, $OP, $e2.ast); }
	| e1=expr OP='&&' e2=expr
	    { $ast = new ExpresionLogica($e1.ast, $OP, $e2.ast); }
	| e1=expr OP='||' e2=expr
	    { $ast = new ExpresionLogica($e1.ast, $OP, $e2.ast); }
	| IDENT '(' params ')'
	    { $ast = new InvocacionExpresion($IDENT, $params.ast); }
	;

params returns[List<Expresion> ast = new ArrayList<Expresion>()]
    : (e1=expr { $ast.add($e1.ast); } (',' e2=expr { $ast.add($e2.ast); })*)?
    ;

funcDefParams returns[List<DefinicionVariable> ast = new ArrayList<DefinicionVariable>()]
    : (d1=defVar { $ast.add($d1.ast); } (',' d2=defVar { $ast.add($d2.ast); })*)?
    |
    ;