package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.TestUtility;
import utility.LeftPanelElementsListUtility;

public class ButtonsPageObjects {

	private WebDriver driver;
	TestUtility function;

	public ButtonsPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}

	@FindBy(id = "doubleClickBtn")
	private WebElement doubleclickme;

	@FindBy(id = "rightClickBtn")
	private WebElement rightclickme;

	@FindBy(xpath = "//button[text()='Click Me']")
	private WebElement clickme;

	public void clickButtonsElement() {
		function = new TestUtility(driver);
		WebElement buttonselement = LeftPanelElementsListUtility.getElementFromList(driver, "item-4");
		function.clickElement(buttonselement);
	}

	public void doubleClickOnButton() {
		function = new TestUtility(driver);
		function.doubleClick(doubleclickme);
	}

	public void rightClickOnButton() {
		function = new TestUtility(driver);
		function.rightClick(rightclickme);
	}

	public void singleClickOnButton() {
		function = new TestUtility(driver);
		function.clickElement(clickme);
	}

}
