package com.example.project;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int N = reader.nextInt();
		long result = 1L;
		while((N--) > 0) {
			result *= reader.nextLong();
		}
		System.out.println(result);
	}

}
