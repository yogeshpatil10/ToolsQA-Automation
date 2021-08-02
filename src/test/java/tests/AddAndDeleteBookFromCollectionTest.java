package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.BookStorePageObjects;
import utility.BookStoreTableReaderUtility;
import utility.WrapperReaderUtility;

public class AddAndDeleteBookFromCollectionTest extends BaseClass {
	BookStorePageObjects bookpage;
	WebDriverWait wait;
	Alert alert;

	@Test(priority = 2, groups = { "Regression" })
	public void addBook() throws InterruptedException {

		wait = new WebDriverWait(driver, 40);

		BookStorePageObjects bookpage = new BookStorePageObjects(driver);
		bookpage.clickGoTOStore();
		Log.info("User is redirected to the Book Store");

		BookStoreTableReaderUtility tablereader = new BookStoreTableReaderUtility(driver);
		tablereader.getAllBooks("ReactTable -striped -highlight");
		WebElement firstBook = BookStoreTableReaderUtility.bookTableReader("ReactTable -striped -highlight", 1, 2);
		wait.until(ExpectedConditions.visibilityOf(firstBook));

		firstBook.click();
		Log.info("User redirected to the Book Details Page");

		WrapperReaderUtility wrapper = new WrapperReaderUtility(driver);
		WebElement wrapper92 = wrapper.getWrapperReader("books-wrapper", 9, "Add To Your Collection");

		wait.until(ExpectedConditions.visibilityOf(wrapper92));
		wrapper92.click();

		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		String alerttext = alert.getText();

		if (alerttext.equals("Book added to your collection.")) {
			assertTrue(alerttext.contentEquals("Book added to your collection."));
			Log.info("Book added to your collection");
		} else {
			assertTrue(alerttext.contentEquals("Book already present in the your collection!"));
			Log.info("Book already present in the your collection!");
		}

		alert.accept();

	}

	@Test(priority = 3, groups = { "Regression" })
	public void deleteBookFromProfile() {
		BookStorePageObjects bookpage1 = new BookStorePageObjects(driver);
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
		Log.info("Book successfully deleted from your collection");
	}

}
