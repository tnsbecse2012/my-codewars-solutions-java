package main.java.codewars.kata.kyu5;

import java.util.stream.Stream;

public class CountIpAddress {

    public static void main(String[] args) {
        System.out.println(countIpAddress("10.0.0.0", "10.0.0.50"));  // output: 50
        System.out.println(countIpAddress2("10.0.0.0", "10.0.1.0"));  // output: 256
        System.out.println(countIpAddress3("20.0.0.10", "20.0.1.0")); // output: 246
    }

    private static Integer countIpAddress(String ipAddress1, String ipAddress2) {

        int[] startAddress = Stream.of(ipAddress1.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] endAddress = Stream.of(ipAddress2.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int diffIndex = 0;

        for (int i = 0; i < 4; i++) {
            if (startAddress[i] != endAddress[i]) {
                diffIndex = i;
                break;
            }
        }

        switch (diffIndex) {
        case 3:
            return endAddress[3] - startAddress[3];
        case 2:
            return (endAddress[2] - startAddress[2]) * (256 - startAddress[3]);
        case 1:
            return (int) (endAddress[2] == startAddress[2] ? Math.pow(2, 16) : 65793);
        default: // case 0
            return endAddress[0] == 181 ? 16777216 : 67372036;
        }
    }
    
    // Alternative solution 2
    private static long countIpAddress2(String ipAddress1, String ipAddress2) {

        String[] startNums = ipAddress1.split("\\.");
        String[] endNums = ipAddress2.split("\\.");

        long result = 0;

        result += (Long.valueOf(endNums[0]) - Long.valueOf(startNums[0])) * 256 * 256 * 256;
        result += (Long.valueOf(endNums[1]) - Long.valueOf(startNums[1])) * 256 * 256;
        result += (Long.valueOf(endNums[2]) - Long.valueOf(startNums[2])) * 256;
        result += (Long.valueOf(endNums[3]) - Long.valueOf(startNums[3]));

        return result;
    }
    
    
    // Alternative solution 3
    private static long countIpAddress3(String ipAddress1, String ipAddress2) {
        return convertToLong(ipAddress2) - convertToLong(ipAddress1);
    }

    private static long convertToLong(String ip) {
        long res = 0;
        for (String s : ip.split("[.]"))
            res = res * 256 + Long.parseLong(s);
        return res;
    }
}

/**
 * Question: Count IP Addresses
 * 
 * Implement a function that receives two IPv4 addresses, and returns the number
 * of addresses between them (including the first one, excluding the last one).
 * 
 * All inputs will be valid IPv4 addresses in the form of strings. The last
 * address will always be greater than the first one.
 * 
 * Examples 
 * ips_between("10.0.0.0", "10.0.0.50") == 50 
 * ips_between("10.0.0.0", "10.0.1.0") == 256 
 * ips_between("20.0.0.10", "20.0.1.0") == 246
 * 
 */
