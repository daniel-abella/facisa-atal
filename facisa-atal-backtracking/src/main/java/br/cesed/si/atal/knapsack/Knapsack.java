package br.cesed.si.atal.knapsack;

import java.util.Scanner;

public class Knapsack {

	private int n, W; // número e ítens e capacidade máxima
	private int w[], v[]; // weights and values of items
	private int V[][]; // table to store results of sub-problems

	/**
	 * Takes necessary inputs and initializes for solving
	 */
	private void initialize() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of items : ");
		n = sc.nextInt(); // number of items
		System.out.print("Enter W of knapsack : ");
		W = sc.nextInt(); // capacity of knapsack
		w = new int[n];
		v = new int[n];
		System.out.println("Enter ws and vs of items : ");
		for (int i = 0; i < n; i++) {
			w[i] = sc.nextInt(); // weight of item
			v[i] = sc.nextInt(); // profit of item
		}
		V = new int[n + 1][W + 1]; // initializing the table to hold results
		for (int i = 0; i <= W; i++)
			V[0][i] = 0;
	}

	/**
	 * Computes the result
	 */
	public void knapsack() {
		// table for backtracking to get the items chosen
		int x[][] = new int[n + 1][W + 1];
		// filling tables
		for (int i = 1; i <= n; i++)
			for (int j = 0; j <= W; j++)
				if ((w[i - 1] <= j) && (v[i - 1] + V[i - 1][j - w[i - 1]] > V[i - 1][j])) {
					V[i][j] = v[i - 1] + V[i - 1][j - w[i - 1]];
					x[i][j] = 1;
				} else {
					V[i][j] = V[i - 1][j];
					x[i][j] = 0;
				}
		// backtracking
		System.out.printf("Items Chosen\n%5s%7s%7s\n", "Item", "Weight", "Profit");
		int K = W;
		for (int i = n; i >= 1; i--)
			if (x[i][K] == 1) {
				System.out.printf("%5d%7d%7d\n", i, w[i - 1], v[i - 1]);
				K -= w[i - 1];
			}
		System.out.println("Maximum profit : " + V[n][W]);
	}

	public static void main(String[] args) {
		Knapsack obj = new Knapsack();
		obj.initialize();
		obj.knapsack();
	}
}
