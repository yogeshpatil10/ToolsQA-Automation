package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ElementActionsUtility;
import utility.ElementListUtility;

public class TextBoxPageObjects {

	private WebDriver driver;
	ElementActionsUtility function;
	Actions actions;
	WebDriverWait wait;

	public TextBoxPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(id = "userName")
	private WebElement fullname;

	@FindBy(id = "userEmail")
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

	public void clickTextBoxElement() {
		WebElement textboxelement = ElementListUtility.getElementFromList(driver, "item-0");
		textboxelement.click();

	}

}
