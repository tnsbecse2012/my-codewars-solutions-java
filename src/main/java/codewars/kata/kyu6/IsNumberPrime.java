package main.java.codewars.kata.kyu6;

import java.util.stream.IntStream;

public class IsNumberPrime {

    public static void main(String[] args) {
        System.out.println(isPrime(1));    // output: false
        System.out.println(isPrime(2));    // output: true
        System.out.println(isPrime(-1));   // output: false
        System.out.println(isPrime(7));    // output: true
        System.out.println(isPrime(41));   // output: true
        System.out.println(isPrime(5099)); // output: true
        System.out.println(isPrime(-5));   // output: false
        System.out.println(isPrime(-8));   // output: false
        System.out.println(isPrime(-41));  // output: false
    }

    /*
     * When a number is not a prime, this number can be factored into two factors
     * namely a and b i.e. number = a * b. If both a and b were greater than the
     * square root of n, a*b would be greater than n.
     * 
     * So at least one of those factors must be less than or equal the square root
     * of a number and to check if a number is prime, we only need to test for
     * factors lower than or equal to the square root of the number being checked.
     * 
     * Additionally, prime numbers can never be an even number as even numbers are
     * all divisible by 2.
     */
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        return IntStream.rangeClosed(2, (int) (Math.sqrt(num))).allMatch(i -> num % i != 0);
    }
    
    // alternative solution 2
    public static boolean isPrime2(int num) {
        return num > 1 && java.math.BigInteger.valueOf(num).isProbablePrime(20);
    }
}


/**
 * Question: Is a number prime?
 * 
 * Define a function that takes one integer argument and returns logical value
 * true or false depending on if the integer is a prime.
 * 
 * Per Wikipedia, a prime number (or a prime) is a natural number greater than 1
 * that has no positive divisors other than 1 and itself.
 * 
 * Requirements 
 * You can assume you will be given an integer input. 
 * You can not assume that the integer will be only positive. 
 * You may be given negative numbers as well (or 0). 
 * 
 * NOTE on performance: There are no fancy optimizations required, but still the most trivial solutions might time out. 
 * Numbers go up to 2^31 (or similar, depends on language version). Looping all the way up to n, or n/2, will be too slow. 
 * Example is_prime(1) false 
 * is_prime(2) true
 * is_prime(-1) false
 * 
 */