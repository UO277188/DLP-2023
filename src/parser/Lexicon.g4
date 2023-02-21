lexer grammar Lexicon;

INT: 'int';
FLOAT: 'float';
CODE: 'CODE';
DATA: 'DATA';
PRINT: 'print';

IDENT: [a-zA-Z][a-zA-Z0-9_]*;

FLOAT_CONSTANT: [0-9]+'.'[0-9]+;

INT_CONSTANT: [0-9]+;

SUMA: '+';
RESTA: '-';
MULT: '*';
DIV: '/';
ASIGNACION: '=';
PUNTO_COMA: ';';

PARENTESIS_ABRIR: '(';
PARENTESIS_CERRAR:  ')';

LINE_COMMENT: '//' .*? ('\n' | EOF) -> skip;

MULTILINE_COMMENT: '/*' .*? '*/' -> skip;

WHITESPACE: [ \t\r\n]+ -> skip;
