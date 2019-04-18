package com.example.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.*;

class SolutionTests {

	final String LINES = "------------------------------------------------------------";

	StringBuilder readInput(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/test/resources/" + fileName));

		StringBuilder sb = new StringBuilder();

		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			sb.append(System.lineSeparator());
			line = br.readLine();
		}

		return sb;
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/test-case.csv", numLinesToSkip = 1)
	void test(String input, String output) {
		try {
			//1. read input
			String lines = readInput(input).toString().trim();

			//2. override stdin & stdout
			InputStream defaultIn = System.in;
			ByteArrayInputStream in = new ByteArrayInputStream(lines.getBytes());
			System.setIn(in);

			PrintStream defaultOut = System.out;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			System.setOut(new PrintStream(out));

			//3. run the program, of course!
			Solution.main(null);

			//4. produce output & reset stdin-stdout
			String programOutput = out.toString();
			System.setIn(defaultIn);
			System.setOut(defaultOut);

			//5. compare output
			String answer = readInput(output).toString();

			System.out.println("Program output\n" + LINES + "\n" + programOutput + "\n" + LINES + "\n" +
							   "\nExpected output\n" + LINES + "\n" + answer + "\n" + LINES + "\n");

			assertEquals(answer, programOutput);

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
