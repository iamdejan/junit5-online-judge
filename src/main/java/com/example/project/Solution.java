package com.example.project;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int N = reader.nextInt();

		BigInteger result = BigInteger.ONE;
		while((N--) > 0) result = result.multiply(new BigInteger(reader.next()));

		System.out.println(result);
	}

}
