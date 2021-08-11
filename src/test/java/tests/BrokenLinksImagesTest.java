package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.BrokenLinksImagesPageObjects;
import pageObjects.HomePageObjects;

public class BrokenLinksImagesTest extends BaseClass {

	BrokenLinksImagesPageObjects brokenimagesobject;
	HomePageObjects homepage;

	@Test
	public void verifyBrokenLinksAndImages() throws InterruptedException {
		brokenimagesobject = new BrokenLinksImagesPageObjects(driver);
		homepage = new HomePageObjects(driver);

		homepage.clickElements();

		brokenimagesobject.clickBrokenLiksImagesElement();
		Log.info("User clicked Broken Links-Images Element Page present on Left Side");
		Thread.sleep(2000);

		brokenimagesobject.validateInvalidImages();
		Log.info("Invalid Images have been verified");

		brokenimagesobject.validateInvalidLinks();
		Log.info("Invalid Links have been verified");

	}
}
