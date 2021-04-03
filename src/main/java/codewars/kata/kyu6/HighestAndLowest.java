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
