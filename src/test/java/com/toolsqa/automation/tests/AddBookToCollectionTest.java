package com.toolsqa.automation.tests;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.toolsqa.automation.baseclass.BookStorePageObjects;
import com.toolsqa.automation.baseclass.LaunchBrowser;
import com.toolsqa.webtablereader.BookStoreTableReader;
import com.toolsqa.webtablereader.WrapperReader;

public class AddBookToCollectionTest extends LaunchBrowser {
	Logger logger = LogManager.getLogger(AddBookToCollectionTest.class);
	WebDriverWait wait;
	Alert alert;

	@Test(priority = 3)
	public void addBook() throws InterruptedException {
		test = extent.createTest("Add Book To Your Collection").assignAuthor("Yogesh").assignCategory("Smoke")
				.assignCategory("Regression");
		BookStorePageObjects bookpage = PageFactory.initElements(driver, BookStorePageObjects.class);
		wait = new WebDriverWait(driver, 10);

		bookpage.clickGoTOStore();
		logger.info("User is redirected to the Book Store");

		sleep(3);

		BookStoreTableReader tablereader = new BookStoreTableReader(driver);
		tablereader.getAllBooks("ReactTable -striped -highlight");
		WebElement firstBook = tablereader.bookTableReader("ReactTable -striped -highlight", 1, 2);
		sleep(2);

		firstBook.click();
		sleep(3);
		logger.info("User redirected to the Book Details Page");

		WrapperReader wrapper = new WrapperReader(driver);
		WebElement wrapper92 = wrapper.getWrapperReader("books-wrapper", 9, "Add To Your Collection");

		wait.until(ExpectedConditions.visibilityOf(wrapper92));
		wrapper92.click();

		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		String alerttext = alert.getText();

		if (alerttext.equals("Book added to your collection.")) {
			assertTrue(alerttext.contentEquals("Book added to your collection."));
			logger.info("Book added to your collection");
		} else {
			assertTrue(alerttext.contentEquals("Book already present in the your collection!"));
			logger.info("Book already present in the your collection!");
		}

		alert.accept();
		sleep(2);

	}

}
