package com.technopreneur.demo;

public class GreatestSubArray {

	private static int[] input = { 1, 4, 3, 2, 5 };
	private static int size = 4;

	public static void main(String[] args) {
		int[] result = findGreatestSumArray(input, size);
		for (int i : result) {
			System.out.print(i + "  ");
		}

	}

	private static int[] findGreatestSumArray(int[] input, int size) {
		int[] sumArrays = getSumArrays(input, size);
		int highestSumIndex = -1;
		for (int i = 0; i < sumArrays.length; i++) {
			if (highestSumIndex == -1 || sumArrays[i] > sumArrays[highestSumIndex])
				highestSumIndex = i;
		}
		int[] result = new int[size];
		for (int i = 0; i < 4; i++) {
			result[i] = input[i + highestSumIndex];
		}
		return result;
	}

	private static int[] getSumArrays(int[] input, int k) {
		int[] sumArray = new int[input.length - k + 1];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < k; j++) {
				if (i - j >= 0 && i - j < sumArray.length)
					sumArray[i - j] += input[i];
			}
		}
		return sumArray;
	}
}
