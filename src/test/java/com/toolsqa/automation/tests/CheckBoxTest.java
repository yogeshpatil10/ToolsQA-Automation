package com.toolsqa.automation.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import appModules.SignIn_Action;
import pageObjects.CheckBoxPageObjects;
import pageObjects.HomePageObjects;

public class CheckBoxTest extends SignIn_Action {

	Logger logger = LogManager.getLogger(CheckBoxTest.class);
	WebDriverWait wait;

	@Test(groups = { "smoke" })
	public void getToCheckBoxPage() {
		test = extent.createTest("CheckBox Test").assignAuthor("Yogesh").assignCategory("Smoke");

		CheckBoxPageObjects checkboxobject = PageFactory.initElements(driver, CheckBoxPageObjects.class);
		HomePageObjects homepage = PageFactory.initElements(driver, HomePageObjects.class);

		homepage.clickElements();

		checkboxobject.clickCheckBoxElement();
		logger.info("User clicked on CheckBox element");

	}
}
