package com.toolsqa.automation.frameworkmethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameworkUtilFunctions {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	public FrameworkUtilFunctions(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void scrollPageDownAndClickElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public WebElement waitUntilElementIsVisible(WebElement element) throws InterruptedException {
		while (!isDisplayed(element)) {
			Thread.sleep(5000);
			System.out.println("Element is not visible yet");
		}
		return element;

	}

	public static boolean isDisplayed(WebElement element) {
		try {
			if (element.isDisplayed()) {
				return element.isDisplayed();
			}
		} catch (java.util.NoSuchElementException e) {
			return false;
		}
		return false;
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

	public void clickElement(WebElement element) {
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void clickElementWithActions(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

	}

}
