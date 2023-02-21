grammar Grammar;
import Lexicon;

start: DATA variables CODE sentencias EOF;

variables: | variables variable;
variable: tipo IDENT PUNTO_COMA;
tipo: INT | FLOAT;

sentencias: | sentencias sentencia;
sentencia: PRINT expr ';'
    | expr '=' expr ';';

expr: expr ('*'|'/') expr
    | expr ('+'|'-') expr
    | '(' expr ')'
    | IDENT | INT_CONSTANT | FLOAT_CONSTANT;