package scanner;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import symbol.LBrSymbol;
import symbol.NumberSymbol;
import symbol.PlusSymbol;
import symbol.RBrSymbol;
import symbol.StarSymbol;
import symbol.Symbol;

public class ScannerTest {

	@Test
	public void scannerTest1() {
		Scanner scanner = new Scanner();
		List<Symbol> result = new ArrayList<Symbol>();
		result.add(new NumberSymbol(123));
		assertEquals(result, scanner.toSymbolSequence("123"));
	}
	
	@Test
	public void scannerTest2() {
		Scanner scanner = new Scanner();
		List<Symbol> result = new ArrayList<Symbol>();
		result.add(new NumberSymbol(123));
		result.add(new NumberSymbol(12));
		result.add(new NumberSymbol(74));
		assertEquals(result, scanner.toSymbolSequence("123  12  74"));
	}
	
	@Test
	public void scannerTest3() {
		Scanner scanner = new Scanner();
		List<Symbol> result = new ArrayList<Symbol>();
		result.add(new NumberSymbol(78));
		result.add(new NumberSymbol(47));
		result.add(new NumberSymbol(11));
		assertEquals(result, scanner.toSymbolSequence("78 47         11"));
	}
	
	@Test
	public void scannerTest4() {
		List <Symbol> result = new ArrayList<>();
		result.add(new NumberSymbol(78));
		result.add(new NumberSymbol(11));
		Scanner scanner = new Scanner();
		assertEquals(result, scanner.toSymbolSequence("78 11"));
	}
	

	@Test
	public void scannerTest5() {
		Scanner scanner = new Scanner();
		List <Symbol> result = new ArrayList<>();
		result.add(new NumberSymbol(78));
		result.add(PlusSymbol.getInstance());
		result.add(new NumberSymbol(11));
		assertEquals(result, scanner.toSymbolSequence("78+11"));
	}
	
	@Test
	public void scannerTest6() {
		Scanner scanner = new Scanner();
		List <Symbol> result = new ArrayList<>();
		result.add(new NumberSymbol(78));
		result.add(PlusSymbol.getInstance());
		result.add(new NumberSymbol(11));
		assertEquals(result, scanner.toSymbolSequence("78  + 11"));
	}
	
	@Test
	public void scannerTest7() {
		Scanner scanner = new Scanner();
		List <Symbol> result = new ArrayList<>();
		result.add(new LBrSymbol());
		result.add(new NumberSymbol(78));
		result.add(new RBrSymbol());
		result.add(PlusSymbol.getInstance());
		result.add(new NumberSymbol(11));
		assertEquals(result, scanner.toSymbolSequence("(78)+11"));
	}
	
	@Test
	public void scannerTest8() {
		Scanner scanner = new Scanner();
		List<Symbol> result = new ArrayList<>();
		assertEquals(result, scanner.toSymbolSequence(""));
	}
	
	@Test
	public void scannerTest9() {
		Scanner scanner = new Scanner();
		List<Symbol> result = new ArrayList<>();
		result.add(new LBrSymbol());
		result.add(new LBrSymbol());
		result.add(new NumberSymbol(4));
		result.add(new StarSymbol());
		result.add(new NumberSymbol(8));
		result.add(new RBrSymbol());
		result.add(PlusSymbol.getInstance());
		result.add(new NumberSymbol(74));
		result.add(new RBrSymbol());
		result.add(new StarSymbol());
		result.add(new NumberSymbol(2));
		assertEquals(result, scanner.toSymbolSequence("((4*8)+74)*2"));
	}
	
	@Test
	public void addTest1 () {
		Scanner scanner = new Scanner();
		List <Symbol> result = new ArrayList<Symbol>();
		result.add(new NumberSymbol(1));
		scanner.addSymbol(new NumberSymbol(1));
		assertEquals(result,scanner.toSymbolSequence(""));
	}
	@Test
	public void stringBuilderTest1() {
		StringBuilder string = new StringBuilder();
		string.append('a');
		string.append('b');
		string.append('c');
		String result = string.toString();
		assertEquals("abc", result);
	}
	
	@Test
	public void equalsTest1() {
		NumberSymbol one = new NumberSymbol(14);
		NumberSymbol two = new NumberSymbol(14);
		assertTrue(one.equals(two));
	}
	
	@Test
	public void equalsTest2() {
		NumberSymbol one = new NumberSymbol(14);
		NumberSymbol two = new NumberSymbol(5);
		assertFalse(one.equals(two));
	}
}
