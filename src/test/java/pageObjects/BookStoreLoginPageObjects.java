package pageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utility.ElementActionsUtility;
import utility.ReadPropertiesFileUtility;

public class BookStoreLoginPageObjects {

	Logger logger = LogManager.getLogger(BookStoreLoginPageObjects.class);

	private WebDriver driver;
	Actions actions;

	public BookStoreLoginPageObjects(WebDriver driver) throws IOException {
		this.driver = driver;

		driver.get(ReadPropertiesFileUtility.getGlobalValue("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@FindBy(css = "div.home-content>div.home-body>div.category-cards>div:nth-child(6)")
	private WebElement bookStoreApp;

	@FindBy(xpath = "//div[@class='left-pannel']/div/div[6]/div/ul[@class='menu-list']/li[@id='item-0']")
	private WebElement loginmenu;

	@FindBy(id = "userName")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login")
	private WebElement loginbutton;

	public void loginToBookStore() throws InterruptedException {
		ElementActionsUtility function = new ElementActionsUtility(driver);
		function.enterUserName(username, ReadPropertiesFileUtility.getGlobalValue("username"));
		function.enterPassword(password, ReadPropertiesFileUtility.getGlobalValue("password"));
		function.scrollDownAndClickSubmitButton(loginbutton);
	}

	public void clickLoginMenuOption() {
		ElementActionsUtility function = new ElementActionsUtility(driver);
		function.scrollPageDownToGetElement(loginmenu);

	}

	public void clickBookStoreApp() {
		ElementActionsUtility function = new ElementActionsUtility(driver);
		function.scrollPageDownToGetElement(bookStoreApp);

	}

}
