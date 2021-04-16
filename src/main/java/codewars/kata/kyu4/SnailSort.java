package main.java.codewars.kata.kyu4;

import java.util.Arrays;

public class SnailSort {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(snail(new int[][] {{}}))); // output: []
		System.out.println(Arrays.toString(snail(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }))); // output: [1,2,3,6,9,8,7,4,5]
		System.out.println(Arrays.toString(snail(new int[][] { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } }))); // output: [1,2,3,4,5,6,7,8,9]
		System.out.println(Arrays.toString(snail(new int[][] { 	{ 1, 2, 3, 1 }, 
																{ 4, 5, 6, 4 }, 
																{ 7, 8, 9, 7 }, 
																{ 7, 8, 9, 7 } }))); // output: [1,2,3,1,4,7,7,9,8,7,7,4,5,6,9,8]
		System.out.println(Arrays.toString(snail(new int[][] { { 1, 	2, 	3, 	4, 	5 }, 
																{ 16, 	17, 18, 19, 6 }, 
																{ 15, 	24, 25, 20, 7 }, 
																{ 14, 	23, 22, 21, 8 },
																{ 13, 	12, 11, 10, 9 }} )));
	}

	private static int[] snail(int[][] arr) {

		if (arr[0].length <= 0) {
			return new int[0];
		}

		int arrLength = arr.length;
		int xAxis = 0, yAxis = 0;

		int right = arrLength, down = arrLength;
		int left = 0, up = 0;

		int[] resultArray = new int[arrLength * arrLength];

		for (int index = 0; index < (arrLength * arrLength); index++) {

			// right Travel
			for (int rightY = yAxis; rightY < right; rightY++) {
				yAxis = rightY;
				resultArray[index] = arr[xAxis][yAxis];
				index++;
			}
			right -= 1;

			// down Travel
			for (int downX = xAxis + 1; downX < down; downX++) {
				xAxis = downX;
				resultArray[index] = arr[xAxis][yAxis];
				index++;
			}
			down -= 1;

			// left Travel
			for (int leftY = yAxis - 1; leftY >= left; leftY--) {
				yAxis = leftY;
				resultArray[index] = arr[xAxis][yAxis];
				index++;
			}
			left += 1;

			// up Travel
			for (int upX = xAxis - 1; upX > up; upX--) {
				xAxis = upX;
				resultArray[index] = arr[xAxis][yAxis];
				index++;
			}
			index--;
			up += 1;

			yAxis = yAxis + 1;
		}
		return resultArray;
	}
	
	// Alternative Solution
	public static int[] snail2(int[][] array) {

		if (array[0].length == 0)
			return new int[] {};
		int[] result = new int[array.length * array.length];
		int space = array.length - 1;
		int index = 0;

		for (int x = 0, y = 0; space / 2 >= 0; space -= 2, x++, y++) {

			for (int i = 0; i < space; i++)
				result[index++] = array[x][y++];
			for (int i = 0; i < space; i++)
				result[index++] = array[x++][y];
			for (int i = 0; i < space; i++)
				result[index++] = array[x][y--];
			for (int i = 0; i < space; i++)
				result[index++] = array[x--][y];
		}

		space = array.length;
		if (space % 2 != 0)
			result[index] = array[space / 2][space / 2];
		return result;
	}
}


/**
 * Question: Snail Sort
 * 
 * Given an n x n array, return the array elements arranged from outermost
 * elements to the middle element, traveling clockwise.
 * 
 * array = [[1,2,3], [4,5,6], [7,8,9]] snail(array) #=> [1,2,3,6,9,8,7,4,5] For
 * better understanding, please follow the numbers of the next array
 * consecutively:
 * 
 * array = [[1,2,3], [8,9,4], [7,6,5]] snail(array) #=> [1,2,3,4,5,6,7,8,9]
 * 
 * NOTE: The idea is not sort the elements from the lowest value to the highest;
 * the idea is to traverse the 2-d array in a clockwise snailshell pattern.
 * 
 * NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an
 * array [[]].
 * 
 */