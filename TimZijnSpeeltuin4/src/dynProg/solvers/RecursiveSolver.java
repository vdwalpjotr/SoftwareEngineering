package dynProg.solvers;
import dynProg.Solver;
import java.util.Arrays;
public class RecursiveSolver implements Solver {
	public boolean solve( int[] numbers, int sum)
	{
		if(sum == 0){
			return true;
		}
		int sumOfNumbers = 0;
		while(numbers.length > 0){
			for(int i=0; i<numbers.length; i++){
				sumOfNumbers += numbers[i];
			}
			if(sumOfNumbers == sum){
				return true;
			}
			solve(Arrays.copyOf(numbers, numbers.length-1), sum);
		}
		
		return false;
	}

}
