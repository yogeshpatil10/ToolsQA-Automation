package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.JavaScriptUtility;
import utility.ReadPropertiesFileUtility;
import utility.TestUtility;

public class BookStoreLoginPageObjects {

	private WebDriver driver;
	Actions actions;
	WebDriverWait wait;
	TestUtility function;

	public BookStoreLoginPageObjects(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		driver.get(ReadPropertiesFileUtility.getGlobalValue("url"));
	}

	@FindBy(css = "div.home-content>div.home-body>div.category-cards>div:nth-child(6)")
	private WebElement bookStoreApp;

	@FindBy(id = "userName")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login")
	private WebElement loginbutton;

	public void loginToBookStore() throws InterruptedException {
		TestUtility function = new TestUtility(driver);
		function.enterUserName(username, ReadPropertiesFileUtility.getGlobalValue("username"));
		function.enterPassword(password, ReadPropertiesFileUtility.getGlobalValue("password"));
		function.scrollDownAndClickSubmitButton(loginbutton);
	}

	public void clickLeftLoginOption() {
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 45);

		int count = 0;
		int maxTries = 5;

//		WebElement bookstoreMenu = driver.findElement(
//				By.xpath("//div[@class='left-pannel']/div/div[6]/span/div/div[text()='Book Store Application']"));

		while (true) {
			try {

				WebElement loginLeftElement = getElementFromBookstoreApp("item-0");
				JavaScriptUtility.scrollWindowByJavaScript(driver);
				JavaScriptUtility.clickElementByJavaScript(loginLeftElement, driver);
				break;
			} catch (ElementClickInterceptedException e) {
				if (++count == maxTries) {
					throw e;
				}
			}
		}

	}

	public void clickBookStoreApp() {
		int count = 0;
		int maxTries = 5;
		while (true) {
			try {

				function = new TestUtility(driver);
				function.scrollDownAndClickSubmitButton(bookStoreApp);
				break;
			} catch (NoSuchElementException | ElementClickInterceptedException e) {
				if (++count == maxTries) {
					throw e;
				}
			}
		}

	}

	public WebElement getElementFromBookstoreApp(String id) {
		WebElement findelement = null;

		List<WebElement> bookStoreAppElements = driver
				.findElements(By.xpath("//div[@class='element-list collapse show']/ul/li"));

		for (WebElement element : bookStoreAppElements) {
			findelement = element
					.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[@id='" + id + "']"));
		}

		return findelement;
	}

}
