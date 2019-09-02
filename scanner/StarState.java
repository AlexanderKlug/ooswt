package scanner;

import symbol.*;

/*
 * Status wenn ein Mal eingelesen wird - Multiplikation
 */
public class StarState extends State {

	/*
	 * Konstruktor
	 */
	public StarState(Scanner scanner) {
		super(scanner);
	}
	
	@Override
	public void scan(Character c) {
		this.getMyScanner().skip();
		this.getMyScanner().addSymbol(new StarSymbol());
		this.endOfProcessing();
	}
}
