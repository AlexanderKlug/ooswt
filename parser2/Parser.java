package parser2;

import java.util.List;

import expression.ParserException;
import symbol.EndSymbol;
import symbol.ErrorToken;
import symbol.LBrSymbol;
import symbol.NumberSymbol;
import symbol.PlusSymbol;
import symbol.RBrSymbol;
import symbol.StarSymbol;
import symbol.Symbol;
import symbol.Visitor;

/*
 * wandelt eine Liste aus Symbolen in einen mathematischen Ausdruck um
 */
public abstract class Parser implements Visitor {
	private List<Symbol> symbols;
	
	public Parser(List<Symbol> symbols) {
		this.symbols = symbols;
	}
	
	/*
	 * git einen Fehler aus wenn die Anordnung der Symbole syntaktisch nicht korrekt ist
	 */
	private void throwUnexpectedSymbolException(Symbol symbol) throws ParserException {
		throw new ParserException(this.getClass().getName() +": unerwartetes Symbol " + '"' + symbol.toString() + '"');
	}

	@Override
	public void handleNumberSymbol(NumberSymbol symbol) throws ParserException {
		throwUnexpectedSymbolException(symbol);
		
	}

	@Override
	public void handlePlusSymbol(PlusSymbol symbol) throws ParserException {
		throwUnexpectedSymbolException(symbol);
		
	}

	@Override
	public void handleStarSymbol(StarSymbol symbol) throws ParserException {
		throwUnexpectedSymbolException(symbol);
		
	}

	@Override
	public void handleLBrSymbol(LBrSymbol symbol) throws ParserException {
		throwUnexpectedSymbolException(symbol);
		
	}

	@Override
	public void handleRBrSymbol(RBrSymbol symbol) throws ParserException {
		throwUnexpectedSymbolException(symbol);
		
	}

	@Override
	public void handleErrorToken(ErrorToken symbol) throws ParserException {
		throw new ParserException("falsche Eingabe");
		
	}

	@Override
	public void handleEndSymbol(EndSymbol symbol) throws ParserException {
	}

	/*
	 * getter Methode für die gespeicherte Symbolliste
	 */
	protected List<Symbol> getSymbols() {
		return symbols;
	}
	
	/*
	 * löscht das erste Element der Symbolliste
	 */
	protected void skipCurrentSymbol() {
		this.symbols.remove(0);
	}
	
	/*
	 * gibt das erste Element der Symbolliste aus
	 */
	protected Symbol getCurrentSymbol() {
		return symbols.get(0);
	}

}
