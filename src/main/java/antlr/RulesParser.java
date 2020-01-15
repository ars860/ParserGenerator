// Generated from E:/acady/Desktop/parsers/last/src/main/java/antlr\Rules.g4 by ANTLR 4.7.2
package antlr;

import java.util.*;
import grammar.Grammar;
import grammar.Rule;
import grammar.TokenDef;
import grammar.Option;
import grammar.atom.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RulesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, INT=15, TOKENNAME=16, 
		TYPE=17, NAME=18, DOTTEDNAME=19, WS=20, TOKEN=21, REGEX=22, CODE=23;
	public static final int
		RULE_start = 0, RULE_header = 1, RULE_skip = 2, RULE_keep = 3, RULE_tokensList = 4, 
		RULE_tokensListCont = 5, RULE_tokens_ = 6, RULE_token = 7, RULE_rules = 8, 
		RULE_rule_ = 9, RULE_ruleReturns = 10, RULE_ruleArgs = 11, RULE_typedArgs = 12, 
		RULE_typedArgsList = 13, RULE_ruleCases = 14, RULE_ruleCase = 15, RULE_ruleCaseTerms = 16, 
		RULE_ruleCaseTerm = 17, RULE_ruleInv = 18, RULE_tokenInv = 19, RULE_args = 20, 
		RULE_argsList = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "header", "skip", "keep", "tokensList", "tokensListCont", "tokens_", 
			"token", "rules", "rule_", "ruleReturns", "ruleArgs", "typedArgs", "typedArgsList", 
			"ruleCases", "ruleCase", "ruleCaseTerms", "ruleCaseTerm", "ruleInv", 
			"tokenInv", "args", "argsList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'grammar'", "';'", "'@header'", "'@skip'", "'('", "')'", "'@keepInTree'", 
			"','", "':'", "'returns'", "'['", "']'", "'|'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "INT", "TOKENNAME", "TYPE", "NAME", "DOTTEDNAME", "WS", 
			"TOKEN", "REGEX", "CODE"
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
	public String getGrammarFileName() { return "Rules.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RulesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public Grammar grammar;
		public Token TYPE;
		public HeaderContext header;
		public SkipContext skip;
		public KeepContext keep;
		public RulesContext rules;
		public Tokens_Context tokens_;
		public TerminalNode TYPE() { return getToken(RulesParser.TYPE, 0); }
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public SkipContext skip() {
			return getRuleContext(SkipContext.class,0);
		}
		public KeepContext keep() {
			return getRuleContext(KeepContext.class,0);
		}
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public Tokens_Context tokens_() {
			return getRuleContext(Tokens_Context.class,0);
		}
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
			setState(44);
			match(T__0);
			setState(45);
			((StartContext)_localctx).TYPE = match(TYPE);
			setState(46);
			match(T__1);
			setState(47);
			((StartContext)_localctx).header = header();
			setState(48);
			((StartContext)_localctx).skip = skip();
			setState(49);
			((StartContext)_localctx).keep = keep();
			setState(50);
			((StartContext)_localctx).rules = rules();
			setState(51);
			((StartContext)_localctx).tokens_ = tokens_();
			Collections.reverse(((StartContext)_localctx).tokens_.tokens); ((StartContext)_localctx).grammar =  new Grammar((((StartContext)_localctx).TYPE!=null?((StartContext)_localctx).TYPE.getText():null), ((StartContext)_localctx).header.code, ((StartContext)_localctx).rules.rules_, ((StartContext)_localctx).tokens_.tokens, ((StartContext)_localctx).skip.tokens, ((StartContext)_localctx).keep.tokenNames);
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

	public static class HeaderContext extends ParserRuleContext {
		public Code code;
		public Token CODE;
		public TerminalNode CODE() { return getToken(RulesParser.CODE, 0); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(T__2);
				setState(55);
				((HeaderContext)_localctx).CODE = match(CODE);
				((HeaderContext)_localctx).code =  new Code((((HeaderContext)_localctx).CODE!=null?((HeaderContext)_localctx).CODE.getText():null));
				}
				break;
			case EOF:
			case T__3:
			case T__6:
			case TOKENNAME:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				((HeaderContext)_localctx).code =  new Code("");
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

	public static class SkipContext extends ParserRuleContext {
		public List<TokenDef> tokens;
		public Tokens_Context tokens_;
		public Tokens_Context tokens_() {
			return getRuleContext(Tokens_Context.class,0);
		}
		public SkipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skip; }
	}

	public final SkipContext skip() throws RecognitionException {
		SkipContext _localctx = new SkipContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_skip);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(T__3);
				setState(61);
				match(T__4);
				setState(62);
				((SkipContext)_localctx).tokens_ = tokens_();
				setState(63);
				match(T__5);
				((SkipContext)_localctx).tokens =  ((SkipContext)_localctx).tokens_.tokens;
				}
				break;
			case EOF:
			case T__6:
			case TOKENNAME:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				((SkipContext)_localctx).tokens =  new ArrayList<TokenDef>();
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

	public static class KeepContext extends ParserRuleContext {
		public Set<String> tokenNames;
		public TokensListContext tokensList;
		public TokensListContext tokensList() {
			return getRuleContext(TokensListContext.class,0);
		}
		public KeepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keep; }
	}

	public final KeepContext keep() throws RecognitionException {
		KeepContext _localctx = new KeepContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_keep);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(T__6);
				setState(70);
				match(T__4);
				setState(71);
				((KeepContext)_localctx).tokensList = tokensList();
				setState(72);
				match(T__5);
				((KeepContext)_localctx).tokenNames =  ((KeepContext)_localctx).tokensList.arguments;
				}
				break;
			case EOF:
			case TOKENNAME:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				((KeepContext)_localctx).tokenNames =  new HashSet<>();
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

	public static class TokensListContext extends ParserRuleContext {
		public Set<String> arguments;
		public Token TOKENNAME;
		public TokensListContContext tokensListCont;
		public TerminalNode TOKENNAME() { return getToken(RulesParser.TOKENNAME, 0); }
		public TokensListContContext tokensListCont() {
			return getRuleContext(TokensListContContext.class,0);
		}
		public TokensListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokensList; }
	}

	public final TokensListContext tokensList() throws RecognitionException {
		TokensListContext _localctx = new TokensListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tokensList);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOKENNAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				((TokensListContext)_localctx).TOKENNAME = match(TOKENNAME);
				setState(79);
				((TokensListContext)_localctx).tokensListCont = tokensListCont();
				((TokensListContext)_localctx).arguments =  ((TokensListContext)_localctx).tokensListCont.arguments;
				                               _localctx.arguments.add((((TokensListContext)_localctx).TOKENNAME!=null?((TokensListContext)_localctx).TOKENNAME.getText():null));
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				((TokensListContext)_localctx).arguments =  new HashSet<>();
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

	public static class TokensListContContext extends ParserRuleContext {
		public Set<String> arguments;
		public Token TOKENNAME;
		public TokensListContContext tokensListCont;
		public TerminalNode TOKENNAME() { return getToken(RulesParser.TOKENNAME, 0); }
		public TokensListContContext tokensListCont() {
			return getRuleContext(TokensListContContext.class,0);
		}
		public TokensListContContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokensListCont; }
	}

	public final TokensListContContext tokensListCont() throws RecognitionException {
		TokensListContContext _localctx = new TokensListContContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tokensListCont);
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(T__7);
				setState(86);
				((TokensListContContext)_localctx).TOKENNAME = match(TOKENNAME);
				setState(87);
				((TokensListContContext)_localctx).tokensListCont = tokensListCont();
				((TokensListContContext)_localctx).arguments =  ((TokensListContContext)_localctx).tokensListCont.arguments;
				                                        _localctx.arguments.add((((TokensListContContext)_localctx).TOKENNAME!=null?((TokensListContContext)_localctx).TOKENNAME.getText():null));
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				((TokensListContContext)_localctx).arguments =  new HashSet<>();
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

	public static class Tokens_Context extends ParserRuleContext {
		public List<TokenDef> tokens;
		public TokenContext token;
		public Tokens_Context tokens_;
		public TokenContext token() {
			return getRuleContext(TokenContext.class,0);
		}
		public Tokens_Context tokens_() {
			return getRuleContext(Tokens_Context.class,0);
		}
		public Tokens_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokens_; }
	}

	public final Tokens_Context tokens_() throws RecognitionException {
		Tokens_Context _localctx = new Tokens_Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_tokens_);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOKENNAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				((Tokens_Context)_localctx).token = token();
				setState(94);
				match(T__1);
				setState(95);
				((Tokens_Context)_localctx).tokens_ = tokens_();
				((Tokens_Context)_localctx).tokens =  ((Tokens_Context)_localctx).tokens_.tokens;
				                          _localctx.tokens.add(((Tokens_Context)_localctx).token.token_);
				}
				break;
			case EOF:
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				((Tokens_Context)_localctx).tokens =  new ArrayList<TokenDef>();
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

	public static class TokenContext extends ParserRuleContext {
		public TokenDef token_;
		public Token TOKENNAME;
		public Token REGEX;
		public TerminalNode TOKENNAME() { return getToken(RulesParser.TOKENNAME, 0); }
		public TerminalNode REGEX() { return getToken(RulesParser.REGEX, 0); }
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_token);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			((TokenContext)_localctx).TOKENNAME = match(TOKENNAME);
			setState(102);
			match(T__8);
			setState(103);
			((TokenContext)_localctx).REGEX = match(REGEX);
			((TokenContext)_localctx).token_ =  new TokenDef((((TokenContext)_localctx).TOKENNAME!=null?((TokenContext)_localctx).TOKENNAME.getText():null), (((TokenContext)_localctx).REGEX!=null?((TokenContext)_localctx).REGEX.getText():null));
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

	public static class RulesContext extends ParserRuleContext {
		public List<Rule> rules_;
		public Rule_Context rule_;
		public RulesContext rules;
		public Rule_Context rule_() {
			return getRuleContext(Rule_Context.class,0);
		}
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rules);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				((RulesContext)_localctx).rule_ = rule_();
				setState(107);
				match(T__1);
				setState(108);
				((RulesContext)_localctx).rules = rules();
				((RulesContext)_localctx).rules_ =  ((RulesContext)_localctx).rules.rules_;
				                      _localctx.rules_.add(((RulesContext)_localctx).rule_.rule);
				}
				break;
			case EOF:
			case TOKENNAME:
				enterOuterAlt(_localctx, 2);
				{
				((RulesContext)_localctx).rules_ =  new ArrayList<Rule>();
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

	public static class Rule_Context extends ParserRuleContext {
		public Rule rule;
		public Token NAME;
		public RuleArgsContext ruleArgs;
		public RuleReturnsContext ruleReturns;
		public RuleCaseContext ruleCase;
		public RuleCasesContext ruleCases;
		public TerminalNode NAME() { return getToken(RulesParser.NAME, 0); }
		public RuleArgsContext ruleArgs() {
			return getRuleContext(RuleArgsContext.class,0);
		}
		public RuleReturnsContext ruleReturns() {
			return getRuleContext(RuleReturnsContext.class,0);
		}
		public RuleCaseContext ruleCase() {
			return getRuleContext(RuleCaseContext.class,0);
		}
		public RuleCasesContext ruleCases() {
			return getRuleContext(RuleCasesContext.class,0);
		}
		public Rule_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_; }
	}

	public final Rule_Context rule_() throws RecognitionException {
		Rule_Context _localctx = new Rule_Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_rule_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			((Rule_Context)_localctx).NAME = match(NAME);
			setState(115);
			((Rule_Context)_localctx).ruleArgs = ruleArgs();
			setState(116);
			((Rule_Context)_localctx).ruleReturns = ruleReturns();
			setState(117);
			match(T__8);
			setState(118);
			((Rule_Context)_localctx).ruleCase = ruleCase();
			setState(119);
			((Rule_Context)_localctx).ruleCases = ruleCases();
			((Rule_Context)_localctx).ruleCases.options.add(new Option(((Rule_Context)_localctx).ruleCase.options));
			    ((Rule_Context)_localctx).rule =  new Rule((((Rule_Context)_localctx).NAME!=null?((Rule_Context)_localctx).NAME.getText():null), ((Rule_Context)_localctx).ruleArgs.arguments, ((Rule_Context)_localctx).ruleReturns.ret, ((Rule_Context)_localctx).ruleCases.options);
			   
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

	public static class RuleReturnsContext extends ParserRuleContext {
		public Rule.Argument ret;
		public Token TYPE;
		public Token NAME;
		public TerminalNode TYPE() { return getToken(RulesParser.TYPE, 0); }
		public TerminalNode NAME() { return getToken(RulesParser.NAME, 0); }
		public RuleReturnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleReturns; }
	}

	public final RuleReturnsContext ruleReturns() throws RecognitionException {
		RuleReturnsContext _localctx = new RuleReturnsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ruleReturns);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(T__9);
				setState(123);
				match(T__10);
				setState(124);
				((RuleReturnsContext)_localctx).TYPE = match(TYPE);
				setState(125);
				((RuleReturnsContext)_localctx).NAME = match(NAME);
				setState(126);
				match(T__11);
				((RuleReturnsContext)_localctx).ret =  new Rule.Argument((((RuleReturnsContext)_localctx).TYPE!=null?((RuleReturnsContext)_localctx).TYPE.getText():null), (((RuleReturnsContext)_localctx).NAME!=null?((RuleReturnsContext)_localctx).NAME.getText():null));
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				((RuleReturnsContext)_localctx).ret =  null;
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

	public static class RuleArgsContext extends ParserRuleContext {
		public List<Rule.Argument> arguments;
		public TypedArgsContext typedArgs;
		public TypedArgsContext typedArgs() {
			return getRuleContext(TypedArgsContext.class,0);
		}
		public RuleArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleArgs; }
	}

	public final RuleArgsContext ruleArgs() throws RecognitionException {
		RuleArgsContext _localctx = new RuleArgsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ruleArgs);
		try {
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(T__10);
				setState(132);
				((RuleArgsContext)_localctx).typedArgs = typedArgs();
				setState(133);
				match(T__11);
				((RuleArgsContext)_localctx).arguments =  ((RuleArgsContext)_localctx).typedArgs.arguments;
				}
				break;
			case T__8:
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				((RuleArgsContext)_localctx).arguments =  new ArrayList<Rule.Argument>();
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

	public static class TypedArgsContext extends ParserRuleContext {
		public List<Rule.Argument> arguments;
		public Token TYPE;
		public Token NAME;
		public TypedArgsListContext typedArgsList;
		public TerminalNode TYPE() { return getToken(RulesParser.TYPE, 0); }
		public TerminalNode NAME() { return getToken(RulesParser.NAME, 0); }
		public TypedArgsListContext typedArgsList() {
			return getRuleContext(TypedArgsListContext.class,0);
		}
		public TypedArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedArgs; }
	}

	public final TypedArgsContext typedArgs() throws RecognitionException {
		TypedArgsContext _localctx = new TypedArgsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_typedArgs);
		try {
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				((TypedArgsContext)_localctx).TYPE = match(TYPE);
				setState(140);
				((TypedArgsContext)_localctx).NAME = match(NAME);
				setState(141);
				((TypedArgsContext)_localctx).typedArgsList = typedArgsList();
				((TypedArgsContext)_localctx).arguments =  ((TypedArgsContext)_localctx).typedArgsList.arguments;
				                                       _localctx.arguments.add(new Rule.Argument((((TypedArgsContext)_localctx).TYPE!=null?((TypedArgsContext)_localctx).TYPE.getText():null), (((TypedArgsContext)_localctx).NAME!=null?((TypedArgsContext)_localctx).NAME.getText():null)));
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				((TypedArgsContext)_localctx).arguments =  new ArrayList<Rule.Argument>();
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

	public static class TypedArgsListContext extends ParserRuleContext {
		public List<Rule.Argument> arguments;
		public Token TYPE;
		public Token NAME;
		public TypedArgsListContext typedArgsList;
		public TerminalNode TYPE() { return getToken(RulesParser.TYPE, 0); }
		public TerminalNode NAME() { return getToken(RulesParser.NAME, 0); }
		public TypedArgsListContext typedArgsList() {
			return getRuleContext(TypedArgsListContext.class,0);
		}
		public TypedArgsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedArgsList; }
	}

	public final TypedArgsListContext typedArgsList() throws RecognitionException {
		TypedArgsListContext _localctx = new TypedArgsListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_typedArgsList);
		try {
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(T__7);
				setState(148);
				((TypedArgsListContext)_localctx).TYPE = match(TYPE);
				setState(149);
				((TypedArgsListContext)_localctx).NAME = match(NAME);
				setState(150);
				((TypedArgsListContext)_localctx).typedArgsList = typedArgsList();
				((TypedArgsListContext)_localctx).arguments =  ((TypedArgsListContext)_localctx).typedArgsList.arguments;
				                                                    _localctx.arguments.add(new Rule.Argument((((TypedArgsListContext)_localctx).TYPE!=null?((TypedArgsListContext)_localctx).TYPE.getText():null), (((TypedArgsListContext)_localctx).NAME!=null?((TypedArgsListContext)_localctx).NAME.getText():null)));
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				((TypedArgsListContext)_localctx).arguments =  new ArrayList<Rule.Argument>();
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

	public static class RuleCasesContext extends ParserRuleContext {
		public List<Option> options;
		public RuleCaseContext ruleCase;
		public RuleCasesContext ruleCases;
		public RuleCaseContext ruleCase() {
			return getRuleContext(RuleCaseContext.class,0);
		}
		public RuleCasesContext ruleCases() {
			return getRuleContext(RuleCasesContext.class,0);
		}
		public RuleCasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleCases; }
	}

	public final RuleCasesContext ruleCases() throws RecognitionException {
		RuleCasesContext _localctx = new RuleCasesContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ruleCases);
		try {
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				match(T__12);
				setState(157);
				((RuleCasesContext)_localctx).ruleCase = ruleCase();
				setState(158);
				((RuleCasesContext)_localctx).ruleCases = ruleCases();
				((RuleCasesContext)_localctx).options =  ((RuleCasesContext)_localctx).ruleCases.options;
				                                  _localctx.options.add(new Option(((RuleCasesContext)_localctx).ruleCase.options));
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				((RuleCasesContext)_localctx).options =  new ArrayList<Option>();
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

	public static class RuleCaseContext extends ParserRuleContext {
		public List<Atom> options;
		public RuleCaseTermContext ruleCaseTerm;
		public RuleCaseTermsContext ruleCaseTerms;
		public RuleCaseTermContext ruleCaseTerm() {
			return getRuleContext(RuleCaseTermContext.class,0);
		}
		public RuleCaseTermsContext ruleCaseTerms() {
			return getRuleContext(RuleCaseTermsContext.class,0);
		}
		public RuleCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleCase; }
	}

	public final RuleCaseContext ruleCase() throws RecognitionException {
		RuleCaseContext _localctx = new RuleCaseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ruleCase);
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
			case CODE:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				((RuleCaseContext)_localctx).ruleCaseTerm = ruleCaseTerm();
				setState(165);
				((RuleCaseContext)_localctx).ruleCaseTerms = ruleCaseTerms();
				((RuleCaseContext)_localctx).options =  ((RuleCaseContext)_localctx).ruleCaseTerms.options;
				                                     _localctx.options.add(((RuleCaseContext)_localctx).ruleCaseTerm.atom);
				                                     Collections.reverse(_localctx.options);
				}
				break;
			case T__1:
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				((RuleCaseContext)_localctx).options =  new ArrayList<>();
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

	public static class RuleCaseTermsContext extends ParserRuleContext {
		public List<Atom> options;
		public RuleCaseTermContext ruleCaseTerm;
		public RuleCaseTermsContext ruleCaseTerms;
		public RuleCaseTermContext ruleCaseTerm() {
			return getRuleContext(RuleCaseTermContext.class,0);
		}
		public RuleCaseTermsContext ruleCaseTerms() {
			return getRuleContext(RuleCaseTermsContext.class,0);
		}
		public RuleCaseTermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleCaseTerms; }
	}

	public final RuleCaseTermsContext ruleCaseTerms() throws RecognitionException {
		RuleCaseTermsContext _localctx = new RuleCaseTermsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ruleCaseTerms);
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
			case CODE:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				((RuleCaseTermsContext)_localctx).ruleCaseTerm = ruleCaseTerm();
				setState(172);
				((RuleCaseTermsContext)_localctx).ruleCaseTerms = ruleCaseTerms();
				((RuleCaseTermsContext)_localctx).options =  ((RuleCaseTermsContext)_localctx).ruleCaseTerms.options;
				                                          _localctx.options.add(((RuleCaseTermsContext)_localctx).ruleCaseTerm.atom);
				}
				break;
			case T__1:
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				((RuleCaseTermsContext)_localctx).options =  new ArrayList<>();
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

	public static class RuleCaseTermContext extends ParserRuleContext {
		public Atom atom;
		public RuleInvContext ruleInv;
		public Token CODE;
		public TokenInvContext tokenInv;
		public RuleInvContext ruleInv() {
			return getRuleContext(RuleInvContext.class,0);
		}
		public TerminalNode CODE() { return getToken(RulesParser.CODE, 0); }
		public TokenInvContext tokenInv() {
			return getRuleContext(TokenInvContext.class,0);
		}
		public RuleCaseTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleCaseTerm; }
	}

	public final RuleCaseTermContext ruleCaseTerm() throws RecognitionException {
		RuleCaseTermContext _localctx = new RuleCaseTermContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ruleCaseTerm);
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				((RuleCaseTermContext)_localctx).ruleInv = ruleInv();
				((RuleCaseTermContext)_localctx).atom =  ((RuleCaseTermContext)_localctx).ruleInv.res;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				((RuleCaseTermContext)_localctx).CODE = match(CODE);
				((RuleCaseTermContext)_localctx).atom =  new Code((((RuleCaseTermContext)_localctx).CODE!=null?((RuleCaseTermContext)_localctx).CODE.getText():null));
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				((RuleCaseTermContext)_localctx).tokenInv = tokenInv();
				((RuleCaseTermContext)_localctx).atom =  ((RuleCaseTermContext)_localctx).tokenInv.res;
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

	public static class RuleInvContext extends ParserRuleContext {
		public RuleInv res;
		public Token newName;
		public Token ruleName;
		public ArgsContext args;
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public List<TerminalNode> NAME() { return getTokens(RulesParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(RulesParser.NAME, i);
		}
		public RuleInvContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleInv; }
	}

	public final RuleInvContext ruleInv() throws RecognitionException {
		RuleInvContext _localctx = new RuleInvContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ruleInv);
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				((RuleInvContext)_localctx).newName = match(NAME);
				setState(189);
				match(T__13);
				setState(190);
				((RuleInvContext)_localctx).ruleName = match(NAME);
				setState(191);
				match(T__10);
				setState(192);
				((RuleInvContext)_localctx).args = args();
				setState(193);
				match(T__11);
				((RuleInvContext)_localctx).res =  new RuleInv((((RuleInvContext)_localctx).newName!=null?((RuleInvContext)_localctx).newName.getText():null), (((RuleInvContext)_localctx).ruleName!=null?((RuleInvContext)_localctx).ruleName.getText():null), ((RuleInvContext)_localctx).args.arguments);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				((RuleInvContext)_localctx).newName = match(NAME);
				setState(197);
				match(T__13);
				setState(198);
				((RuleInvContext)_localctx).ruleName = match(NAME);
				((RuleInvContext)_localctx).res =  new RuleInv((((RuleInvContext)_localctx).newName!=null?((RuleInvContext)_localctx).newName.getText():null), (((RuleInvContext)_localctx).ruleName!=null?((RuleInvContext)_localctx).ruleName.getText():null), new ArrayList<>());
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

	public static class TokenInvContext extends ParserRuleContext {
		public TokenInv res;
		public Token newName;
		public Token ruleName;
		public TerminalNode NAME() { return getToken(RulesParser.NAME, 0); }
		public TerminalNode TOKENNAME() { return getToken(RulesParser.TOKENNAME, 0); }
		public TokenInvContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenInv; }
	}

	public final TokenInvContext tokenInv() throws RecognitionException {
		TokenInvContext _localctx = new TokenInvContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_tokenInv);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			((TokenInvContext)_localctx).newName = match(NAME);
			setState(203);
			match(T__13);
			setState(204);
			((TokenInvContext)_localctx).ruleName = match(TOKENNAME);
			((TokenInvContext)_localctx).res =  new TokenInv((((TokenInvContext)_localctx).newName!=null?((TokenInvContext)_localctx).newName.getText():null), (((TokenInvContext)_localctx).ruleName!=null?((TokenInvContext)_localctx).ruleName.getText():null));
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

	public static class ArgsContext extends ParserRuleContext {
		public List<String> arguments;
		public Token DOTTEDNAME;
		public ArgsListContext argsList;
		public Token NAME;
		public TerminalNode DOTTEDNAME() { return getToken(RulesParser.DOTTEDNAME, 0); }
		public ArgsListContext argsList() {
			return getRuleContext(ArgsListContext.class,0);
		}
		public TerminalNode NAME() { return getToken(RulesParser.NAME, 0); }
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_args);
		try {
			setState(216);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOTTEDNAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				((ArgsContext)_localctx).DOTTEDNAME = match(DOTTEDNAME);
				setState(208);
				((ArgsContext)_localctx).argsList = argsList();
				((ArgsContext)_localctx).arguments =  ((ArgsContext)_localctx).argsList.arguments;
				                          _localctx.arguments.add((((ArgsContext)_localctx).DOTTEDNAME!=null?((ArgsContext)_localctx).DOTTEDNAME.getText():null));
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				((ArgsContext)_localctx).NAME = match(NAME);
				setState(212);
				((ArgsContext)_localctx).argsList = argsList();
				((ArgsContext)_localctx).arguments =  ((ArgsContext)_localctx).argsList.arguments;
				                    _localctx.arguments.add((((ArgsContext)_localctx).NAME!=null?((ArgsContext)_localctx).NAME.getText():null));
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				((ArgsContext)_localctx).arguments =  new ArrayList<>();
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

	public static class ArgsListContext extends ParserRuleContext {
		public List<String> arguments;
		public Token DOTTEDNAME;
		public ArgsListContext argsList;
		public Token NAME;
		public TerminalNode DOTTEDNAME() { return getToken(RulesParser.DOTTEDNAME, 0); }
		public ArgsListContext argsList() {
			return getRuleContext(ArgsListContext.class,0);
		}
		public TerminalNode NAME() { return getToken(RulesParser.NAME, 0); }
		public ArgsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argsList; }
	}

	public final ArgsListContext argsList() throws RecognitionException {
		ArgsListContext _localctx = new ArgsListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_argsList);
		try {
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				match(T__7);
				setState(219);
				((ArgsListContext)_localctx).DOTTEDNAME = match(DOTTEDNAME);
				setState(220);
				((ArgsListContext)_localctx).argsList = argsList();
				((ArgsListContext)_localctx).arguments =  ((ArgsListContext)_localctx).argsList.arguments;
				                                   _localctx.arguments.add((((ArgsListContext)_localctx).DOTTEDNAME!=null?((ArgsListContext)_localctx).DOTTEDNAME.getText():null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(T__7);
				setState(224);
				((ArgsListContext)_localctx).NAME = match(NAME);
				setState(225);
				((ArgsListContext)_localctx).argsList = argsList();
				((ArgsListContext)_localctx).arguments =  ((ArgsListContext)_localctx).argsList.arguments;
				                             _localctx.arguments.add((((ArgsListContext)_localctx).NAME!=null?((ArgsListContext)_localctx).NAME.getText():null));
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				((ArgsListContext)_localctx).arguments =  new ArrayList<>();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31\u00ea\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3=\n\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4F\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5O\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\5\6V\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7^\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b"+
		"f\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\ns\n\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0084\n\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u008c\n\r\3\16\3\16\3\16\3\16\3\16\3\16\5"+
		"\16\u0094\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u009d\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u00a5\n\20\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00ac\n\21\3\22\3\22\3\22\3\22\3\22\5\22\u00b3\n\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\5\23\u00bd\n\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00cb\n\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00db\n\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00e8\n\27\3\27\2\2"+
		"\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\2\2\u00e8\2.\3\2"+
		"\2\2\4<\3\2\2\2\6E\3\2\2\2\bN\3\2\2\2\nU\3\2\2\2\f]\3\2\2\2\16e\3\2\2"+
		"\2\20g\3\2\2\2\22r\3\2\2\2\24t\3\2\2\2\26\u0083\3\2\2\2\30\u008b\3\2\2"+
		"\2\32\u0093\3\2\2\2\34\u009c\3\2\2\2\36\u00a4\3\2\2\2 \u00ab\3\2\2\2\""+
		"\u00b2\3\2\2\2$\u00bc\3\2\2\2&\u00ca\3\2\2\2(\u00cc\3\2\2\2*\u00da\3\2"+
		"\2\2,\u00e7\3\2\2\2./\7\3\2\2/\60\7\23\2\2\60\61\7\4\2\2\61\62\5\4\3\2"+
		"\62\63\5\6\4\2\63\64\5\b\5\2\64\65\5\22\n\2\65\66\5\16\b\2\66\67\b\2\1"+
		"\2\67\3\3\2\2\289\7\5\2\29:\7\31\2\2:=\b\3\1\2;=\b\3\1\2<8\3\2\2\2<;\3"+
		"\2\2\2=\5\3\2\2\2>?\7\6\2\2?@\7\7\2\2@A\5\16\b\2AB\7\b\2\2BC\b\4\1\2C"+
		"F\3\2\2\2DF\b\4\1\2E>\3\2\2\2ED\3\2\2\2F\7\3\2\2\2GH\7\t\2\2HI\7\7\2\2"+
		"IJ\5\n\6\2JK\7\b\2\2KL\b\5\1\2LO\3\2\2\2MO\b\5\1\2NG\3\2\2\2NM\3\2\2\2"+
		"O\t\3\2\2\2PQ\7\22\2\2QR\5\f\7\2RS\b\6\1\2SV\3\2\2\2TV\b\6\1\2UP\3\2\2"+
		"\2UT\3\2\2\2V\13\3\2\2\2WX\7\n\2\2XY\7\22\2\2YZ\5\f\7\2Z[\b\7\1\2[^\3"+
		"\2\2\2\\^\b\7\1\2]W\3\2\2\2]\\\3\2\2\2^\r\3\2\2\2_`\5\20\t\2`a\7\4\2\2"+
		"ab\5\16\b\2bc\b\b\1\2cf\3\2\2\2df\b\b\1\2e_\3\2\2\2ed\3\2\2\2f\17\3\2"+
		"\2\2gh\7\22\2\2hi\7\13\2\2ij\7\30\2\2jk\b\t\1\2k\21\3\2\2\2lm\5\24\13"+
		"\2mn\7\4\2\2no\5\22\n\2op\b\n\1\2ps\3\2\2\2qs\b\n\1\2rl\3\2\2\2rq\3\2"+
		"\2\2s\23\3\2\2\2tu\7\24\2\2uv\5\30\r\2vw\5\26\f\2wx\7\13\2\2xy\5 \21\2"+
		"yz\5\36\20\2z{\b\13\1\2{\25\3\2\2\2|}\7\f\2\2}~\7\r\2\2~\177\7\23\2\2"+
		"\177\u0080\7\24\2\2\u0080\u0081\7\16\2\2\u0081\u0084\b\f\1\2\u0082\u0084"+
		"\b\f\1\2\u0083|\3\2\2\2\u0083\u0082\3\2\2\2\u0084\27\3\2\2\2\u0085\u0086"+
		"\7\r\2\2\u0086\u0087\5\32\16\2\u0087\u0088\7\16\2\2\u0088\u0089\b\r\1"+
		"\2\u0089\u008c\3\2\2\2\u008a\u008c\b\r\1\2\u008b\u0085\3\2\2\2\u008b\u008a"+
		"\3\2\2\2\u008c\31\3\2\2\2\u008d\u008e\7\23\2\2\u008e\u008f\7\24\2\2\u008f"+
		"\u0090\5\34\17\2\u0090\u0091\b\16\1\2\u0091\u0094\3\2\2\2\u0092\u0094"+
		"\b\16\1\2\u0093\u008d\3\2\2\2\u0093\u0092\3\2\2\2\u0094\33\3\2\2\2\u0095"+
		"\u0096\7\n\2\2\u0096\u0097\7\23\2\2\u0097\u0098\7\24\2\2\u0098\u0099\5"+
		"\34\17\2\u0099\u009a\b\17\1\2\u009a\u009d\3\2\2\2\u009b\u009d\b\17\1\2"+
		"\u009c\u0095\3\2\2\2\u009c\u009b\3\2\2\2\u009d\35\3\2\2\2\u009e\u009f"+
		"\7\17\2\2\u009f\u00a0\5 \21\2\u00a0\u00a1\5\36\20\2\u00a1\u00a2\b\20\1"+
		"\2\u00a2\u00a5\3\2\2\2\u00a3\u00a5\b\20\1\2\u00a4\u009e\3\2\2\2\u00a4"+
		"\u00a3\3\2\2\2\u00a5\37\3\2\2\2\u00a6\u00a7\5$\23\2\u00a7\u00a8\5\"\22"+
		"\2\u00a8\u00a9\b\21\1\2\u00a9\u00ac\3\2\2\2\u00aa\u00ac\b\21\1\2\u00ab"+
		"\u00a6\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac!\3\2\2\2\u00ad\u00ae\5$\23\2"+
		"\u00ae\u00af\5\"\22\2\u00af\u00b0\b\22\1\2\u00b0\u00b3\3\2\2\2\u00b1\u00b3"+
		"\b\22\1\2\u00b2\u00ad\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3#\3\2\2\2\u00b4"+
		"\u00b5\5&\24\2\u00b5\u00b6\b\23\1\2\u00b6\u00bd\3\2\2\2\u00b7\u00b8\7"+
		"\31\2\2\u00b8\u00bd\b\23\1\2\u00b9\u00ba\5(\25\2\u00ba\u00bb\b\23\1\2"+
		"\u00bb\u00bd\3\2\2\2\u00bc\u00b4\3\2\2\2\u00bc\u00b7\3\2\2\2\u00bc\u00b9"+
		"\3\2\2\2\u00bd%\3\2\2\2\u00be\u00bf\7\24\2\2\u00bf\u00c0\7\20\2\2\u00c0"+
		"\u00c1\7\24\2\2\u00c1\u00c2\7\r\2\2\u00c2\u00c3\5*\26\2\u00c3\u00c4\7"+
		"\16\2\2\u00c4\u00c5\b\24\1\2\u00c5\u00cb\3\2\2\2\u00c6\u00c7\7\24\2\2"+
		"\u00c7\u00c8\7\20\2\2\u00c8\u00c9\7\24\2\2\u00c9\u00cb\b\24\1\2\u00ca"+
		"\u00be\3\2\2\2\u00ca\u00c6\3\2\2\2\u00cb\'\3\2\2\2\u00cc\u00cd\7\24\2"+
		"\2\u00cd\u00ce\7\20\2\2\u00ce\u00cf\7\22\2\2\u00cf\u00d0\b\25\1\2\u00d0"+
		")\3\2\2\2\u00d1\u00d2\7\25\2\2\u00d2\u00d3\5,\27\2\u00d3\u00d4\b\26\1"+
		"\2\u00d4\u00db\3\2\2\2\u00d5\u00d6\7\24\2\2\u00d6\u00d7\5,\27\2\u00d7"+
		"\u00d8\b\26\1\2\u00d8\u00db\3\2\2\2\u00d9\u00db\b\26\1\2\u00da\u00d1\3"+
		"\2\2\2\u00da\u00d5\3\2\2\2\u00da\u00d9\3\2\2\2\u00db+\3\2\2\2\u00dc\u00dd"+
		"\7\n\2\2\u00dd\u00de\7\25\2\2\u00de\u00df\5,\27\2\u00df\u00e0\b\27\1\2"+
		"\u00e0\u00e8\3\2\2\2\u00e1\u00e2\7\n\2\2\u00e2\u00e3\7\24\2\2\u00e3\u00e4"+
		"\5,\27\2\u00e4\u00e5\b\27\1\2\u00e5\u00e8\3\2\2\2\u00e6\u00e8\b\27\1\2"+
		"\u00e7\u00dc\3\2\2\2\u00e7\u00e1\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8-\3"+
		"\2\2\2\24<ENU]er\u0083\u008b\u0093\u009c\u00a4\u00ab\u00b2\u00bc\u00ca"+
		"\u00da\u00e7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}