package expression;

/*
 * mathematisches Produkt aus zwei Faktoren
 */
public class Product extends Summand {
	private Factor firstPart;
	private Summand secondPart;
	
	/*
	 * Konstruktor
	 */
	public Product(Factor factor, Summand summand) {
		this.firstPart = factor;
		this.secondPart = summand;
	}
	
	@Override
	public Integer evaluate() {
		return this.firstPart.evaluate() * this.secondPart.evaluate();
	}

}
