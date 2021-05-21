package main.java.codewars.kata.kyu6;

import java.util.Arrays;

public class CreatePhoneNumber {

    public static void main(String[] args) {
        
        System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
    
    public static String createPhoneNumber(int[] numbers) {
        
        
        String numbersStr = Arrays.toString(numbers).replaceAll("\\[|\\]|,|\\s", "");
        String phNumbers = "(" +numbersStr.substring(0, 3) + ") "+numbersStr.substring(3, 6)+"-"+numbersStr.substring(6);
        
                
                return phNumbers;
        
      }
}
