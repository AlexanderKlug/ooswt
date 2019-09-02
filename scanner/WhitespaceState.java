package scanner;

/*
 * Status bei Einlesen eines Leerzeichens
 */
public class WhitespaceState extends State {
	
	/*
	 * Konstruktor
	 */
	public WhitespaceState(Scanner scanner) {
		super(scanner);
	}

	@Override
	public void scan(Character c) { // Whitespace löscht nur und setzt den State neu
		this.getMyScanner().skip();
		this.endOfProcessing();
	}
}
