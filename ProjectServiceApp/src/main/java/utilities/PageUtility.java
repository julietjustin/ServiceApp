package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static void clickOnElement(WebElement element) {
		element.click();
		}
		public static WebElement enterText(WebElement element, String value) {
		element.sendKeys(value);
		return element;
		}

		public static String getElementText(WebElement element) {
		return element.getText();
		}

		public static void clickAndHoldOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
		}
		public static void mouseHover(WebElement element,WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		}
		public static void click(WebElement element,WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click();
		}
		public static void rightClick(WebElement element,WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).contextClick().perform();
		}
		public static void doubleClick(WebElement element,WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).doubleClick();
		}
		
		
		public static void selectDropdownbyText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		}
		public static void selectDropdownbyIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		}
		
		public static WebElement enterIntValue(WebElement element, CharSequence[] value) {
		element.sendKeys(value);
		return element;
		}
		
		public static Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
		}
		
		public static void ScrollBy(WebDriver driver) {
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript("window.scrollBy(0,1000)");
		}
		public static void stopPageRefresh(WebDriver driver) {
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript("window.stop();");

		}
		public static void click(WebDriver driver,WebElement element) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript("arguments[0].click()", element);

		}
		public static void reLoad(WebDriver driver) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript("location.reload()");

		}
		public static void scrollTillLenghtOfPage(WebDriver driver) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		}
		public static void scrollBack(WebDriver driver) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript("window.scrollBy(0,-350)","" );

		}
		public static void scrollTillTheElementFound(WebDriver driver,WebElement element) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript("arguments[0].scrollIntoView();", element);

		}
		public static void alert(WebDriver driver) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript("alert('Welcome');");

		}
		public static void newLocation(WebDriver driver) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript("window.location = 'http://demo.guru99.com/'");

		}


}
