package dynProg.solvers;

import dynProg.Solver;

public class BottomUpSolver implements Solver{
	int row=0;
	int subsumLastRow=0;
	int subsumPrevRow=0;
	public boolean solve( int[] numbers, int sum){
		int[][] matrix = new int[numbers.length][sum];
		matrix[0][numbers[0]-1] = 1; 	
		for(int j=0; j<sum; j++){
			if(j<9){
			System.out.print(j+1 + "|  ");
			}else{
				System.out.print(j+1 + "| ");
			}
		}
		System.out.println("\n");
		while( row < numbers.length){
			matrix[row][numbers[row]-1] = 1;
			
			for(int j=0; j<sum; j++){
				
				if(row > 0 && (matrix[row-1][j] == 1)){
					matrix[row][j] = 1;
					subsumLastRow += j;				
					if(subsumLastRow <= sum){
						matrix[row][subsumLastRow] = 1;
					}
					
				}
				if( row > 1){
						if(matrix[row-2][j] == 1){
							subsumPrevRow += j;
						}
						//int value = subsumPrevRow+numbers[row];
						//System.out.print("Waarde : " + value+ " |");
						
						if((subsumPrevRow+numbers[row])<= sum){
							matrix[row][subsumPrevRow+numbers[row]-1] = 1;
						}
				}
				
				System.out.print(matrix[row][j] + "|  ");
			}
			
			
			System.out.print("\n");
			
			if(matrix[row][sum-1] == 1){
				row = 0;
				return true;
			}
			row++;
			
			
		}
		
		return false;
	}

}
