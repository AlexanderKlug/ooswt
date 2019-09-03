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

/*
 * wandelt Symbole in ein Produkt oder einen Faktor um
 */
public class SummandParser extends Parser {
	private Summand mySummand;
	
	/*
	 * Konstruktor
	 */
	public SummandParser(List<Symbol> symbols) {
		super(symbols);
	}

	/*
	 * wandelt Symbole in ein Produkt oder einen Faktor um
	 */
	public Summand toExpression() throws ParserException {
		this.mySummand = new FactorParser(getSymbols()).toExpression();
		getCurrentSymbol().accept(this);
		return this.mySummand;
		
	}
	
	@Override
	public void handleStarSymbol(StarSymbol symbol) throws ParserException {
		skipCurrentSymbol();
		this.mySummand = new Product((Factor) this.mySummand, new SummandParser(getSymbols()).toExpression());
		
	}
	
	@Override
	public void handlePlusSymbol(PlusSymbol symbol) throws ParserException {
	}
	
	@Override
	public void handleRBrSymbol(RBrSymbol symbol) throws ParserException {
	}
}
