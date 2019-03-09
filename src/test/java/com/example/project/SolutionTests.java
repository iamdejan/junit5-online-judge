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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.*;

class SolutionTests {

	final String LINES = "----------------------";

	@ParameterizedTest
	@CsvFileSource(resources = "/test-case.csv", numLinesToSkip = 1)
	void add(String input, String output) {
		try {
			//1. read input
			BufferedReader inputBR = new BufferedReader(new FileReader("src/test/resources/" + input));
			String line = inputBR.readLine();

			//2. override stdin & stdout
			InputStream defaultIn = System.in;
			ByteArrayInputStream in = new ByteArrayInputStream(line.getBytes());
			System.setIn(in);

			PrintStream defaultOut = System.out;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			System.setOut(new PrintStream(out));

			//3. run the program, of course!
			Solution.run();

			//4. produce output
			String programOutput = out.toString();
			System.setIn(defaultIn);
			System.setOut(defaultOut);

			//5. compare output
			BufferedReader outputBR = new BufferedReader(new FileReader("src/test/resources/" + output));
			String answer = outputBR.readLine();

			System.out.println("Program output" + System.lineSeparator() + LINES + System.lineSeparator() + programOutput + System.lineSeparator() + LINES + System.lineSeparator() +
							   "\nExpected output" + System.lineSeparator() + LINES + System.lineSeparator() + answer + System.lineSeparator() + LINES + System.lineSeparator());

			assertTrue(programOutput.equals(answer));

		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
