/**
 * File Name: RomanFSM.java
 * 
 * Copyright (c) 2014 BISON Schweiz AG, All Rights Reserved.
 */

package roman.numerals;

/**
 * @author peter.zurkirchen
 */
public class RomanFSM implements RomanNumberProcessor {
  private RomanState state = RomanState.Init;
  private int value = 0;

  @Override
  public void process(char c) {
    state = state.transitFromRightToLeft(c);
    value += state.getValue();
  }

  @Override
  public int getValue() {
    return value;
  }
}
