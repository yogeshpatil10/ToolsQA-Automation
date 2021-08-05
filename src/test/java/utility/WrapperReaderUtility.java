package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WrapperReaderUtility {

	static WebDriver driver;

	public WrapperReaderUtility(WebDriver driver) {
		WrapperReaderUtility.driver = driver;

	}

	public static WebElement getWrapperReader(WebDriver driver, String classname, int item, String text) {
		WebElement findElement = null;

		List<WebElement> profilewrappers = driver
				.findElements(By.xpath("//*[@class='" + classname + "']/div[@class='profile-wrapper']"));

		for (WebElement element : profilewrappers) {
			findElement = element.findElement(
					By.xpath("div[" + item + "]/div[@class='text-right fullButton']/button[text()='" + text + "']"));

		}

		return findElement;

	}

	public static WebElement webTableReader(WebDriver driver, String classname, int trrow, int trtd) {
		WebElement tbody = driver
				.findElement(By.xpath("//*[@class='" + classname + "']/div[@class='rt-table']/div[@class='rt-tbody']"));

		WebElement findElement = tbody
				.findElement(By.xpath("div[@class='rt-tr-group'][" + trrow + "]/div/div[" + trtd + "]"));

		return findElement;
	}

	public static WebElement actionOnWebTableElement(WebDriver driver, String classname, int trrow, int trtd,
			int actionindex) {
		WebElement tbody = driver
				.findElement(By.xpath("//*[@class='" + classname + "']/div[@class='rt-table']/div[@class='rt-tbody']"));

		WebElement findElement = tbody.findElement(By
				.xpath("div[@class='rt-tr-group'][" + trrow + "]/div/div[" + trtd + "]/div/span[" + actionindex + "]"));

		return findElement;
	}

}
