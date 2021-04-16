package main.java.codewars.kata.kyu5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WeightSort {

	public static void main(String[] args) {
		System.out.println(orderWeight("56 65 74 100 99 68 86 180 90")); // should return: "100 180 90 56 65 74 68 86 99"
		System.out.println(orderWeight("103 123 4444 99 2000")); // should return: "2000 103 123 4444 99"
		System.out.println(orderWeight2("2000 10003 1234000 44444444 9999 11 11 22 123")); // should return: "11 11 2000 10003 22 123 1234000 44444444
																							// 9999"
	}

	private static String orderWeight(String weightList) {

		if (weightList.length() == 0) {
			return "";
		}

		// Tree map to hold weight's sum in order
		TreeMap<Integer, List<String>> weightMap = new TreeMap<>();
		for (String weight : weightList.split(" ")) {
			Integer weightSumAsInt = getSumOfDigits(weight);
			addWeightToList(weightMap, weight, weightSumAsInt);
		}

		StringBuffer outputWeights = new StringBuffer("");

		weightMap.forEach((key, value) -> {
			Collections.sort(value);
			outputWeights.append(value.stream().collect(Collectors.joining(" ")) + " ");
		});

		return outputWeights.toString().trim();
	}

	// add weights into sum of weights key
	private static void addWeightToList(TreeMap<Integer, List<String>> weightMap, String str, Integer weightSumAsInt) {

		List<String> wtList = weightMap.get(weightSumAsInt);
		if (wtList == null) {
			wtList = new ArrayList<>();
		}

		wtList.add(str);
		weightMap.put(weightSumAsInt, wtList);
	}

	private static int getSumOfDigits(String wieghtAsString) {
		return wieghtAsString.chars().map(Character::getNumericValue).sum();
	}

	// Alternative Solution
	// 1: Sort weights by its value
	// 2: Sort weights by its sum of value
	private static String orderWeight2(String weights) {
		return Stream.of(weights.trim().split(" +"))
					.sorted()
					.sorted(Comparator.comparingInt(o -> o.chars().map(Character::getNumericValue).sum()))
					.collect(Collectors.joining(" "));
	}
}

/**
 * Question: Weight for weight
 * 
 * My friend John and I are members of the "Fat to Fit Club (FFC)". John is
 * worried because each month a list with the weights of members is published
 * and each month he is the last on the list which means he is the heaviest.
 * 
 * I am the one who establishes the list so I told him: "Don't worry any more, I
 * will modify the order of the list". It was decided to attribute a "weight" to
 * numbers. The weight of a number will be from now on the sum of its digits.
 * 
 * For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list
 * 100 will come before 99.
 * 
 * Given a string with the weights of FFC members in normal order can you give
 * this string ordered by "weights" of these numbers?
 * 
 * Example: "56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes:
 * 
 * "100 180 90 56 65 74 68 86 99"
 * 
 * When two numbers have the same "weight", let us class them as if they were
 * strings (alphabetical ordering) and not numbers:
 * 
 * 180 is before 90 since, having the same "weight" (9), it comes before as a
 * string.
 * 
 * All numbers in the list are positive numbers and the list can be empty.
 * 
 * Notes it may happen that the input string have leading, trailing white spaces
 * and more than a unique whitespace between two consecutive numbers For C: The
 * result is freed.
 * 
 */
