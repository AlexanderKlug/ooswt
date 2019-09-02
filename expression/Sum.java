package expression;

/*
 * Summe bestehend aus Summand 1 und Summand 2
 */
public class Sum extends Expression {
	private Summand firstPart;
	private Expression secondPart;
	
	public Sum(Summand summand, Expression expression) {
		this.firstPart = summand;
		this.secondPart = expression;
	}

	@Override
	public Integer evaluate() {
		return this.firstPart.evaluate() + this.secondPart.evaluate();
	}

}
