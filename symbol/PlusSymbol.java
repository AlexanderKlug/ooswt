package symbol;

import expression.ParserException;

/*
 * Symbol für die mathematische Addition
 */
public class PlusSymbol implements OperatorSymbol {
	
	private static final PlusSymbol INSTANCE = new PlusSymbol(); // Plus-Symbol als Singleton	
	
	/*
	 * privater Konstruktor
	 */
	private PlusSymbol() {	
	}
	
	public static PlusSymbol getInstance() {
		return INSTANCE;
	}
	
	/*
	 * überschreibt die default-Implementierung für equals
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof PlusSymbol;
	}

	@Override
	public void accept(Visitor visitor) throws ParserException {
		visitor.handlePlusSymbol(this);
	}
}
