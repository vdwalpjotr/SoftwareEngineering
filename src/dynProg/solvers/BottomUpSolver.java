package dynProg.solvers;
import dynProg.Solver;


public class BottomUpSolver implements Solver {

    public boolean solve(int[] numbers, int sum){
        //Sum +1, because range from 0 to sum including the 0
        boolean[][] matrix = new boolean[numbers.length][sum+1];
        int row = 0;

        //If sum = 0 and length = 0 or sum=0 return true, if length = 0 but sum is not return false
        if(sum == 0){
            return true;
        }
        if(numbers.length == 0){
            return false;
        }
        // loop trough all elements of your collection
        while(row < numbers.length){
            matrix[row][numbers[row]] = true;
            if(row>0){
                //Having a collection of the same elements can also sum to 2 * that element,
                //eg {3,3, 5} can have subset sum=3 or sum is 6 or 8 (8 is done in next loop)
                if(numbers[row-1]==numbers[row] && (2*numbers[row] <= sum)){
                    matrix[row][2*numbers[row]] = true;
                }
                //For all indices true on previous row, that indices + current is also true.
                //eg {1,2,4} will give subsums
                // 1
                // 1 , 2, 3,
                // 1 , 2, 3, 4 , 5, 6, 7
                for(int i = 0; i < sum + 1; i++){
                    if(matrix[row - 1][i] && i != numbers[row]){
                        // Next value is the same as the previous
                        // No need to calculate if it's already true
                        matrix[row][i] = matrix[row-1][i];
                        if((i+numbers[row]) <= sum){
                            matrix[row][i+numbers[row]] = true;
                        }
                    }
                }
            }
            if(matrix[row][sum]){
                return true;
            }
            row++;
        }

//
//		for(int i=0; i<numbers.length;i++){
//			for(int j=0; j<sum+1; j++){
//				System.out.print(matrix[i][j]+"|");
//			}
//			System.out.print("\n");
//
//		}
        return false;
    }
}
