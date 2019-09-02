package parser2;

import java.util.List;

import expression.Expression;
import expression.ParserException;
import expression.Sum;
import expression.Summand;
import symbol.PlusSymbol;
import symbol.RBrSymbol;
import symbol.Symbol;

public class ExpressionParser extends Parser {
	public ExpressionParser(List<Symbol> symbols) {
		super(symbols);
	}

	private Expression myExpression;
	
	public Expression toExpression() throws ParserException {
		myExpression = new SummandParser(getSymbols()).toExpression();
		getCurrentSymbol().accept(this);
		return myExpression;
	}
	
	@Override
	public void handlePlusSymbol(PlusSymbol symbol) throws ParserException {
		skipCurrentSymbol();
		myExpression = new Sum((Summand) myExpression, new ExpressionParser(getSymbols()).toExpression());
	}
	
	@Override
	public void handleRBrSymbol(RBrSymbol symbol) throws ParserException {
	}
}
