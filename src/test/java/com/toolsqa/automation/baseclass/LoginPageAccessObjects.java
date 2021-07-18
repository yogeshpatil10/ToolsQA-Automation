package com.toolsqa.automation.baseclass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.toolsqa.automation.frameworkmethods.FrameworkUtilFunctions;

public class LoginPageAccessObjects {

	Logger logger = LogManager.getLogger(LoginPageAccessObjects.class);

	private WebDriver driver;
	Actions actions;

	public LoginPageAccessObjects(WebDriver driver) throws IOException {
		super();
		this.driver = driver;

		driver.get(FrameworkUtilFunctions.getGlobalValue("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		logger.info("Redirected to the ToolsQA Website");
	}

	@FindBy(css = ".category-cards>div:nth-child(6)")
	private WebElement bookStoreApp;

	@FindBy(className = "main-header")
	private WebElement mainheader;

	@FindBy(xpath = "//div[@class='element-list collapse show']/ul/li[@id='item-0']")
	private WebElement loginmenu;

	@FindBy(xpath = "//input[@placeholder='UserName']")
	private WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(id = "login")
	private WebElement loginbutton;

	public void clickBookStoreApp() {
		FrameworkUtilFunctions function = new FrameworkUtilFunctions(driver);
		function.scrollPageDownAndClickElement(bookStoreApp);
		actions = new Actions(driver);
		actions.moveToElement(bookStoreApp).click().perform();

	}

	public void clickLoginMenuOption() {
		FrameworkUtilFunctions function = new FrameworkUtilFunctions(driver);
		function.scrollPageDownAndClickElement(loginmenu);
		actions = new Actions(driver);
		actions.moveToElement(loginmenu).click().perform();

	}

	public void loginToBookStore() throws InterruptedException {
		FrameworkUtilFunctions function = new FrameworkUtilFunctions(driver);
		function.enterUserName(username, FrameworkUtilFunctions.getGlobalValue("username"));
		Thread.sleep(2);
		function.enterPassword(password, FrameworkUtilFunctions.getGlobalValue("password"));
		function.clickSubmitButton(loginbutton);
	}

}
