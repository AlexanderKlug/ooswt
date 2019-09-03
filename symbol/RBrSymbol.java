package symbol;

import expression.ParserException;

/*
 * Symbol f�r schlie�ende Klammer
 */
public class RBrSymbol implements BracketSymbol {
	
	/*
	 * Konstruktor
	 */
	public RBrSymbol (){
		
	}
	
	/*
	 * �berschreibt die default-Implementierung von equals()
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
