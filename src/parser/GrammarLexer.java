// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, FLOAT=2, CODE=3, DATA=4, PRINT=5, IDENT=6, FLOAT_CONSTANT=7, INT_CONSTANT=8, 
		SUMA=9, RESTA=10, MULT=11, DIV=12, ASIGNACION=13, PUNTO_COMA=14, PARENTESIS_ABRIR=15, 
		PARENTESIS_CERRAR=16, LINE_COMMENT=17, MULTILINE_COMMENT=18, WHITESPACE=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "FLOAT", "CODE", "DATA", "PRINT", "IDENT", "FLOAT_CONSTANT", "INT_CONSTANT", 
			"SUMA", "RESTA", "MULT", "DIV", "ASIGNACION", "PUNTO_COMA", "PARENTESIS_ABRIR", 
			"PARENTESIS_CERRAR", "LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'float'", "'CODE'", "'DATA'", "'print'", null, null, 
			null, "'+'", "'-'", "'*'", "'/'", "'='", "';'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "FLOAT", "CODE", "DATA", "PRINT", "IDENT", "FLOAT_CONSTANT", 
			"INT_CONSTANT", "SUMA", "RESTA", "MULT", "DIV", "ASIGNACION", "PUNTO_COMA", 
			"PARENTESIS_ABRIR", "PARENTESIS_CERRAR", "LINE_COMMENT", "MULTILINE_COMMENT", 
			"WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u008d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\7"+
		"\7F\n\7\f\7\16\7I\13\7\3\b\6\bL\n\b\r\b\16\bM\3\b\3\b\6\bR\n\b\r\b\16"+
		"\bS\3\t\6\tW\n\t\r\t\16\tX\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\7\22o\n\22\f\22\16"+
		"\22r\13\22\3\22\5\22u\n\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23}\n\23\f"+
		"\23\16\23\u0080\13\23\3\23\3\23\3\23\3\23\3\23\3\24\6\24\u0088\n\24\r"+
		"\24\16\24\u0089\3\24\3\24\4p~\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\7\4\2C\\"+
		"c|\6\2\62;C\\aac|\3\2\62;\3\3\f\f\5\2\13\f\17\17\"\"\2\u0093\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\3)\3\2\2\2\5-\3\2\2\2\7\63\3\2\2\2\t8\3\2\2\2\13=\3\2"+
		"\2\2\rC\3\2\2\2\17K\3\2\2\2\21V\3\2\2\2\23Z\3\2\2\2\25\\\3\2\2\2\27^\3"+
		"\2\2\2\31`\3\2\2\2\33b\3\2\2\2\35d\3\2\2\2\37f\3\2\2\2!h\3\2\2\2#j\3\2"+
		"\2\2%x\3\2\2\2\'\u0087\3\2\2\2)*\7k\2\2*+\7p\2\2+,\7v\2\2,\4\3\2\2\2-"+
		".\7h\2\2./\7n\2\2/\60\7q\2\2\60\61\7c\2\2\61\62\7v\2\2\62\6\3\2\2\2\63"+
		"\64\7E\2\2\64\65\7Q\2\2\65\66\7F\2\2\66\67\7G\2\2\67\b\3\2\2\289\7F\2"+
		"\29:\7C\2\2:;\7V\2\2;<\7C\2\2<\n\3\2\2\2=>\7r\2\2>?\7t\2\2?@\7k\2\2@A"+
		"\7p\2\2AB\7v\2\2B\f\3\2\2\2CG\t\2\2\2DF\t\3\2\2ED\3\2\2\2FI\3\2\2\2GE"+
		"\3\2\2\2GH\3\2\2\2H\16\3\2\2\2IG\3\2\2\2JL\t\4\2\2KJ\3\2\2\2LM\3\2\2\2"+
		"MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OQ\7\60\2\2PR\t\4\2\2QP\3\2\2\2RS\3\2\2"+
		"\2SQ\3\2\2\2ST\3\2\2\2T\20\3\2\2\2UW\t\4\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2"+
		"\2\2XY\3\2\2\2Y\22\3\2\2\2Z[\7-\2\2[\24\3\2\2\2\\]\7/\2\2]\26\3\2\2\2"+
		"^_\7,\2\2_\30\3\2\2\2`a\7\61\2\2a\32\3\2\2\2bc\7?\2\2c\34\3\2\2\2de\7"+
		"=\2\2e\36\3\2\2\2fg\7*\2\2g \3\2\2\2hi\7+\2\2i\"\3\2\2\2jk\7\61\2\2kl"+
		"\7\61\2\2lp\3\2\2\2mo\13\2\2\2nm\3\2\2\2or\3\2\2\2pq\3\2\2\2pn\3\2\2\2"+
		"qt\3\2\2\2rp\3\2\2\2su\t\5\2\2ts\3\2\2\2uv\3\2\2\2vw\b\22\2\2w$\3\2\2"+
		"\2xy\7\61\2\2yz\7,\2\2z~\3\2\2\2{}\13\2\2\2|{\3\2\2\2}\u0080\3\2\2\2~"+
		"\177\3\2\2\2~|\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7"+
		",\2\2\u0082\u0083\7\61\2\2\u0083\u0084\3\2\2\2\u0084\u0085\b\23\2\2\u0085"+
		"&\3\2\2\2\u0086\u0088\t\6\2\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2"+
		"\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c"+
		"\b\24\2\2\u008c(\3\2\2\2\13\2GMSXpt~\u0089\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}