package dynProg.solvers;

import dynProg.Solver;

public class BottomUpSolver implements Solver{
	int row=0;
	int subsum=0;
	public boolean solve( int[] numbers, int sum){
		int[][] matrix = new int[numbers.length][sum];
		for(int j=0; j<sum; j++){
			matrix[0][j] = 0;
		}
		matrix[0][numbers[0]-1] = 1; 
		subsum = numbers[0];
		for(int j=0; j<sum-1; j++){
			System.out.print(j+1 + "|  ");
		}
		System.out.println("\n");
		for(int j=0; j<sum; j++){
			
			System.out.print(matrix[row][j] + "|  ");
		}
		System.out.print("\n");
		while( row < numbers.length-1){
			row++;
			matrix[row][numbers[row]-1] = 1;
			subsum += numbers[row];
	//		System.out.println(subsum);
			if(subsum < sum){ 
			matrix[row][subsum-1] = 1;
			}
			for(int j=0; j<sum; j++){
				if(matrix[row-1][j] == 1){
					matrix[row][j] = 1;
				}
				
				System.out.print(matrix[row][j] + "|  ");
			}
			System.out.print("\n");
			if(matrix[row][sum-1] == 1){
				System.out.println( "hai");
				return true;
			}
			
		}
		
		return false;
	}

}
