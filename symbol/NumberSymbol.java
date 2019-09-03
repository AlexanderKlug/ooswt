package symbol;

import expression.ParserException;

/*
 * Nat�rliche Zahl
 */
public class NumberSymbol implements Symbol {
	/*
	 * Zahlenwert des Symbols
	 */
	private Integer value;
	
	/*
	 * Konstruktor
	 */
	public NumberSymbol(Integer value) {
		this.value = new Integer(value);
	}
	
	/*
	 * 1.pr�ft ob ein Object obj ein NumberSymbol ist
	 * 2. pr�ft ob ein NumberSymbol den selben Wert
	 */
	public boolean equals(Object obj) { // Object entspricht Anything - kann mit allem verglichen werden
		if(obj == null) { // pr�ft ob obj null ist
			return false;
		}
		if(!(obj instanceof NumberSymbol)) { // pr�ft ob obj ein NumberSymbol ist
			return false;
		}
		NumberSymbol other = (NumberSymbol)obj; // Typanpassung: obj als NumberSymbol typisieren
		return this.value.equals(other.value); // pr�ft ob die Zahlenwerte gleich sind
	}
	
	/*
	 * �berschreibt die default Implementierung von toString()
	 */
	public String toString() {
		return ("NumberSymbol");
	}
	
	/*
	 * returns the stored value of the NumberSymbol
	 */
	public Integer getValue() {
		return this.value;
	}

	@Override
	public void accept(Visitor visitor) throws ParserException {
		visitor.handleNumberSymbol(this);
	}
}
