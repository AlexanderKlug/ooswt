package scanner;

/*
 * Scanner - State Pattern
 */
public abstract class State {
	private Scanner myScanner;
	
	/*
	 * Konstruktor
	 */
	public State(Scanner scanner) {
		this.myScanner = scanner;
	}
	/*
	 * fügt ein Symbol zur Ausgabe des Scanner hinzu (je nach Typ von c)
	 * kann c im eingegebenen String löschen
	 * kann den Scanner Status wechseln
	 */
	public abstract void scan(Character c);
	
	/*
	 * beendet den aktuellen Status
	 */
	public void exit() {
	};
	
	/*
	 * seztz den Status des Scanner auf new SelectionState
	 */
	public void endOfProcessing() {
		this.myScanner.setState(new SelectionState(myScanner));
	}
	
	/*
	 * gibt die Referenz des Scanners aus
	 */
	public Scanner getMyScanner() {
		return this.myScanner;
	}
	
	
}
