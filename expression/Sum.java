package expression;

/*
 * Summe bestehend aus Teil 1 und Teil 2
 */
public class Sum extends Expression {
	private Summand firstPart;
	private Expression secondPart;
	
	/*
	 * Konstruktor
	 */
	public Sum(Summand summand, Expression expression) {
		this.firstPart = summand;
		this.secondPart = expression;
	}

	@Override
	public Integer evaluate() {
		return this.firstPart.evaluate() + this.secondPart.evaluate();
	}

}
