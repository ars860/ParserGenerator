// Generated from E:/acady/Desktop/parsers/secondd/src/main/java/antlr\Expr.g4 by ANTLR 4.7.2
package antlr;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, INT=9, 
		VAR=10, WS=11;
	public static final int
		RULE_start = 0, RULE_string = 1, RULE_expr = 2, RULE_exprr = 3, RULE_term = 4, 
		RULE_termm = 5, RULE_fact = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "string", "expr", "exprr", "term", "termm", "fact"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'+'", "'-'", "'*'", "'/'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "INT", "VAR", "WS"
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
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			string(new HashMap<String, Integer>());
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

	public static class StringContext extends ParserRuleContext {
		public Map<String, Integer> curVars;
		public Token VAR;
		public ExprContext expr;
		public TerminalNode VAR() { return getToken(ExprParser.VAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public StringContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StringContext(ParserRuleContext parent, int invokingState, Map<String, Integer> curVars) {
			super(parent, invokingState);
			this.curVars = curVars;
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitString(this);
		}
	}

	public final StringContext string(Map<String, Integer> curVars) throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState(), curVars);
		enterRule(_localctx, 2, RULE_string);
		try {
			setState(24);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				((StringContext)_localctx).VAR = match(VAR);
				setState(17);
				match(T__0);
				setState(18);
				((StringContext)_localctx).expr = expr(curVars);
				setState(19);
				match(T__1);
				curVars.put((((StringContext)_localctx).VAR!=null?((StringContext)_localctx).VAR.getText():null), ((StringContext)_localctx).expr.value); System.out.println((((StringContext)_localctx).VAR!=null?((StringContext)_localctx).VAR.getText():null) + " = " + ((StringContext)_localctx).expr.value);
				setState(21);
				string(curVars);
				}
				break;
			case EOF:
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

	public static class ExprContext extends ParserRuleContext {
		public Map<String, Integer> variables;
		public int value;
		public TermContext term;
		public ExprrContext exprr;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprrContext exprr() {
			return getRuleContext(ExprrContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, Map<String, Integer> variables) {
			super(parent, invokingState);
			this.variables = variables;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr(Map<String, Integer> variables) throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState(), variables);
		enterRule(_localctx, 4, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			((ExprContext)_localctx).term = term(variables);
			setState(27);
			((ExprContext)_localctx).exprr = exprr(((ExprContext)_localctx).term.value, variables);
			((ExprContext)_localctx).value =  ((ExprContext)_localctx).exprr.value;
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

	public static class ExprrContext extends ParserRuleContext {
		public int prev;
		public Map<String, Integer> variables;
		public int value;
		public TermContext term;
		public ExprrContext exprr1;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprrContext exprr() {
			return getRuleContext(ExprrContext.class,0);
		}
		public ExprrContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprrContext(ParserRuleContext parent, int invokingState, int prev, Map<String, Integer> variables) {
			super(parent, invokingState);
			this.prev = prev;
			this.variables = variables;
		}
		@Override public int getRuleIndex() { return RULE_exprr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterExprr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitExprr(this);
		}
	}

	public final ExprrContext exprr(int prev,Map<String, Integer> variables) throws RecognitionException {
		ExprrContext _localctx = new ExprrContext(_ctx, getState(), prev, variables);
		enterRule(_localctx, 6, RULE_exprr);
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				match(T__2);
				setState(31);
				((ExprrContext)_localctx).term = term(variables);
				setState(32);
				((ExprrContext)_localctx).exprr1 = exprr(_localctx.prev + ((ExprrContext)_localctx).term.value, variables);
				((ExprrContext)_localctx).value =  ((ExprrContext)_localctx).exprr1.value;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				match(T__3);
				setState(36);
				((ExprrContext)_localctx).term = term(variables);
				setState(37);
				((ExprrContext)_localctx).exprr1 = exprr(_localctx.prev - ((ExprrContext)_localctx).term.value, variables);
				((ExprrContext)_localctx).value =  ((ExprrContext)_localctx).exprr1.value;
				}
				break;
			case T__1:
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				((ExprrContext)_localctx).value =  _localctx.prev;
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

	public static class TermContext extends ParserRuleContext {
		public Map<String, Integer> variables;
		public int value;
		public FactContext fact;
		public TermmContext termm;
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public TermmContext termm() {
			return getRuleContext(TermmContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TermContext(ParserRuleContext parent, int invokingState, Map<String, Integer> variables) {
			super(parent, invokingState);
			this.variables = variables;
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitTerm(this);
		}
	}

	public final TermContext term(Map<String, Integer> variables) throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState(), variables);
		enterRule(_localctx, 8, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			((TermContext)_localctx).fact = fact(variables);
			setState(44);
			((TermContext)_localctx).termm = termm(((TermContext)_localctx).fact.value, variables);
			((TermContext)_localctx).value =  ((TermContext)_localctx).termm.value;
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

	public static class TermmContext extends ParserRuleContext {
		public int prev;
		public Map<String, Integer> variables;
		public int value;
		public FactContext fact;
		public TermmContext termm1;
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public TermmContext termm() {
			return getRuleContext(TermmContext.class,0);
		}
		public TermmContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TermmContext(ParserRuleContext parent, int invokingState, int prev, Map<String, Integer> variables) {
			super(parent, invokingState);
			this.prev = prev;
			this.variables = variables;
		}
		@Override public int getRuleIndex() { return RULE_termm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterTermm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitTermm(this);
		}
	}

	public final TermmContext termm(int prev,Map<String, Integer> variables) throws RecognitionException {
		TermmContext _localctx = new TermmContext(_ctx, getState(), prev, variables);
		enterRule(_localctx, 10, RULE_termm);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(T__4);
				setState(48);
				((TermmContext)_localctx).fact = fact(variables);
				setState(49);
				((TermmContext)_localctx).termm1 = termm(_localctx.prev * ((TermmContext)_localctx).fact.value, variables);
				((TermmContext)_localctx).value =  ((TermmContext)_localctx).termm1.value;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				match(T__5);
				setState(53);
				((TermmContext)_localctx).fact = fact(variables);
				setState(54);
				((TermmContext)_localctx).termm1 = termm(_localctx.prev / ((TermmContext)_localctx).fact.value, variables);
				((TermmContext)_localctx).value =  ((TermmContext)_localctx).termm1.value;
				}
				break;
			case T__1:
			case T__2:
			case T__3:
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				((TermmContext)_localctx).value =  _localctx.prev;
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

	public static class FactContext extends ParserRuleContext {
		public Map<String, Integer> variables;
		public int value;
		public Token INT;
		public Token VAR;
		public ExprContext expr;
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public TerminalNode VAR() { return getToken(ExprParser.VAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FactContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FactContext(ParserRuleContext parent, int invokingState, Map<String, Integer> variables) {
			super(parent, invokingState);
			this.variables = variables;
		}
		@Override public int getRuleIndex() { return RULE_fact; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterFact(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitFact(this);
		}
	}

	public final FactContext fact(Map<String, Integer> variables) throws RecognitionException {
		FactContext _localctx = new FactContext(_ctx, getState(), variables);
		enterRule(_localctx, 12, RULE_fact);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				((FactContext)_localctx).INT = match(INT);
				((FactContext)_localctx).value =  Integer.parseInt((((FactContext)_localctx).INT!=null?((FactContext)_localctx).INT.getText():null));
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				((FactContext)_localctx).VAR = match(VAR);
				((FactContext)_localctx).value =  variables.get((((FactContext)_localctx).VAR!=null?((FactContext)_localctx).VAR.getText():null));
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				match(T__6);
				setState(65);
				((FactContext)_localctx).expr = expr(variables);
				setState(66);
				match(T__7);
				((FactContext)_localctx).value =  ((FactContext)_localctx).expr.value;
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\rJ\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3\33\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5,\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7=\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bH\n\b\3"+
		"\b\2\2\t\2\4\6\b\n\f\16\2\2\2I\2\20\3\2\2\2\4\32\3\2\2\2\6\34\3\2\2\2"+
		"\b+\3\2\2\2\n-\3\2\2\2\f<\3\2\2\2\16G\3\2\2\2\20\21\5\4\3\2\21\3\3\2\2"+
		"\2\22\23\7\f\2\2\23\24\7\3\2\2\24\25\5\6\4\2\25\26\7\4\2\2\26\27\b\3\1"+
		"\2\27\30\5\4\3\2\30\33\3\2\2\2\31\33\3\2\2\2\32\22\3\2\2\2\32\31\3\2\2"+
		"\2\33\5\3\2\2\2\34\35\5\n\6\2\35\36\5\b\5\2\36\37\b\4\1\2\37\7\3\2\2\2"+
		" !\7\5\2\2!\"\5\n\6\2\"#\5\b\5\2#$\b\5\1\2$,\3\2\2\2%&\7\6\2\2&\'\5\n"+
		"\6\2\'(\5\b\5\2()\b\5\1\2),\3\2\2\2*,\b\5\1\2+ \3\2\2\2+%\3\2\2\2+*\3"+
		"\2\2\2,\t\3\2\2\2-.\5\16\b\2./\5\f\7\2/\60\b\6\1\2\60\13\3\2\2\2\61\62"+
		"\7\7\2\2\62\63\5\16\b\2\63\64\5\f\7\2\64\65\b\7\1\2\65=\3\2\2\2\66\67"+
		"\7\b\2\2\678\5\16\b\289\5\f\7\29:\b\7\1\2:=\3\2\2\2;=\b\7\1\2<\61\3\2"+
		"\2\2<\66\3\2\2\2<;\3\2\2\2=\r\3\2\2\2>?\7\13\2\2?H\b\b\1\2@A\7\f\2\2A"+
		"H\b\b\1\2BC\7\t\2\2CD\5\6\4\2DE\7\n\2\2EF\b\b\1\2FH\3\2\2\2G>\3\2\2\2"+
		"G@\3\2\2\2GB\3\2\2\2H\17\3\2\2\2\6\32+<G";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}