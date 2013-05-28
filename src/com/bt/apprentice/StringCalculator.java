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
  private String calculationString;

  public Calculation(final String input) {
    delimiterPattern = extractDelimiterPattern(input);
    calculationString = extractCalculation(input);
  }

  public int performCalculation() throws Exception {
    if (calculationString.length() == 0) {
      return 0;
    }
    String[] operands = calculationString.split(delimiterPattern);
    int total = 0;
    for (String operand : operands) {
      int number = Integer.parseInt(operand);
      rejectNegativeNumber(number);
      total += number;
    }
    return total;
  }

  private void rejectNegativeNumber(int number) throws Exception {
    if (number < 0) {
      throw new Exception("negatives not allowed " + number);
    }
  }

  private static String extractDelimiterPattern(String input) {
    if (input.startsWith("//")) {
      return input.substring(2, 3);
    } else {
      return DEFAULT_DELIMITER_PATTERN;
    }
  }

  private static String extractCalculation(String input) {
    if (input.startsWith("//")) {
      return input.substring(4);
    } else {
      return input;
    }
  }
}