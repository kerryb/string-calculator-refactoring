package com.bt.apprentice;

public class StringCalculator {

	public static int add(String numbers) throws Exception {
		if (numbers == "") {
			return 0;
		}
		
		String delimiter = "[,\n]";
		
		if (numbers.startsWith("//")){
			delimiter = numbers.substring(2, 3);
			numbers = numbers.substring(4);
		}
		
		String[] splitNumbers = numbers.split(delimiter);
		int sum = 0;
		for (String number : splitNumbers) {
			if(number.contains("-")){
				throw new Exception("negatives not allowed " + number);
			}
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}