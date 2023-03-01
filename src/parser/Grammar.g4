grammar Grammar;
import Lexicon;

start: programa EOF ;

defVarGlobal:
    'var' IDENT ':' tipo ';'
    ;

defFunc:
    IDENT '(' funcDefParamsOpt ')' (':' tipo)? '{' defVarLocal* sentencia* '}'
    ;

defStruct:
    'struct' IDENT '{' (IDENT ':' tipo ';')* '}' ';'
    ;

programa:
    (defVarGlobal | defStruct | defFunc)*
    ;

tipo:
    'int'
	| 'float'
	| 'char'
	| IDENT
	| '[' expr ']' tipo;

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

defVarLocal:
    'var' IDENT ':' tipo ';'
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
    IDENT ':' tipo
    | funcDefParams ',' IDENT ':' tipo
    ;