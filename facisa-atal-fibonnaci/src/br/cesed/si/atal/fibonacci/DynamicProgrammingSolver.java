package br.cesed.si.atal.fibonacci;

public class DynamicProgrammingSolver implements FibonacciSolver {

	@Override
	public int solve(int n) {

		int[] fib = new int[n + 2]; // +2 para facilitar
		fib[0] = 1;
		fib[1] = 1;

		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}

		return fib[n];
	}

}
