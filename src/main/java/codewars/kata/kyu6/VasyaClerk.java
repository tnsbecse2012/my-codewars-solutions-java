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

/** 
Question:

The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line. Each of them has a single 100, 50 or 25 dollar bill. An "Avengers" ticket costs 25 dollars.

Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.

Can Vasya sell a ticket to every person and give change if he initially has no money and sells the tickets strictly in the order people queue?

Return YES, if Vasya can sell a ticket to every person and give change with the bills he has at hand at that moment. Otherwise return NO.

Examples:
Line.Tickets(new int[] {25, 25, 50}) // => YES 
Line.Tickets(new int[] {25, 100}) // => NO. Vasya will not have enough money to give change to 100 dollars
Line.Tickets(new int[] {25, 25, 50, 50, 100}) // => NO. Vasya will not have the right bills to give 75 dollars of change (you can't make two bills of 25 from one of 50)

 */
