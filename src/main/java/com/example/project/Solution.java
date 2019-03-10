/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import java.util.Scanner;

public class Solution {

	public static void run() {
		Scanner reader = new Scanner(System.in);
		int N = reader.nextInt();
		long result = 1L;
		while((N--) > 0) {
			result *= reader.nextLong();
		}
		System.out.println(result);
	}

}
