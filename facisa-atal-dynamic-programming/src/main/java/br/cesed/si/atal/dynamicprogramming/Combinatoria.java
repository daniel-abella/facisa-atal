package br.cesed.si.atal.dynamicprogramming;

public class Combinatoria {
	
	public static int BinomialExponencial(int n,int k){
		if (n == k || k == 0){
			return 1;
		}
		return BinomialExponencial(n-1,k-1)+BinomialExponencial(n-1,k);
	}
	
	public static int BinomialProgramacaoDinamica(int n, int k){
		Integer[][] C = new Integer[n][k];
		
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < min(i,k); j++) {
				if (i == j || j == 0){
					C[i][j] = 1;
				}
				else {
					C[i][j] = C[i-1][j-1]+C[i-1][j];
				}
			}
		}
		return C[n][k];
	}
		
	private static int min(int i, int k) {
		if (i <= k){
			return i;
		}
		return k;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(BinomialExponencial(5, 3));
		System.out.println(BinomialExponencial(5, 3));
	}
}