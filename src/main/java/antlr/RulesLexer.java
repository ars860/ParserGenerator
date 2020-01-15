// Generated from E:/acady/Desktop/parsers/last/src/main/java/antlr\Rules.g4 by ANTLR 4.7.2
package antlr;

import java.util.*;
import grammar.Grammar;
import grammar.Rule;
import grammar.TokenDef;
import grammar.Option;
import grammar.atom.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RulesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, INT=15, TOKENNAME=16, 
		TYPE=17, NAME=18, DOTTEDNAME=19, WS=20, TOKEN=21, REGEX=22, CODE=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "INT", "TOKENNAME", "TYPE", 
			"NAME", "DOTTEDNAME", "WS", "TOKEN", "REGEX", "CODE"
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


	public RulesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Rules.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00d4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\6\20o\n\20\r\20\16\20p\3"+
		"\21\3\21\7\21u\n\21\f\21\16\21x\13\21\3\22\3\22\7\22|\n\22\f\22\16\22"+
		"\177\13\22\3\22\3\22\7\22\u0083\n\22\f\22\16\22\u0086\13\22\3\22\7\22"+
		"\u0089\n\22\f\22\16\22\u008c\13\22\3\22\3\22\7\22\u0090\n\22\f\22\16\22"+
		"\u0093\13\22\3\22\7\22\u0096\n\22\f\22\16\22\u0099\13\22\7\22\u009b\n"+
		"\22\f\22\16\22\u009e\13\22\3\22\5\22\u00a1\n\22\3\23\3\23\7\23\u00a5\n"+
		"\23\f\23\16\23\u00a8\13\23\3\24\3\24\7\24\u00ac\n\24\f\24\16\24\u00af"+
		"\13\24\3\25\3\25\3\25\3\25\3\26\3\26\6\26\u00b7\n\26\r\26\16\26\u00b8"+
		"\3\26\3\26\3\27\3\27\6\27\u00bf\n\27\r\27\16\27\u00c0\3\27\3\27\3\30\3"+
		"\30\6\30\u00c7\n\30\r\30\16\30\u00c8\3\30\5\30\u00cc\n\30\7\30\u00ce\n"+
		"\30\f\30\16\30\u00d1\13\30\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\3\2\r\3\2\62;\3\2C\\\5\2\63;C\\aa\6\2\63;C\\aac|\4\2\13\13"+
		"\"\"\3\2c|\7\2\60\60\63;C\\aac|\5\2\13\f\17\17\"\"\3\2))\3\2$$\4\2}}\177"+
		"\177\2\u00e3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\3\61\3\2\2\2\59\3\2\2\2\7;\3\2\2\2\tC\3\2\2\2\13I\3\2\2"+
		"\2\rK\3\2\2\2\17M\3\2\2\2\21Y\3\2\2\2\23[\3\2\2\2\25]\3\2\2\2\27e\3\2"+
		"\2\2\31g\3\2\2\2\33i\3\2\2\2\35k\3\2\2\2\37n\3\2\2\2!r\3\2\2\2#y\3\2\2"+
		"\2%\u00a2\3\2\2\2\'\u00a9\3\2\2\2)\u00b0\3\2\2\2+\u00b4\3\2\2\2-\u00bc"+
		"\3\2\2\2/\u00c4\3\2\2\2\61\62\7i\2\2\62\63\7t\2\2\63\64\7c\2\2\64\65\7"+
		"o\2\2\65\66\7o\2\2\66\67\7c\2\2\678\7t\2\28\4\3\2\2\29:\7=\2\2:\6\3\2"+
		"\2\2;<\7B\2\2<=\7j\2\2=>\7g\2\2>?\7c\2\2?@\7f\2\2@A\7g\2\2AB\7t\2\2B\b"+
		"\3\2\2\2CD\7B\2\2DE\7u\2\2EF\7m\2\2FG\7k\2\2GH\7r\2\2H\n\3\2\2\2IJ\7*"+
		"\2\2J\f\3\2\2\2KL\7+\2\2L\16\3\2\2\2MN\7B\2\2NO\7m\2\2OP\7g\2\2PQ\7g\2"+
		"\2QR\7r\2\2RS\7K\2\2ST\7p\2\2TU\7V\2\2UV\7t\2\2VW\7g\2\2WX\7g\2\2X\20"+
		"\3\2\2\2YZ\7.\2\2Z\22\3\2\2\2[\\\7<\2\2\\\24\3\2\2\2]^\7t\2\2^_\7g\2\2"+
		"_`\7v\2\2`a\7w\2\2ab\7t\2\2bc\7p\2\2cd\7u\2\2d\26\3\2\2\2ef\7]\2\2f\30"+
		"\3\2\2\2gh\7_\2\2h\32\3\2\2\2ij\7~\2\2j\34\3\2\2\2kl\7?\2\2l\36\3\2\2"+
		"\2mo\t\2\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2q \3\2\2\2rv\t\3\2"+
		"\2su\t\4\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\"\3\2\2\2xv\3\2"+
		"\2\2y}\t\3\2\2z|\t\5\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u00a0"+
		"\3\2\2\2\177}\3\2\2\2\u0080\u0084\7>\2\2\u0081\u0083\5#\22\2\u0082\u0081"+
		"\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u009c\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0089\t\6\2\2\u0088\u0087\3\2"+
		"\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u0091\7.\2\2\u008e\u0090\t\6"+
		"\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0097\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0096\5#"+
		"\22\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u008a\3\2"+
		"\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\7@\2\2\u00a0\u0080\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1$\3\2\2\2\u00a2\u00a6\t\7\2\2\u00a3\u00a5"+
		"\t\5\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7&\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ad\t\7\2\2"+
		"\u00aa\u00ac\t\b\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab"+
		"\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae(\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0"+
		"\u00b1\t\t\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\25\2\2\u00b3*\3\2\2\2"+
		"\u00b4\u00b6\7)\2\2\u00b5\u00b7\n\n\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00b8"+
		"\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00bb\7)\2\2\u00bb,\3\2\2\2\u00bc\u00be\7$\2\2\u00bd\u00bf\n\13\2\2\u00be"+
		"\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\7$\2\2\u00c3.\3\2\2\2\u00c4\u00cf"+
		"\7}\2\2\u00c5\u00c7\n\f\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00cc\5/"+
		"\30\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd"+
		"\u00c6\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\7\177\2\2\u00d3"+
		"\60\3\2\2\2\23\2pv}\u0084\u008a\u0091\u0097\u009c\u00a0\u00a6\u00ad\u00b8"+
		"\u00c0\u00c8\u00cb\u00cf\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}