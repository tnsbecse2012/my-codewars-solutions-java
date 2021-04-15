package main.java.codewars.kata.kyu6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindOddInt {

	public static void main(String[] args) {
		System.out.println(findOddInt(new int[] { 20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5 }));  // output: 5
		System.out.println(findOddInt(new int[] { 1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5 })); 						// output: -1
		System.out.println(findOddInt(new int[] { 20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5 })); 					// output: 5
		System.out.println(findOddInt(new int[] { 10 })); 														// output: 10
		System.out.println(findOddInt(new int[] { 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1 })); 						// output: 10
		System.out.println(findOddInt(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10 })); 						// output: 1
	}

	public static int findOddInt(int[] a) {
		List<Integer> aList = Arrays.stream(a).sorted().boxed().collect(Collectors.toList());
		for (int i = 0; i < a.length; i++) {
			int value = aList.get(i);
			int freq = Collections.frequency(aList, value);
			if (freq % 2 != 0) {
				return value;
			}
			// if that number not an even repeating number then skip same numbers and take next number
			i = aList.lastIndexOf(value);
		}
		return 0;
	}

	// Alternative solution: using XOR
	public static int findOddInt2(int[] a) {
		int xor = 0;
		for (int i = 0; i < a.length; i++) {
			// XOR will cancel out every time you XOR with the same number
			// so 1^1=0 but 1^1^1=1 so every pair should cancel out leaving the odd number out
			xor ^= a[i];
		}
		return xor;
	}

	// Alternative solution: using stream
	public static int findOddInt3(int[] a) {
		return Arrays.stream(a).reduce(0, (x, y) -> x ^ y);
	}
}

/**
 * Question: Find the odd int
 * 
 * Given an array of integers, find the one that appears an odd number of times.
 * 
 * There will always be only one integer that appears an odd number of times.
 * 
 */
