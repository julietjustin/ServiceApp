package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class InventoryPage {
	public WebDriver driver;
	public InventoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By showDropDown= By.xpath("//select[@name='PRData_length']");
	@FindBy(xpath="//img[@src='https://qalegend.com/mobile_service/assets/uploads/thumbs/4b50d036f60a154b126318477eb9c0ed.jpg']")
	private WebElement imageClickFromTable;
	By tableDisplayCount=By.xpath("//tr[@class='product_link']");
	
	@FindBy(xpath="//img[@style='max-width: 100%;']")
	private WebElement imageSize;
	

	public void clickShow() throws IOException {
		int expectedCount=ExcelUtility.getTestNumericData(1, 0, constants.Constants.TESTDATAFILE, "Inventory");
		Select selectObj=new Select(driver.findElement(showDropDown));
		List<WebElement>option=selectObj.getOptions();
		for(WebElement Inputmenu:option) {
			String show=Inputmenu.getText();
			if(show.contains(ExcelUtility.getNumeric(1, 0, constants.Constants.TESTDATAFILE, "Inventory"))) {
				Inputmenu.click();
				break;
			}	
		}
		WaitUtility.waitForElementVisibilityOfElementLocated(driver, tableDisplayCount);
		List<WebElement>tableCount=driver.findElements(tableDisplayCount);
		int count=tableCount.size();
		Assert.assertEquals(count, expectedCount, "Count Is Not Displayed");
	}
	public void clickOnImage() {
		WaitUtility.waitForElementClickable(driver, imageClickFromTable);
		Assert.assertTrue(imageClickFromTable.isDisplayed(), "Image Is Not Displayed");
		PageUtility.clickOnElement(imageClickFromTable);
		WaitUtility.waitVisibilityOfAllElements(driver, imageSize);
		Boolean display=PageUtility.isElementDisplayed(imageSize);
		Assert.assertTrue(display, "Image Is Not Displayed");	
	}

}
