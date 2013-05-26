package com.bt.apprentice;

public class StringCalculator {

	private static final String DEFAULT_DELIMITER_PATTERN = "[,\n]";

	public static int add(final String input) throws Exception {
		if (input == "") {
			return 0;
		}

		String delimiterPattern = extractDelimiterPattern(input);
		String calculation = extractCalculation(input);
		
		String[] numbers = calculation.split(delimiterPattern);
		int sum = 0;
		for (String number : numbers) {
			if (number.contains("-")) {
				throw new Exception("negatives not allowed " + number);
			}
			sum += Integer.parseInt(number);
		}
		return sum;
	}

	private static String extractDelimiterPattern(final String input) {
		if (input.startsWith("//")) {
			return input.substring(2, 3);
		} else {
			return DEFAULT_DELIMITER_PATTERN;
		}
	}

	private static String extractCalculation(final String input) {
		if (input.startsWith("//")) {
			return input.substring(4);
		} else {
			return input;
		}
	}
}