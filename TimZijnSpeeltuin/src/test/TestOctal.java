package test;
import junit.framework.TestCase;
import multiformat.*;


public class TestOctal extends TestCase {

	/**
	 * Constructor of the TestOctal class
	 * @param arg0
	 */
	public TestOctal(String arg0) {
		super(arg0);
	}

	/**
	 * When used the testOperations method will create a new Calculator.
	 * Then it will add two operands and change the base.
	 * To check if the base is correctly changed and the operands
	 * are converted to the new base.
	 * It will check if the operands are the same as they should be.
	 * Then it will sum the two existing operands and
	 * check if the right values are set afterwards.
	 * If a check will fail there will be a FormatException thrown.
	 */
	public void testOperations(){
	
		Calculator calc = new Calculator();
		
		try{
		calc.addOperand("5");
		calc.addOperand("10");
		calc.setBase(new OctalBase());
		
		assertEquals("5.0",calc.firstOperand());
		assertEquals("12.0",calc.secondOperand());
		
		calc.add();
		
		assertEquals("0.0",calc.firstOperand());
		assertEquals("17.0",calc.secondOperand());
		
		}catch(FormatException e){
			fail("Unexpected exception");
		}
	}	
}
