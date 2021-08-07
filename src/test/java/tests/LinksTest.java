package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePageObjects;
import pageObjects.LinksPageObjects;
import utility.TestUtility;

public class LinksTest extends BaseClass {

	LinksPageObjects linksobject;
	HomePageObjects homepage;
	private String seondWindowTitle;
	TestUtility function;

	@Test
	public void verifyLinks() throws InterruptedException {

		linksobject = new LinksPageObjects(driver);
		homepage = new HomePageObjects(driver);
		function = new TestUtility(driver);

		homepage.clickElements();

		linksobject.clickLinksElement();
		Log.info("User Clicked Links Element From Left Panel");

		linksobject.clickHomeLink();
		Log.info("User Clicked Home Hyperlink on Page");
		Thread.sleep(2000);

		String firstWindow = driver.getWindowHandle();

		seondWindowTitle = function.getTitleOfSecondWinodw(firstWindow);
		Log.info("User switched to the Second Window and got the title");

		assertEquals(seondWindowTitle, "ToolsQA");

		driver.switchTo().window(firstWindow);
		Log.info("User switched to First WIndow");

		linksobject.clickDynamicLink();
		Log.info("User Clicked Dynamic Hyperlink on Page");

		function.swithcToSecondWinodw(firstWindow);
		Log.info("Second Winodw is launched");

		driver.switchTo().window(firstWindow);
		Log.info("User switched to First WIndow");

		try {
			linksobject.clickCreatedLink();
			Log.info("User Clicked Created Hyperlink on Page");

			String linkResponse = driver.findElement(By.id("linkResponse")).getText();

			assertEquals(linkResponse, "Link has responded with staus 201 and status text Created");

		} catch (AssertionError e) {
			e.printStackTrace();
		}

		driver.switchTo().window(firstWindow);
		Log.info("User switched to First WIndow");

	}
}
