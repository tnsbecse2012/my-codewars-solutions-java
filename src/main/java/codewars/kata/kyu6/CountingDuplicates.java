package main.java.codewars.kata.kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingDuplicates {

    public static void main(String[] args) {
        System.out.println(duplicateCount("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZReturnsTwentySix"));
    }
    
    public static int duplicateCount(String text) {
       
        List<String> textList = Arrays.asList(text.toLowerCase().split(""));
        List<String> dupList = new ArrayList<>();
        
        for(int i=0; i<textList.size(); i++) {
            if(textList.indexOf(textList.get(i)) != textList.lastIndexOf(textList.get(i))) {
                if(!dupList.contains(textList.get(i))) {
                    dupList.add(textList.get(i));
                }
            }
        }
        return dupList.size();
      }
}
