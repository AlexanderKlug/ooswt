package symbol;

import expression.ParserException;

/*
 * Symbol das in einem arithmetischen Ausdruck nicht vorkommen darf
 */
public class ErrorToken implements Symbol {
	private String content; // Inhalt des ErrorToken
	
	/*
	 * Konstruktor
	 */
	public ErrorToken(String content) {
		this.content = content;
	}
	
	/*S
	 * überschreibt die default Implementierung von equals
	 */
	 @Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof ErrorToken)) {
			return false;
		}
		else {
			ErrorToken other = (ErrorToken) obj;
			return this.content.equals(other.content);
		}
	}
	 
	 /*
	  * returns the content of the ErrorSymbol
	  */
	 @Override
	 public String toString() {
		 return this.content;
	 }

	@Override
	public void accept(Visitor visitor) throws ParserException {
		visitor.handleErrorToken(this);
	}
}
