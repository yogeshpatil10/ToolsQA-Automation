package tests;

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

import base.BaseClass;
import pageObjects.BookStorePageObjects;
import utility.BookStoreTableReaderUtility;
import utility.WrapperReaderUtility;

public class AddAndDeleteBookFromCollectionTest extends BaseClass {
	Logger logger = LogManager.getLogger(AddAndDeleteBookFromCollectionTest.class);
	WebDriverWait wait;
	Alert alert;

	@Test(priority = 2)
	public void addBook() throws InterruptedException {

		wait = new WebDriverWait(driver, 40);
		test = extent.createTest("Add Book To Your Collection").assignAuthor("Yogesh").assignCategory("Smoke")
				.assignCategory("Regression");

		BookStorePageObjects bookpage = PageFactory.initElements(driver, BookStorePageObjects.class);
		bookpage.clickGoTOStore();
		logger.info("User is redirected to the Book Store");

		BookStoreTableReaderUtility tablereader = new BookStoreTableReaderUtility(driver);
		tablereader.getAllBooks("ReactTable -striped -highlight");
		WebElement firstBook = BookStoreTableReaderUtility.bookTableReader("ReactTable -striped -highlight", 1, 2);
		wait.until(ExpectedConditions.visibilityOf(firstBook));

		firstBook.click();
		logger.info("User redirected to the Book Details Page");

		WrapperReaderUtility wrapper = new WrapperReaderUtility(driver);
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

	}

	@Test(priority = 3)
	public void deleteBookFromProfile() {
		test = extent.createTest("Delete Book from Your Collection").assignAuthor("Yogesh").assignCategory("Smoke")
				.assignCategory("Regression");
		BookStorePageObjects bookpage1 = PageFactory.initElements(driver, BookStorePageObjects.class);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement profilemenuitem = bookpage1.getListOfMenusFromBookStoreApp("item-3");
		js.executeScript("arguments[0].scrollIntoView();", profilemenuitem);
		profilemenuitem.click();

		String firstbooktext = BookStoreTableReaderUtility.bookTableReader("ReactTable -striped -highlight", 1, 2)
				.getText();
		if (firstbooktext.equalsIgnoreCase("Git Pocket Guide")) {
			WebElement deletebuttn = BookStoreTableReaderUtility.bookTableReader("ReactTable -striped -highlight", 1,
					5);
			deletebuttn.click();
		}

		WebElement modalpopup = driver.switchTo().activeElement();
		if (modalpopup.isDisplayed()) {
			modalpopup.findElement(By.id("closeSmallModal-ok")).click();
		}
		logger.info("Book successfully deleted from your collection");
	}

}
