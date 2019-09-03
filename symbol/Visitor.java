package symbol;

import expression.ParserException;
/*
 * Visitor Pattern
 */
public interface Visitor {
	
	public void handleNumberSymbol(NumberSymbol symbol) throws ParserException;
	
	public void handlePlusSymbol(PlusSymbol symbol) throws ParserException;
	
	public void handleStarSymbol(StarSymbol symbol)throws ParserException;
	
	public void handleLBrSymbol(LBrSymbol symbol) throws ParserException;
	
	public void handleRBrSymbol(RBrSymbol symbol) throws ParserException;
	
	public void handleErrorToken(ErrorToken symbol) throws ParserException;
	
	public void handleEndSymbol(EndSymbol symbol) throws ParserException;

}
