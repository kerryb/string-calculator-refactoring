package com.bt.apprentice;

public class StringCalculator {

	private static final String DEFAULT_DELIMITER_PATTERN = "[,\n]";

	public static int add(final String input) throws Exception {
		if (input == "") {
			return 0;
		}
		
		String delimiterPattern = DEFAULT_DELIMITER_PATTERN;
		String calculation = input;
		
		if (input.startsWith("//")){
			delimiterPattern = input.substring(2, 3);
			calculation = input.substring(4);
		}
		
		String[] numbers = calculation.split(delimiterPattern);
		int sum = 0;
		for (String number : numbers) {
			if(number.contains("-")){
				throw new Exception("negatives not allowed " + number);
			}
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}