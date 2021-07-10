package com.toolsqa.automation.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.toolsqa.automation.baseclass.LaunchBrowser;
import com.toolsqa.automation.baseclass.LoginPageAccessObjects;

public class AccessLoginPageTest extends LaunchBrowser {

	@Test
	public void goBookStoreAppLoginPage() throws InterruptedException {
		Logger logger = LogManager.getLogger(AccessLoginPageTest.class);
		test = extent.createTest("Click on Book Store Application for login").assignAuthor("Yogesh")
				.assignCategory("Smoke");

		LoginPageAccessObjects loginPage = PageFactory.initElements(driver, LoginPageAccessObjects.class);
		loginPage.clickBookStoreApp();
		logger.info("Element Book Store Application has been clicked and user is redirected to the Book Store Page");

	}
}
