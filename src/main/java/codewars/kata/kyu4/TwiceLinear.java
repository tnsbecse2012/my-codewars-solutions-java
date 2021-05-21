package main.java.codewars.kata.kyu4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TwiceLinear {

    public static void main(String[] args) {

        System.out.println(dblLinear(20));

    }
    
    public static int dblLinear (int n) {

        Set<Integer> linearSet = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        
        int i = 0;
        while(list.size() < n-1) {
            
            int y = 2 * list.get(i) + 1;
            int z = 3 * list.get(i) + 1;
            
            if(!list.contains(y)) {
                list.add(y);
            }
            if(!list.contains(z)) {
                list.add(z);
            }
           
            
            Collections.sort(list);
            i++;
        }

        System.out.println(list.toString());
        
        return 0;
        
    }

}
