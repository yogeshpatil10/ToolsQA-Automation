package com.toolsqa.automation.tests;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.toolsqa.automation.baseclass.BookStorePageObjects;
import com.toolsqa.automation.baseclass.LaunchBrowser;
import com.toolsqa.webtablereader.BookStoreTableReader;
import com.toolsqa.webtablereader.WrapperReader;

public class AddAndDeleteBookFromCollectionTest extends LaunchBrowser {
	Logger logger = LogManager.getLogger(AddAndDeleteBookFromCollectionTest.class);
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
		WebElement firstBook = BookStoreTableReader.bookTableReader("ReactTable -striped -highlight", 1, 2);
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

	@Test(priority = 4)
	public void deleteBookFromProfile() {
		test = extent.createTest("Delete Book from Your Collection").assignAuthor("Yogesh").assignCategory("Smoke")
				.assignCategory("Regression");
		BookStorePageObjects bookpage1 = PageFactory.initElements(driver, BookStorePageObjects.class);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement profilemenuitem = bookpage1.getListOfMenusFromBookStoreApp("item-3");
		js.executeScript("arguments[0].scrollIntoView();", profilemenuitem);
		profilemenuitem.click();
		sleep(2);

		String firstbooktext = BookStoreTableReader.bookTableReader("ReactTable -striped -highlight", 1, 2).getText();
		if (firstbooktext.equalsIgnoreCase("Git Pocket Guide")) {
			WebElement deletebuttn = BookStoreTableReader.bookTableReader("ReactTable -striped -highlight", 1, 5);
			deletebuttn.click();
			sleep(2);
		}

		WebElement modalpopup = driver.switchTo().activeElement();
		if (modalpopup.isDisplayed()) {
			modalpopup.findElement(By.id("closeSmallModal-ok")).click();
		}
		logger.info("Book successfully deleted from your collection");
	}

}
