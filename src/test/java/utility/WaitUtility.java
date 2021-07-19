package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaitUtility {
	WebDriver driver;

	public WaitUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public static WebElement waitUntilElementIsVisible(WebElement element) throws InterruptedException {
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

}
