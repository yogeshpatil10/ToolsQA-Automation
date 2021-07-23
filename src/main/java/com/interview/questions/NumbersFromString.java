package com.interview.questions;

import com.google.common.base.CharMatcher;

public class NumbersFromString {

	public static void numbersFromString(String str) {

		String digits = CharMatcher.inRange('0', '9').retainFrom(str);
		System.out.println("digits: " + digits);

		String theDigits = str.replaceAll("[^0-9]", "");
		System.out.println("The Digits are: " + theDigits);

		char[] charArray = str.toCharArray();
		String newstring = "";
		for (char ch : charArray) {
			if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
				newstring += ch;
			}
		}
		System.out.println("The string is: " + newstring);

	}

	public static void main(String[] args) {

		numbersFromString("123abc5A4B6C7");

	}

}
