package main.java.codewars.kata.kyu6;

import java.util.stream.Collectors;

public class DuplicateEncoder {

	public static void main(String[] args) {
		System.out.println(encode("NPcdP")); // => "((("
		System.out.println(encode("recede")); // => "()()()"
		System.out.println(encode("Success")); // => ")())())"
		System.out.println(encode("(( @")); // => "))(("
		System.out.println(encode("Prespecialized"));// => ")()())()(()()("
		System.out.println(encode("   ()(   ")); // => "))))())))"
	}

	static String encode(String word) {
		word = word.toLowerCase();
		char[] chs = word.toCharArray();
		StringBuffer strBuff = new StringBuffer();
		for (char ch : chs) {
			if (word.indexOf(ch) == word.lastIndexOf(ch)) {
				strBuff.append("(");
			} else {
				strBuff.append(")");
			}
		}
		return strBuff.toString();
	}

	// Alternative solution with stream
	static String encode2(String word) {
		return word.chars()
				.mapToObj(i -> String.valueOf((char) i))
				.map(i -> word.indexOf(i) == word.lastIndexOf(i) ? "(" : ")")
				.collect(Collectors.joining());
	}
}

/**
 * Question:
 * 
 * The goal of this exercise is to convert a string to a new string where each
 * character in the new string is "(" if that character appears only once in the
 * original string, or ")" if that character appears more than once in the
 * original string. Ignore capitalization when determining if a character is a
 * duplicate.
 * 
 * Examples "din" => "(((" "recede" => "()()()" "Success" => ")())())" "(( @" =>
 * "))((" Notes
 * 
 * Assertion messages may be unclear about what they display in some languages.
 * If you read "...It Should encode XXX", the "XXX" is the expected result, not
 * the input!
 * 
 */
