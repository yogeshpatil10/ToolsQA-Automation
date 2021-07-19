package com.toolsqa.automation.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.toolsqa.automation.baseclass.ElementsObjectsPage;
import com.toolsqa.automation.baseclass.LaunchBrowser;
import com.toolsqa.automation.frameworkmethods.FrameworkUtilFunctions;

public class ElementsTest extends LaunchBrowser {

	Logger logger = LogManager.getLogger(ElementsTest.class);
	WebDriverWait wait;

	@Test
	public void getToElementsPage() {

		test = extent.createTest("TextBox Test").assignAuthor("Yogesh").assignCategory("Smoke");

		ElementsObjectsPage elementobjects = PageFactory.initElements(driver, ElementsObjectsPage.class);

		elementobjects.clickElements();
		logger.info("User clicked on Main Elements on Home Page");
		elementobjects.clickTextBoxElement();
		logger.info("User clicked on TextBox element");
		elementobjects.enterFullName();
		logger.info("User entered full name");
		elementobjects.enterCurrentAddress();
		logger.info("User entered current address");
		elementobjects.enterPermanentAddress();
		logger.info("User enetered permanent address");

		WebElement submit = driver.findElement(By.id("submit"));
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(submit));

		assertTrue(FrameworkUtilFunctions.isDisplayed(submit));
		assertEquals(submit.getText(), "Submit");
		String currentAddress = driver.findElement(By.id("currentAddress")).getText();
		String permanentAddress = driver.findElement(By.id("permanentAddress")).getText();
		assertEquals(currentAddress, permanentAddress);

		submit.click();

	}
}
