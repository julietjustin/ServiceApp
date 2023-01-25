package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.RandomServiceUtility;

public class LoginPage {
	public WebDriver driver;
		
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		@FindBy(xpath="//input[@name='identity']")
		private WebElement userNameField;
		@FindBy(xpath="//input[@name='password']")
		private WebElement passwordField;
		@FindBy(xpath="//input[@name='submit']")
		private WebElement loginButton;
		
		public void loginWithValidUserNameAndPassword() throws IOException{
			String actualTitle,expectedTitle=ExcelUtility.getTestData(0, 0, constants.Constants.TESTDATAFILE, "LoginPage");
			String userName=ExcelUtility.getTestData(1, 0, constants.Constants.TESTDATAFILE, "LoginPage");
			String password=ExcelUtility.getTestData(2, 0, constants.Constants.TESTDATAFILE, "LoginPage");
			PageUtility.enterText(userNameField, userName);
			PageUtility.enterText(passwordField, password);
			Assert.assertTrue(loginButton.isEnabled(), "Login Button Is Not Enabled");
			PageUtility.click(driver, loginButton);
			actualTitle=driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle, "Not Navigated to home page");		
		}
		public void loginWithInValidUserNameAndPassword() throws IOException{
			String actualTitle,expectedTitle=ExcelUtility.getTestData(3, 0, constants.Constants.TESTDATAFILE, "LoginPage");
			PageUtility.enterText(userNameField, RandomServiceUtility.fakerSendTextEmail());
			PageUtility.enterText(passwordField, RandomServiceUtility.fakerSendUserName());
			Assert.assertTrue(loginButton.isEnabled(), "Login Button Is Not Enabled");	
			PageUtility.click(driver, loginButton);
			actualTitle=driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle, "Navigated to home page");
			
				
		}

}
