package main.java.codewars.kata.kyu5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Unsolved
public class DirectionsReduction {

    public static void main(String[] args) {

        System.out.println(dirReduc(new String[] { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" }));
        System.out.println(dirReduc(new String[] { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH" }));
    }

    public static String[] dirReduc(String[] arr) {

        Map<String, String> oppositeDirMap = setupOppositeDirectionsDetails();
        List<String> redDirection = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i].equals(oppositeDirMap.get(arr[i + 1]))) {
                i++;
                continue;
            } else {
                redDirection.add(arr[i]);
            }

        }
        System.out.println(redDirection.toString());
        return redDirection.toArray(new String[0]);
    }

    private static Map<String, String> setupOppositeDirectionsDetails() {
        Map<String, String> map = new HashMap<>();
        map.put("NORTH", "SOUTH");
        map.put("EAST", "WEST");
        map.put("SOUTH", "NORTH");
        map.put("WEST", "EAST");
        return map;
    }

}
