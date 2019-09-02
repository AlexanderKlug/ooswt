package parser2;

import java.util.List;

import expression.Factor;
import expression.ParserException;
import expression.Product;
import expression.Summand;
import symbol.PlusSymbol;
import symbol.RBrSymbol;
import symbol.StarSymbol;
import symbol.Symbol;

public class SummandParser extends Parser {
	private Summand mySummand;
	
	public SummandParser(List<Symbol> symbols) {
		super(symbols);
	}

	public Summand toExpression() throws ParserException {
		this.mySummand = new FactorParser(getSymbols()).toExpression();
		getCurrentSymbol().accept(this);
		return this.mySummand;
		
	}
	
	@Override
	public void handleStarSymbol(StarSymbol symbol) throws ParserException {
		skipCurrentSymbol();
		mySummand = new Product((Factor) mySummand, new SummandParser(getSymbols()).toExpression());
		
	}
	
	@Override
	public void handlePlusSymbol(PlusSymbol symbol) throws ParserException {
	}
	
	@Override
	public void handleRBrSymbol(RBrSymbol symbol) throws ParserException {
	}
}
