package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.BookStoreLoginPageObjects;
import utility.Constant;
import utility.ReadCSVFileUtility;

public class VerifyLoginTest extends BaseClass {
	WebDriverWait wait;

	@DataProvider(name = "logindata-fromcsv")
	public static Iterator<String[]> provideDataFromCSV() {
		return ReadCSVFileUtility.readFromCSVFile(Constant.logindatacsv).iterator();

	}

	@Test(dataProvider = "logindata-fromcsv")
	public void verifyLoginWithMultipleUsers(String username, String password, String isLoginSuccess)
			throws IOException {

		wait = new WebDriverWait(driver, 40);

		BookStoreLoginPageObjects loginpage = new BookStoreLoginPageObjects(driver);
		boolean isLoginSuccessful = Boolean.valueOf(isLoginSuccess);

		loginpage.clickBookStoreApp();
		Log.info("User clicked BookStore App on Home Page");

		loginpage.clickLeftLoginOption();
		Log.info("User clicked Login option from left panel");

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
			wait.until(ExpectedConditions.visibilityOf(bookSearchBox));
			assertTrue(bookSearchBox.isDisplayed());
			Log.info("Login successful");
			WebElement logoutbutton = driver.findElement(By.id("submit"));
			logoutbutton.click();
		} else {
			String errormsg = driver.findElement(By.id("name")).getText();
			assertEquals(errormsg, "Invalid username or password!");
			Log.info("Invalid user name and password");
		}
	}

}
