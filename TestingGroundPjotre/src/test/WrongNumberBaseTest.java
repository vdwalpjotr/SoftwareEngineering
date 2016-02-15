package test;
import junit.framework.TestCase;
import multiformat.*;


public class WrongNumberBaseTest extends TestCase {

	public WrongNumberBaseTest(String arg0) {
		super(arg0);
	}

	public void testOperations(){
	
		Calculator calc = new Calculator();
		
		try{
		calc.setBase(new HexBase());
		calc.addOperand("1D");
		
		assertEquals("0.0",calc.firstOperand());
		assertEquals("1D.0",calc.secondOperand());
		
		calc.addOperand("1a");
		
		assertEquals("0.0",calc.firstOperand());
		assertEquals("1D.0",calc.secondOperand());
		
		}catch(FormatException e){
			fail("Unexpected exception");
		}
	}
	
	
}
