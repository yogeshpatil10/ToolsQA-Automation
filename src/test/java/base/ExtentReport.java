package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utility.Constant;

public class ExtentReport extends BaseClass {

	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static ExtentReports extentReportSetup() {

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + Constant.ExtentReport);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		sparkReporter.config().setDocumentTitle("ToolsQA Automation Test");
		sparkReporter.config().setReportName("Automation Run Extent Report");
		sparkReporter.config().setTheme(Theme.STANDARD);

		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Host", "Desktop");
		extent.setSystemInfo("Java Version", "15.0.1");

		return extent;
	}

}
