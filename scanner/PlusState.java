package scanner;

/*
 * Zustand bei einlesen eines Plus
 */
import symbol.PlusSymbol;

public class PlusState extends State {
	
	/*
	 * Konstruktor
	 */
	public PlusState(Scanner scanner) {
		super(scanner);
	}

	@Override
	public void scan(Character c) {
		this.getMyScanner().skip();
		this.getMyScanner().addSymbol(PlusSymbol.getInstance());
		this.endOfProcessing();
	}
}
