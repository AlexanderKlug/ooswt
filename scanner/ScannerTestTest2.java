package scanner;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import symbol.ErrorToken;
import symbol.NumberSymbol;
import symbol.PlusSymbol;
import symbol.StarSymbol;
import symbol.Symbol;

public class ScannerTestTest2 {

	@Test
	public void scannerTest10() {
		Scanner scanner = new Scanner();
		List<Symbol> result = new ArrayList<>();
		result.add(new NumberSymbol(4));
		result.add(PlusSymbol.getInstance());
		result.add(new NumberSymbol(7));
		assertEquals(result, scanner.toSymbolSequence("4+7"));
	}
	
	@Test
	public void scannerTest11() {
		Scanner scanner = new Scanner();
		List<Symbol> result = new ArrayList<>();
		result.add(new NumberSymbol(8));
		result.add(PlusSymbol.getInstance());
		result.add(new NumberSymbol(8));
		result.add(PlusSymbol.getInstance());
		assertEquals(result, scanner.toSymbolSequence("8+8+"));
	}
	
	@Test
	public void scannerTest12() {
		Scanner scanner = new Scanner();
		List<Symbol> result = new ArrayList<>();
		result.add(PlusSymbol.getInstance());
		result.add(PlusSymbol.getInstance());
		result.add(new StarSymbol());
		result.add(PlusSymbol.getInstance());
		result.add(PlusSymbol.getInstance());
		assertEquals(result, scanner.toSymbolSequence("++*++"));
	}
	
	@Test
	public void scannerTest13() {
		Scanner scanner = new Scanner();
		List<Symbol> result = new ArrayList<>();
		result.add(PlusSymbol.getInstance());
		result.add(PlusSymbol.getInstance());
		result.add(new ErrorToken("/"));
		result.add(PlusSymbol.getInstance());
		result.add(PlusSymbol.getInstance());
		assertEquals(result, scanner.toSymbolSequence("++/++"));
	}
	
	@Test
	public void scannerTest14() {
		Scanner scanner = new Scanner();
		List<Symbol> result = new ArrayList<>();
		result.add(new ErrorToken("ABC/CBA"));
		assertEquals(result, scanner.toSymbolSequence("ABC/CBA"));
	}
	
	@Test
	public void scannerTest15() {
		Scanner scanner = new Scanner();
		List<Symbol> result = new ArrayList<>();
		result.add(new NumberSymbol(3));
		result.add(PlusSymbol.getInstance());
		result.add(new ErrorToken("XXX"));
		assertEquals(result, scanner.toSymbolSequence("3+XXX"));
	}
	
	@Test
	public void scannerTest16() {
		Scanner scanner = new Scanner();
		List<Symbol> result = new ArrayList<>();
		result.add(new NumberSymbol(3));
		result.add(PlusSymbol.getInstance());
		result.add(new ErrorToken("XXX"));
		result.add(new NumberSymbol(17));
		assertEquals(result, scanner.toSymbolSequence("3 +  XXX    17"));
	}
	
	@Test
	public void scannerTest17() {
		Scanner scanner = new Scanner();
		List<Symbol> result = new ArrayList<>();
		result.add(new NumberSymbol(5));
		result.add(new NumberSymbol(6));
		result.add(new NumberSymbol(7));
		assertEquals(result, scanner.toSymbolSequence("5 6 7"));
	}

}
