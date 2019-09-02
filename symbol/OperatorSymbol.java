package symbol;
/*
 * Operator Symbol das in einer Liste gespeichert werden kann
 */
public interface OperatorSymbol extends Symbol {
	
	/*
	 * überschreibt die default-Implementierung von equals
	 */
	public boolean equals(Object obj);
}