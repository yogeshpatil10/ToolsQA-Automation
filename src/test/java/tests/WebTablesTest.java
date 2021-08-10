package tests;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePageObjects;
import pageObjects.WebTablePageObjects;
import utility.WrapperReaderUtility;

public class WebTablesTest extends BaseClass {

	WebTablePageObjects webtableobjects;
	HomePageObjects homepage;

	@Test(groups = { "smoke" })
	public void getWebTablesRecords() throws InterruptedException {

		webtableobjects = new WebTablePageObjects(driver);
		homepage = new HomePageObjects(driver);

		homepage.clickElements();

		webtableobjects.clickWebTablesElement();
		Log.info("User clicked Web Tables element");

		webtableobjects.deleteSecondRecord();
		Log.info("User deleted second person details from Web Tables");

		WebElement secondrecord = WrapperReaderUtility.webTableReader(driver, "ReactTable -striped -highlight", 2, 4);
		String secondrecordEmail = secondrecord.getText();
		assertFalse(secondrecordEmail.equalsIgnoreCase("alden@example.com"));

	}
}
