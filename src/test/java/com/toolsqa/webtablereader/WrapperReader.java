package com.toolsqa.webtablereader;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WrapperReader {

	WebDriver driver;

	public WrapperReader(WebDriver driver) {
		super();
		this.driver = driver;

	}

//	"//*[@class='books-wrapper']/div[@class='profile-wrapper']/div[9]/div[@class='text-right fullButton']/button[text()='Add To Your Collection']"

	public WebElement getWrapperReader(String classname, int item, String text) {
		WebElement findElement = null;

		List<WebElement> profilewrappers = driver
				.findElements(By.xpath("//*[@class='" + classname + "']/div[@class='profile-wrapper']"));

		for (WebElement element : profilewrappers) {
			findElement = element.findElement(
					By.xpath("div[" + item + "]/div[@class='text-right fullButton']/button[text()='" + text + "']"));

		}

		return findElement;

	}
}
