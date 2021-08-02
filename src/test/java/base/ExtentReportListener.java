package base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import utility.CaptureScreenshot;
import utility.Constant;

public class ExtentReportListener extends ExtentReportSetup implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Yogesh");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case Passed is PASSED: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case FAILED: " + result.getMethod().getMethodName());
		test.fail(result.getThrowable());

		try {
			CaptureScreenshot screen = new CaptureScreenshot(driver);
			screen.takesScreenshot(Constant.screenshots);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test case SKIPPED: " + result.getMethod().getMethodName());
		test.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		extent = ExtentReportSetup.extentReportSetup();
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
