/**
 * File Name: RomanNumberProcessor.java
 * 
 * Copyright (c) 2014 BISON Schweiz AG, All Rights Reserved.
 */

package roman.numerals;

/**
 * @author peter.zurkirchen
 */
public interface RomanNumberProcessor {

  public abstract void process(char c);

  public abstract int getValue();

}