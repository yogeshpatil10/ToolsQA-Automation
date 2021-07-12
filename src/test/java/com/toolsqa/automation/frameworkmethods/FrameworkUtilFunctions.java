package com.toolsqa.automation.frameworkmethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameworkUtilFunctions {

	WebDriver driver;

	public FrameworkUtilFunctions(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void scrollPageDownAndClickElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOf(element));
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void enterUserName(WebElement element, String username) {
		element.clear();
		element.sendKeys(username);

	}

	public void enterPassword(WebElement element, String password) {
		element.clear();
		element.sendKeys(password);
	}

	public void clickSubmitButton(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
	}

}
