package assignment10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class sumArrays {
	public static void main(String[] args) {
	    sumArrays sumObject = new sumArrays();
	  }
	
	public sumArrays() {
		try {
		BufferedReader lineReader = new  BufferedReader( new InputStreamReader( System.in ) );
		System.out.println("Please seperate the numbers with a ','");
		System.out.println("First Array");
		System.out.print("numbers: ");
		
		String command1 = lineReader.readLine();
		System.out.println(command1);
		int[] firstArray = intArray(command1);
		
		System.out.println();
		System.out.println("Second Array");
		System.out.print("numbers: ");
		String command2 = lineReader.readLine();
		System.out.println(command2);
		int[] secondArray = intArray(command2);
		
		if(firstArray.length != secondArray.length) {
			throw new ArraySizeException();
		}
		else {
			int[] total = new int[firstArray.length];
			for(int i=0; i < firstArray.length; i++) {
				total[i] = firstArray[i] + secondArray[i];
			}

			System.out.println();
			System.out.print("Total Array: [");
			for(int z = 0; z < total.length-1; z++) {
				System.out.print(total[z]);
				if(z != total.length-2) {
					System.out.print(",");
				}
			}
			System.out.print("]");
		}
		
		} catch (IOException | ArraySizeException e) {
			e.printStackTrace();
		}
	}
	
	private int[] intArray(String arrayString) {
		String[] strArray = arrayString.split(",");
		int[] intArray = new int[strArray.length+1];
		for(int i = 0; i < strArray.length; i++) {
			try {
		    intArray[i] = Integer.parseInt(strArray[i]);
			}
			catch (NumberFormatException e) {
				System.out.println("Please only insert numbers.");
				System.exit(1);
			}
		}
		return intArray;
	}
}
