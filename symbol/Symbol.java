package symbol;

import expression.ParserException;

/*
 * aus einem String extrahierte Werte (Ziffern, Operatoren,...)
 */
public interface Symbol {
	
	/*
	 * �berschreibt die default Implementierung von equals()
	 */
	public boolean equals(Object obj);
	
	/*
	 * accepts a visitor from another object
	 */
	public void accept (Visitor visitor) throws ParserException;
	
	/*
	 * �berschreibt die default Implementierung von toString()
	 */
	public String toString();
}
