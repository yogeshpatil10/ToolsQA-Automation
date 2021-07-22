package tests;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.BookStoreLoginPageObjects;

public class BookStoreLoginTest extends BaseClass {

	Logger logger = LogManager.getLogger(BookStoreLoginTest.class);
	BookStoreLoginPageObjects loginPage;

	@Test(priority = 1)
	public void goToBookStoreAppLoginPage() throws InterruptedException {

		test = extent.createTest("Click on Book Store Application for login").assignAuthor("Yogesh")
				.assignCategory("Smoke").assignCategory("Regression");

		loginPage = PageFactory.initElements(driver, BookStoreLoginPageObjects.class);

		loginPage.clickBookStoreApp();
		logger.info("Element Book Store Application has been clicked and user is redirected to the Book Store Page");

		loginPage.clickLoginMenuOption();
		logger.info("User clicked Login Menu Option from list");

	}

	@Test(priority = 2)
	public void loginToBookStoreApplication() throws InterruptedException {
		test = extent.createTest("Login to Book Store Application").assignAuthor("Yogesh").assignCategory("Smoke")
				.assignCategory("Regression");

		loginPage.loginToBookStore();
		logger.info("User is successfully logged in to BookStore App");
		assertTrue(driver.findElement(By.id("userName-value")).getText().contentEquals("joybutta"));
		assertTrue(driver.findElement(By.id("submit")).getText().contentEquals("Log out"));
	}
}
