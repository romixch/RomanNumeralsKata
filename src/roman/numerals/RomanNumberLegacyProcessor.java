/**
 * File Name: RomanNumberLegacyProcessor.java
 * 
 * Copyright (c) 2014 BISON Schweiz AG, All Rights Reserved.
 */

package roman.numerals;

/**
 * This was the first implementation of a poor roman digit algorythm.
 * 
 * @author peter.zurkirchen
 */
@Deprecated
public final class RomanNumberLegacyProcessor implements RomanNumberProcessor {

  int value;

  @Override
  public void process(char c) {
    switch (c) {
      case 'I':
        value += 1;
        break;
      case 'V':
        value += 5;
        break;
      case 'X':
        value += 10;
        break;
      case 'L':
        value += 50;
        break;
      case 'C':
        value += 100;
        break;
      case 'D':
        value += 500;
        break;
      case 'M':
        value += 1000;
        break;
      default:
        throw new IllegalArgumentException("Input '" + c + "' is not a valid roman number.");
    }
  }

  @Override
  public int getValue() {
    return value;
  }

}
