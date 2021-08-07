package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.TestUtility;
import utility.LeftPanelElementsListUtility;

public class LinksPageObjects {

	private WebDriver driver;
	TestUtility function;

	public LinksPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(linkText = "Home")
	private WebElement homeLink;

	@FindBy(id = "dynamicLink")
	private WebElement dynamicLink;

	@FindBy(linkText = "Created")
	private WebElement createdLink;

	@FindBy(linkText = "No Content")
	private WebElement noContentLink;

	@FindBy(linkText = "Moved")
	private WebElement movedLink;

	public void clickLinksElement() {
		WebElement linksElement = LeftPanelElementsListUtility.getElementFromList(driver, "item-5");
		linksElement.click();

	}

	public void clickHomeLink() {
		function = new TestUtility(driver);
		function.clickElement(homeLink);
	}

	public void clickDynamicLink() {
		function = new TestUtility(driver);
		function.clickElement(dynamicLink);
	}

	public void clickCreatedLink() {
		function = new TestUtility(driver);
		function.clickElement(createdLink);
	}

	public void clickNoContentLink() {
		function = new TestUtility(driver);
		function.clickElement(noContentLink);
	}

	public void clickMovedLink() {
		function = new TestUtility(driver);
		function.clickElement(movedLink);
	}

}
