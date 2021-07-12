package com.toolsqa.automation.tests;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.toolsqa.automation.baseclass.BookStorePageObjects;
import com.toolsqa.automation.baseclass.LaunchBrowser;

public class AddBookToCollectionTest extends LaunchBrowser {

	Logger logger = LogManager.getLogger(AccessLoginPageTest.class);
	BookStorePageObjects bookpage;

	@Test(priority = 3)
	public void addBook() {

		test = extent.createTest("Add Book To Your Collection").assignAuthor("Yogesh").assignCategory("Smoke")
				.assignCategory("Regression");

		bookpage = PageFactory.initElements(driver, BookStorePageObjects.class);

		bookpage.clickGoTOStore();
		logger.info("User clicked on Go To BookStore button");

		bookpage.clickBookName();
		logger.info("User clicked Book Name=Git Pockect Guide");

		WebElement bookname = driver
				.findElement(By.cssSelector("#title-wrapper>div:nth-child(2)>label#userName-value"));
		assertTrue(bookname.getText().contentEquals("Git Pocket Guide"));

		// "#title-wrapper>div:nth-child(2)>label#userName-value"

	}
}
