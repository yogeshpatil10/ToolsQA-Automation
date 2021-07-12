package com.toolsqa.automation.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.toolsqa.automation.frameworkmethods.FrameworkUtilFunctions;

public class BookStorePageObjects {

	private WebDriver driver;

	public BookStorePageObjects(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(css = "div.mt-2.buttonWrap.row>div>button#gotoStore")
	WebElement gotoStore;

	@FindBy(linkText = "Git Pocket Guide")
	WebElement gitPocketGuide;

	public void clickGoTOStore() {
		FrameworkUtilFunctions function = new FrameworkUtilFunctions(driver);
		function.scrollPageDownAndClickElement(gotoStore);
	}

	public void clickBookName() {
		FrameworkUtilFunctions function = new FrameworkUtilFunctions(driver);
		function.clickElement(gitPocketGuide);
	}

}
