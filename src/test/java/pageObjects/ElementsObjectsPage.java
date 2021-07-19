package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utility.ElementActionsUtility;
import utility.ReadPropertiesFileUtility;

public class ElementsObjectsPage {

	WebDriver driver;
	ElementActionsUtility function;
	Actions actions;

	public ElementsObjectsPage(WebDriver driver) {
		super();
		this.driver = driver;
		driver.get(ReadPropertiesFileUtility.getGlobalValue("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@FindBy(css = "div.home-content>div.home-body>div.category-cards>div:nth-child(1)")
	private WebElement mainElements;

	@FindBy(css = "div.left-pannel>div>div:nth-child(1)>div>ul>li#item-0")
	private WebElement textbox;

	@FindBy(css = "input#userName")
	private WebElement fullname;

	@FindBy(css = "input#userEmail")
	private WebElement useremail;

	@FindBy(css = "textarea#currentAddress")
	private WebElement currentAddress;

	@FindBy(css = "textarea#permanentAddress")
	private WebElement permanentAddress;

	public void enterPermanentAddress() {
		actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		actions.click(permanentAddress).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
	}

	public void enterCurrentAddress() {
		ElementActionsUtility.sendkeys(currentAddress, "123, Red Hat Corner, California 956201 USA");

	}

	public void enterEmail() {
		ElementActionsUtility.sendkeys(useremail, "joy.butta@toolsqa.com");
	}

	public void enterFullName() {
		ElementActionsUtility.sendkeys(fullname, "Joy Butta");

	}

	public void clickElements() {
		function = new ElementActionsUtility(driver);
		function.clickElementWithActions(mainElements);
	}

	public void clickTextBoxElement() {
		function = new ElementActionsUtility(driver);
		function.clickElement(textbox);
	}

}
