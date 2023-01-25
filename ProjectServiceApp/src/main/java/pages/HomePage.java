package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reparation']")
	private WebElement reparationMoreInfo;
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers']")
	private WebElement clientMoreInfo;
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/inventory']")
	private WebElement inventoryProductsMoreInfo;
	@FindBy(xpath="//li[@class='dropdown user user-menu']")
	private WebElement userIcon;
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/auth/logout']")
	private WebElement signOutButton;
	@FindBy(xpath="//li[@class='dropdown item-more']//child::a[@class='dropdown-toggle']")
	private WebElement plusIcon;
	By plusIconList=By.xpath("//ul[@class='more-list']//a");
	@FindBy(xpath="//div[@class='modal-header']//child::h5[text()='Send SMS']")
	private WebElement sendSMSPage;
	@FindBy(xpath="(//h5[@id='exampleModalLabel'])[2]")
	private WebElement sendEmailPage;
	@FindBy(xpath="//h4[@id='titReparation']")
	private WebElement addReparationPage;
	By plusIconCount=By.xpath("//ul[@class='more-list']");
	
	
	
	
	public void clickOnreparationMoreInfo() throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(0, 0, constants.Constants.TESTDATAFILE, "HomePage");
		Assert.assertTrue(reparationMoreInfo.isDisplayed(), "reparation MoreInfo link is not displayed");
		PageUtility.clickOnElement(reparationMoreInfo);
		actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "It is Not Navigated To Order & Reparations page");		
	}
	public void clickOnClientMoreInfo() throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(1, 0, constants.Constants.TESTDATAFILE, "HomePage");
		Assert.assertTrue(clientMoreInfo.isDisplayed(), "Client MoreInfo link is not displayed");
		PageUtility.clickOnElement(clientMoreInfo);
		actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "It is Not Navigated To Customers Page");	
	}
	public void clickOnInventoryProductsMoreInfo() throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(2, 0, constants.Constants.TESTDATAFILE, "HomePage");
		Assert.assertTrue(inventoryProductsMoreInfo.isDisplayed(), "Inventory Products MoreInfo link is not displayed");
		PageUtility.clickOnElement(inventoryProductsMoreInfo);
		actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "It is Not Navigated To Inventory Page");	
	}
	public void clickOnUserIconSignOut() throws IOException{
		String actualTitle,expectedTitle=ExcelUtility.getTestData(3, 0, constants.Constants.TESTDATAFILE, "LoginPage");
		Assert.assertTrue(userIcon.isDisplayed(), "User Icon Is Not Displayed");
		PageUtility.clickOnElement(userIcon);
		Assert.assertTrue(signOutButton.isEnabled(), "Sign Out Button IS Not Enabled");
		PageUtility.clickOnElement(signOutButton);
		actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "User Is Not Navigated Back To Login Page");	
	}
	public void clickOnPlusIcon() throws IOException {
		int expectedCount=ExcelUtility.getTestNumericData(6, 0, constants.Constants.TESTDATAFILE, "HomePage");
		Assert.assertTrue(plusIcon.isDisplayed(), "The Plus Icon Is No Displayed In The HomePage");
		PageUtility.clickOnElement(plusIcon);
		List<WebElement>plusIconList=driver.findElements(plusIconCount);
		int countDrop=plusIconList.size();
		Assert.assertEquals(countDrop, expectedCount, "Count Is Not Displayed");
	}
	public void clickOnSendSMS(String listItem) throws IOException {
		String expectedTitle=ExcelUtility.getTestData(3, 0, constants.Constants.TESTDATAFILE, "HomePage");
		List<WebElement>plusIconHome=driver.findElements(plusIconList);
		for(WebElement plusListIcon:plusIconHome) {
			if(plusListIcon.getText().equalsIgnoreCase(listItem)){
				Assert.assertTrue(plusListIcon.isDisplayed(), "List To Select Send SMS Is Not Displayed");
				plusListIcon.click();
				break;	
			}
		}
		WaitUtility.textToBePresentInElement(driver, sendSMSPage, expectedTitle);
		String actualTitle=PageUtility.getElementText(sendSMSPage);
		Assert.assertEquals(actualTitle, expectedTitle, "Not Navigated To Send SMS Page");
	}
	public void clickOnSendEmail(String listItem) throws IOException {
		String expectedTitle=ExcelUtility.getTestData(4, 0, constants.Constants.TESTDATAFILE, "HomePage");
		List<WebElement>plusIconHome=driver.findElements(plusIconList);
		for(WebElement plusListIcon:plusIconHome) {
			if(plusListIcon.getText().equalsIgnoreCase(listItem)){
				Assert.assertTrue(plusListIcon.isDisplayed(), "List To Select Send Email Is Not Displayed");
				plusListIcon.click();
				break;
			}
		}
		WaitUtility.fluentTextToBePresentInElement(driver, sendEmailPage, expectedTitle);
		String actualTitle=PageUtility.getElementText(sendEmailPage);
		Assert.assertEquals(actualTitle, expectedTitle, "Not Navigated To Send Email Page");
	}
	public void clickOnAddReparation(String listItem) throws IOException {
		String expectedTitle=ExcelUtility.getTestData(5, 0, constants.Constants.TESTDATAFILE, "HomePage");
		List<WebElement>plusIconHome=driver.findElements(plusIconList);
		for(WebElement plusListIcon:plusIconHome) {
			if(plusListIcon.getText().equalsIgnoreCase(listItem)){
				Assert.assertTrue(plusListIcon.isDisplayed(), "List To Select Add Reparation Is Not Displayed");
				plusListIcon.click();
				break;
			}
		}
		WaitUtility.textToBePresentInElement(driver, addReparationPage, expectedTitle);
		String actualTitle=PageUtility.getElementText(addReparationPage);
		Assert.assertEquals(actualTitle, expectedTitle, "Not Navigated To Add Reparation Page");
	}

}
