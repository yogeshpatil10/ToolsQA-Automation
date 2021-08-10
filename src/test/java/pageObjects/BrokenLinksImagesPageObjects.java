package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utility.LeftPanelElementsListUtility;
import utility.TestUtility;

public class BrokenLinksImagesPageObjects {

	private WebDriver driver;
	TestUtility function;
	private int invalidImageCount;
	private String url;

	public BrokenLinksImagesPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void clickBrokenLiksImagesElement() {
		function = new TestUtility(driver);
		WebElement buttonselement = LeftPanelElementsListUtility.getElementFromList(driver, "item-6");
		function.clickElement(buttonselement);
	}

	public void validateInvalidImages() {
		try {
			invalidImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			System.out.println("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					TestUtility.verifyimageActive(imgElement);
				}
			}
			System.out.println("Total no. of invalid images are " + invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void validateInvalidLinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());
		for (WebElement element : links) {
			url = element.getAttribute("href");
			// calling verifyLink() method here. Passing the parameter as url which we
			// collected in the above link
			// See the detailed functionality of the verifyLink(url) method below
			TestUtility.verifyLinks(url);
		}
	}

}
