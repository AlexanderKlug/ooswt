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

public class FactorParser extends Parser {
	private Factor myFactor;
	
	public FactorParser(List<Symbol> symbols) {
		super(symbols);
	}

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
			throw new ParserException("schlieﬂende Klammmer fehlt!");
		}
	}
	
	@Override
	public void handleEndSymbol(EndSymbol symbol) throws ParserException {
		throw new ParserException("Unerwartetes Ende.");
	}

}
