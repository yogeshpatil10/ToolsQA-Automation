package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ElementActionsUtility;
import utility.ElementListUtility;

public class CheckBoxPageObjects {

	private WebDriver driver;
	ElementActionsUtility function;
	WebDriverWait wait;

	public CheckBoxPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}

	@FindBy(xpath = "//div[@id='tree-node']/div/button[@class='rct-option rct-option-expand-all']")
	private WebElement expandAll;

	@FindBy(xpath = "//div[@id='tree-node']/div/button[@class='rct-option rct-option-collapse-all']")
	private WebElement collapseAll;

	@FindBy(xpath = "//button[@class='rct-collapse rct-collapse-btn']")
	private WebElement homecollapse;

	public void clickCheckBoxElement() {
		WebElement checkBoxElement = ElementListUtility.getElementFromList(driver, "item-1");
		checkBoxElement.click();
	}

	public void clickHomeCollapse() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(homecollapse));
		homecollapse.click();
	}

	public void clickDesktopChildNodeCollapse() {
		wait = new WebDriverWait(driver, 30);
		WebElement desktopChildNode = ChildNodeCollapse(1);
		wait.until(ExpectedConditions.elementToBeClickable(desktopChildNode));
		desktopChildNode.click();

	}

	public void clickSubChildNodeCheckBox() {
		wait = new WebDriverWait(driver, 30);
		WebElement commands = subChildNodeCheckBox(2);
		wait.until(ExpectedConditions.elementToBeClickable(commands));
		commands.click();
	}

	public WebElement ChildNodeCollapse(int childnode) {
		WebElement subnodecollapse = null;
		List<WebElement> childcollapse = driver.findElements(By.xpath("//div[@id='tree-node']/ol/li/ol/li"));

		for (WebElement element : childcollapse) {
			subnodecollapse = element
					.findElement(By.xpath("//div[@id='tree-node']/ol/li/ol/li[" + childnode + "]/span/button"));
		}

		return subnodecollapse;
	}

	public WebElement subChildNodeCheckBox(int subchildnode) {
		WebElement subnodecheckbox = null;

		List<WebElement> subNodeCheckBoxes = driver.findElements(
				By.xpath("//div[@id='tree-node']/ol/li/ol/li[1]/ol/li/span/label/span[@class='rct-checkbox']"));

		for (WebElement element : subNodeCheckBoxes) {
			subnodecheckbox = element.findElement(By.xpath("//div[@id='tree-node']/ol/li/ol/li[1]/ol/li[" + subchildnode
					+ "]/span/label/span[@class='rct-checkbox']"));
		}

		return subnodecheckbox;

	}

}
