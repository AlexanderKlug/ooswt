package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import expression.ParserException;
import parser2.ExpressionParserProxy;
import scanner.Scanner;
import symbol.Symbol;

public class ParserTests {
	
	Scanner scanner = new Scanner();
	ExpressionParserProxy parser = new ExpressionParserProxy();
	

	@Test
	public void evaluateNumber() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("5");
		assertEquals(new Integer(5),parser.toExpression(liste).evaluate());
	}
	
	@Test
	public void evaluateSum() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("5+5");
		assertEquals(new Integer(10),parser.toExpression(liste).evaluate());
	}
	
	@Test
	public void evaluateProduct() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("5*5");
		assertEquals(new Integer(25),parser.toExpression(liste).evaluate());
	}
	
	@Test
	public void evaluatePunktvorStrich() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("5*5+2");
		assertEquals(new Integer(27),parser.toExpression(liste).evaluate());
	}
	
	@Test
	public void evaluatePvS2() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("3*2+1");
		assertEquals(new Integer(7), parser.toExpression(liste).evaluate());
	}
	
	@Test
	public void evaluateKlammer() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("(3*2)");
		assertEquals(new Integer(6), parser.toExpression(liste).evaluate());
	}
	
	@Test
	public void evaluateKlammer2() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("(1)");
		assertEquals(new Integer(1), parser.toExpression(liste).evaluate());
	}
	
	@Test
	public void evaluateKlammer3() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("3* (5*5)");
		assertEquals(new Integer(75), parser.toExpression(liste).evaluate());
	}
	
	@Test
	public void evaluateKlammer4() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("(5+5)*3");
		assertEquals(new Integer(30), parser.toExpression(liste).evaluate());
	}
	
	@Test
	public void evaluateKlammer5() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("(2+5)*(4+3)");
		assertEquals(new Integer(49), parser.toExpression(liste).evaluate());
	}
	
	@Test
	public void evaluateKlammer6() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("5+5)");
		assertThrows(ParserException.class, () ->  parser.toExpression(liste));
	}
	
	@Test
	public void evaluateKlammer7() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("(5+5");
		assertThrows(ParserException.class, () -> parser.toExpression(liste));
	}
	
	@Test
	public void evaluateKlammer8() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("1+1)+1");
		assertThrows(ParserException.class,() -> parser.toExpression(liste));
	}
	
	@Test
	public void evaluatePlus() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("5++5");
		assertThrows(ParserException.class, () -> parser.toExpression(liste));
	}
	
	@Test
	public void evaluatePlus2() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("5+5+");
		assertThrows(ParserException.class, () -> parser.toExpression(liste));
	}
	
	@Test
	public void evaluateEmpty() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("");
		assertThrows(ParserException.class, () -> parser.toExpression(liste));
	}
	
	@Test
	public void evaluatePlusOne() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("+1");
		assertThrows(ParserException.class, () -> parser.toExpression(liste));
	}
	
	@Test
	public void evaluateMultiplication() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("1*1*");
		assertThrows(ParserException.class, () -> parser.toExpression(liste));
	}
	
	@Test
	public void evaluateError() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("1* Hallo 1");
		assertThrows(ParserException.class, () -> parser.toExpression(liste), "falsche Eingabe");
	}
	
	@Test
	public void evaluateKlammer9() throws ParserException {
		List<Symbol> liste = scanner.toSymbolSequence("3 * ((2+2)*4)");
		assertEquals(new Integer(48), parser.toExpression(liste).evaluate());
	}
	
}
