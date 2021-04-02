package main.java.codewars.kata.kyu6;

public class VasyaClerk {

	public static void main(String[] args) {
		System.out.println(tickets(new int[] { 25, 25, 50 })); // => YES
		System.out.println(tickets(new int[] { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 })); // => NO
		System.out.println(tickets(new int[] { 25, 100 })); // => NO. Vasya will not have enough money to give change to100 dollars
		System.out.println(tickets(new int[] { 25, 25, 50, 50, 100 })); // => NO. Vasya will not have the right bills to
																		// give 75dollars of change (you can't make two bills
																		// of 25 from one of 50
	}

	public static String tickets(int[] peopleInLine) {
		if (peopleInLine.length > 0 && (peopleInLine[0] == 50 || peopleInLine[0] == 100)) {
			return "NO";
		}
		
		int doller25 = 0;
		int doller50 = 0;
		for (int peopleDoller : peopleInLine) {
			if (peopleDoller == 25) {
				doller25++;
			}
			if (peopleDoller == 50) {
				doller50++;
				doller25--;
			}
			if (peopleDoller == 100) {
				if (doller25 >= 3) {
					doller25 -= 3;
				} else if (doller25 == 1 && doller50 == 1) {
					doller25--;
					doller50--;
				} else {
					return "NO";
				}
			}
		}
		return "YES";
	}
}
