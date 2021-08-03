package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {

	public static JavascriptExecutor javaScript;

	// To Click on WebElement using JavaScript Executor.
	public static void clickElementByJavaScript(WebElement element, WebDriver driver) {
		javaScript = (JavascriptExecutor) driver;
		javaScript.executeScript("arguments[0].click();", element);
	}

}
