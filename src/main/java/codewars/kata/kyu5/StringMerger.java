package main.java.codewars.kata.kyu5;

public class StringMerger {

    public static void main(String[] args) {
        System.out.println(isMerge("codewars", "code", "wars")); // true
        System.out.println(isMerge("codewars", "cdw", "oears")); // true
        System.out.println(isMerge("codewars", "cdwr", "oeas")); // true
        System.out.println(isMerge("codewars", "cod", "wars")); // false
    }

    public static boolean isMerge(String s, String part1, String part2) {
        if (s.length() != part1.length() + part2.length()) {
            return false;
        }

        if (s.length() == 0) {
            return false;
        }

        if (part1.length() == 0 && part2.length() == s.length()) {
            if (s.equalsIgnoreCase(part2)) {
                return true;
            }
            return false;
        }

        if (part2.length() == 0 && part1.length() == s.length()) {
            if (s.equalsIgnoreCase(part1)) {
                return true;
            }
            return false;
        }

        if (part1.charAt(0) == s.charAt(0) && isMerge(s.substring(1), part1.substring(1), part2)) {
            return true;
        }

        if (part2.charAt(0) == s.charAt(0) && isMerge(s.substring(1), part1, part2.substring(1))) {
            return true;
        }
        return false;
    }

    // Alternative Solution:2
    public static boolean isMerge2(String s, String part1, String part2) {
        if (s.length() != part1.length() + part2.length())
            return false;
        if (s.length() == 0)
            return true;
        return (part1.length() > 0 && part1.charAt(0) == s.charAt(0) && isMerge(s.substring(1), part1.substring(1), part2))
                || (part2.length() > 0 && part2.charAt(0) == s.charAt(0) && isMerge(s.substring(1), part1, part2.substring(1)));
    }
}

/**
 * Question: Merged String Checker
 * 
 * At a job interview, you are challenged to write an algorithm to check if a
 * given string, s, can be formed from two other strings, part1 and part2.
 * 
 * The restriction is that the characters in part1 and part2 should be in the
 * same order as in s.
 * 
 * The interviewer gives you the following example and tells you to figure out
 * the rest from the given test cases.
 * 
 * For example:
 * 
 * 'codewars' is a merge from 'cdw' and 'oears':
 * 
 * s: c o d e w a r s = codewars 
 * part1: c d w = cdw 
 * part2: o e a r s = oears
 * 
 */