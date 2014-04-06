/**
 * File Name: RomanNumber.java
 * 
 * Copyright (c) 2014 BISON Schweiz AG, All Rights Reserved.
 */

package roman.numerals;

import java.util.ServiceLoader;

/**
 * TODO:peter.zurkirchen Auto-generated comment for class
 * 
 * @author peter.zurkirchen
 */
public class RomanNumber {

  private int value;

  private RomanNumber(int value) {
    this.value = value;
  }

  public static RomanNumber valueOf(String input) {
    if (input == null) {
      throw new NullPointerException();
    }

    return parse(input.toUpperCase());
  }

  private static RomanNumber parse(String input) {
    RomanNumberProcessor processor = ServiceLoader.load(RomanNumberProcessor.class).iterator().next();
    return parse(input, processor);
  }

  private static RomanNumber parse(String input, RomanNumberProcessor processor) {
    for (int i = input.length() - 1; i >= 0; i--) {
      processor.process(input.charAt(i));
    }

    return new RomanNumber(processor.getValue());
  }

  public int toInt() {
    return value;
  }

}
