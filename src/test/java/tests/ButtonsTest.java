package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.ButtonsPageObjects;
import pageObjects.HomePageObjects;

public class ButtonsTest extends BaseClass {

	ButtonsPageObjects buttonsobject;
	HomePageObjects homepage;

	@Test
	public void actionsOnButtons() {

		buttonsobject = new ButtonsPageObjects(driver);
		homepage = new HomePageObjects(driver);

		homepage.clickElements();

		buttonsobject.clickButtonsElement();
		Log.info("User clicked Buttons Element Page present on Left Side");

		buttonsobject.doubleClickOnButton();
		Log.info("User performed Double Click on Button");

		String doubleClickMessage = driver.findElement(By.id("doubleClickMessage")).getText();
		assertEquals(doubleClickMessage, "You have done a double click");

		buttonsobject.rightClickOnButton();
		Log.info("User performed Right Click on Button");

		String rightClickMessage = driver.findElement(By.id("rightClickMessage")).getText();
		assertEquals(rightClickMessage, "You have done a right click");

		buttonsobject.singleClickOnButton();
		Log.info("User perforemd Single Click on a Button");

		String dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage")).getText();
		assertEquals(dynamicClickMessage, "You have done a dynamic click");
	}
}
