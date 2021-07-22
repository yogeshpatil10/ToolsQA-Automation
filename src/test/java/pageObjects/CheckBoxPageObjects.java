package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ElementActionsUtility;
import utility.ElementListUtility;

public class CheckBoxPageObjects {

	private WebDriver driver;
	ElementActionsUtility function;
	WebDriverWait wait;

	public CheckBoxPageObjects(WebDriver driver) {
		this.driver = driver;

	}

	public void clickCheckBoxElement() {
		WebElement checkBoxElement = ElementListUtility.getElementFromList(driver, "item-1");
		checkBoxElement.click();
	}

}
