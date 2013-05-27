package com.bt.apprentice;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringCalculator {

  @Test
  public void shouldReturnZeroIfPassedAnEmptyString() throws Exception {
    assertEquals(0, StringCalculator.add(""));
  }

  @Test
  public void shouldReturnSumOfOneNumber() throws Exception {
    assertEquals(42, StringCalculator.add("42"));
    assertEquals(7, StringCalculator.add("7"));
  }

  @Test
  public void shouldReturnSumOfTwoNumbers() throws Exception {
    assertEquals(46, StringCalculator.add("3,43"));
  }

  @Test
  public void shouldReturnSumOfThreeOrMoreNumbers() throws Exception {
    assertEquals(90, StringCalculator.add("30,30,30"));
  }

  @Test
  public void shouldAllowNewLineDelimiter() throws Exception {
    assertEquals(90, StringCalculator.add("30\n30,30"));
  }

  @Test
  public void shouldAllowSpecificDelimiter() throws Exception {
    assertEquals(90, StringCalculator.add("//;\n30;30;30"));
  }

  @Test
  public void shouldAllowMinusAsDelimiter() throws Exception {
    assertEquals(90, StringCalculator.add("//-\n30-30-30"));
  }

  @Test(expected = Exception.class)
  public void whenNegativeNumberPassedGivesException() throws Exception {
    try {
      StringCalculator.add("-1987654345");
    } catch (Exception e) {
      assertEquals("negatives not allowed -1987654345", e.getMessage());
      throw e;
    }
  }
}
