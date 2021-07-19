package com.interview.questions;

import java.util.HashSet;
import java.util.Set;

public class ExtractUniqueValuesFromArray {

	public static Set<Integer> getUniqueValuesFromArray(int[] array) {

		Set<Integer> set = new HashSet<Integer>();

		for (int a : array) {
			set.add(a);
		}

		return set;
	}

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 5 };
		Set<Integer> uniqueValuesFromArray = getUniqueValuesFromArray(array);
		System.out.println(uniqueValuesFromArray);

	}

}
