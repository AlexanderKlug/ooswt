package symbol;

import expression.ParserException;

/*
 * Symbol für die mathematische Multiplikation
 */
public class StarSymbol implements OperatorSymbol {
	
	/*
	 * Konstruktor
	 */
	public StarSymbol() {
		
	}
	
	/*
	 * überschreibt die default-Implementierung von equals
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof StarSymbol;
	}

	@Override
	public void accept(Visitor visitor) throws ParserException {
		visitor.handleStarSymbol(this);
	}
}
