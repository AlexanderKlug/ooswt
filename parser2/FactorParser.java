package parser2;

import java.util.List;

import expression.Bracket;
import expression.Factor;
import expression.NaturalNumber;
import expression.ParserException;
import symbol.EndSymbol;
import symbol.LBrSymbol;
import symbol.NumberSymbol;
import symbol.RBrSymbol;
import symbol.Symbol;

/*
 * erzeut eine natürliche Zahl oder einen Klammerausdruck
 */
public class FactorParser extends Parser {
	private Factor myFactor;
	
	/*
	 * Konstruktor
	 */
	public FactorParser(List<Symbol> symbols) {
		super(symbols);
	}

	/*
	 * wandelt Symbole in eine natürliche Zahl oder einen Klammerausdruck um
	 */
	public Factor toExpression() throws ParserException {
		getCurrentSymbol().accept(this);
		return myFactor;
	}
	
	@Override
	public void handleNumberSymbol(NumberSymbol symbol) throws ParserException {
		myFactor = new NaturalNumber(symbol.getValue());
		skipCurrentSymbol();
	}
	
	@Override
	public void handleLBrSymbol(LBrSymbol symbol) throws ParserException {
		skipCurrentSymbol();
		myFactor = new Bracket(new ExpressionParser(getSymbols()).toExpression());
		if(getCurrentSymbol() instanceof RBrSymbol) {
			skipCurrentSymbol();
		}else {
			throw new ParserException("schließende Klammmer fehlt!");
		}
	}
	
	@Override
	public void handleEndSymbol(EndSymbol symbol) throws ParserException {
		throw new ParserException("Unerwartetes Ende.");
	}

}
