package dynProg.solvers;
import dynProg.Solver;
import java.util.Arrays;
public class RecursiveSolver implements Solver {
	public boolean solve( int[] numbers, int sum)
	{
		//basecases
		if(sum == 0){
			return true; 
		}
		if(numbers.length == 0) {
			return false;
		}
		
		if(numbers[numbers.length -1] > sum){
			return solve(Arrays.copyOf(numbers,  numbers.length-1), sum);
		}
		int[] subSet = Arrays.copyOf(numbers, numbers.length-1);
		return solve(subSet, sum-numbers[numbers.length-1]) || solve(subSet, sum);
	}

}


