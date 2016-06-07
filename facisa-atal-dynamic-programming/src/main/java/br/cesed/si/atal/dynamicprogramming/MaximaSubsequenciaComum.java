package br.cesed.si.atal.dynamicprogramming;
public class MaximaSubsequenciaComum {
	
	public static int max(int n1, int n2){
		if(n1 >= n2){
			return n1;
		}
		return n2;
	}
	
	public static Integer[][] inicializaMatriz(Integer [][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (i == 0 || j == 0){
					array[i][j] = 0;
				}
			}
		}
		return array;
	}
	
	public static int MaximaSubsequenciaComumPD(String[]X, String[]Y){
		Integer[][]C = new Integer[X.length+1][Y.length+1];
		C = inicializaMatriz(C);
		
		for (int i = 1; i <= X.length; i++) {
			for (int j = 1; j <= Y.length; j++) {
				if(X[i-1].equals(Y[j-1])){
					C[i][j] = 1 + C[i-1][j-1];
				}
				else{
					C[i][j] = max(C[i-1][j],C[i][j-1]);
				}	
			}	
		}
		return C[X.length][Y.length];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[]X = {"A","B","C","T"};
		String[]Y = {"A","B","T"};
		
		System.out.println(MaximaSubsequenciaComumPD(X, Y));
	}
}