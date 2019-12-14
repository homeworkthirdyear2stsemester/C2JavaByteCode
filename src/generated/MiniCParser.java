// Generated from D:/ProgramFiles/IntelliJ/Programs/homework/compiler/lab5_3_final/src\MiniC.g4 by ANTLR 4.7.2
 
package generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, VOID=20, INT=21, CHAR=22, DOUBLE=23, FLOAT=24, WHILE=25, 
		IF=26, ELSE=27, RETURN=28, FOR=29, OR=30, AND=31, LE=32, GE=33, EQ=34, 
		NE=35, IDENT=36, CHAR_SET=37, AlPHA_CHAR=38, LITERAL=39, DecimalConstant=40, 
		OctalConstant=41, HexadecimalConstant=42, FLOAT_IDENT=43, WS=44;
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_var_decl = 2, RULE_type_spec = 3, 
		RULE_fun_decl = 4, RULE_params = 5, RULE_param = 6, RULE_stmt = 7, RULE_expr_stmt = 8, 
		RULE_while_stmt = 9, RULE_compound_stmt = 10, RULE_local_decl = 11, RULE_if_stmt = 12, 
		RULE_return_stmt = 13, RULE_for_stmt = 14, RULE_for_condition = 15, RULE_expr = 16, 
		RULE_args = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decl", "var_decl", "type_spec", "fun_decl", "params", "param", 
			"stmt", "expr_stmt", "while_stmt", "compound_stmt", "local_decl", "if_stmt", 
			"return_stmt", "for_stmt", "for_condition", "expr", "args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'['", "']'", "'('", "')'", "','", "'{'", "'}'", 
			"'-'", "'+'", "'--'", "'++'", "'*'", "'/'", "'%'", "'<'", "'>'", "'!'", 
			"'void'", "'int'", "'char'", "'double'", "'float'", "'while'", "'if'", 
			"'else'", "'return'", "'for'", "'or'", "'and'", "'<='", "'>='", "'=='", 
			"'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "VOID", "INT", "CHAR", 
			"DOUBLE", "FLOAT", "WHILE", "IF", "ELSE", "RETURN", "FOR", "OR", "AND", 
			"LE", "GE", "EQ", "NE", "IDENT", "CHAR_SET", "AlPHA_CHAR", "LITERAL", 
			"DecimalConstant", "OctalConstant", "HexadecimalConstant", "FLOAT_IDENT", 
			"WS"
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
	public String getGrammarFileName() { return "MiniC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				decl();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT))) != 0) );
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

	public static class DeclContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Fun_declContext fun_decl() {
			return getRuleContext(Fun_declContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				var_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				fun_decl();
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

	public static class Var_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public TerminalNode CHAR_SET() { return getToken(MiniCParser.CHAR_SET, 0); }
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decl);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				type_spec();
				setState(46);
				match(IDENT);
				setState(47);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				type_spec();
				setState(50);
				match(IDENT);
				setState(51);
				match(T__1);
				setState(52);
				match(CHAR_SET);
				setState(53);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				type_spec();
				setState(56);
				match(IDENT);
				setState(57);
				match(T__1);
				setState(58);
				match(LITERAL);
				setState(59);
				match(T__0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				type_spec();
				setState(62);
				match(IDENT);
				setState(63);
				match(T__2);
				setState(64);
				match(LITERAL);
				setState(65);
				match(T__3);
				setState(66);
				match(T__0);
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

	public static class Type_specContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(MiniCParser.VOID, 0); }
		public TerminalNode DOUBLE() { return getToken(MiniCParser.DOUBLE, 0); }
		public TerminalNode FLOAT() { return getToken(MiniCParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(MiniCParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(MiniCParser.CHAR, 0); }
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterType_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitType_spec(this);
		}
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Fun_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Fun_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFun_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFun_decl(this);
		}
	}

	public final Fun_declContext fun_decl() throws RecognitionException {
		Fun_declContext _localctx = new Fun_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fun_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			type_spec();
			setState(73);
			match(IDENT);
			setState(74);
			match(T__4);
			setState(75);
			params();
			setState(76);
			match(T__5);
			setState(77);
			compound_stmt();
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
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode VOID() { return getToken(MiniCParser.VOID, 0); }
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				param();
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(80);
					match(T__6);
					setState(81);
					param();
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				match(VOID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class ParamContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				type_spec();
				setState(92);
				match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				type_spec();
				setState(95);
				match(IDENT);
				setState(96);
				match(T__2);
				setState(97);
				match(T__3);
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

	public static class StmtContext extends ParserRuleContext {
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmt);
		try {
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__18:
			case IDENT:
			case CHAR_SET:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				expr_stmt();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				compound_stmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				while_stmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				return_stmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 6);
				{
				setState(106);
				for_stmt();
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

	public static class Expr_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExpr_stmt(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			expr(0);
			setState(110);
			match(T__0);
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

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniCParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitWhile_stmt(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(WHILE);
			setState(113);
			match(T__4);
			setState(114);
			expr(0);
			setState(115);
			match(T__5);
			setState(116);
			stmt();
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

	public static class Compound_stmtContext extends ParserRuleContext {
		public List<Local_declContext> local_decl() {
			return getRuleContexts(Local_declContext.class);
		}
		public Local_declContext local_decl(int i) {
			return getRuleContext(Local_declContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitCompound_stmt(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_compound_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__7);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << INT) | (1L << CHAR) | (1L << DOUBLE) | (1L << FLOAT))) != 0)) {
				{
				{
				setState(119);
				local_decl();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__18) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << FOR) | (1L << IDENT) | (1L << CHAR_SET) | (1L << LITERAL))) != 0)) {
				{
				{
				setState(125);
				stmt();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
			match(T__8);
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

	public static class Local_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public TerminalNode CHAR_SET() { return getToken(MiniCParser.CHAR_SET, 0); }
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public Local_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterLocal_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitLocal_decl(this);
		}
	}

	public final Local_declContext local_decl() throws RecognitionException {
		Local_declContext _localctx = new Local_declContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_local_decl);
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				type_spec();
				setState(134);
				match(IDENT);
				setState(135);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				type_spec();
				setState(138);
				match(IDENT);
				setState(139);
				match(T__1);
				setState(140);
				match(CHAR_SET);
				setState(141);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				type_spec();
				setState(144);
				match(IDENT);
				setState(145);
				match(T__1);
				setState(146);
				match(LITERAL);
				setState(147);
				match(T__0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				type_spec();
				setState(150);
				match(IDENT);
				setState(151);
				match(T__2);
				setState(152);
				match(LITERAL);
				setState(153);
				match(T__3);
				setState(154);
				match(T__0);
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

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniCParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniCParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_if_stmt);
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(IF);
				setState(159);
				match(T__4);
				setState(160);
				expr(0);
				setState(161);
				match(T__5);
				setState(162);
				stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(IF);
				setState(165);
				match(T__4);
				setState(166);
				expr(0);
				setState(167);
				match(T__5);
				setState(168);
				stmt();
				setState(169);
				match(ELSE);
				setState(170);
				stmt();
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

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiniCParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitReturn_stmt(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_return_stmt);
		try {
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(RETURN);
				setState(175);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(RETURN);
				setState(177);
				expr(0);
				setState(178);
				match(T__0);
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

	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniCParser.FOR, 0); }
		public For_conditionContext for_condition() {
			return getRuleContext(For_conditionContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFor_stmt(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_for_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(FOR);
			setState(183);
			match(T__4);
			setState(184);
			for_condition();
			setState(185);
			match(T__5);
			setState(186);
			compound_stmt();
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

	public static class For_conditionContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public For_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFor_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFor_condition(this);
		}
	}

	public final For_conditionContext for_condition() throws RecognitionException {
		For_conditionContext _localctx = new For_conditionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_for_condition);
		try {
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				expr(0);
				setState(189);
				match(T__0);
				setState(190);
				expr(0);
				setState(191);
				match(T__0);
				setState(192);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				match(T__0);
				setState(195);
				expr(0);
				setState(196);
				match(T__0);
				setState(197);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				match(T__0);
				setState(200);
				expr(0);
				setState(201);
				match(T__0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(203);
				expr(0);
				setState(204);
				match(T__0);
				setState(205);
				expr(0);
				setState(206);
				match(T__0);
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
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CHAR_SET() { return getToken(MiniCParser.CHAR_SET, 0); }
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode EQ() { return getToken(MiniCParser.EQ, 0); }
		public TerminalNode NE() { return getToken(MiniCParser.NE, 0); }
		public TerminalNode LE() { return getToken(MiniCParser.LE, 0); }
		public TerminalNode GE() { return getToken(MiniCParser.GE, 0); }
		public TerminalNode AND() { return getToken(MiniCParser.AND, 0); }
		public TerminalNode OR() { return getToken(MiniCParser.OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(211);
				match(LITERAL);
				}
				break;
			case 2:
				{
				setState(212);
				match(T__4);
				setState(213);
				expr(0);
				setState(214);
				match(T__5);
				}
				break;
			case 3:
				{
				setState(216);
				match(CHAR_SET);
				}
				break;
			case 4:
				{
				setState(217);
				match(IDENT);
				}
				break;
			case 5:
				{
				setState(218);
				match(IDENT);
				setState(219);
				match(T__2);
				setState(220);
				expr(0);
				setState(221);
				match(T__3);
				}
				break;
			case 6:
				{
				setState(223);
				match(IDENT);
				setState(224);
				match(T__4);
				setState(225);
				args();
				setState(226);
				match(T__5);
				}
				break;
			case 7:
				{
				setState(228);
				match(T__9);
				setState(229);
				expr(20);
				}
				break;
			case 8:
				{
				setState(230);
				match(T__10);
				setState(231);
				expr(19);
				}
				break;
			case 9:
				{
				setState(232);
				match(T__11);
				setState(233);
				expr(18);
				}
				break;
			case 10:
				{
				setState(234);
				match(T__12);
				setState(235);
				expr(17);
				}
				break;
			case 11:
				{
				setState(236);
				match(T__18);
				setState(237);
				expr(5);
				}
				break;
			case 12:
				{
				setState(238);
				match(IDENT);
				setState(239);
				match(T__1);
				setState(240);
				expr(2);
				}
				break;
			case 13:
				{
				setState(241);
				match(IDENT);
				setState(242);
				match(T__2);
				setState(243);
				expr(0);
				setState(244);
				match(T__3);
				setState(245);
				match(T__1);
				setState(246);
				expr(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(291);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(289);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(250);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(251);
						match(T__13);
						setState(252);
						expr(17);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(254);
						match(T__14);
						setState(255);
						expr(16);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(256);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(257);
						match(T__15);
						setState(258);
						expr(15);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(259);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(260);
						match(T__10);
						setState(261);
						expr(14);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(262);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(263);
						match(T__9);
						setState(264);
						expr(13);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(265);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(266);
						match(EQ);
						setState(267);
						expr(12);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(268);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(269);
						match(NE);
						setState(270);
						expr(11);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(271);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(272);
						match(LE);
						setState(273);
						expr(10);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(274);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(275);
						match(T__16);
						setState(276);
						expr(9);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(277);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(278);
						match(GE);
						setState(279);
						expr(8);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(280);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(281);
						match(T__17);
						setState(282);
						expr(7);
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(283);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(284);
						match(AND);
						setState(285);
						expr(5);
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(286);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(287);
						match(OR);
						setState(288);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(293);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_args);
		int _la;
		try {
			setState(303);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__18:
			case IDENT:
			case CHAR_SET:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				expr(0);
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(295);
					match(T__6);
					setState(296);
					expr(0);
					}
					}
					setState(301);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__5:
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0134\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\6\2(\n\2\r\2\16\2)\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4G\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7U\n\7\f"+
		"\7\16\7X\13\7\3\7\3\7\5\7\\\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bf\n"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tn\n\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\7\f{\n\f\f\f\16\f~\13\f\3\f\7\f\u0081\n\f\f\f\16\f\u0084"+
		"\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009f\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00af\n\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00b7\n\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00d3\n\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u00fb\n\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\7\22\u0124\n\22\f\22\16\22\u0127\13\22\3\23"+
		"\3\23\3\23\7\23\u012c\n\23\f\23\16\23\u012f\13\23\3\23\5\23\u0132\n\23"+
		"\3\23\2\3\"\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\3\3\2\26\32"+
		"\2\u0154\2\'\3\2\2\2\4-\3\2\2\2\6F\3\2\2\2\bH\3\2\2\2\nJ\3\2\2\2\f[\3"+
		"\2\2\2\16e\3\2\2\2\20m\3\2\2\2\22o\3\2\2\2\24r\3\2\2\2\26x\3\2\2\2\30"+
		"\u009e\3\2\2\2\32\u00ae\3\2\2\2\34\u00b6\3\2\2\2\36\u00b8\3\2\2\2 \u00d2"+
		"\3\2\2\2\"\u00fa\3\2\2\2$\u0131\3\2\2\2&(\5\4\3\2\'&\3\2\2\2()\3\2\2\2"+
		")\'\3\2\2\2)*\3\2\2\2*\3\3\2\2\2+.\5\6\4\2,.\5\n\6\2-+\3\2\2\2-,\3\2\2"+
		"\2.\5\3\2\2\2/\60\5\b\5\2\60\61\7&\2\2\61\62\7\3\2\2\62G\3\2\2\2\63\64"+
		"\5\b\5\2\64\65\7&\2\2\65\66\7\4\2\2\66\67\7\'\2\2\678\7\3\2\28G\3\2\2"+
		"\29:\5\b\5\2:;\7&\2\2;<\7\4\2\2<=\7)\2\2=>\7\3\2\2>G\3\2\2\2?@\5\b\5\2"+
		"@A\7&\2\2AB\7\5\2\2BC\7)\2\2CD\7\6\2\2DE\7\3\2\2EG\3\2\2\2F/\3\2\2\2F"+
		"\63\3\2\2\2F9\3\2\2\2F?\3\2\2\2G\7\3\2\2\2HI\t\2\2\2I\t\3\2\2\2JK\5\b"+
		"\5\2KL\7&\2\2LM\7\7\2\2MN\5\f\7\2NO\7\b\2\2OP\5\26\f\2P\13\3\2\2\2QV\5"+
		"\16\b\2RS\7\t\2\2SU\5\16\b\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W"+
		"\\\3\2\2\2XV\3\2\2\2Y\\\7\26\2\2Z\\\3\2\2\2[Q\3\2\2\2[Y\3\2\2\2[Z\3\2"+
		"\2\2\\\r\3\2\2\2]^\5\b\5\2^_\7&\2\2_f\3\2\2\2`a\5\b\5\2ab\7&\2\2bc\7\5"+
		"\2\2cd\7\6\2\2df\3\2\2\2e]\3\2\2\2e`\3\2\2\2f\17\3\2\2\2gn\5\22\n\2hn"+
		"\5\26\f\2in\5\32\16\2jn\5\24\13\2kn\5\34\17\2ln\5\36\20\2mg\3\2\2\2mh"+
		"\3\2\2\2mi\3\2\2\2mj\3\2\2\2mk\3\2\2\2ml\3\2\2\2n\21\3\2\2\2op\5\"\22"+
		"\2pq\7\3\2\2q\23\3\2\2\2rs\7\33\2\2st\7\7\2\2tu\5\"\22\2uv\7\b\2\2vw\5"+
		"\20\t\2w\25\3\2\2\2x|\7\n\2\2y{\5\30\r\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2"+
		"|}\3\2\2\2}\u0082\3\2\2\2~|\3\2\2\2\177\u0081\5\20\t\2\u0080\177\3\2\2"+
		"\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\13\2\2\u0086\27\3\2\2\2\u0087"+
		"\u0088\5\b\5\2\u0088\u0089\7&\2\2\u0089\u008a\7\3\2\2\u008a\u009f\3\2"+
		"\2\2\u008b\u008c\5\b\5\2\u008c\u008d\7&\2\2\u008d\u008e\7\4\2\2\u008e"+
		"\u008f\7\'\2\2\u008f\u0090\7\3\2\2\u0090\u009f\3\2\2\2\u0091\u0092\5\b"+
		"\5\2\u0092\u0093\7&\2\2\u0093\u0094\7\4\2\2\u0094\u0095\7)\2\2\u0095\u0096"+
		"\7\3\2\2\u0096\u009f\3\2\2\2\u0097\u0098\5\b\5\2\u0098\u0099\7&\2\2\u0099"+
		"\u009a\7\5\2\2\u009a\u009b\7)\2\2\u009b\u009c\7\6\2\2\u009c\u009d\7\3"+
		"\2\2\u009d\u009f\3\2\2\2\u009e\u0087\3\2\2\2\u009e\u008b\3\2\2\2\u009e"+
		"\u0091\3\2\2\2\u009e\u0097\3\2\2\2\u009f\31\3\2\2\2\u00a0\u00a1\7\34\2"+
		"\2\u00a1\u00a2\7\7\2\2\u00a2\u00a3\5\"\22\2\u00a3\u00a4\7\b\2\2\u00a4"+
		"\u00a5\5\20\t\2\u00a5\u00af\3\2\2\2\u00a6\u00a7\7\34\2\2\u00a7\u00a8\7"+
		"\7\2\2\u00a8\u00a9\5\"\22\2\u00a9\u00aa\7\b\2\2\u00aa\u00ab\5\20\t\2\u00ab"+
		"\u00ac\7\35\2\2\u00ac\u00ad\5\20\t\2\u00ad\u00af\3\2\2\2\u00ae\u00a0\3"+
		"\2\2\2\u00ae\u00a6\3\2\2\2\u00af\33\3\2\2\2\u00b0\u00b1\7\36\2\2\u00b1"+
		"\u00b7\7\3\2\2\u00b2\u00b3\7\36\2\2\u00b3\u00b4\5\"\22\2\u00b4\u00b5\7"+
		"\3\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b0\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b7"+
		"\35\3\2\2\2\u00b8\u00b9\7\37\2\2\u00b9\u00ba\7\7\2\2\u00ba\u00bb\5 \21"+
		"\2\u00bb\u00bc\7\b\2\2\u00bc\u00bd\5\26\f\2\u00bd\37\3\2\2\2\u00be\u00bf"+
		"\5\"\22\2\u00bf\u00c0\7\3\2\2\u00c0\u00c1\5\"\22\2\u00c1\u00c2\7\3\2\2"+
		"\u00c2\u00c3\5\"\22\2\u00c3\u00d3\3\2\2\2\u00c4\u00c5\7\3\2\2\u00c5\u00c6"+
		"\5\"\22\2\u00c6\u00c7\7\3\2\2\u00c7\u00c8\5\"\22\2\u00c8\u00d3\3\2\2\2"+
		"\u00c9\u00ca\7\3\2\2\u00ca\u00cb\5\"\22\2\u00cb\u00cc\7\3\2\2\u00cc\u00d3"+
		"\3\2\2\2\u00cd\u00ce\5\"\22\2\u00ce\u00cf\7\3\2\2\u00cf\u00d0\5\"\22\2"+
		"\u00d0\u00d1\7\3\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00be\3\2\2\2\u00d2\u00c4"+
		"\3\2\2\2\u00d2\u00c9\3\2\2\2\u00d2\u00cd\3\2\2\2\u00d3!\3\2\2\2\u00d4"+
		"\u00d5\b\22\1\2\u00d5\u00fb\7)\2\2\u00d6\u00d7\7\7\2\2\u00d7\u00d8\5\""+
		"\22\2\u00d8\u00d9\7\b\2\2\u00d9\u00fb\3\2\2\2\u00da\u00fb\7\'\2\2\u00db"+
		"\u00fb\7&\2\2\u00dc\u00dd\7&\2\2\u00dd\u00de\7\5\2\2\u00de\u00df\5\"\22"+
		"\2\u00df\u00e0\7\6\2\2\u00e0\u00fb\3\2\2\2\u00e1\u00e2\7&\2\2\u00e2\u00e3"+
		"\7\7\2\2\u00e3\u00e4\5$\23\2\u00e4\u00e5\7\b\2\2\u00e5\u00fb\3\2\2\2\u00e6"+
		"\u00e7\7\f\2\2\u00e7\u00fb\5\"\22\26\u00e8\u00e9\7\r\2\2\u00e9\u00fb\5"+
		"\"\22\25\u00ea\u00eb\7\16\2\2\u00eb\u00fb\5\"\22\24\u00ec\u00ed\7\17\2"+
		"\2\u00ed\u00fb\5\"\22\23\u00ee\u00ef\7\25\2\2\u00ef\u00fb\5\"\22\7\u00f0"+
		"\u00f1\7&\2\2\u00f1\u00f2\7\4\2\2\u00f2\u00fb\5\"\22\4\u00f3\u00f4\7&"+
		"\2\2\u00f4\u00f5\7\5\2\2\u00f5\u00f6\5\"\22\2\u00f6\u00f7\7\6\2\2\u00f7"+
		"\u00f8\7\4\2\2\u00f8\u00f9\5\"\22\3\u00f9\u00fb\3\2\2\2\u00fa\u00d4\3"+
		"\2\2\2\u00fa\u00d6\3\2\2\2\u00fa\u00da\3\2\2\2\u00fa\u00db\3\2\2\2\u00fa"+
		"\u00dc\3\2\2\2\u00fa\u00e1\3\2\2\2\u00fa\u00e6\3\2\2\2\u00fa\u00e8\3\2"+
		"\2\2\u00fa\u00ea\3\2\2\2\u00fa\u00ec\3\2\2\2\u00fa\u00ee\3\2\2\2\u00fa"+
		"\u00f0\3\2\2\2\u00fa\u00f3\3\2\2\2\u00fb\u0125\3\2\2\2\u00fc\u00fd\f\22"+
		"\2\2\u00fd\u00fe\7\20\2\2\u00fe\u0124\5\"\22\23\u00ff\u0100\f\21\2\2\u0100"+
		"\u0101\7\21\2\2\u0101\u0124\5\"\22\22\u0102\u0103\f\20\2\2\u0103\u0104"+
		"\7\22\2\2\u0104\u0124\5\"\22\21\u0105\u0106\f\17\2\2\u0106\u0107\7\r\2"+
		"\2\u0107\u0124\5\"\22\20\u0108\u0109\f\16\2\2\u0109\u010a\7\f\2\2\u010a"+
		"\u0124\5\"\22\17\u010b\u010c\f\r\2\2\u010c\u010d\7$\2\2\u010d\u0124\5"+
		"\"\22\16\u010e\u010f\f\f\2\2\u010f\u0110\7%\2\2\u0110\u0124\5\"\22\r\u0111"+
		"\u0112\f\13\2\2\u0112\u0113\7\"\2\2\u0113\u0124\5\"\22\f\u0114\u0115\f"+
		"\n\2\2\u0115\u0116\7\23\2\2\u0116\u0124\5\"\22\13\u0117\u0118\f\t\2\2"+
		"\u0118\u0119\7#\2\2\u0119\u0124\5\"\22\n\u011a\u011b\f\b\2\2\u011b\u011c"+
		"\7\24\2\2\u011c\u0124\5\"\22\t\u011d\u011e\f\6\2\2\u011e\u011f\7!\2\2"+
		"\u011f\u0124\5\"\22\7\u0120\u0121\f\5\2\2\u0121\u0122\7 \2\2\u0122\u0124"+
		"\5\"\22\6\u0123\u00fc\3\2\2\2\u0123\u00ff\3\2\2\2\u0123\u0102\3\2\2\2"+
		"\u0123\u0105\3\2\2\2\u0123\u0108\3\2\2\2\u0123\u010b\3\2\2\2\u0123\u010e"+
		"\3\2\2\2\u0123\u0111\3\2\2\2\u0123\u0114\3\2\2\2\u0123\u0117\3\2\2\2\u0123"+
		"\u011a\3\2\2\2\u0123\u011d\3\2\2\2\u0123\u0120\3\2\2\2\u0124\u0127\3\2"+
		"\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126#\3\2\2\2\u0127\u0125"+
		"\3\2\2\2\u0128\u012d\5\"\22\2\u0129\u012a\7\t\2\2\u012a\u012c\5\"\22\2"+
		"\u012b\u0129\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e"+
		"\3\2\2\2\u012e\u0132\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0132\3\2\2\2\u0131"+
		"\u0128\3\2\2\2\u0131\u0130\3\2\2\2\u0132%\3\2\2\2\24)-FV[em|\u0082\u009e"+
		"\u00ae\u00b6\u00d2\u00fa\u0123\u0125\u012d\u0131";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}