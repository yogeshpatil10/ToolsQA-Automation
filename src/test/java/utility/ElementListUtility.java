package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementListUtility {

	private static WebDriver driver;
	private static WebElement findelement;

	public ElementListUtility(WebDriver driver) {
		super();
		ElementListUtility.driver = driver;

	}

	public static WebElement getElementFromList(WebDriver driver, String id) {
		// #item-0
		List<WebElement> elementFromListOfElements = driver
				.findElements(By.xpath("//div[@class='element-list collapse show']/ul/li"));
		for (WebElement element : elementFromListOfElements) {
			findelement = element
					.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[@id='" + id + "']"));
		}
		return findelement;

	}

}
