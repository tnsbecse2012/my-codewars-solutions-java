package main.java.codewars.kata.kyu5;

public class HumanReadableTime {

    public static void main(String[] args) {

        System.out.println(makeReadable(0)); // "00:00:00"
        System.out.println(makeReadable(5)); // "00:00:05"
        System.out.println(makeReadable(60)); // "00:01:00"
        System.out.println(makeReadable(86399)); // "23:59:59"
        System.out.println(makeReadable(359999)); // "99:59:59"
    }

    public static String makeReadable(int seconds) {

        String readableTime = "00:00:00";
        if (seconds <= 0) {
            return readableTime;
        }
        
        int hours = 0;
        int minutes = 0;

        if (seconds >= 3600) {
            hours = (int) Math.floor(seconds / 3600);
            seconds -= hours * 3600;
        }
        readableTime = hours < 10 ? '0' + String.valueOf(hours) + ":" : String.valueOf(hours) + ":";

        if (seconds >= 60) {
            minutes = (int) Math.floor(seconds / 60);
            seconds -= minutes * 60;
        }
        readableTime += minutes < 10 ? '0' + String.valueOf(minutes) + ":" : String.valueOf(minutes) + ":";
        readableTime += seconds < 10 ? '0' + String.valueOf(seconds) : String.valueOf(seconds);

        return readableTime;
    }

}

/**
 * Question: Human Readable Time
 * 
 * Write a function, which takes a non-negative integer (seconds) as input and
 * returns the time in a human-readable format (HH:MM:SS)
 * 
 * HH = hours, padded to 2 digits, range: 00 - 99 
 * MM = minutes, padded to 2
 * digits, range: 00 - 59 
 * SS = seconds, padded to 2 digits, 
 * range: 00 - 59 The maximum time never exceeds 359999 (99:59:59)
 * 
 */
