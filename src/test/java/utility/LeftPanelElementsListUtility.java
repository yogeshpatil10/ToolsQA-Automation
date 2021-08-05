package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeftPanelElementsListUtility {

	protected static WebDriver driver;
	private static WebElement findelement;

	public static WebElement getElementFromList(WebDriver driver, String id) {
		List<WebElement> elementFromListOfElements = driver
				.findElements(By.xpath("//div[@class='element-list collapse show']/ul/li"));
		for (WebElement element : elementFromListOfElements) {
			findelement = element
					.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[@id='" + id + "']"));
		}
		return findelement;

	}

	public static WebElement getRadioFromListOptions(WebDriver driver, String id) {
		WebElement findElement = null;
		List<WebElement> radioButtons = driver
				.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[1]/div/input"));
		for (WebElement element : radioButtons) {
			findElement = element
					.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[1]/div/input[@id='" + id + "']"));
		}
		return findElement;
	}

}
