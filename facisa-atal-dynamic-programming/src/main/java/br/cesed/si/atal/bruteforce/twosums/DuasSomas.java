package br.cesed.si.atal.bruteforce.twosums;

public class DuasSomas {

	/**
	 * número de tuplas (i,j) que satisfaz a condição: a[i] + a[j] = 0
	 * 
	 * @param a
	 */
	public static int printAll(int[] a) {
		
		int size = a.length;
		int count = 0;
		for (int i = 0; i < size; i++) {
			
			for (int j = i + 1; j < size; j++) {
				
				if (a[i] + a[j] == 0) {
					count++;
					System.out.println(a[i] + " " + a[j]);
				}
			}
		}
		
		return count;
	}

	/**
	 * Retorna o número de tuplas (i,j) que satisfaz a condição: a[i] + a[j] = 0
	 * 
	 * @param a array com os valores
	 * @return tuplas (i,j) que satisfaz a condição a[i] + a[j] = 0
	 */
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (a[i] + a[j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {

		int[] a = new int[] { -2, 2, -1, 1, 3 };
		
		printAll(a);
		int cnt = count(a);
		System.out.println(cnt);
	}
}