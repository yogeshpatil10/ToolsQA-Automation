package com.toolsqa.automation.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.toolsqa.automation.frameworkmethods.FrameworkUtilFunctions;

public class BookStorePageObjects {

	private WebDriver driver;
	FrameworkUtilFunctions function;

	public BookStorePageObjects(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(css = ".profile-wrapper>div.mt-2.buttonWrap.row>div.text-left button")
	private WebElement gotoStore;

	@FindBy(css = "div.profile-wrapper>div:nth-child(9)>div:nth-child(2)>button#addNewRecordButton")
	private WebElement addToYourCollectionButton;

	@FindBy(css = "div.element-group>div>ul>li:nth-child(3)#item-3")
	private WebElement profile;

	public void clickGoTOStore() {
		function = new FrameworkUtilFunctions(driver);
		function.clickElementWithActions(gotoStore);
	}

//	public void clickAddToYourCollectionBtn() throws InterruptedException {
//		function.scrollPageDownAndClickElement(addToYourCollectionButton);
//		addToYourCollectionButton.click();
//	}
//
//	public void clickProfile() {
//		function.clickElement(profile);
//
//	}

}
