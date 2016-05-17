package br.cesed.si.atal.subsets;

import java.util.*;

public class AllSubsets {

	private List<Set<Integer>> subsetList = new LinkedList<Set<Integer>>();

	private void subsets_dfs(int[] items, Set<Integer> subset, int k) {
		if (k == items.length) {
			System.out.println(subset);
			subsetList.add(new TreeSet<Integer>(subset));
		} else {
			for (int b = 1; b >= 0; b--) {
				if (b != 0) subset.add(items[k]);
				subsets_dfs(items, subset, k + 1);
				subset.remove(items[k]);
			}
		}
	}

	public List<Set<Integer>> subsets(int[] items) {
		subsets_dfs(items, new TreeSet<Integer>(), 0);
		return subsetList;
	}

	public static void main(String[] args) {
		new AllSubsets().subsets(new int[] {1,2,3});
	}
	

}