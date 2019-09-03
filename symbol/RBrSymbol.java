package symbol;

import expression.ParserException;

/*
 * Symbol für schließende Klammer
 */
public class RBrSymbol implements BracketSymbol {
	
	/*
	 * Konstruktor
	 */
	public RBrSymbol (){
		
	}
	
	/*
	 * überschreibt die default-Implementierung von equals()
	 */
	public boolean equals(Object obj) {
		return obj instanceof RBrSymbol;
	}

	@Override
	public void accept(Visitor visitor) throws ParserException {
		visitor.handleRBrSymbol(this);
	}
	
	@Override
	public String toString() {
		return ("RBrSymbol");
	}
	
	
}
