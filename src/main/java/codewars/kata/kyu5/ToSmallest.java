package main.java.codewars.kata.kyu5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Not working with all test cases
public class ToSmallest {

    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(smallest(261235l))); // output: [126235, 2, 0]
        System.out.println(Arrays.toString(smallest(209917l))); // output: [29917, 0, 1]
        System.out.println(Arrays.toString(smallest(285365l))); // output: [238565, 3, 1]
        System.out.println(Arrays.toString(smallest(269045l))); // output: [26945, 3, 0]
        System.out.println(Arrays.toString(smallest(296837l))); // output: [239687, 4, 1]
        System.out.println(Arrays.toString(smallest(523805853176351040l))); // not working
    }
    
    
    public static long[] smallest(long num) {

        num = (long) num;
        List<Long> list = Stream.of(String.valueOf(num).split("")).map(Long::parseLong).collect(Collectors.toList());
        // Assume input is not null
        long lowestNumber = list.get(0);
        int lowestNumberIndex = 0;
        int previousLowestNumIndex = 0;

        for (int i = 0; i < list.size(); i++) {

            lowestNumber = list.get(i);

            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(j) < list.get(i) && list.get(j) < lowestNumber) {
                    lowestNumber = list.get(j);
                    lowestNumberIndex = j;
                    previousLowestNumIndex = i;
                }
            }
            if (list.get(i) != lowestNumber) {
                break;
            }
        }
        
        list.remove(lowestNumberIndex);
        list.add(previousLowestNumIndex, lowestNumber);
        long result = Long.parseLong(list.stream().map(String::valueOf).collect(Collectors.joining("")));
        
        if(lowestNumberIndex == 1 && previousLowestNumIndex == 0) {
            return new long[] { result, previousLowestNumIndex,  lowestNumberIndex};
        }
        
        return new long[] { result, lowestNumberIndex, previousLowestNumIndex };
    }
}
