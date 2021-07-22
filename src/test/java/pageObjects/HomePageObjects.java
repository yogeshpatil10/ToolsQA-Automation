package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.ReadPropertiesFileUtility;

public class HomePageObjects {

	static WebDriver driver;

	public HomePageObjects(WebDriver driver) {
		HomePageObjects.driver = driver;

		driver.get(ReadPropertiesFileUtility.getGlobalValue("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@FindBy(css = "div.home-content>div.home-body>div.category-cards>div:nth-child(1)")
	private WebElement mainElements;

	public void clickElements() {

		mainElements.click();
	}

}
