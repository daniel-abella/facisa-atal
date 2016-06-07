package br.cesed.si.atal.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class MaximoConjuntoIndependente {
	
	public static List<Integer> Reconstrucao(List<Integer> A, List<Integer> V){
		int i = A.size()-1;
		List<Integer> S = new ArrayList<Integer>();
		
		while(i >= 1){
			if (A.get(i-1) >= A.get(i-2) + V.get(i-1)){
				i--;
			}
			else {
				S.add(V.get(i-1));
				i = i-2;
			}
		}
		return S;
	}
	
	public static List<Integer> SomaMaximoConjuntoIndependete(List<Integer> V){
		List<Integer> A = new ArrayList<Integer>();
		A.add(0);
		A.add(V.get(0));
		int i = 2;
		
		while(i <= V.size()){
			A.add(max(A.get(i-1), A.get(i-2) + V.get(i-1)));
			i++;
		}
		return A;
	}

	private static int max(int x, int y) {
		if (x >= y){
			return x;
		}
		return y;
	}

	public static void main(String[] args) {
		List<Integer> V = new ArrayList<Integer>();
		List<Integer> A = null;
		Integer[] aux = {1,4,5,4};
		
		for(Integer element: aux){
			V.add(element);
		}
		
		A = SomaMaximoConjuntoIndependete(V);
		
		System.out.println(A);
		System.out.println(Reconstrucao(A, V));
	}
}