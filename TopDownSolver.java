package dynProg.solvers;

import dynProg.Solver;

public class TopDownSolver implements Solver{
	private Boolean[][] sol;
	
	public boolean solve( int[] numbers, int sum){
		//initialise Boolean matrix (default values are null)
	sol	 = new Boolean[numbers.length][sum+1];
		//call the main function
		return findSolution(numbers, sum);
	}
	private boolean findSolution(int[] numbers, int sum){
		//Empty subset has sum 0;
		if(sum == 0){
			return true;
		}
		//Empty collection has no sum other than 0. This implementation can call with a sum < 0, 
		// which should return false since this is not what we want to see 
		
		if(numbers.length == 0 || sum <0){
			return false;
		}
		//If the last element of the (sub)matrix is null, execute the algorithm, otherwise you have found your solution.
		if(sol[numbers.length-1][sum] == null){
			sol[numbers.length-1][sum] = executeSolving(numbers, sum);
		}
		return sol[numbers.length-1][sum];
	}	
	
	private boolean executeSolving(int[] numbers, int sum){
		//Divide and conquer
		int length = numbers.length-1;
		int[] subSet = new int[length];
		for(int i = 0; i< length; i++){
			subSet[i] = numbers[i];
		}
		
		//Recursive call, if the last element is sum, sum becomes 0, and hence returning true;
		return findSolution(subSet, sum) || findSolution(subSet, sum-numbers[length]);
	}
}
