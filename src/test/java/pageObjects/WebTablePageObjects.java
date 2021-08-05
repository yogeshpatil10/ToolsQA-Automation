package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ElementListUtility;
import utility.JavaScriptUtility;
import utility.WrapperReaderUtility;

public class WebTablePageObjects {

	private WebDriver driver;
	WebDriverWait wait;

	public WebTablePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(id = "addNewRecordButton")
	private WebElement addnewrecord;

	@FindBy(id = "searchBox")
	private WebElement searchbox;

	@FindBy(id = "basic-addon2")
	private WebElement search;

	public void clickWebTablesElement() {
		WebElement textboxelement = ElementListUtility.getElementFromList(driver, "item-3");
		textboxelement.click();

	}

	public void deleteSecondRecord() {

		WebElement deleteaction = WrapperReaderUtility.actionOnWebTableElement(driver, "ReactTable -striped -highlight",
				1, 7, 2);
		JavaScriptUtility.clickElementByJavaScript(deleteaction, driver);

	}

}
