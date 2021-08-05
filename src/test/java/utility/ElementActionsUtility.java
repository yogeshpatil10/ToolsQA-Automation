package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActionsUtility {

	private WebDriver driver;
	WebDriverWait wait;
	FluentWait<WebDriver> fluentwait;
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

	// To Double Click on Element.
	public void doubleClick(WebElement element) {
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		actions.doubleClick(element).build().perform();
	}

	// To Right Click on Element.
	public void rightClick(WebElement element) {
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		actions.contextClick(element).build().perform();
	}

}
