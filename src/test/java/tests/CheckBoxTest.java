package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.CheckBoxPageObjects;
import pageObjects.HomePageObjects;

public class CheckBoxTest extends BaseClass {
	WebDriverWait wait;
	CheckBoxPageObjects checkboxobject;
	HomePageObjects homepage;

	@Test(groups = { "smoke" })
	public void getToCheckBoxPage() {

		checkboxobject = new CheckBoxPageObjects(driver);

		homepage = new HomePageObjects(driver);

		homepage.clickElements();

		checkboxobject.clickCheckBoxElement();
		Log.info("User clicked on CheckBox element");

		checkboxobject.clickHomeCollapse();
		Log.info("User clicked Home expand option to see sub-node checkboxes");

		checkboxobject.clickDesktopChildNodeCollapse();
		Log.info("User clicked Desktop expand option to see it's sub-node checkboxes");

		checkboxobject.clickSubChildNodeCheckBox();
		Log.info("User selected Commands sub-node checkbox from Desktop");

		String youHaveSelected = driver
				.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[1]/div[@id='result']/span[2]"))
				.getText();

		assertEquals(youHaveSelected, "commands");

	}
}
