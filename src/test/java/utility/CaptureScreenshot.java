package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {

	WebDriver driver;

	public CaptureScreenshot(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void takesScreenshot(String dest) throws IOException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss a'.png'");

		LocalDateTime now = LocalDateTime.now();

		String dateTimeString = now.format(formatter);

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(dest + dateTimeString));
	}

}
