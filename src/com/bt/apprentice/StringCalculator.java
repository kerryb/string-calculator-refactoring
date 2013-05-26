package com.bt.apprentice;

public class StringCalculator {

	public static int add(String input) throws Exception {
		if (input == "") {
			return 0;
		}
		
		String delimiterPattern = "[,\n]";
		
		if (input.startsWith("//")){
			delimiterPattern = input.substring(2, 3);
			input = input.substring(4);
		}
		
		String[] numbers = input.split(delimiterPattern);
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