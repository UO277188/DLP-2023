lexer grammar Lexicon;

LITENT: [0-9]+;
LITREAL: [0-9]+ '.' [0-9]+;
IDENT: [a-zA-Z_][a-zA-Z0-9_]*;
LITCHAR: '\'' '\\n' '\''
    | '\'' ~[\n\r\t] '\'';

COMMENT_MULTILINEA: '/*' .*? '*/' -> skip;
COMENT_LINEA: '//' .*? '\n' -> skip;
WS: [ \t\r\n]+ -> skip;
