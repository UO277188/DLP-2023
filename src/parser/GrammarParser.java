// Generated from ../../src/parser/Grammar.g4 by ANTLR 4.7.2
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		LITENT=39, LITREAL=40, IDENT=41, LITCHAR=42, COMMENT_MULTILINEA=43, COMENT_LINEA=44, 
		WS=45;
	public static final int
		RULE_start = 0, RULE_programa = 1, RULE_tipo = 2, RULE_sentencia = 3, 
		RULE_expr = 4, RULE_params = 5, RULE_funcDefParams = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "programa", "tipo", "sentencia", "expr", "params", "funcDefParams"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'float'", "'char'", "'['", "']'", "'print'", "'printsp'", 
			"'println'", "';'", "'read'", "'='", "'if'", "'('", "')'", "'{'", "'}'", 
			"'else'", "'while'", "'var'", "':'", "'return'", "'struct'", "'*'", "'/'", 
			"'+'", "'-'", "'%'", "'&&'", "'||'", "'!'", "'<'", "'>'", "'>='", "'<='", 
			"'=='", "'!='", "'.'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "LITENT", "LITREAL", "IDENT", "LITCHAR", "COMMENT_MULTILINEA", 
			"COMENT_LINEA", "WS"
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

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public ProgramaContext programa() {
			return getRuleContext(ProgramaContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			programa();
			setState(15);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramaContext extends ParserRuleContext {
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
				{
				{
				setState(17);
				sentencia();
				}
				}
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tipo);
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(23);
				match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(24);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(25);
				match(T__2);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(26);
				match(IDENT);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 5);
				{
				setState(27);
				match(T__3);
				setState(28);
				expr(0);
				setState(29);
				match(T__4);
				setState(30);
				tipo();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public List<TipoContext> tipo() {
			return getRuleContexts(TipoContext.class);
		}
		public TipoContext tipo(int i) {
			return getRuleContext(TipoContext.class,i);
		}
		public List<ParamsContext> params() {
			return getRuleContexts(ParamsContext.class);
		}
		public ParamsContext params(int i) {
			return getRuleContext(ParamsContext.class,i);
		}
		public List<FuncDefParamsContext> funcDefParams() {
			return getRuleContexts(FuncDefParamsContext.class);
		}
		public FuncDefParamsContext funcDefParams(int i) {
			return getRuleContext(FuncDefParamsContext.class,i);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sentencia);
		int _la;
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
					{
					setState(35);
					expr(0);
					}
				}

				setState(38);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				match(T__9);
				setState(40);
				match(IDENT);
				setState(41);
				match(T__8);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				expr(0);
				setState(43);
				match(T__10);
				setState(44);
				expr(0);
				setState(45);
				match(T__8);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				match(T__11);
				setState(48);
				match(T__12);
				setState(49);
				expr(0);
				setState(50);
				match(T__13);
				setState(51);
				match(T__14);
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
					{
					{
					setState(52);
					sentencia();
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(58);
				match(T__15);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
				match(T__11);
				setState(61);
				match(T__12);
				setState(62);
				expr(0);
				setState(63);
				match(T__13);
				setState(64);
				match(T__14);
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
					{
					{
					setState(65);
					sentencia();
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(71);
				match(T__15);
				setState(72);
				match(T__16);
				setState(73);
				match(T__14);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
					{
					{
					setState(74);
					sentencia();
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(80);
				match(T__15);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				match(T__17);
				setState(83);
				match(T__12);
				setState(84);
				expr(0);
				setState(85);
				match(T__13);
				setState(86);
				match(T__14);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
					{
					{
					setState(87);
					sentencia();
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(93);
				match(T__15);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(95);
				match(T__18);
				setState(96);
				match(IDENT);
				setState(97);
				match(T__19);
				setState(98);
				tipo();
				setState(99);
				match(T__8);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(101);
				match(IDENT);
				setState(102);
				match(T__12);
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
					{
					{
					setState(103);
					params(0);
					}
					}
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(109);
				match(T__13);
				setState(110);
				match(T__8);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(111);
				match(IDENT);
				setState(112);
				match(T__12);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENT) {
					{
					{
					setState(113);
					funcDefParams(0);
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(119);
				match(T__13);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(120);
					match(T__19);
					setState(121);
					tipo();
					}
				}

				setState(124);
				match(T__14);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
					{
					{
					setState(125);
					sentencia();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(131);
				match(T__15);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(132);
				match(T__20);
				setState(133);
				expr(0);
				setState(134);
				match(T__8);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(136);
				match(T__21);
				setState(137);
				match(IDENT);
				setState(138);
				match(T__14);
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENT) {
					{
					{
					setState(139);
					match(IDENT);
					setState(140);
					match(T__19);
					setState(141);
					tipo();
					setState(142);
					match(T__8);
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(149);
				match(T__15);
				setState(150);
				match(T__8);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode LITENT() { return getToken(GrammarParser.LITENT, 0); }
		public TerminalNode LITREAL() { return getToken(GrammarParser.LITREAL, 0); }
		public TerminalNode LITCHAR() { return getToken(GrammarParser.LITCHAR, 0); }
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<ParamsContext> params() {
			return getRuleContexts(ParamsContext.class);
		}
		public ParamsContext params(int i) {
			return getRuleContext(ParamsContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(154);
				match(LITENT);
				}
				break;
			case 2:
				{
				setState(155);
				match(LITREAL);
				}
				break;
			case 3:
				{
				setState(156);
				match(LITCHAR);
				}
				break;
			case 4:
				{
				setState(157);
				match(IDENT);
				}
				break;
			case 5:
				{
				setState(158);
				match(T__12);
				setState(159);
				expr(0);
				setState(160);
				match(T__13);
				}
				break;
			case 6:
				{
				setState(162);
				match(T__30);
				setState(163);
				tipo();
				setState(164);
				match(T__31);
				setState(165);
				match(T__12);
				setState(166);
				expr(0);
				setState(167);
				match(T__13);
				}
				break;
			case 7:
				{
				setState(169);
				match(IDENT);
				setState(170);
				match(T__12);
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
					{
					{
					setState(171);
					params(0);
					}
					}
					setState(176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(177);
				match(T__13);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(209);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(180);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(181);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(182);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(183);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(184);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(185);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(186);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(187);
						match(T__26);
						setState(188);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(189);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(190);
						match(T__27);
						setState(191);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(192);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(193);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(194);
						expr(9);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(195);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(196);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(197);
						expr(8);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(198);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(199);
						_la = _input.LA(1);
						if ( !(_la==T__34 || _la==T__35) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(200);
						expr(7);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(201);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(202);
						match(T__36);
						setState(203);
						expr(2);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(204);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(205);
						match(T__3);
						setState(206);
						expr(0);
						setState(207);
						match(T__4);
						}
						break;
					}
					} 
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		return params(0);
	}

	private ParamsContext params(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParamsContext _localctx = new ParamsContext(_ctx, _parentState);
		ParamsContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_params, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(215);
			expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(222);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ParamsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_params);
					setState(217);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(218);
					match(T__37);
					setState(219);
					expr(0);
					}
					} 
				}
				setState(224);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FuncDefParamsContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public FuncDefParamsContext funcDefParams() {
			return getRuleContext(FuncDefParamsContext.class,0);
		}
		public FuncDefParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDefParams; }
	}

	public final FuncDefParamsContext funcDefParams() throws RecognitionException {
		return funcDefParams(0);
	}

	private FuncDefParamsContext funcDefParams(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FuncDefParamsContext _localctx = new FuncDefParamsContext(_ctx, _parentState);
		FuncDefParamsContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_funcDefParams, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(226);
			match(IDENT);
			setState(227);
			match(T__19);
			setState(228);
			tipo();
			}
			_ctx.stop = _input.LT(-1);
			setState(237);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FuncDefParamsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_funcDefParams);
					setState(230);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(231);
					match(T__37);
					setState(232);
					match(IDENT);
					setState(233);
					match(T__19);
					setState(234);
					tipo();
					}
					} 
				}
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 5:
			return params_sempred((ParamsContext)_localctx, predIndex);
		case 6:
			return funcDefParams_sempred((FuncDefParamsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean params_sempred(ParamsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean funcDefParams_sempred(FuncDefParamsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u00f3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\3\7\3\25"+
		"\n\3\f\3\16\3\30\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4#\n\4\3\5"+
		"\3\5\5\5\'\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\7\58\n\5\f\5\16\5;\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5E\n\5"+
		"\f\5\16\5H\13\5\3\5\3\5\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\7\5[\n\5\f\5\16\5^\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\7\5k\n\5\f\5\16\5n\13\5\3\5\3\5\3\5\3\5\3\5\7\5u\n\5"+
		"\f\5\16\5x\13\5\3\5\3\5\3\5\5\5}\n\5\3\5\3\5\7\5\u0081\n\5\f\5\16\5\u0084"+
		"\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0093\n"+
		"\5\f\5\16\5\u0096\13\5\3\5\3\5\5\5\u009a\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00af\n\6\f\6\16"+
		"\6\u00b2\13\6\3\6\5\6\u00b5\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\7\6\u00d4\n\6\f\6\16\6\u00d7\13\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7"+
		"\u00df\n\7\f\7\16\7\u00e2\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\7\b\u00ee\n\b\f\b\16\b\u00f1\13\b\3\b\2\5\n\f\16\t\2\4\6\b\n\f\16\2\b"+
		"\3\2\b\n\3\2\31\32\3\2\33\34\3\2\37 \3\2!$\3\2%&\2\u0116\2\20\3\2\2\2"+
		"\4\26\3\2\2\2\6\"\3\2\2\2\b\u0099\3\2\2\2\n\u00b4\3\2\2\2\f\u00d8\3\2"+
		"\2\2\16\u00e3\3\2\2\2\20\21\5\4\3\2\21\22\7\2\2\3\22\3\3\2\2\2\23\25\5"+
		"\b\5\2\24\23\3\2\2\2\25\30\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\5\3"+
		"\2\2\2\30\26\3\2\2\2\31#\7\3\2\2\32#\7\4\2\2\33#\7\5\2\2\34#\7+\2\2\35"+
		"\36\7\6\2\2\36\37\5\n\6\2\37 \7\7\2\2 !\5\6\4\2!#\3\2\2\2\"\31\3\2\2\2"+
		"\"\32\3\2\2\2\"\33\3\2\2\2\"\34\3\2\2\2\"\35\3\2\2\2#\7\3\2\2\2$&\t\2"+
		"\2\2%\'\5\n\6\2&%\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2(\u009a\7\13\2\2)*\7\f"+
		"\2\2*+\7+\2\2+\u009a\7\13\2\2,-\5\n\6\2-.\7\r\2\2./\5\n\6\2/\60\7\13\2"+
		"\2\60\u009a\3\2\2\2\61\62\7\16\2\2\62\63\7\17\2\2\63\64\5\n\6\2\64\65"+
		"\7\20\2\2\659\7\21\2\2\668\5\b\5\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\2"+
		"9:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7\22\2\2=\u009a\3\2\2\2>?\7\16\2\2?@"+
		"\7\17\2\2@A\5\n\6\2AB\7\20\2\2BF\7\21\2\2CE\5\b\5\2DC\3\2\2\2EH\3\2\2"+
		"\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7\22\2\2JK\7\23\2\2KO\7\21"+
		"\2\2LN\5\b\5\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2"+
		"\2\2RS\7\22\2\2S\u009a\3\2\2\2TU\7\24\2\2UV\7\17\2\2VW\5\n\6\2WX\7\20"+
		"\2\2X\\\7\21\2\2Y[\5\b\5\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]"+
		"_\3\2\2\2^\\\3\2\2\2_`\7\22\2\2`\u009a\3\2\2\2ab\7\25\2\2bc\7+\2\2cd\7"+
		"\26\2\2de\5\6\4\2ef\7\13\2\2f\u009a\3\2\2\2gh\7+\2\2hl\7\17\2\2ik\5\f"+
		"\7\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7\20"+
		"\2\2p\u009a\7\13\2\2qr\7+\2\2rv\7\17\2\2su\5\16\b\2ts\3\2\2\2ux\3\2\2"+
		"\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2y|\7\20\2\2z{\7\26\2\2{}\5\6"+
		"\4\2|z\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\u0082\7\21\2\2\177\u0081\5\b\5\2\u0080"+
		"\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2"+
		"\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u009a\7\22\2\2\u0086"+
		"\u0087\7\27\2\2\u0087\u0088\5\n\6\2\u0088\u0089\7\13\2\2\u0089\u009a\3"+
		"\2\2\2\u008a\u008b\7\30\2\2\u008b\u008c\7+\2\2\u008c\u0094\7\21\2\2\u008d"+
		"\u008e\7+\2\2\u008e\u008f\7\26\2\2\u008f\u0090\5\6\4\2\u0090\u0091\7\13"+
		"\2\2\u0091\u0093\3\2\2\2\u0092\u008d\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0097\u0098\7\22\2\2\u0098\u009a\7\13\2\2\u0099$\3\2\2\2\u0099)\3"+
		"\2\2\2\u0099,\3\2\2\2\u0099\61\3\2\2\2\u0099>\3\2\2\2\u0099T\3\2\2\2\u0099"+
		"a\3\2\2\2\u0099g\3\2\2\2\u0099q\3\2\2\2\u0099\u0086\3\2\2\2\u0099\u008a"+
		"\3\2\2\2\u009a\t\3\2\2\2\u009b\u009c\b\6\1\2\u009c\u00b5\7)\2\2\u009d"+
		"\u00b5\7*\2\2\u009e\u00b5\7,\2\2\u009f\u00b5\7+\2\2\u00a0\u00a1\7\17\2"+
		"\2\u00a1\u00a2\5\n\6\2\u00a2\u00a3\7\20\2\2\u00a3\u00b5\3\2\2\2\u00a4"+
		"\u00a5\7!\2\2\u00a5\u00a6\5\6\4\2\u00a6\u00a7\7\"\2\2\u00a7\u00a8\7\17"+
		"\2\2\u00a8\u00a9\5\n\6\2\u00a9\u00aa\7\20\2\2\u00aa\u00b5\3\2\2\2\u00ab"+
		"\u00ac\7+\2\2\u00ac\u00b0\7\17\2\2\u00ad\u00af\5\f\7\2\u00ae\u00ad\3\2"+
		"\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b5\7\20\2\2\u00b4\u009b\3"+
		"\2\2\2\u00b4\u009d\3\2\2\2\u00b4\u009e\3\2\2\2\u00b4\u009f\3\2\2\2\u00b4"+
		"\u00a0\3\2\2\2\u00b4\u00a4\3\2\2\2\u00b4\u00ab\3\2\2\2\u00b5\u00d5\3\2"+
		"\2\2\u00b6\u00b7\f\16\2\2\u00b7\u00b8\t\3\2\2\u00b8\u00d4\5\n\6\17\u00b9"+
		"\u00ba\f\r\2\2\u00ba\u00bb\t\4\2\2\u00bb\u00d4\5\n\6\16\u00bc\u00bd\f"+
		"\f\2\2\u00bd\u00be\7\35\2\2\u00be\u00d4\5\n\6\r\u00bf\u00c0\f\13\2\2\u00c0"+
		"\u00c1\7\36\2\2\u00c1\u00d4\5\n\6\f\u00c2\u00c3\f\n\2\2\u00c3\u00c4\t"+
		"\5\2\2\u00c4\u00d4\5\n\6\13\u00c5\u00c6\f\t\2\2\u00c6\u00c7\t\6\2\2\u00c7"+
		"\u00d4\5\n\6\n\u00c8\u00c9\f\b\2\2\u00c9\u00ca\t\7\2\2\u00ca\u00d4\5\n"+
		"\6\t\u00cb\u00cc\f\3\2\2\u00cc\u00cd\7\'\2\2\u00cd\u00d4\5\n\6\4\u00ce"+
		"\u00cf\f\4\2\2\u00cf\u00d0\7\6\2\2\u00d0\u00d1\5\n\6\2\u00d1\u00d2\7\7"+
		"\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00b6\3\2\2\2\u00d3\u00b9\3\2\2\2\u00d3"+
		"\u00bc\3\2\2\2\u00d3\u00bf\3\2\2\2\u00d3\u00c2\3\2\2\2\u00d3\u00c5\3\2"+
		"\2\2\u00d3\u00c8\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d4"+
		"\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\13\3\2\2"+
		"\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\b\7\1\2\u00d9\u00da\5\n\6\2\u00da\u00e0"+
		"\3\2\2\2\u00db\u00dc\f\3\2\2\u00dc\u00dd\7(\2\2\u00dd\u00df\5\n\6\2\u00de"+
		"\u00db\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\r\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\b\b\1\2\u00e4\u00e5"+
		"\7+\2\2\u00e5\u00e6\7\26\2\2\u00e6\u00e7\5\6\4\2\u00e7\u00ef\3\2\2\2\u00e8"+
		"\u00e9\f\3\2\2\u00e9\u00ea\7(\2\2\u00ea\u00eb\7+\2\2\u00eb\u00ec\7\26"+
		"\2\2\u00ec\u00ee\5\6\4\2\u00ed\u00e8\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\17\3\2\2\2\u00f1\u00ef\3\2\2"+
		"\2\25\26\"&9FO\\lv|\u0082\u0094\u0099\u00b0\u00b4\u00d3\u00d5\u00e0\u00ef";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}