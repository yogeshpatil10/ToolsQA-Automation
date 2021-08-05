package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ElementActionsUtility;
import utility.JavaScriptUtility;
import utility.LeftPanelElementsListUtility;

public class RadioButtonPageObjects {

	private WebDriver driver;
	WebDriverWait wait;
	ElementActionsUtility function;

	public RadioButtonPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void clickRadioButton() {
		WebElement yesRadioOption = LeftPanelElementsListUtility.getRadioFromListOptions(driver, "yesRadio");
		JavaScriptUtility.clickElementByJavaScript(yesRadioOption, driver);

	}

	public void clickRadioButtonElement() {
		WebElement textboxelement = LeftPanelElementsListUtility.getElementFromList(driver, "item-2");
		textboxelement.click();

	}

}
