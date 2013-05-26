package com.bt.apprentice;

public class StringCalculator {
	public static int add(final String input) throws Exception {
		Calculation calculation = new Calculation(input);
		return calculation.performCalculation();
	}
}

class Calculation {
	private static final String DEFAULT_DELIMITER_PATTERN = "[,\n]";
	private String delimiterPattern;
	private String sum;

	public Calculation(final String input) {
		if (input.startsWith("//")) {
			delimiterPattern = input.substring(2, 3);
			sum = input.substring(4);
		} else {
			delimiterPattern = DEFAULT_DELIMITER_PATTERN;
			sum = input;
		}
	}

	public int performCalculation() throws Exception {
		String[] operands = sum.split(delimiterPattern);
		int total = 0;
		for (String operand : operands) {
			total += convertToInt(operand);
		}
		return total;
	}

	private int convertToInt(String numberAsString) throws Exception {
		if (numberAsString == "") {
			return 0;
		}
		int number = Integer.parseInt(numberAsString);
		if (number < 0) {
			throw new Exception("negatives not allowed " + numberAsString);
		}
		return number;
	}
}