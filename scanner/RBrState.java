package scanner;

import symbol.RBrSymbol;

/*
 * Status wenn Klammern eingelesen werden
 */
public class RBrState extends State {
	
	/*
	 * Konstruktor
	 */
	public RBrState(Scanner scanner) {
		super(scanner);
	}

	@Override
	public void scan(Character c) {
		this.getMyScanner().skip();
		this.getMyScanner().addSymbol(new RBrSymbol());
		this.endOfProcessing();
	}
}
