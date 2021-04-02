package main.java.codewars.kata.kyu6;

import java.util.Arrays;

public class TribonacciSequence {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(tribonacci(new double[] { 1, 1, 1 }, 10))); // 1,1,1,3,5,9,17,31,57,105
		System.out.println(Arrays.toString(tribonacci(new double[] { 0, 0, 1 }, 10))); // 0,0,1,1,2,4,7,13,24,44
		System.out.println(Arrays.toString(tribonacci(new double[] { 0, 1, 1 }, 10))); // 0,1,1,2,4,7,13,24,44,81
	}

	public static double[] tribonacci(double[] s, int n) {
		double[] tribonacciSeq = new double[n];
		for (int d = 0; d < n; d++) {
			// add starting input into result array(tribonacciSeq)
			if (d <= s.length - 1) {
				tribonacciSeq[d] = s[d];
				continue; // skip current loop and go to next element
			}
			// add previous 3 elements to make 4th element.
			tribonacciSeq[d] = tribonacciSeq[d - 1] + tribonacciSeq[d - 2] + tribonacciSeq[d - 3];
		}
		return tribonacciSeq;
	}
}
