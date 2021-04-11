package main.java.codewars.kata.kyu6;

import java.util.ArrayList;
import java.util.Arrays;

public class StringSplit {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("HelloWorld"))); // should return [He, ll, oW, or, ld]
		System.out.println(Arrays.toString(solution("abc"))); // should return ["ab", "c_"]
	}

	public static String[] solution(String s) {
		int len = s.length();
		int i = 0;
		ArrayList<String> pairOfStrings = new ArrayList<>();

		while (i < len) {
			// if its length is odd number, and reached end of char then append '_'
			if (i + 2 > len) {
				pairOfStrings.add(s.substring(len - 1) + "_");
				break;
			}

			// add pair of string until end of char
			pairOfStrings.add(s.substring(i, i + 2));
			i += 2;
		}
		return pairOfStrings.toArray(new String[0]);
	}

	// alternative solution -> split s into array and regex 2 character each
	public static String[] solution2(String s) {
		if (s.length() % 2 != 0) {
			s = s + "_";
		}
		return s.split("(?<=\\G.{2})");
	}
}

/**
 * Question: StringSplit
 * 
 * Complete the solution so that it splits the string into pairs of two
 * characters. If the string contains an odd number of characters then it should
 * replace the missing second character of the final pair with an underscore
 * ('_').
 * 
 * Examples:
 * 
 * StringSplit.solution("abc") // should return {"ab", "c_"}
 * StringSplit.solution("abcdef") // should return {"ab", "cd", "ef"}
 * 
 */