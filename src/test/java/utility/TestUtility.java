package utility;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtility {

	private WebDriver driver;
	WebDriverWait wait;
	FluentWait<WebDriver> fluentwait;
	Actions actions;
	private static URL link = null;
	private static HttpURLConnection httpConn;
	private static int invalidImageCount;
	private static CloseableHttpClient client;
	private static HttpGet request;
	private static CloseableHttpResponse response;

	public TestUtility(WebDriver driver) {
		this.driver = driver;
	}

	// To Scroll Browser Window using JavaScriptExecutor and ExpectedConditions.
	public void scrollPageDownToGetElement(WebElement element) {

		JavaScriptUtility.scrollWindowByJavaScript(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();

	}

	// To Enter UserName.
	public void enterUserName(WebElement element, String username) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(username);
	}

	// To Enter Password.
	public void enterPassword(WebElement element, String password) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(password);
	}

	// To Scroll Browser Window using JavaScript.
	public void scrollDownAndClickSubmitButton(WebElement element) {
		JavaScriptUtility.scrollWindowByJavaScript(driver, element);

		element.click();
	}

	// To Click WebElement using ExpectedConditions.
	public void clickElement(WebElement element) {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	// To Click WebElement using JavaScript.
	public void clickElementWithActions(WebElement element) {
		wait = new WebDriverWait(driver, 40);
		JavaScriptUtility.scrollWindowByJavaScript(driver, element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

	// To Send Message using SendKeys.
	public static void sendkeys(WebElement element, String msg) {
		element.sendKeys(msg);
	}

	// To Select Radio Button.
	public void selectRadioButton(WebElement element, String value) {
		wait = new WebDriverWait(driver, 30);
		if (element.getText().equalsIgnoreCase(value)) {
			element.click();
		}

	}

	// To Double Click on Element.
	public void doubleClick(WebElement element) {
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		actions.doubleClick(element).build().perform();
	}

	// To Right Click on Element.
	public void rightClick(WebElement element) {
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		actions.contextClick(element).build().perform();
	}

	// To Handle Second Window OR Switch to Second Window and Get Title
	public String getTitleOfSecondWinodw(String firstWindow) {
		String title = "";
		Set<String> windowHandles = driver.getWindowHandles();

		for (String window : windowHandles) {
			if (!window.equals(firstWindow)) {
				driver.switchTo().window(window);
				title = driver.getTitle();
				return title;
			}
		}
		return null;
	}

	// To Switch to Second Window
	public void swithcToSecondWinodw(String firstWindow) {
		Set<String> windowHandles = driver.getWindowHandles();

		for (String window : windowHandles) {
			if (!window.equals(firstWindow)) {
				driver.switchTo().window(window);
			}
		}
	}

	// To Verify Links Status present on Web Page
	public static void verifyLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			// Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
			}

			// Fetching and Printing the response code obtained
			else {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
		}
	}

	// To Verify Image Status present on Web Page
	public static void verifyimageActive(WebElement imgElement) {
		try {
			client = HttpClientBuilder.create().build();
			request = new HttpGet(imgElement.getAttribute("src"));
			response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200) {
				invalidImageCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
