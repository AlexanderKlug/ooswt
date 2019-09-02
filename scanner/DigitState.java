package scanner;
import symbol.NumberSymbol;

/*
 * Zustand wenn Zahlen eingelesen werden
 */
public class DigitState extends State {
	
	private StringBuilder digits;
	
	/*
	 * Konstruktor
	 */
	public DigitState(Scanner scanner) {
		super(scanner);
		this.digits = new StringBuilder(); // initialisiert einen neunen StringBuilder mit 16 Stellen (defaultWert)
	}

	@Override
	public void scan(Character c) { // scanner muss mitgegeben werden damit die scan Methode den State ver�ndern kann
		if(Character.isDigit(c)) {	
			digits.append(c);
			this.getMyScanner().skip();
		}else{
			this.exit();				// Digit-State verlassen und Nummer-Symbol im Scanner anf�gen
			this.endOfProcessing();
		}
	}
	
	/*
	 * f�gt digits zur Ausgabe des Scanner hinzu
	 * setzt den Scanner State auf SelectionState
	 */
	public void exit() {
		this.getMyScanner().addSymbol(new NumberSymbol(Integer.valueOf(digits.toString())));
	}
}
