package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.BookStoreLoginPageObjects;
import utility.Constant;
import utility.ReadCSVFileUtility;

public class VerifyLoginTest extends BaseClass {

	Logger logger = LogManager.getLogger(VerifyLoginTest.class);

	@DataProvider(name = "logindata-fromcsv")
	public static Iterator<String[]> provideDataFromCSV() {
		return ReadCSVFileUtility.readFromCSVFile(Constant.logindatacsv).iterator();

	}

	@Test(dataProvider = "logindata-fromcsv")
	public void verifyLoginWithNoOfUsers(String username, String password, String isLoginSuccess) {

		test = extent.createTest("Verify Login Functionality With Different Users").assignAuthor("Yogesh")
				.assignCategory("Regression");

		BookStoreLoginPageObjects loginpage = PageFactory.initElements(driver, BookStoreLoginPageObjects.class);
		boolean isLoginSuccessful = Boolean.valueOf(isLoginSuccess);

		loginpage.clickBookStoreApp();
		logger.info("User clicked BookStore App on Home Page");

		loginpage.clickLeftLoginOption();
		logger.info("User clicked Login option from left panel");

		WebElement userid = driver.findElement(By.id("userName"));

		userid.clear();
		userid.sendKeys(username);
		WebElement pass = driver.findElement(By.id("password"));
		pass.clear();
		pass.sendKeys(password);
		WebElement loginbutton = driver.findElement(By.id("login"));
		loginbutton.click();

		if (isLoginSuccessful) {
			WebElement bookSearchBox = driver.findElement(By.id("searchBox"));

			assertTrue(bookSearchBox.isDisplayed());
			logger.info("Login successful");
			WebElement logoutbutton = driver.findElement(By.id("submit"));
			logoutbutton.click();
		} else {
			String errormsg = driver.findElement(By.id("name")).getText();
			assertEquals(errormsg, "Invalid username or password!");
			logger.info("Invalid user name and password");
		}
	}

}
