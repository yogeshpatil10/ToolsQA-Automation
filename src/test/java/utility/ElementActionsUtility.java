package utility;

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

	// To Scroll Browser Window using JavaScriptExecutor and ExpectedConditions.
	public void scrollPageDownToGetElement(WebElement element) {

		JavaScriptUtility.scrollWindowByJavaScript(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();

	}

	// To Enter UserName.
	public void enterUserName(WebElement element, String username) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(username);
	}

	// To Enter Password.
	public void enterPassword(WebElement element, String password) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(password);
	}

	// To Scroll Browser Window using JavaScript.
	public void scrollDownAndClickSubmitButton(WebElement element) {
		JavaScriptUtility.scrollWindowByJavaScript(driver, element);

		element.click();
	}

	// To Click WebElement using ExpectedConditions.
	public void clickElement(WebElement element) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	// To Click WebElement using JavaScript.
	public void clickElementWithActions(WebElement element) {
		wait = new WebDriverWait(driver, 30);
		JavaScriptUtility.scrollWindowByJavaScript(driver, element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

	// To Send Message using SendKeys.
	public static void sendkeys(WebElement element, String msg) {
		element.sendKeys(msg);
	}

	// To Select Radio Button.
	public void selectRadioButton(WebElement element, String value) {
		wait = new WebDriverWait(driver, 30);
		if (element.getText().equalsIgnoreCase(value)) {
			element.click();
		}

	}

}
