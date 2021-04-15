package main.java.codewars.kata.kyu6;

import java.util.stream.IntStream;

public class DigitsPower {

	public static void main(String[] args) {
		System.out.println(digPow(89, 1)); 		// output: 1
		System.out.println(digPow(695, 2)); 	// output: 2
		System.out.println(digPow(46288, 3)); 	// output: 51
		System.out.println(digPow(92, 1)); 		// output: -1
		System.out.println(digPow(695, 2)); 	// output: 2
		System.out.println(digPow2(3456789, 5)); // output: -1
	}

	public static long digPow(int number, int power) {

		int[] arrNumbers = Integer.toString(number).chars().map(c -> Character.getNumericValue(c)).toArray();

		int p = power;
		int multipleValue = 0;
		
		// sum of number's power value
		for (int i = 0; i < arrNumbers.length; i++) {
			int j = p;
			long result = 1;
			while(j != 0) {
				result *= arrNumbers[i];
				j--;
			}
			multipleValue += result;
			p++;
		}
		
		// if both are same then k will be 1
		if(multipleValue == number) {
			return 1;
		}

		int k = 1;
		int n = number;
		// finding k
		while (n < multipleValue) {
			n = number * k;
			k++;
		}

		if (n == multipleValue) {
			return k - 1;
		}
		return -1;
	}
	
	// Alternative solution with Stream
	public static long digPow2(int number, int power) {
	    int[] digits = String.valueOf(number).chars().map(Character::getNumericValue).toArray();
	    int sum = IntStream.range(0, digits.length).map(i -> (int) Math.pow(digits[i], i + power)).sum();
	    return sum % number == 0 ? sum / number : -1;
	  }
}

/**
 * Question: Playing with digits
 * 
 * Some numbers have funny properties. For example:
 * 
 * 89 --> 8¹ + 9² = 89 * 1
 * 
 * 695 --> 6² + 9³ + 5⁴= 1390 = 695 * 2
 * 
 * 46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
 * 
 * Given a positive integer n written as abcd... (a, b, c, d... being digits)
 * and a positive integer p
 * 
 * we want to find a positive integer k, if it exists, such as the sum of the
 * digits of n taken to the successive powers of p is equal to k * n. In other
 * words:
 * 
 * Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) +...) = n * k
 * 
 * If it is the case we will return k, if not return -1.
 * 
 * Note: n and p will always be given as strictly positive integers.
 * 
 * digPow(89, 1) should return 1 since 8¹ + 9² = 89 = 89 * 1 digPow(92, 1) 
 * 		= should return -1 since there is no k such as 9¹ + 2² equals 92 * k
 * 
 * digPow(695, 2) should return 2 since 6² + 9³ + 5⁴= 1390 = 695 * 2
 * 
 * digPow(46288, 3) should return 51 since 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
 * 
 */
