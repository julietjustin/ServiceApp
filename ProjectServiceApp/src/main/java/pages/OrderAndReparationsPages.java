package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class OrderAndReparationsPages {
	WebDriver driver;
	public OrderAndReparationsPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement filterResultIcon;
	@FindBy(xpath="(//div[@class='form-group'])[1]")
	private WebElement filterFirstField;
	@FindBy(xpath="//input[@name='date']")
	private WebElement filterEnterDate;
	By timePeriodFromDropDown=By.xpath("//div[@class='ranges']//li");
	@FindBy(xpath="//span[@class='select2-selection__rendered'][1]")
	private WebElement filterMapkaField;
	By filterMapkaSelectField=By.xpath("//select[@name='manufacturer']");
	@FindBy(xpath="//span[@class='select2-selection__placeholder'][1]")
	private WebElement filterHasWarrantyField;
	By filterWarrantySelectField=By.xpath("//ul[@class='select2-results__options']//li");
	By filterStatusField=By.xpath("//select[@name='status']");
	@FindBy(xpath="//input[@type='submit']")
	private WebElement filterResultButton;
	@FindBy(xpath="(//td[@class='dataTables_empty'])[1]")
	private WebElement tableDataAfterFilter;
	@FindBy(xpath="//button[@class='add_reparation btn btn-primary']")
	private WebElement addReparationButton;
	@FindBy(xpath="//h4[@id='titReparation']")
	private WebElement addReparationPageTitle;
	@FindBy(xpath="//div[@id='reparationmodal']//child::button[@type='button'][1]")
	private WebElement AddReparationWindowCloseButton;
	@FindBy(xpath="//section[@class='content-header']")
	private WebElement addReparationCloseTitle;
	@FindBy(xpath="//a[@href='#CompletedRepairs']")
	private WebElement completedRepairsTab;
	By completedrepairTableShow=By.xpath("//select[@name='dynamic-table-completed_length']");
	By rowcount=By.xpath("//tr[@class='warranty_row even' or @class='warranty_row odd']");
	@FindBy(xpath="//a[@class='pull-right btn btn-primary']//child::i[@class='fa fa-file-pdf']")
	private WebElement pdfDownloadButton;
	@FindBy(xpath="//a[@class='pull-right btn btn-primary']//child::i[@class='fa fa-file-excel']")
	private WebElement excelDownloadButton;
	@FindBy(xpath="(//a[text()='Next > '])[2]")
	private WebElement scrollNextButton;
	By tableRow=By.xpath("//tr[@class='warranty_row odd'or@class='warranty_row even']");
	By tableHead=By.xpath("//tr[@role='row']");
	
	
	
	
	public void clickOnFilterIcon() throws IOException  {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(7, 0, constants.Constants.TESTDATAFILE, "OrderReparationsPage");
		Assert.assertTrue(filterResultIcon.isDisplayed(), "Filter Result + icon Is Not Displayed");
		PageUtility.clickOnElement(filterResultIcon);
		actualTitle=PageUtility.getElementText(filterFirstField);
		Assert.assertEquals(actualTitle, expectedTitle, "Filter Field Is Not Displayed");
	}
	public void EnterDetailsInFilter(String listItem,String warrantyListItem) throws IOException, InterruptedException  {
		String actualData,expectedData=ExcelUtility.getTestData(8, 0, constants.Constants.TESTDATAFILE, "OrderReparationsPage");
		Assert.assertTrue(filterEnterDate.isDisplayed(), "Date Field Is Not Displayed");
		PageUtility.clickOnElement(filterEnterDate);
		List<WebElement>timePeriodList=driver.findElements(timePeriodFromDropDown);
		for(WebElement timePeriod:timePeriodList) {
			if(timePeriod.getText().equalsIgnoreCase(listItem)){
				Assert.assertTrue(timePeriod.isDisplayed(), "List Is Not Displayed To Select TimePeriod");
				timePeriod.click();
				break;	
			}
		}
		Assert.assertTrue(filterMapkaField.isDisplayed(),"Mapka Field Is Not displayed");
		PageUtility.clickOnElement(filterMapkaField);
		Select inputSelect = new Select(driver.findElement(filterMapkaSelectField));
		inputSelect.selectByVisibleText(ExcelUtility.getTestData(2, 0, constants.Constants.TESTDATAFILE, "OrderReparationsPage"));
		Assert.assertTrue(filterHasWarrantyField.isDisplayed(),"Has Warranty Field Is Not Displayed");
		PageUtility.clickOnElement(filterHasWarrantyField);
		List<WebElement>hasWarrantSelect=driver.findElements(filterWarrantySelectField);
		for(WebElement selectList:hasWarrantSelect) {
			if(selectList.getText().equalsIgnoreCase(warrantyListItem)){
				Assert.assertTrue(selectList.isDisplayed(),"List Is Not Displayed To Select TimePeriod");
				selectList.click();
				break;	
			}
		}
		Select statusSelect = new Select(driver.findElement(filterStatusField));
		statusSelect.selectByVisibleText(ExcelUtility.getTestData(5, 0, constants.Constants.TESTDATAFILE, "OrderReparationsPage"));
		Assert.assertTrue(filterResultButton.isEnabled(),"Filter Result Button Is Not Enabled");
		PageUtility.click(driver, filterResultButton);
		actualData=PageUtility.getElementText(tableDataAfterFilter);
		Assert.assertEquals(actualData, expectedData, "Filtered Data Is Not Displayed");
		
		}
		public void clickOnAddReparationButton() throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(10, 0, constants.Constants.TESTDATAFILE, "OrderReparationsPage");
		Assert.assertTrue(addReparationButton.isEnabled(),"Add Reparation Button Is Not Enabled");
		PageUtility.clickOnElement(addReparationButton);
		WaitUtility.textToBePresentInElement(driver, addReparationPageTitle, expectedTitle);
		actualTitle=PageUtility.getElementText(addReparationPageTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Add Reparation Page Is Not Displayed");
		}
		public void clickOnAddReparationWindowCloseButton() throws IOException {
		String actualTitle,expectedTitle=ExcelUtility.getTestData(0, 0, constants.Constants.TESTDATAFILE, "OrderReparationsPage");
		Assert.assertTrue(AddReparationWindowCloseButton.isEnabled(),"Close Button Is Not Enabled");
		PageUtility.click(driver, AddReparationWindowCloseButton);
		actualTitle=PageUtility.getElementText(addReparationCloseTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "It Is Not Landed Back To Order&Reparation page");
		}
		public void clickOnCompletedRepairsTab() throws IOException{
		String actualData,expectedData= ExcelUtility.getTestData(6, 0, constants.Constants.TESTDATAFILE, "OrderReparationsPage");
		Assert.assertTrue(completedRepairsTab.isDisplayed(), "Completed Repairs Tab Is Not Displayed");
		PageUtility.clickOnElement(completedRepairsTab);
		Select objSelect=new Select(driver.findElement(completedrepairTableShow));
		List<WebElement>option=objSelect.getOptions();
			for(WebElement inputMenu:option) {
				String show=inputMenu.getText();
				if(show.contains(ExcelUtility.getNumeric(11, 0, constants.Constants.TESTDATAFILE, "OrderReparationsPage"))) {
					inputMenu.click();
					break;
				}	
			}
			List<WebElement>row=driver.findElements(tableRow);
			for(WebElement data:row ) {
				if(data.getText().equals(ExcelUtility.getTestData(6, 0, constants.Constants.TESTDATAFILE, "OrderReparationsPage"))) {
					actualData = data.getText();
					Assert.assertEquals(actualData, expectedData, "Displayed Data IS Not Correct");
					break;
				}
			}
		}	
		public void clickOnPdfButton() throws InterruptedException {
			Assert.assertTrue(pdfDownloadButton.isEnabled(), "PDF Download Button Is Not Enabled");
			PageUtility.clickOnElement(pdfDownloadButton);
			String sourceLocation = pdfDownloadButton.getAttribute("href");
			String wget_command = "cmd /c C:\\Wget\\wget.exe -P D:\\abc --no-check-certificate " + sourceLocation;
			try {
			       Process exec = Runtime.getRuntime().exec(wget_command);
			       int exitVal = exec.waitFor();
			       System.out.println("Exit value: " + exitVal);
			       } catch ( IOException ex) {
			       System.out.println(ex.toString());
			       }
			       driver.close();
			 }
		public void clickOnExcelButton() throws InterruptedException {
			Assert.assertTrue(excelDownloadButton.isEnabled(), "Excel Download Button Is Not Enabled");
			PageUtility.clickOnElement(excelDownloadButton);
			String sourceLocation = excelDownloadButton.getAttribute("href");
			String wget_command = "cmd /c C:\\Wget\\wget.exe -P D:\\abc --no-check-certificate " + sourceLocation;
			try {
			       Process exec = Runtime.getRuntime().exec(wget_command);
			       int exitVal = exec.waitFor();
			       System.out.println("Exit value: " + exitVal);
			     } catch ( IOException ex) {
			       System.out.println(ex.toString());
			       }
			       driver.close();
			 }
		public void clickOnNextButtonByScrollingDown() throws InterruptedException, IOException {
			String actualData,expectedData=ExcelUtility.getTestData(12, 0, constants.Constants.TESTDATAFILE, "OrderReparationsPage");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1400)","" );
			WaitUtility.fluentVisibilityOfAllElements(driver, scrollNextButton);
			Assert.assertTrue(scrollNextButton.isEnabled(), "NextButton Is Not Enabled");
			PageUtility.clickOnElement(scrollNextButton);
			List<WebElement>row=driver.findElements(tableHead);
			for(WebElement data:row ) {
				if(data.getText().equals(ExcelUtility.getTestData(12, 0, constants.Constants.TESTDATAFILE, "OrderReparationsPage"))) {
					actualData = data.getText();
					Assert.assertEquals(actualData, expectedData, "Displayed Data IS Not Correct");
					break;
				}
			}
		}
			


}
