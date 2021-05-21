package main.java.codewars.kata.kyu7;

public class ReverseLonger {

    public static void main(String[] args) {
        System.out.println(shorterReverseLonger("first", "abcde"));

    }
    
    public static String shorterReverseLonger(String a, String b) {
       
        if(a.length() ==0 && b.length() ==0) {
            return "";
        }
        
        String result = "";
        if(a.length() >= b.length()) {
            result = b + (new StringBuilder(a).reverse().toString()) + b;
        } else {
            result = a + (new StringBuilder(b).reverse().toString()) + a;
        }
        return result;
       }

}
