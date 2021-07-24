package tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.CheckBoxPageObjects;
import pageObjects.HomePageObjects;

public class CheckBoxTest extends BaseClass {

	Logger logger = LogManager.getLogger(CheckBoxTest.class);
	WebDriverWait wait;

	@Test(groups = { "smoke" })
	public void getToCheckBoxPage() {
		test = extent.createTest("CheckBox Test").assignAuthor("Yogesh").assignCategory("Smoke");

		CheckBoxPageObjects checkboxobject = PageFactory.initElements(driver, CheckBoxPageObjects.class);

		HomePageObjects homepage = new HomePageObjects(driver);

		homepage.clickElements();

		checkboxobject.clickCheckBoxElement();
		logger.info("User clicked on CheckBox element");

		checkboxobject.clickHomeCollapse();
		logger.info("User clicked Home expand option to see sub-node checkboxes");

		checkboxobject.clickDesktopChildNodeCollapse();
		logger.info("User clicked Desktop expand option to see it's sub-node checkboxes");

		checkboxobject.clickSubChildNodeCheckBox();
		logger.info("User selected Commands sub-node checkbox from Desktop");

		String youHaveSelected = driver
				.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[1]/div[@id='result']/span[2]"))
				.getText();

		assertEquals(youHaveSelected, "commands");

	}
}
