/*
 * shows the end of a symbol list
 */
package symbol;

import expression.ParserException;

public class EndSymbol implements Symbol {
	
	public boolean equals(Object obj) {
		return obj instanceof EndSymbol;
	}

	@Override
	public void accept(Visitor visitor) throws ParserException {
		visitor.handleEndSymbol(this);
	}

}
