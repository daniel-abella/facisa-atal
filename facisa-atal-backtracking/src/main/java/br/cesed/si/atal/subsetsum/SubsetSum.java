package br.cesed.si.atal.subsetsum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Resolução do Problema do SubsetSum usando Backtracking
 * 
 * @author https://github.com/thehappybug/subset-sum
 */
public class SubsetSum {
	
	private int[] numbers;
	private int sum = 5; //a soma tem que ser 5
	private int totalSum = 0;
	private ArrayList<ArrayList<Integer>> results;

	public SubsetSum(int[] numbers) {
		this.numbers = numbers;
		
		//ordena
		Arrays.sort(numbers);

		//obtém a soma
		for (int item : numbers) {
			totalSum += item;
		}
	}

	public ArrayList<ArrayList<Integer>> run() {
		
		results = new ArrayList<ArrayList<Integer>>();
		sumOfSubsets(0, 0, totalSum, new ArrayList<Integer>());
		return results;
	}

	private void sumOfSubsets(int index, int currentSum, int remainingSum, ArrayList<Integer> sublist) {

		sublist.add(numbers[index]);
		
		if (numbers[index] + currentSum == sum) {
			results.add(sublist);
		
		} else if (index + 1 < numbers.length  //se deve seguir
				&& currentSum + numbers[index] + numbers[index + 1] <= sum) {
			sumOfSubsets(index + 1, currentSum + numbers[index], remainingSum - numbers[index],new ArrayList<Integer>(sublist));
		}
		
		if (index + 1 < numbers.length 
				&& currentSum + numbers[index + 1] <= sum
				&& currentSum + remainingSum - numbers[index] >= sum) {
			sublist.remove(sublist.size() - 1);
			sumOfSubsets(index + 1, currentSum, remainingSum - numbers[index], new ArrayList<Integer>(sublist));
		}
	}

	public static void main(String[] args) {
		
		int[] numbers = { 1, 2, 3, 4, 5 };
		
		SubsetSum algo = new SubsetSum(numbers);
		ArrayList<ArrayList<Integer>> results = algo.run();
		
		for (ArrayList<Integer> a : results) {
			System.out.println(a);
		}
	}
}