package base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.CaptureScreenshot;
import utility.Constant;

public abstract class BaseClass {

	protected static WebDriver driver;

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(@org.testng.annotations.Optional("chrome") String browser) {

		Logger logger = LogManager.getLogger(BaseClass.class);

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
//			options.setHeadless(true);
			driver = new ChromeDriver();
			logger.info("Chrome Browser has been initiated");

		} else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);

			logger.info("Firefox Browser has been initiated");

		} else {
			System.out.println("Invalid browser, enjoy!");
		}

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@BeforeSuite
	public void setup() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + Constant.myExtentReport);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Host", "Desktop");
		extent.setSystemInfo("Java Version", "15.0.1");

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("ToolsQA Automation Test");
		htmlReporter.config().setReportName("Automation Run Extent Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

	@AfterMethod
	public void getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test case FAILED.", ExtentColor.RED));
			test.fail(result.getThrowable());
			try {
				CaptureScreenshot screen = new CaptureScreenshot(driver);
				screen.takesScreenshot(Constant.screenshots);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test case PASSED.", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + "Test case SKIPPED.", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}

	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
