package com.interview.questions;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeRunner {

	public static void main(String[] args) {

		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);

		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String format = now.format(ofPattern);
		System.out.println(format);

		Timestamp timestamp = Timestamp.valueOf(now);
		System.out.println(timestamp);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm:ss a'.png'");

		String dateTimeString = now.format(formatter);
		System.out.println("this one: " + dateTimeString);
	}

}
