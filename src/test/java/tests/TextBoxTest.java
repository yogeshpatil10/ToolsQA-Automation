package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePageObjects;
import pageObjects.TextBoxPageObjects;
import utility.WaitUtility;

public class TextBoxTest extends BaseClass {

	WebDriverWait wait;
	TextBoxPageObjects textboxobject;
	HomePageObjects homepage;

	@Test(groups = { "smoke" })
	public void verifyTextBoxes() {

		textboxobject = new TextBoxPageObjects(driver);
		homepage = new HomePageObjects(driver);

		homepage.clickElements();

		textboxobject.clickTextBoxElement();
		Log.info("User clicked on TextBox element");

		textboxobject.enterFullName();
		Log.info("User entered full name");
		textboxobject.enterEmail();
		Log.info("User entered an email address");
		textboxobject.enterCurrentAddress();
		Log.info("User entered current address");
		textboxobject.enterPermanentAddress();
		Log.info("User enetered permanent address");

		WebElement submit = driver.findElement(By.id("submit"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(submit));

		assertTrue(WaitUtility.isDisplayed(submit));
		assertEquals(submit.getText(), "Submit");
		String currentAddress = driver.findElement(By.id("currentAddress")).getText();
		String permanentAddress = driver.findElement(By.id("permanentAddress")).getText();
		assertEquals(currentAddress, permanentAddress);

		submit.click();

	}
}
