package br.cesed.si.atal.dynamicprogramming;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemaMochila {

	public static Integer[][] inicializaMatriz(Integer[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (i == 0 || j == 0) {
					array[i][j] = 0;
				}
			}
		}
		return array;
	}

	public static Integer[][] MochilaProgramacaoDinamica(Integer[] v, Integer[] w, Integer W) {
		Integer[][] V = new Integer[v.length + 1][W + 1];
		V = inicializaMatriz(V);

		for (int i = 1; i <= v.length; i++) {
			for (int j = 1; j <= W; j++) {
				if (w[i - 1] > j) {
					V[i][j] = V[i - 1][j];
				} else {
					V[i][j] = max(V[i - 1][j], V[i - 1][j - w[i - 1]]
							+ v[i - 1]);
				}
			}
		}
		return V;
	}

	private static int max(int x, int y) {
		if (x >= y) {
			return x;
		}
		return y;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String aux = sc.nextLine();

		String[] aux2 = aux.split(" ");

		Integer S = Integer.valueOf(aux2[0]);
		Integer N = Integer.valueOf(aux2[1]);

		Integer[] v = new Integer[N];
		Integer[] w = new Integer[N];

		for (int i = 0; i < N; i++) {
			aux = sc.nextLine();
			aux2 = aux.split(" ");
			w[i] = Integer.valueOf(aux2[0]);
			v[i] = Integer.valueOf(aux2[1]);
		}

		Integer[][] V = MochilaProgramacaoDinamica(v, w, S);
		Integer result = V[v.length][S];

		System.out.println(result);
	}
}