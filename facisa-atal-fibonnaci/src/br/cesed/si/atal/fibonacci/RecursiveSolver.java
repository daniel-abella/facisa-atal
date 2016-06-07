package br.cesed.si.atal.fibonacci;

public class RecursiveSolver implements FibonacciSolver {

	@Override
	public int solve(int n) {

		if (n == 0) return 1;
		if (n == 1) return 1;
		return solve(n-1) + solve(n-2);
	}
}
