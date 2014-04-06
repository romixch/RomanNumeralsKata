/**
 * File Name: RomanFSMTest.java
 * 
 * Copyright (c) 2014 BISON Schweiz AG, All Rights Reserved.
 */

package roman.numerals;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.romix.junit.Parameter;
import ch.romix.junit.Parameters;
import ch.romix.junit.ParameterizedRunner;

/**
 * @author peter.zurkirchen
 */
@RunWith(ParameterizedRunner.class)
public class RomanFSMTest {

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsInvalidDigit_MustThrowIllegalArgumentException() throws Exception {
		RomanFSM fsm = new RomanFSM();
		fsm.process('R');
	}

	@Test
	@Parameters({ @Parameter({ "I", "1" }),//
			@Parameter({ "V", "5" }), //
			@Parameter({ "X", "10" }), //
			@Parameter({ "L", "50" }), //
			@Parameter({ "C", "100" }), //
			@Parameter({ "D", "500" }), //
			@Parameter({ "M", "1000" }) })
	public void testValueOf_SingleValidRomanNumbers(String input, int expected) throws Exception {
		assertDigits(input, expected);
	}

	@Test
	@Parameters({ @Parameter({ "XV", "15" }) })
	public void test_Silvans_testcases(String input, int expected) {
		assertDigits(input, expected);
	}

	@Test
	public void testValueOf_WhenInputIsTwoAllowedSameDigits() throws Exception {
		assertDigits("II", 2);
		assertDigits("XX", 20);
		assertDigits("CC", 200);
		assertDigits("MM", 2000);
	}

	@Test
	public void testValueOf_WhenInputIsThreeAllowedSameDigits() throws Exception {
		assertDigits("III", 3);
		assertDigits("XXX", 30);
		assertDigits("CCC", 300);
		assertDigits("MMM", 3000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsIIII_MustThrowException() throws Exception {
		process("IIII");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsXXXX_MustThrowException() throws Exception {
		process("XXXX");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsCCCC_MustThrowException() throws Exception {
		process("CCCC");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsMMMM_MustThrowException() throws Exception {
		process("MMMM");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFire_WhenInputIsDD_MustThrowException() throws Exception {
		process("DD");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFire_WhenInputIsLL_MustThrowException() throws Exception {
		process("LL");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFire_WhenInputIsVV_MustThrowException() throws Exception {
		process("VV");
	}

	@Test
	public void testValueOf_WhenInputIsCL_MustBe150() throws Exception {
		assertDigits("CL", 150);
	}

	@Test
	public void testValueOf_WhenInputIsXX_MustBe20() throws Exception {
		assertDigits("XX", 20);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFire_WhenInputIsLXM_MustThrowException() throws Exception {
		process("LXM");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_MustThrowException() throws Exception {
		process("LXL");
	}

	@Test
	public void testValueOf_WhenInputIsMCD_MustBe1400() throws Exception {
		assertDigits("MCD", 1400);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOfDCD_MustThrowException() throws Exception {
		process("DCD");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOfLCD_MustThrowException() throws Exception {
		process("LCD");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOfXCD_MustThrowException() throws Exception {
		process("XCD");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOfVCD_MustThrowException() throws Exception {
		process("VCD");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOfICD_MustThrowException() throws Exception {
		process("ICD");
	}

	@Test
	public void testValueOf_WhenInputIsCXL_MustBe140() throws Exception {
		assertDigits("CXL", 140);
	}

	@Test
	public void testValueOf_WhenInputIsDXL_MustBe540() throws Exception {
		assertDigits("DXL", 540);
	}

	@Test
	public void testValueOf_WhenInputIsMXL_MustBe1040() throws Exception {
		assertDigits("MXL", 1040);
	}

	@Test
	public void testValueOf_ShouldSupportSubtractionOfI_X_C() {
		assertDigits("IV", 4);
		assertDigits("IX", 9);
		assertDigits("XL", 40);
		assertDigits("XC", 90);
		assertDigits("CD", 400);
		assertDigits("CM", 900);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenSubtractingIfromL_MustThrowExcption() {
		process("IL");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenSubtractingIfromC_MustThrowExcption() {
		process("IC");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenSubtractingIfromCC_MustThrowExcption() {
		process("ICC");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenSubtractingIfromCCC_MustThrowExcption() {
		process("ICCC");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenSubtractingIfromD_MustThrowExcption() {
		process("ID");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenSubtractingIfromM_MustThrowExcption() {
		process("IM");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenSubtractingIfromMM_MustThrowExcption() {
		process("IMM");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenSubtractingIfromMMM_MustThrowExcption() {
		process("IMMM");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenSubtractingXfromD_MustThrowExcption() {
		process("XD");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenSubtractingXfromM_MustThrowExcption() {
		process("XM");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenSubtractingXfromMM_MustThrowExcption() {
		process("XMM");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenSubtractingXfromMMM_MustThrowExcption() {
		process("XMMM");
	}

	@Test
	public void testValueOf_WhenInputIsXLIX_wichMeansSubtraction_MustReturn49() {
		assertDigits("XLIX", 49);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsIIV_MustThrowException() {
		process("IIV");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsXXL_MustThrowException() {
		process("XXL");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsCCM_MustThrowException() {
		process("CCM");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOfIXL_MustThrowException() throws Exception {
		process("IXL");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOfVXL_MustThrowException() throws Exception {
		process("VXL");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsIXXM_MustThrowException() {
		process("IXXM");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsVXXX_MustThrowException() {
		process("VXXX");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsIXXX_MustThrowException() {
		process("IXXX");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsICCC_MustThrowException() {
		process("ICCC");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsVCCC_MustThrowException() {
		process("VCCC");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsXCCC_MustThrowException() {
		process("XCCC");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValueOf_WhenInputIsLCCC_MustThrowException() {
		process("LCCC");
	}

	private void assertDigits(String input, int expected) {
		int value = process(input);
		assertEquals(expected, value);
	}

	private int process(String input) {
		RomanFSM fsm = new RomanFSM();

		for (int i = input.length() - 1; i >= 0; i--) {
			fsm.process(input.charAt(i));
		}
		return fsm.getValue();
	}

}