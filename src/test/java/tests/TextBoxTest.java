package tests;

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

import base.BaseClass;
import pageObjects.HomePageObjects;
import pageObjects.TextBoxPageObjects;
import utility.WaitUtility;

public class TextBoxTest extends BaseClass {

	Logger logger = LogManager.getLogger(TextBoxTest.class);
	WebDriverWait wait;

	@Test(groups = { "smoke" })
	public void getTextBoxPage() {

		test = extent.createTest("TextBox Test").assignAuthor("Yogesh").assignCategory("Smoke");

		TextBoxPageObjects textboxobject = PageFactory.initElements(driver, TextBoxPageObjects.class);

		HomePageObjects homepage = new HomePageObjects(driver);
		homepage.clickElements();

		textboxobject.clickTextBoxElement();
		logger.info("User clicked on TextBox element");

		textboxobject.enterFullName();
		logger.info("User entered full name");
		textboxobject.enterEmail();
		logger.info("User entered an email address");
		textboxobject.enterCurrentAddress();
		logger.info("User entered current address");
		textboxobject.enterPermanentAddress();
		logger.info("User enetered permanent address");

		WebElement submit = driver.findElement(By.id("submit"));
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(submit));

		assertTrue(WaitUtility.isDisplayed(submit));
		assertEquals(submit.getText(), "Submit");
		String currentAddress = driver.findElement(By.id("currentAddress")).getText();
		String permanentAddress = driver.findElement(By.id("permanentAddress")).getText();
		assertEquals(currentAddress, permanentAddress);

		submit.click();

	}
}
