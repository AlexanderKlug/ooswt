package parser2;

import java.util.List;

import expression.Expression;
import expression.ParserException;
import symbol.EndSymbol;
import symbol.Symbol;

/*
 * startet die Umwandlung einer Symbolliste
 * Einstiegspunkt in die Umwandlung
 */
public class ExpressionParserProxy {
	
	
	public Expression toExpression(List<Symbol> symbols) throws ParserException {
//		if (symbols.isEmpty()) {
//			throw new ParserException("Keine Symbole gefunden.");
//		}
			symbols.add(new EndSymbol());
			Expression expression = new ExpressionParser(symbols).toExpression();
			if (symbols.size() > 1) {
				throw new ParserException("Unerwartetes Symbol "+symbols.get(0).toString());
			}
			
			return expression;
	}
		
}
