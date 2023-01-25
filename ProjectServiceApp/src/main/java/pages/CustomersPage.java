package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AlertAndPopUpWindowHandlingUtility;
import utilities.DataProviderUtility;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;


public class CustomersPage {
	WebDriver driver;
	public CustomersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//button[@class='add_c btn btn-primary']")
	private WebElement addClientButton;
	@FindBy(xpath="//h4[@id='titclienti']")
	private WebElement addClientPageTitle;
	@FindBy(xpath="//input[@id='name1']")
	private WebElement clientName;
	@FindBy(xpath="//input[@id='company1']")
	private WebElement companyName;
	@FindBy(xpath="//input[@id='autocomplete']")
	private WebElement geoLocateField;
	@FindBy(xpath="//input[@id='route']")
	private WebElement addressField;
	@FindBy(xpath="//input[@id='locality']")
	private WebElement cityField;
	@FindBy(xpath="//input[@id='postal_code']")
	private WebElement postalCodeField;
	@FindBy(xpath="//input[@id='telephone']")
	private WebElement telephoneField;
	@FindBy(xpath="//input[@id='email1']")
	private WebElement emailField;
	@FindBy(xpath="//input[@id='vat1']")
	private WebElement vatField;
	@FindBy(xpath="//input[@id='cf1']")
	private WebElement ssnField;
	@FindBy(xpath="//input[@id='image']")
	private WebElement fileUploadField;
	@FindBy(xpath="//textarea[@id='comment1']")
	private WebElement commentField;
	@FindBy(xpath="//button[@form='client_form']")
	private WebElement addClientButtonSubmit;
	@FindBy(xpath="//div[@id='titoloclienti']")
	private WebElement addClientSubmitTitle;
	@FindBy(xpath="(//button[@class='pull-left btn btn-default'])[2]")
	private WebElement goBackButtonAdClientWindow;
	@FindBy(xpath="//section[@class='content-header']")
	private WebElement goBackNavigatedPageTitle;
	By dropdownSelectCustomerPage=By.xpath("//ul[@class='dropdown-menu pull-right tasks-menus']//li");
	@FindBy(xpath="//a[@data-toggle='dropdown'and@class='dropdown-toggle btn-round btn btn-default']")
	private WebElement actionButtonCustomerPage;
	@FindBy(xpath="(//button[@class='btn btn-default btn-xs btn-primary dropdown-toggle'])[1]")
	private WebElement actionButtonInTable;
	By actionDropdown=By.xpath("(//ul[@class='dropdown-menu pull-right'])[2]//li");
	@FindBy(xpath="//button[@id='submit']")
	private WebElement saveChangesButtonInEdit;
	@FindBy(xpath="//button[@data-bb-handler='cancel']")
	private WebElement deleteOptionCancelButton;
	@FindBy(xpath="//button[@data-bb-handler='confirm']")
	private WebElement deleteOptionConfirmButton;
	@FindBy(xpath="//input[@type='search'and@aria-controls='dynamic-table']")
	private WebElement searchFieldCustomerPage;
	@FindBy(xpath="(//i[@class='fas fa-file-excel'])[2]")
	private WebElement dropDownItem;
	@FindBy(xpath="(//a[@data-toggle='modal'])[5]")
	private WebElement tableDropDownItem;
	@FindBy(xpath="(//span[@class='bold'])[12]")
	private WebElement viewClientTitle;
	@FindBy(xpath="//h4[@id='titclienti']")
	private WebElement editClientTitle;
	@FindBy(xpath="(//div[@class='col-md-12 col-lg-6 bio-row']//child::span[@class='bold'])[1]")
	private WebElement editClientSubmitTitle;
	@FindBy(xpath="//div[@class='bootbox-body']")
	private WebElement deleteClientTitle;
	By rowTable=By.xpath("//table[@role='grid']//child::tr[@class='odd'or@class='even']");
	By dropdownCount=By.xpath("//ul[@class='dropdown-menu pull-right tasks-menus']//li");
	By tableActionDropCount=By.xpath("(//ul[@class='dropdown-menu pull-right'])[3]//li");
	
	
	
	public void clickOnAddClientButton() throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(1, 0, constants.Constants.TESTDATAFILE, "CustomerPage");
		Assert.assertTrue(addClientButton.isEnabled(), "Add Client Button Is Not Enabled");
		PageUtility.clickOnElement(addClientButton);
		WaitUtility.textToBePresentInElement(driver, addClientPageTitle, expectedTitle);
		actualTitle=PageUtility.getElementText(addClientPageTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Add Client Page Is Not Displayed");
				
	}
	public void enterDetailsOnAddClientWindow(String userName,String company,String geoLocate,String address,String city,String postalCode,String telephone,String email,String vat,String ssn,String comment) throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(2, 0, constants.Constants.TESTDATAFILE, "CustomerPage");
		DataProviderUtility.sendKeyValue(driver, clientName, userName);
		DataProviderUtility.sendKeyValue(driver, companyName, company);
		DataProviderUtility.sendKeyValue(driver, geoLocateField, geoLocate);
		DataProviderUtility.sendKeyValue(driver, addressField, address);
		DataProviderUtility.sendKeyValue(driver, cityField, city);
		DataProviderUtility.sendKeyValue(driver, postalCodeField, postalCode);
		DataProviderUtility.sendKeyValue(driver, telephoneField, telephone);
		DataProviderUtility.sendKeyValue(driver, emailField, email);
		DataProviderUtility.sendKeyValue(driver, vatField, vat);
		DataProviderUtility.sendKeyValue(driver, ssnField, ssn);
		PageUtility.enterText(fileUploadField, constants.Constants.UPLOADFILE);
		DataProviderUtility.sendKeyValue(driver, commentField, comment);
		Assert.assertTrue(addClientButtonSubmit.isEnabled(), "Add Client Button Is Not Enabled");
		PageUtility.clickOnElement(addClientButtonSubmit);
		WaitUtility.textToBePresentInElement(driver, addClientSubmitTitle, expectedTitle);
		actualTitle=PageUtility.getElementText(addClientSubmitTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Not Displayed The Submission Page");
		
	}
	public void clickOnGoBackButtonAddClientWindow() throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(3, 0, constants.Constants.TESTDATAFILE, "CustomerPage");
		Assert.assertTrue(goBackButtonAdClientWindow.isEnabled(), "GoBack Button In Add Client Popup Window Is Not Enabled");
		PageUtility.clickOnElement(goBackButtonAdClientWindow);
		actualTitle=PageUtility.getElementText(goBackNavigatedPageTitle);
		Assert.assertEquals(actualTitle, expectedTitle, expectedTitle);
				
	}
	public void clickOnActionButtonCustomerPage() throws IOException {
		int expectedCount=ExcelUtility.getTestNumericData(8, 0, constants.Constants.TESTDATAFILE, "CustomerPage");
		Assert.assertTrue(actionButtonCustomerPage.isEnabled(), "Action button Is Not Enabled in the Customer Page");
		WaitUtility.fluentWaitForElementToBeClickable(driver, actionButtonCustomerPage);
		PageUtility.clickOnElement(actionButtonCustomerPage);
		List<WebElement>dropdown=driver.findElements(dropdownCount);
			int countDrop=dropdown.size();
			Assert.assertEquals(countDrop, expectedCount, "Count Is Not Displayed");
	}
	public void clickOnActionButtonInTable() throws IOException {
		int expectedCount=ExcelUtility.getTestNumericData(8, 0, constants.Constants.TESTDATAFILE, "CustomerPage");
		WaitUtility.waitForElementClickable(driver, actionButtonInTable);
		Assert.assertTrue(actionButtonInTable.isEnabled(), "Action Button Is Not Enabled For The Table");
		PageUtility.clickOnElement(actionButtonInTable);
		List<WebElement>dropdown=driver.findElements(tableActionDropCount);
		int countDrop=dropdown.size();
		Assert.assertEquals(countDrop, expectedCount, "Count Is Not Displayed");
		
	}
	public void clickOnViewClientOptionFromDropdown(String listItem) throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(5, 0, constants.Constants.TESTDATAFILE, "CustomerPage");
		List<WebElement>selectDropDown=driver.findElements(actionDropdown);
		WaitUtility.waitVisibilityOfAllElementsLocatedBy(driver, actionDropdown);
		for(WebElement dropDown:selectDropDown) {
			if(dropDown.getText().equalsIgnoreCase(listItem)){
				Assert.assertTrue(dropDown.isDisplayed(), "List To Select View Client Option Is Not Displayed");
				dropDown.click();
				break;	
			}
		}	
		actualTitle=PageUtility.getElementText(viewClientTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Not Displayed View Client Page");
	}
	public void clickOnEditClientOptionFromDropdown(String listItem) throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(6, 0, constants.Constants.TESTDATAFILE, "CustomerPage");
		List<WebElement>selectDropDown=driver.findElements(actionDropdown);
		WaitUtility.waitVisibilityOfAllElementsLocatedBy(driver, actionDropdown);
		for(WebElement dropDown:selectDropDown) {
			if(dropDown.getText().equalsIgnoreCase(listItem)){
				Assert.assertTrue(dropDown.isDisplayed(), "List To Select Edit Client Option Is Not Displayed");
				dropDown.click();
				break;	
			}	
		}
		WaitUtility.textToBePresentInElement(driver, editClientTitle, expectedTitle);
		actualTitle=PageUtility.getElementText(editClientTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Edit Client Page Is NOt Displayed");
	}
	public void editClientData(String geoLocate,String address,String listItem) throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(5, 0, constants.Constants.TESTDATAFILE, "CustomerPage");
		List<WebElement>selectDropDown=driver.findElements(actionDropdown);
		WaitUtility.waitVisibilityOfAllElementsLocatedBy(driver, actionDropdown);
		for(WebElement dropDown:selectDropDown) {
			if(dropDown.getText().equalsIgnoreCase(listItem)){
				Assert.assertTrue(dropDown.isDisplayed(), "List To Select Edit Client Option Is Not Displayed");
				dropDown.click();
				break;	
			}	
		}
		DataProviderUtility.sendKeyValue(driver, geoLocateField, geoLocate);
		DataProviderUtility.sendKeyValue(driver, addressField, address);
		WaitUtility.waitForElementClickable(driver, saveChangesButtonInEdit);
		Assert.assertTrue(saveChangesButtonInEdit.isEnabled(), "Save Changes Button Is Not Enabled In Client Edit Page");
		PageUtility.clickOnElement(saveChangesButtonInEdit);
		WaitUtility.textToBePresentInElement(driver, editClientSubmitTitle, expectedTitle);
		actualTitle=PageUtility.getElementText(editClientSubmitTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Not Displaying The Edit Submit Page");
	}
	public void clickOnDeleteClientOptionFromDropdown(String listItem) throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(3, 0, constants.Constants.TESTDATAFILE, "CustomerPage");
		List<WebElement>selectDropDown=driver.findElements(actionDropdown);
		WaitUtility.waitVisibilityOfAllElementsLocatedBy(driver, actionDropdown);
		for(WebElement dropDown:selectDropDown) {
			if(dropDown.getText().equalsIgnoreCase(listItem)){
				Assert.assertTrue(dropDown.isDisplayed(), "List To Select Delete Client Option Is Not Displayed");
				dropDown.click();
				break;	
			}	
		}
		WaitUtility.waitForElementVisibilityOf(driver, deleteOptionCancelButton);
		Assert.assertTrue(deleteOptionCancelButton.isEnabled(), "Cancel Button Is Not Enabled In Delete Confirmation Page");
		PageUtility.clickOnElement(deleteOptionCancelButton);
		actualTitle=PageUtility.getElementText(goBackNavigatedPageTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Not Landed In Customer Page");
	}
	public void clickOnConfirmButtonInDelete(String listItem) throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(3, 0, constants.Constants.TESTDATAFILE, "CustomerPage");
		List<WebElement>selectDropDown=driver.findElements(actionDropdown);
		WaitUtility.waitVisibilityOfAllElementsLocatedBy(driver, actionDropdown);
		for(WebElement dropDown:selectDropDown) {
			if(dropDown.getText().equalsIgnoreCase(listItem)){
				Assert.assertTrue(dropDown.isDisplayed(), "List To Select Delete Client Option Is Not Displayed");
				dropDown.click();
				break;	
			}	
		}
		WaitUtility.waitForElementVisibilityOf(driver, deleteOptionConfirmButton);
		Assert.assertTrue(deleteOptionConfirmButton.isEnabled(), "Confirm Button Is Not Enabled In Delete Confirmation Page");
		PageUtility.clickOnElement(deleteOptionConfirmButton);
		actualTitle=PageUtility.getElementText(goBackNavigatedPageTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Confirm Delete Alert Message IS Not Displayed and Not Landed In Customer Page");
	}
	public void enterDataInSearchField() throws IOException {
		Assert.assertTrue(searchFieldCustomerPage.isDisplayed(), "Search Field Is Not Displayed In The Customer Page");
		PageUtility.enterText(searchFieldCustomerPage, ExcelUtility.getTestData(0, 0, constants.Constants.TESTDATAFILE, "CustomerPage"));
		String actualData,expectedData= ExcelUtility.getTestData(7, 0, constants.Constants.TESTDATAFILE, "CustomerPage");
		WaitUtility.presenceOfAllElementsLocatedBy(driver, rowTable);
		List<WebElement>row=driver.findElements(rowTable);
		for(WebElement data:row ) {
			if(data.getText().equals(ExcelUtility.getTestData(7, 0, constants.Constants.TESTDATAFILE, "CustomerPage"))) {
				actualData = data.getText();
				Assert.assertEquals(actualData, expectedData, "Displayed Data IS Not Correct");
				break;
			}
			
		}
	}

}
