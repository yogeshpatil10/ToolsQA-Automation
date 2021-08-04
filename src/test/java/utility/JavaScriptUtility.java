package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {

	public static JavascriptExecutor javaScript;
	protected static WebDriver driver;

	// To Click on WebElement using JavaScript Executor.
	public static void clickElementByJavaScript(WebElement element, WebDriver driver) {
		javaScript = (JavascriptExecutor) driver;
		javaScript.executeScript("arguments[0].click();", element);
	}

	// To Scroll Browser Window using JavaScript Executor.
	public static void scrollWindowByJavaScript(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}

	// To Scroll Browser Window using JavaScript Executor.
	public static void scrollWindowByJavaScript(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

}
