package main.java.codewars.kata.kyu5;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Dictionary {

    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public String findMostSimilar(String searchWord) {

        int maxSimilarity = 0;
        String tempWord = "";
        
        for(int i=0; i<words.length; i++) {
            AtomicInteger count = new AtomicInteger();
            
            Arrays.stream(words[i].split("")).forEach(w -> {
                if(searchWord.indexOf(w) > -1) {
                    count.set(count.get() + 1);
                }
            });
            
            if(count.get() > maxSimilarity) {
                maxSimilarity = count.get();
                tempWord = words[i];
            }
        }

        return tempWord;
    }

    public static void main(String[] args) {
        
        Dictionary dictionary = new Dictionary(new String[] { "cherry", "pineapple", "melon", "strawberry", "raspberry" });
        System.out.println(dictionary.findMostSimilar("strawbery"));
        System.out.println(dictionary.findMostSimilar("berry")); 
        
        Dictionary dictionary2 = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
        System.out.println(dictionary2.findMostSimilar("heaven"));
        System.out.println(dictionary2.findMostSimilar("javascript")); 
        

    }

}
