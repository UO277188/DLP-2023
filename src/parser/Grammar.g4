grammar Grammar;
import Lexicon;

start: ('var' defVar ';' | defStruct | defFunc)* EOF ;

defFunc:
    IDENT '(' funcDefParamsOpt ')' (':' tipo)? '{' ('var' defVar ';')* sentencia* '}'
    ;

defStruct:
    'struct' IDENT '{' (defVar ';')* '}' ';'
    ;

tipo:
    'int'
	| 'float'
	| 'char'
	| IDENT
	| '[' LITENT ']' tipo;

sentencia:
    ('print'|'printsp'|'println') expr? ';'
	| 'read' expr ';'
	| expr '=' expr ';'
	| 'if' '(' expr ')' '{' sentencia* '}' ('else' '{' sentencia* '}')?
	| 'while' '(' expr ')' '{' sentencia* '}'
	| IDENT '(' params* ')' ';'
	| 'return' expr? ';'
	;

expr:
    LITENT
	| LITREAL
	| LITCHAR
	| IDENT
	| expr ('*'|'/') expr
	| expr ('+'|'-') expr
	| expr '%' expr
	| expr '&&' expr
	| expr ('||'|'!') expr
	| expr ('<'|'>'|'>='|'<=') expr
	| expr ('=='|'!=') expr
	| '(' expr ')'
	| '<' tipo '>' '(' expr ')'
	| IDENT '(' paramOpt ')'
	| expr '[' expr ']'
	| expr '.' expr
	;

defVar:
    IDENT ':' tipo
    ;

paramOpt:
    params
    |
    ;
params:
    expr
    | params ',' expr
    ;

funcDefParamsOpt:
    funcDefParams
    |
    ;
funcDefParams:
    defVar
    | funcDefParams ',' defVar
    ;