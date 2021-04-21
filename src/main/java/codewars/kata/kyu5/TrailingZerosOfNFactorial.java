package main.java.codewars.kata.kyu5;

import java.util.stream.LongStream;

// not working with larger number
public class TrailingZerosOfNFactorial {

    public static void main(String[] args) {

        System.out.println(trailingZerosOfNFactorial(6)); // output: 720 => 1
        System.out.println(trailingZerosOfNFactorial(12)); // output: 479001600 => 2
        System.out.println(trailingZerosOfNFactorial(14)); // output: => 2
        //System.out.println(trailingZerosOfNFactorial(619782033)); // output: => 2
    }

    public static int trailingZerosOfNFactorial(int n) {

        // if n=0, return 0
        if (n <= 0) {
            return n;
        }

        // if n > 0, find factorial of n
        long nFactorial = LongStream.rangeClosed(1, n).parallel().reduce(1, (long a, long b) -> a * b);

        // find trailing zeros of factorial n
        int noOfTrailingZeros = 0;

        while (nFactorial % 10 == 0) {
            nFactorial = nFactorial / 10;
            noOfTrailingZeros++;
        }
        return noOfTrailingZeros;
    }
}

/**
 * Question: Number of trailing zeros of N!
 * 
 * Write a program that will calculate the number of trailing zeros in a
 * factorial of a given number.
 * 
 * N! = 1 * 2 * 3 * ... * N
 * 
 * Be careful 1000! has 2568 digits...
 * 
 * For more info, see: http://mathworld.wolfram.com/Factorial.html
 * 
 * Examples zeros(6) = 1 # 6! = 1 * 2 * 3 * 4 * 5 * 6 = 720 --> 1 trailing zero
 * 
 * zeros(12) = 2 # 12! = 479001600 --> 2 trailing zeros
 * 
 * Hint: You're not meant to calculate the factorial. Find another way to find
 * the number of zeros.
 * 
 */
