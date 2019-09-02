package scanner;

import symbol.LBrSymbol;

/*
 * Status beim Einlesen einer �ffnenden Klammer
 */
public class LBrState extends State {
	
	/*
	 * Konstruktor
	 */
	public LBrState(Scanner scanner) {
		super(scanner);
	}
	
	@Override
	public void scan(Character c) {
		this.getMyScanner().skip();
		this.getMyScanner().addSymbol(new LBrSymbol());
		this.endOfProcessing();
	}
}
