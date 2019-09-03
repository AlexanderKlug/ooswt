package expression;

/*
 * Klammerausdruck
 */
public class Bracket extends Factor {
	private Expression bracketedExpression;
	
	/*
	 * Konstruktor
	 */
	public Bracket (Expression expression) {
		this.bracketedExpression = expression;
	}
	
	@Override
	public Integer evaluate() {
	return this.bracketedExpression.evaluate();
	}

}
