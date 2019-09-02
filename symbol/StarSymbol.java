package symbol;

import expression.ParserException;

/*
 * Symbol f�r die mathematische Multiplikation
 */
public class StarSymbol implements OperatorSymbol {
	
	/*
	 * Konstruktor
	 */
	public StarSymbol() {
		
	}
	
	/*
	 * �berschreibt die default-Implementierung von equals
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
