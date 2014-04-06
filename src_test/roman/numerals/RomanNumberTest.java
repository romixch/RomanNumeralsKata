/**
 * File Name: RomanNumberTest.java
 * 
 * Copyright (c) 2014 BISON Schweiz AG, All Rights Reserved.
 */

package roman.numerals;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * TODO:peter.zurkirchen Auto-generated comment for class
 * 
 * @author peter.zurkirchen
 */
public class RomanNumberTest {

  @Test(expected = NullPointerException.class)
  public void testValueOf_WhenInputIsNull_ThrowNullPointerException() {
    String input = null;
    RomanNumber.valueOf(input);
  }

  @Test
  public void testValueOf_WhenInputIsSingleRomanDigit() throws Exception {
    assertEquals(1, RomanNumber.valueOf("I").toInt());
    assertEquals(5, RomanNumber.valueOf("V").toInt());
    assertEquals(10, RomanNumber.valueOf("X").toInt());
    assertEquals(50, RomanNumber.valueOf("L").toInt());
    assertEquals(100, RomanNumber.valueOf("C").toInt());
    assertEquals(500, RomanNumber.valueOf("D").toInt());
    assertEquals(1000, RomanNumber.valueOf("M").toInt());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValueOf_WhenInputIsInvalidDigit_MustThrowIllegalArgumentException() throws Exception {
    String inputNotValid = "Roman";
    RomanNumber.valueOf(inputNotValid);
  }

  @Test
  public void testValueOf_WhenInputIsTwoAllowedSameDigits() throws Exception {
    assertEquals(2, RomanNumber.valueOf("II").toInt());
    assertEquals(20, RomanNumber.valueOf("XX").toInt());
    assertEquals(200, RomanNumber.valueOf("CC").toInt());
    assertEquals(2000, RomanNumber.valueOf("MM").toInt());
  }

  @Test
  public void testValueOf_WhenValueIsMDLVII_MustReturn1557() throws Exception {
    assertEquals(1557, RomanNumber.valueOf("MDLVII").toInt());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValueOf_WhenDigit_D_SequenciallyRepeated_MustThrowIllegalArgumentException() throws Exception {
    String inputNotValid = "DD";
    RomanNumber.valueOf(inputNotValid);
  }

  @Test
  public void testValueOf_WhenInputIsLowercase_WillBeHandledAsUppercase() {
    String lowercaseInput = "i";
    assertEquals(1, RomanNumber.valueOf(lowercaseInput).toInt());
  }

}
