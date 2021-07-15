package com.toolsqa.webtablereader;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookStoreTableReader {
	private static WebDriver driver;

	public BookStoreTableReader(WebDriver driver) {
		this.driver = driver;

	}

	public static WebElement bookTableReader(String classname, int trrow, int trtd) {
		WebElement tbody = driver
				.findElement(By.xpath("//*[@class='" + classname + "']/div[@class='rt-table']/div[@class='rt-tbody']"));

		WebElement findElement = tbody
				.findElement(By.xpath("div[@class='rt-tr-group'][" + trrow + "]/div/div[" + trtd + "]/div/span"));

		return findElement;
	}

	public void getAllBooks(String classname) {
		WebElement tbody = driver
				.findElement(By.xpath("//*[@class='" + classname + "']/div[@class='rt-table']/div[@class='rt-tbody']"));

		List<WebElement> rows = tbody.findElements(By.xpath("div[@class='rt-tr-group']"));

		System.out.println("Books available in store are: ");
		for (WebElement row : rows) {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(row));
			System.out.println(row.getText());
		}
	}

}
