package com.toolsqa.automation.baseclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.toolsqa.automation.frameworkmethods.FrameworkUtilFunctions;

public class LoginPageAccessObjects {

	Logger logger = LogManager.getLogger(LoginPageAccessObjects.class);

	private WebDriver driver;

	public LoginPageAccessObjects(WebDriver driver) {
		super();
		this.driver = driver;

		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();

		logger.info("Redirected to the ToolsQA Website");
	}

	@FindBy(css = ".category-cards>div:nth-child(6)")
	private WebElement bookStoreApp;

	@FindBy(className = "main-header")
	private WebElement mainheader;

	public void clickBookStoreApp() {
		FrameworkUtilFunctions function = new FrameworkUtilFunctions(driver);
		function.scrollPageDownAndClickElement(bookStoreApp);
		bookStoreApp.click();

	}

}
