package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActionsUtility {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	public ElementActionsUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollPageDownToGetElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();

//		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public void enterUserName(WebElement element, String username) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(username);
	}

	public void enterPassword(WebElement element, String password) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(password);
	}

	public void scrollDownAndClickSubmitButton(WebElement element) {
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
		wait = new WebDriverWait(driver, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

	public static void sendkeys(WebElement element, String msg) {
		element.sendKeys(msg);
	}

}
