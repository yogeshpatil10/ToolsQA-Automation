package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePageObjects;
import pageObjects.RadioButtonPageObjects;
import utility.LeftPanelElementsListUtility;

public class RadioButtonTest extends BaseClass {

	WebDriverWait wait;
	RadioButtonPageObjects radiobuttonobject;
	HomePageObjects homepage;

	@Test
	public void verifyRadioButtons() throws InterruptedException {

		radiobuttonobject = new RadioButtonPageObjects(driver);
		homepage = new HomePageObjects(driver);
		wait = new WebDriverWait(driver, 30);

		homepage.clickElements();

		radiobuttonobject.clickRadioButtonElement();
		Log.info("User clicked on Radio Buttons Element from Elements List");

		radiobuttonobject.clickRadioButton();
		Log.info("User clicked YES radio button");

		WebElement textsuccess = driver
				.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[1]/p/span[@class='text-success']"));
		String youHaveSelected = textsuccess.getText();

		WebElement noRadio = LeftPanelElementsListUtility.getRadioFromListOptions(driver, "noRadio");

		assertEquals(youHaveSelected, "Yes");
		assertTrue(!noRadio.isEnabled());

	}
}
