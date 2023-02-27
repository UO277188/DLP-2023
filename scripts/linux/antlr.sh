clear
java -jar "../../antlr/antlr-4.7.2-complete.jar" -no-listener -package parser ../../src/parser/Grammar.g4

rm ../../src/parser/*.tokens
rm ../../src/parser/*.interp
