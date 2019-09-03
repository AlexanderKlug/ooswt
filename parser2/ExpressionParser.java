package parser2;

import java.util.List;

import expression.Expression;
import expression.ParserException;
import expression.Sum;
import expression.Summand;
import symbol.PlusSymbol;
import symbol.RBrSymbol;
import symbol.Symbol;

/*
 * wandelt Symbole in einen Summanden oder eine Summe um
 * nicht öffentlich
 * Aufruf über den ExpressionParserProxy
 */
class ExpressionParser extends Parser {
	private Expression myExpression;
	
	/*
	 * Konstruktor
	 */
	public ExpressionParser(List<Symbol> symbols) {
		super(symbols);
	}

	/*
	 * wandelt Symbole in einen Summanden oder eine Summe um
	 */
	public Expression toExpression() throws ParserException {
		this.myExpression = new SummandParser(getSymbols()).toExpression();
		getCurrentSymbol().accept(this);
		return this.myExpression;
	}
	
	@Override
	public void handlePlusSymbol(PlusSymbol symbol) throws ParserException {
		skipCurrentSymbol();
		this.myExpression = new Sum((Summand) this.myExpression, new ExpressionParser(getSymbols()).toExpression());
	}
	
	@Override
	public void handleRBrSymbol(RBrSymbol symbol) throws ParserException {
	}
}
