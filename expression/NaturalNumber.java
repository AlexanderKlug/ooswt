package expression;

/*
 * nat�rliche ganze Zahl
 */
public class NaturalNumber extends Factor {
	private Integer value;	// Wert der nat�rlichen Zahl
	
	/*
	 * Konstruktor
	 */
	public NaturalNumber(Integer value) {
		this.value = value;
	}

	@Override
	public Integer evaluate() {
		return this.value;
	}
}
