package com.toolsqa.automation.baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.toolsqa.automation.frameworkmethods.FrameworkUtilFunctions;

public class ElementsObjectsPage {

	WebDriver driver;
	FrameworkUtilFunctions function;

	public ElementsObjectsPage(WebDriver driver) {
		super();
		this.driver = driver;
		driver.get(FrameworkUtilFunctions.getGlobalValue("url"));
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
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		actions.click(permanentAddress).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
	}

	public void enterCurrentAddress() {
		FrameworkUtilFunctions.sendkeys(currentAddress, "123, Red Hat Corner, California 956201 USA");

	}

	public void enterEmail() {
		FrameworkUtilFunctions.sendkeys(useremail, "joy.butta@toolsqa.com");
	}

	public void enterFullName() {
		FrameworkUtilFunctions.sendkeys(fullname, "Joy Butta");

	}

	public void clickElements() {
		function = new FrameworkUtilFunctions(driver);
		function.clickElementWithActions(mainElements);
	}

	public void clickTextBoxElement() {
		function = new FrameworkUtilFunctions(driver);
		function.clickElement(textbox);
	}

}
