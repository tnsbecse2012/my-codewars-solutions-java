package main.java.codewars.kata.kyu6;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HighestAndLowest {

	public static void main(String[] args) {
		System.out.println(highAndLow("1 2 3 4 5")); // return "5 1"
		System.out.println(highAndLow("1 2 -3 4 5")); // return "5 -3"
		System.out.println(highAndLow("1 9 3 4 -5")); // return "9 -5"

	}

	public static String highAndLow(String numbers) {
		Supplier<IntStream> numberStream = () -> Stream.of(numbers.split(" ")).mapToInt(num -> Integer.parseInt(num));
		return numberStream.get().max().getAsInt() + " " + numberStream.get().min().getAsInt();
	}
}

/**
 * Question: HighestAndLowest
 * 
 * In this little assignment you are given a string of space separated numbers,
 * and have to return the highest and lowest number.
 * 
 * Example:
 * 
 * highAndLow("1 2 3 4 5") // return "5 1" 
 * 
 * highAndLow("1 2 -3 4 5") // return "5
 * -3" 
 * 
 * highAndLow("1 9 3 4 -5") // return "9 -5" Notes:
 * 
 * All numbers are valid Int32, no need to validate them. There will always be
 * at least one number in the input string. Output string must be two numbers
 * separated by a single space, and highest number is first.
 * 
 */
