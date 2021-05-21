package main.java.codewars.kata.kyu5;

import java.util.StringTokenizer;

public class PigLatin {

    public static void main(String[] args) {
       System.out.println(pigIt("Pig latin is cool !")); // igPay atinlay siay oolcay
       System.out.println(pigIt("This is my string")); // hisTay siay ymay tringsay
    }
    
    public static String pigIt(String str) {
       
        StringTokenizer strTokens = new StringTokenizer(str, " ");
        StringBuffer strBuff = new StringBuffer("");
        
        while(strTokens.hasMoreTokens()) {
            String s = strTokens.nextToken();
            if(s.matches(".*\\p{Punct}")) {
                strBuff.append(s+" ");
                continue;
            }
            strBuff.append(s.substring(1) + s.charAt(0) + "ay ");
        }
        return strBuff.toString().trim();
    }
}

/**
 * Question: Simple Pig Latin
 * 
 * Move the first letter of each word to the end of it, then add "ay" to the end
 * of the word. Leave punctuation marks untouched.
 * 
 * Examples 
 * pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
 * pigIt('Hello world !'); // elloHay orldway !
 * 
 */