/*
 * (C) Copyright 2005 Davide Brugali, Marco Torchiano
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 * 02111-1307  USA
 */
package multiformat;

import java.util.ArrayList;

/**
 * The multiformat calculator
 */
public class Calculator {
  private Rational operand_0 = new Rational();
  private Rational operand_1 = new Rational();
  
  private int totalCalculations = 0;
  
  private String currentNumber = "";
  private String operator = "";
  
  // The current format of the calculator
  private Format format = new FixedPointFormat();
  // The current numberbase of the calculator
  private Base base = new DecimalBase();

  public void addOperand(String newOperand) throws FormatException {
	  Rational test = format.parse(newOperand, base);
	  String test2 = format.toString(test, base);
	  if(!newOperand.contains(".")) {
		  newOperand = newOperand+".0";
	  }
	  if(!test2.equals(newOperand)) {
		  try {
		  throw new NumberBaseException("Wrong number for this base.");
	  }
	  catch(NumberBaseException e) {
		  System.out.println(e.getMessage());
	  }
	  }
	  else {
		  operand_1 = operand_0;
	      operand_0 = format.parse(newOperand, base);		  
	  }
  }

  public void add(){
    operand_0 = operand_1.plus(operand_0);
    operand_1 = new Rational();
  }
  public void subtract() {
    operand_0 = operand_1.minus(operand_0);
    operand_1 = new Rational();
  }
  public void multiply() {
    operand_0 = operand_1.mul(operand_0);
    operand_1 = new Rational();
  }
  public void divide() {
    operand_0 = operand_1.div(operand_0);
    operand_1 = new Rational();
  }
  public void delete() {
    operand_0 = operand_1;
    operand_1 = new Rational();
  }

  public String firstOperand(){
    return format.toString(operand_1,base);
  }
  public String secondOperand(){
    return format.toString(operand_0,base);
  }

  public void setBase(Base newBase){
    base = newBase;
  }
  public Base getBase(){
    return base;
  }
  public void setFormat(Format newFormat){
    format = newFormat;
  }
  public Format getFormat(){
    return format;
  }
  
  public void increaseCalculations() {
	  totalCalculations++;
  }
  
  public int getCalculations() {
		return totalCalculations;
	}
  
  public void setCurrentNumber(String number) {
	  if(number.equals("-")) {
		  currentNumber = number+currentNumber;
	  }
	  else {
		  currentNumber = currentNumber+number;		  
	  }
  }
  
  public String getCurrentNumber() {
	  return currentNumber;
  }
  
  public void operatorClicked(String op) {
	  try {
		  if(currentNumber.equals("")) {
			  currentNumber = secondOperand();
		  }
		addOperand(currentNumber);
		currentNumber = "";
		operator = op;
	} catch (FormatException e) {
		e.printStackTrace();
	}
  }
  
  public void resultClicked() {
		try {
			addOperand(currentNumber);
			currentNumber = "";
			if(operator.equals("+")) {
				add();
				increaseCalculations();
			}
			else if(operator.equals("-")) {
				subtract();
				increaseCalculations();				
			}
			else if(operator.equals("x")) {
				multiply();
				increaseCalculations();
			}
			else if(operator.equals("/")) {
				divide();
				increaseCalculations();
			}
			System.out.println(firstOperand());
			System.out.println(secondOperand());
			
		} catch (FormatException e) {
			e.printStackTrace();
		}
  }
}