package com.interview.questions;

import com.google.common.base.CharMatcher;

public class ExtractNumberFromString {

	public static void main(String[] args) {

		extractNumbersAndAlphabetsUsingCharMacther();
		extractAlphabetsAndNumbersUsingJava("The4Indian1Space2 And7");
		extractAlphabetsAndNumbersUsingForLoop("The4Indian1Space2 And7");
	}

	public static void extractNumbersAndAlphabetsUsingCharMacther() {
		String str = "The4Indian1Space2 And7";

		String theDigits = CharMatcher.inRange('0', '9').retainFrom(str);
		System.out.println(theDigits);

		String lowecaseLetter = CharMatcher.inRange('a', 'z').retainFrom(str); // Basic Multilingual Plane (BMP) range.
		System.out.println(lowecaseLetter);
	}

	public static void extractAlphabetsAndNumbersUsingJava(String str) {

		String theDigits = str.replaceAll("[^0-9]", "");
		System.out.println(theDigits);

	}

	public static void extractAlphabetsAndNumbersUsingForLoop(String str) {
		char[] characters = str.toCharArray();
		String newstring = "";

		for (char ch : characters) {
			if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
				newstring += ch;
			}
		}
		System.out.println(newstring);

		String theDigits = str.replaceAll("[^0-9]", "");
		System.out.println(theDigits);
	}

}
