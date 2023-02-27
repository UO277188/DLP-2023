grammar Grammar;
import Lexicon;

start: programa EOF ;
programa: sentencia* ;
tipo: 'int'
	| 'float'
	| 'char'
	| IDENT
	| '[' expr ']' tipo;

sentencia: ('print'|'printsp'|'println') expr? ';'
	| 'read' IDENT ';'
	| expr '=' expr ';'
	| 'if' '(' expr ')' '{' sentencia* '}'
	| 'if' '(' expr ')' '{' sentencia* '}' 'else' '{' sentencia* '}'
	| 'while' '(' expr ')' '{' sentencia* '}'
	| 'var' IDENT ':' tipo ';'
	| IDENT '(' params* ')' ';'
	| IDENT '(' funcDefParams* ')' (':' tipo)? '{' sentencia* '}'
	| 'return' expr ';'
	| 'struct' IDENT '{' (IDENT ':' tipo ';')* '}' ';' ;

expr: LITENT
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
	| IDENT '(' params* ')'
	| expr '[' expr ']'
	| expr '.' expr ;

params: expr | params ',' expr ;
funcDefParams: IDENT ':' tipo | funcDefParams ',' IDENT ':' tipo ;