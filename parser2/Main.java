package parser2;

import java.util.List;

import expression.ParserException;
import scanner.Scanner;
import symbol.Symbol;

public class Main {

	public static void main(String[] args) throws ParserException {
		Scanner scanner = new Scanner();
		ExpressionParserProxy parser = new ExpressionParserProxy();
		List<Symbol> list = scanner.toSymbolSequence("");
		parser.toExpression(list);

	}

}
