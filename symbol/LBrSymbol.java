package symbol;

import expression.ParserException;

/*
 * Symbol für eine öffnende Klammer
 */
public class LBrSymbol implements BracketSymbol {
	
	/*
	 * Konstruktor
	 */
	public LBrSymbol() {
		
	}

	/*
	 * überschreibt die default-Implementierung von equals
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof LBrSymbol;
	}

	@Override
	public void accept(Visitor visitor) throws ParserException {
		visitor.handleLBrSymbol(this);
	}

	
}
