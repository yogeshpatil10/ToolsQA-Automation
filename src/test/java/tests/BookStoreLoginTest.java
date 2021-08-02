package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.BookStoreLoginPageObjects;

public class BookStoreLoginTest extends BaseClass {

	BookStoreLoginPageObjects loginPage;

	@Test(priority = 1, groups = { "Regression" })
	public void goToBookStoreAppLoginPage() throws InterruptedException, IOException {

		loginPage = new BookStoreLoginPageObjects(driver);

		loginPage.clickBookStoreApp();
		Log.info("Element Book Store Application has been clicked and user is redirected to the Book Store Page");

		loginPage.clickLeftLoginOption();
		Log.info("User clicked Login Menu Option from list");

		loginPage.loginToBookStore();
		Log.info("User is successfully logged in to BookStore App");
		assertTrue(driver.findElement(By.id("userName-value")).getText().contentEquals("joybutta"));
		assertTrue(driver.findElement(By.id("submit")).getText().contentEquals("Log out"));

	}

}
