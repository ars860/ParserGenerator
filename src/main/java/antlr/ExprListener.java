// Generated from E:/acady/Desktop/parsers/secondd/src/main/java/antlr\Expr.g4 by ANTLR 4.7.2
package antlr;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ExprParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ExprParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(ExprParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(ExprParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExprParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#exprr}.
	 * @param ctx the parse tree
	 */
	void enterExprr(ExprParser.ExprrContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#exprr}.
	 * @param ctx the parse tree
	 */
	void exitExprr(ExprParser.ExprrContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ExprParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ExprParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#termm}.
	 * @param ctx the parse tree
	 */
	void enterTermm(ExprParser.TermmContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#termm}.
	 * @param ctx the parse tree
	 */
	void exitTermm(ExprParser.TermmContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterFact(ExprParser.FactContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitFact(ExprParser.FactContext ctx);
}