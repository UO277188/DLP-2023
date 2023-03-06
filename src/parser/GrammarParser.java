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
		RULE_start = 0, RULE_defFunc = 1, RULE_defStruct = 2, RULE_tipo = 3, RULE_sentencia = 4, 
		RULE_expr = 5, RULE_defVar = 6, RULE_paramOpt = 7, RULE_params = 8, RULE_funcDefParamsOpt = 9, 
		RULE_funcDefParams = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "defFunc", "defStruct", "tipo", "sentencia", "expr", "defVar", 
			"paramOpt", "params", "funcDefParamsOpt", "funcDefParams"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "';'", "'('", "')'", "':'", "'{'", "'}'", "'struct'", 
			"'int'", "'float'", "'char'", "'['", "']'", "'print'", "'printsp'", "'println'", 
			"'read'", "'='", "'if'", "'else'", "'while'", "'return'", "'*'", "'/'", 
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
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<DefVarContext> defVar() {
			return getRuleContexts(DefVarContext.class);
		}
		public DefVarContext defVar(int i) {
			return getRuleContext(DefVarContext.class,i);
		}
		public List<DefStructContext> defStruct() {
			return getRuleContexts(DefStructContext.class);
		}
		public DefStructContext defStruct(int i) {
			return getRuleContext(DefStructContext.class,i);
		}
		public List<DefFuncContext> defFunc() {
			return getRuleContexts(DefFuncContext.class);
		}
		public DefFuncContext defFunc(int i) {
			return getRuleContext(DefFuncContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << IDENT))) != 0)) {
				{
				setState(28);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(22);
					match(T__0);
					setState(23);
					defVar();
					setState(24);
					match(T__1);
					}
					break;
				case T__7:
					{
					setState(26);
					defStruct();
					}
					break;
				case IDENT:
					{
					setState(27);
					defFunc();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(33);
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

	public static class DefFuncContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public FuncDefParamsOptContext funcDefParamsOpt() {
			return getRuleContext(FuncDefParamsOptContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<DefVarContext> defVar() {
			return getRuleContexts(DefVarContext.class);
		}
		public DefVarContext defVar(int i) {
			return getRuleContext(DefVarContext.class,i);
		}
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public DefFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defFunc; }
	}

	public final DefFuncContext defFunc() throws RecognitionException {
		DefFuncContext _localctx = new DefFuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_defFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(IDENT);
			setState(36);
			match(T__2);
			setState(37);
			funcDefParamsOpt();
			setState(38);
			match(T__3);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(39);
				match(T__4);
				setState(40);
				tipo();
				}
			}

			setState(43);
			match(T__5);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(44);
				match(T__0);
				setState(45);
				defVar();
				setState(46);
				match(T__1);
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
				{
				{
				setState(53);
				sentencia();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(T__6);
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

	public static class DefStructContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public List<TipoContext> tipo() {
			return getRuleContexts(TipoContext.class);
		}
		public TipoContext tipo(int i) {
			return getRuleContext(TipoContext.class,i);
		}
		public DefStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defStruct; }
	}

	public final DefStructContext defStruct() throws RecognitionException {
		DefStructContext _localctx = new DefStructContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_defStruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__7);
			setState(62);
			match(IDENT);
			setState(63);
			match(T__5);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(64);
				match(IDENT);
				setState(65);
				match(T__4);
				setState(66);
				tipo();
				setState(67);
				match(T__1);
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(T__6);
			setState(75);
			match(T__1);
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
		public TerminalNode LITENT() { return getToken(GrammarParser.LITENT, 0); }
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
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(T__8);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(T__9);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(T__10);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(IDENT);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				match(T__11);
				setState(82);
				match(LITENT);
				setState(83);
				match(T__12);
				setState(84);
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
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<ParamsContext> params() {
			return getRuleContexts(ParamsContext.class);
		}
		public ParamsContext params(int i) {
			return getRuleContext(ParamsContext.class,i);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sentencia);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
					{
					setState(88);
					expr(0);
					}
				}

				setState(91);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(T__16);
				setState(93);
				expr(0);
				setState(94);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				expr(0);
				setState(97);
				match(T__17);
				setState(98);
				expr(0);
				setState(99);
				match(T__1);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				match(T__18);
				setState(102);
				match(T__2);
				setState(103);
				expr(0);
				setState(104);
				match(T__3);
				setState(105);
				match(T__5);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
					{
					{
					setState(106);
					sentencia();
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112);
				match(T__6);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(113);
					match(T__19);
					setState(114);
					match(T__5);
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
						{
						{
						setState(115);
						sentencia();
						}
						}
						setState(120);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(121);
					match(T__6);
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				match(T__20);
				setState(125);
				match(T__2);
				setState(126);
				expr(0);
				setState(127);
				match(T__3);
				setState(128);
				match(T__5);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__20) | (1L << T__21) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
					{
					{
					setState(129);
					sentencia();
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(135);
				match(T__6);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(137);
				match(IDENT);
				setState(138);
				match(T__2);
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
					{
					{
					setState(139);
					params(0);
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(145);
				match(T__3);
				setState(146);
				match(T__1);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(147);
				match(T__21);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__30) | (1L << LITENT) | (1L << LITREAL) | (1L << IDENT) | (1L << LITCHAR))) != 0)) {
					{
					setState(148);
					expr(0);
					}
				}

				setState(151);
				match(T__1);
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
		public ParamOptContext paramOpt() {
			return getRuleContext(ParamOptContext.class,0);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(155);
				match(LITENT);
				}
				break;
			case 2:
				{
				setState(156);
				match(LITREAL);
				}
				break;
			case 3:
				{
				setState(157);
				match(LITCHAR);
				}
				break;
			case 4:
				{
				setState(158);
				match(IDENT);
				}
				break;
			case 5:
				{
				setState(159);
				match(T__2);
				setState(160);
				expr(0);
				setState(161);
				match(T__3);
				}
				break;
			case 6:
				{
				setState(163);
				match(T__30);
				setState(164);
				tipo();
				setState(165);
				match(T__31);
				setState(166);
				match(T__2);
				setState(167);
				expr(0);
				setState(168);
				match(T__3);
				}
				break;
			case 7:
				{
				setState(170);
				match(IDENT);
				setState(171);
				match(T__2);
				setState(172);
				paramOpt();
				setState(173);
				match(T__3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(206);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(177);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(178);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(179);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(180);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(181);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(182);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(183);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(184);
						match(T__26);
						setState(185);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(186);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(187);
						match(T__27);
						setState(188);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(189);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(190);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(191);
						expr(9);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(192);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(193);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(194);
						expr(8);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(195);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(196);
						_la = _input.LA(1);
						if ( !(_la==T__34 || _la==T__35) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(197);
						expr(7);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(198);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(199);
						match(T__36);
						setState(200);
						expr(2);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(201);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(202);
						match(T__11);
						setState(203);
						expr(0);
						setState(204);
						match(T__12);
						}
						break;
					}
					} 
				}
				setState(210);
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

	public static class DefVarContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DefVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defVar; }
	}

	public final DefVarContext defVar() throws RecognitionException {
		DefVarContext _localctx = new DefVarContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_defVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(IDENT);
			setState(212);
			match(T__4);
			setState(213);
			tipo();
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

	public static class ParamOptContext extends ParserRuleContext {
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ParamOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramOpt; }
	}

	public final ParamOptContext paramOpt() throws RecognitionException {
		ParamOptContext _localctx = new ParamOptContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_paramOpt);
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__30:
			case LITENT:
			case LITREAL:
			case IDENT:
			case LITCHAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				params(0);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_params, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(220);
			expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(227);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ParamsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_params);
					setState(222);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(223);
					match(T__37);
					setState(224);
					expr(0);
					}
					} 
				}
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class FuncDefParamsOptContext extends ParserRuleContext {
		public FuncDefParamsContext funcDefParams() {
			return getRuleContext(FuncDefParamsContext.class,0);
		}
		public FuncDefParamsOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDefParamsOpt; }
	}

	public final FuncDefParamsOptContext funcDefParamsOpt() throws RecognitionException {
		FuncDefParamsOptContext _localctx = new FuncDefParamsOptContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcDefParamsOpt);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				funcDefParams(0);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class FuncDefParamsContext extends ParserRuleContext {
		public DefVarContext defVar() {
			return getRuleContext(DefVarContext.class,0);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_funcDefParams, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(235);
			defVar();
			}
			_ctx.stop = _input.LT(-1);
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FuncDefParamsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_funcDefParams);
					setState(237);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(238);
					match(T__37);
					setState(239);
					defVar();
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 8:
			return params_sempred((ParamsContext)_localctx, predIndex);
		case 10:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u00f8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3,\n\3\3\3\3\3\3\3\3\3\3\3\7\3\63\n\3\f\3\16"+
		"\3\66\13\3\3\3\7\39\n\3\f\3\16\3<\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\7\4H\n\4\f\4\16\4K\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5X\n\5\3\6\3\6\5\6\\\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6n\n\6\f\6\16\6q\13\6\3\6\3\6\3\6\3\6\7"+
		"\6w\n\6\f\6\16\6z\13\6\3\6\5\6}\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0085"+
		"\n\6\f\6\16\6\u0088\13\6\3\6\3\6\3\6\3\6\3\6\7\6\u008f\n\6\f\6\16\6\u0092"+
		"\13\6\3\6\3\6\3\6\3\6\5\6\u0098\n\6\3\6\5\6\u009b\n\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5"+
		"\7\u00b2\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00d1\n"+
		"\7\f\7\16\7\u00d4\13\7\3\b\3\b\3\b\3\b\3\t\3\t\5\t\u00dc\n\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\7\n\u00e4\n\n\f\n\16\n\u00e7\13\n\3\13\3\13\5\13\u00eb"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00f3\n\f\f\f\16\f\u00f6\13\f\3\f\2"+
		"\5\f\22\26\r\2\4\6\b\n\f\16\20\22\24\26\2\b\3\2\20\22\3\2\31\32\3\2\33"+
		"\34\3\2\37 \3\2!$\3\2%&\2\u0117\2 \3\2\2\2\4%\3\2\2\2\6?\3\2\2\2\bW\3"+
		"\2\2\2\n\u009a\3\2\2\2\f\u00b1\3\2\2\2\16\u00d5\3\2\2\2\20\u00db\3\2\2"+
		"\2\22\u00dd\3\2\2\2\24\u00ea\3\2\2\2\26\u00ec\3\2\2\2\30\31\7\3\2\2\31"+
		"\32\5\16\b\2\32\33\7\4\2\2\33\37\3\2\2\2\34\37\5\6\4\2\35\37\5\4\3\2\36"+
		"\30\3\2\2\2\36\34\3\2\2\2\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2"+
		"\2\2!#\3\2\2\2\" \3\2\2\2#$\7\2\2\3$\3\3\2\2\2%&\7+\2\2&\'\7\5\2\2\'("+
		"\5\24\13\2(+\7\6\2\2)*\7\7\2\2*,\5\b\5\2+)\3\2\2\2+,\3\2\2\2,-\3\2\2\2"+
		"-\64\7\b\2\2./\7\3\2\2/\60\5\16\b\2\60\61\7\4\2\2\61\63\3\2\2\2\62.\3"+
		"\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65:\3\2\2\2\66\64\3\2"+
		"\2\2\679\5\n\6\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<"+
		":\3\2\2\2=>\7\t\2\2>\5\3\2\2\2?@\7\n\2\2@A\7+\2\2AI\7\b\2\2BC\7+\2\2C"+
		"D\7\7\2\2DE\5\b\5\2EF\7\4\2\2FH\3\2\2\2GB\3\2\2\2HK\3\2\2\2IG\3\2\2\2"+
		"IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7\t\2\2MN\7\4\2\2N\7\3\2\2\2OX\7\13\2"+
		"\2PX\7\f\2\2QX\7\r\2\2RX\7+\2\2ST\7\16\2\2TU\7)\2\2UV\7\17\2\2VX\5\b\5"+
		"\2WO\3\2\2\2WP\3\2\2\2WQ\3\2\2\2WR\3\2\2\2WS\3\2\2\2X\t\3\2\2\2Y[\t\2"+
		"\2\2Z\\\5\f\7\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]\u009b\7\4\2\2^_\7\23"+
		"\2\2_`\5\f\7\2`a\7\4\2\2a\u009b\3\2\2\2bc\5\f\7\2cd\7\24\2\2de\5\f\7\2"+
		"ef\7\4\2\2f\u009b\3\2\2\2gh\7\25\2\2hi\7\5\2\2ij\5\f\7\2jk\7\6\2\2ko\7"+
		"\b\2\2ln\5\n\6\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3"+
		"\2\2\2r|\7\t\2\2st\7\26\2\2tx\7\b\2\2uw\5\n\6\2vu\3\2\2\2wz\3\2\2\2xv"+
		"\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{}\7\t\2\2|s\3\2\2\2|}\3\2\2\2}"+
		"\u009b\3\2\2\2~\177\7\27\2\2\177\u0080\7\5\2\2\u0080\u0081\5\f\7\2\u0081"+
		"\u0082\7\6\2\2\u0082\u0086\7\b\2\2\u0083\u0085\5\n\6\2\u0084\u0083\3\2"+
		"\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7\t\2\2\u008a\u009b\3\2"+
		"\2\2\u008b\u008c\7+\2\2\u008c\u0090\7\5\2\2\u008d\u008f\5\22\n\2\u008e"+
		"\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7\6\2\2\u0094"+
		"\u009b\7\4\2\2\u0095\u0097\7\30\2\2\u0096\u0098\5\f\7\2\u0097\u0096\3"+
		"\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\7\4\2\2\u009a"+
		"Y\3\2\2\2\u009a^\3\2\2\2\u009ab\3\2\2\2\u009ag\3\2\2\2\u009a~\3\2\2\2"+
		"\u009a\u008b\3\2\2\2\u009a\u0095\3\2\2\2\u009b\13\3\2\2\2\u009c\u009d"+
		"\b\7\1\2\u009d\u00b2\7)\2\2\u009e\u00b2\7*\2\2\u009f\u00b2\7,\2\2\u00a0"+
		"\u00b2\7+\2\2\u00a1\u00a2\7\5\2\2\u00a2\u00a3\5\f\7\2\u00a3\u00a4\7\6"+
		"\2\2\u00a4\u00b2\3\2\2\2\u00a5\u00a6\7!\2\2\u00a6\u00a7\5\b\5\2\u00a7"+
		"\u00a8\7\"\2\2\u00a8\u00a9\7\5\2\2\u00a9\u00aa\5\f\7\2\u00aa\u00ab\7\6"+
		"\2\2\u00ab\u00b2\3\2\2\2\u00ac\u00ad\7+\2\2\u00ad\u00ae\7\5\2\2\u00ae"+
		"\u00af\5\20\t\2\u00af\u00b0\7\6\2\2\u00b0\u00b2\3\2\2\2\u00b1\u009c\3"+
		"\2\2\2\u00b1\u009e\3\2\2\2\u00b1\u009f\3\2\2\2\u00b1\u00a0\3\2\2\2\u00b1"+
		"\u00a1\3\2\2\2\u00b1\u00a5\3\2\2\2\u00b1\u00ac\3\2\2\2\u00b2\u00d2\3\2"+
		"\2\2\u00b3\u00b4\f\16\2\2\u00b4\u00b5\t\3\2\2\u00b5\u00d1\5\f\7\17\u00b6"+
		"\u00b7\f\r\2\2\u00b7\u00b8\t\4\2\2\u00b8\u00d1\5\f\7\16\u00b9\u00ba\f"+
		"\f\2\2\u00ba\u00bb\7\35\2\2\u00bb\u00d1\5\f\7\r\u00bc\u00bd\f\13\2\2\u00bd"+
		"\u00be\7\36\2\2\u00be\u00d1\5\f\7\f\u00bf\u00c0\f\n\2\2\u00c0\u00c1\t"+
		"\5\2\2\u00c1\u00d1\5\f\7\13\u00c2\u00c3\f\t\2\2\u00c3\u00c4\t\6\2\2\u00c4"+
		"\u00d1\5\f\7\n\u00c5\u00c6\f\b\2\2\u00c6\u00c7\t\7\2\2\u00c7\u00d1\5\f"+
		"\7\t\u00c8\u00c9\f\3\2\2\u00c9\u00ca\7\'\2\2\u00ca\u00d1\5\f\7\4\u00cb"+
		"\u00cc\f\4\2\2\u00cc\u00cd\7\16\2\2\u00cd\u00ce\5\f\7\2\u00ce\u00cf\7"+
		"\17\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00b3\3\2\2\2\u00d0\u00b6\3\2\2\2\u00d0"+
		"\u00b9\3\2\2\2\u00d0\u00bc\3\2\2\2\u00d0\u00bf\3\2\2\2\u00d0\u00c2\3\2"+
		"\2\2\u00d0\u00c5\3\2\2\2\u00d0\u00c8\3\2\2\2\u00d0\u00cb\3\2\2\2\u00d1"+
		"\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\r\3\2\2\2"+
		"\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7+\2\2\u00d6\u00d7\7\7\2\2\u00d7\u00d8"+
		"\5\b\5\2\u00d8\17\3\2\2\2\u00d9\u00dc\5\22\n\2\u00da\u00dc\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc\21\3\2\2\2\u00dd\u00de\b\n\1"+
		"\2\u00de\u00df\5\f\7\2\u00df\u00e5\3\2\2\2\u00e0\u00e1\f\3\2\2\u00e1\u00e2"+
		"\7(\2\2\u00e2\u00e4\5\f\7\2\u00e3\u00e0\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\23\3\2\2\2\u00e7\u00e5\3\2\2"+
		"\2\u00e8\u00eb\5\26\f\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea"+
		"\u00e9\3\2\2\2\u00eb\25\3\2\2\2\u00ec\u00ed\b\f\1\2\u00ed\u00ee\5\16\b"+
		"\2\u00ee\u00f4\3\2\2\2\u00ef\u00f0\f\3\2\2\u00f0\u00f1\7(\2\2\u00f1\u00f3"+
		"\5\16\b\2\u00f2\u00ef\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2"+
		"\u00f4\u00f5\3\2\2\2\u00f5\27\3\2\2\2\u00f6\u00f4\3\2\2\2\30\36 +\64:"+
		"IW[ox|\u0086\u0090\u0097\u009a\u00b1\u00d0\u00d2\u00db\u00e5\u00ea\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}