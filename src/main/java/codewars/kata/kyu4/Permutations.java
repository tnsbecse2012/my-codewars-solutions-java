package main.java.codewars.kata.kyu4;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
       System.out.println(singlePermutations("aabb")); // output: ["aabb","abab","abba","baab","baba","bbaa"]
       System.out.println(singlePermutations("ab"));   // output: ["ab","ba"]
       System.out.println(singlePermutations("a")); // output: ["a"]

    }

    public static List<String> singlePermutations(String str) {
        ArrayList<String> strPermutations = new ArrayList<>();
        addDistinctPermutation(str, "", strPermutations);
        return strPermutations;
    }

    public static void addDistinctPermutation(String str, String ans, ArrayList<String> strpermutations) {

        // if string is empty
        if (str.length() == 0) {
            if (strpermutations.contains(ans)) {
                return;
            }
            strpermutations.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding the ith character
            String ros = str.substring(0, i) + str.substring(i + 1);

            // Recurvise call
            addDistinctPermutation(ros, ans + ch, strpermutations);
        }
    }
    
}

/**
 * Question: Permutations
 * 
 * In this kata you have to create all permutations of an input string and
 * remove duplicates, if present. This means, you have to shuffle all letters
 * from the input in all possible orders.
 * 
 * Examples:
 * 
 * Permutations.singlePermutations("a") `shouldBe` ["a"]
 * Permutations.singlePermutations("ab") `shouldBe` ["ab", "ba"]
 * Permutations.singlePermutations("aabb") `shouldBe` ["aabb","abab","abba","baab","baba","bbaa"] 
 * The order of the permutations doesn't matter.
 * 
 */