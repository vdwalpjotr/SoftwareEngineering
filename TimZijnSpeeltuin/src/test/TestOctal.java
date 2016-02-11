package test;
import junit.framework.TestCase;
import multiformat.*;


public class TestOctal extends TestCase {

	public TestOctal(String arg0) {
		super(arg0);
	}

	public void testOperations(){
	
		Calculator calc = new Calculator();
		
		try{
		calc.addOperand("5");
		calc.addOperand("10");
		calc.setBase(new OctalBase());
		
		assertEquals("5.0",calc.firstOperand());
		assertEquals("12.0",calc.secondOperand());
		
		}catch(FormatException e){
			fail("Unexpected exception");
		}
	}
	
	
}
