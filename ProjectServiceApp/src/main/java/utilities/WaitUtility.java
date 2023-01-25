package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long IMPLICIT_WAIT = 20;
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT = 50;
	public static final long FLUENT_WAIT = 30;
	public static final long POLLING_TIME = 5;
	
	
	
	public enum LocatorType {
		Id, Xpath, CssSelector, Linktext, PartiallinkText, Tagname, Name, ClassName;
	}

	public static void waitForElementVisibilityOf(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
			wait.until(ExpectedConditions.visibilityOf(target));
	}
	public static void waitForElementVisibilityOfElementLocated(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static void waitVisibilityOfAllElementsLocatedBy(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public static void waitVisibilityOfAllElements(WebDriver driver,WebElement elements) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	public static void waitForElementClickable(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public static void waitForElementClickable(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public static void waitForElementSelected(WebDriver driver,WebElement target) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeSelected(target));
	}
	public static void waitForElementSelected(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	public static void titleIs(WebDriver driver,String title) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.titleIs(title));	
	}
	public static void titleContains(WebDriver driver,String title) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.titleContains(title));
	}
	public static void urlToBe(WebDriver driver,String url) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.urlToBe(url));
	}
	public static void urlContains(WebDriver driver,String url) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.urlContains(url));
	}
	public static void urlMatches(WebDriver driver,String url) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.urlMatches(url));
	}
	public static void alertPresent(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void numberOfElementsToBe(WebDriver driver,By locator, int number) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.numberOfElementsToBe(locator, number));
	}
	public static void numberOfElementsToBeLessThan(WebDriver driver,By locator, int number) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator, number));
	}
	public static void numberOfElementsToBeMoreThan(WebDriver driver,By locator, int number) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
	}
	public static void numberOfWindowsToBe(WebDriver driver,int number) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.numberOfWindowsToBe(number));
	}
	public static void numberOfWindowsToBe(WebDriver driver,By locator,Pattern text) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textMatches(locator, text));
	}
	public static void textToBe(WebDriver driver,By locator,String value) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBe(locator, value));
	}
	public static void textToBePresentInElement(WebDriver driver,WebElement element,String text) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	public static void textToBePresentInElementLocated(WebDriver driver,By locator,String text) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}
	public static void textToBePresentInElementValue(WebDriver driver,By locator,String text) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
	}
	public static void textToBePresentInElementValue(WebDriver driver,WebElement element,String text) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}
	public static void invisibilityOf(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public static void invisibilityOfAllElements(WebDriver driver,WebElement elements) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	public static void invisibilityOfAllElements(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public static void invisibilityOfElementWithText(WebDriver driver,By locator,String text) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
	}
	public static void frameToBeAvailableAndSwitchToIt(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	public static void frameToBeAvailableAndSwitchToIt(WebDriver driver,int frameLocator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	public static void frameToBeAvailableAndSwitchToIt(WebDriver driver,WebElement frameLocator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	public static void frameToBeAvailableAndSwitchToIt(WebDriver driver,String frameLocator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	public static void presenceOfAllElementsLocatedBy(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	public static void presenceOfElementLocated(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static void presenceOfNestedElementLocatedBy(WebDriver driver,By locator,By childLocator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(locator, childLocator));
	}
	public static void presenceOfNestedElementLocatedBy(WebDriver driver,WebElement element,By childLocator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, childLocator));
	}
	public static void presenceOfNestedElementsLocatedBy(WebDriver driver,By parent,By childLocator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(parent, childLocator));
	}
	public static void fluentWaitForElementToBeClickable(WebDriver driver,By locator) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public static void fluentWaitForElementToBeClickable(WebDriver driver,WebElement element) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void fluentelementToBeSelected(WebDriver driver,By locator) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	public static void fluentElementToBeSelected(WebDriver driver,WebElement element) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeSelected(element));		
	}
	public static void fluentNumberOfElementsToBe(WebDriver driver,By locator,int number) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.numberOfElementsToBe(locator, number));		
	}
	public static void fluentPresenceOfAllElementsLocatedBy(WebDriver driver,By locator) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	public static void fluentTextToBePresentInElement(WebDriver driver,WebElement element,String text) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	public static void fluentTextToBePresentInElementLocated(WebDriver driver,By locator,String text) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}
	public static void fluentTextToBe(WebDriver driver,By locator,String value) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.textToBe(locator, value));
	}
	public static void fluentAlertIsPresent(WebDriver driver) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.alertIsPresent());
	}
	public static void fluentTitleIs(WebDriver driver,String title) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.titleIs(title));
	}
	public static void fluentTitleContains(WebDriver driver,String title) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.titleContains(title));
	}
	public static void fluentUrlToBe(WebDriver driver,String url) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.urlToBe(url));
	}
	public static void fluentUrlContains(WebDriver driver,String url) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.urlContains(url));
	}
	public static void fluentInvisibilityOfElementLocated(WebDriver driver,By locator) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public static void fluentInvisibilityOfElements(WebDriver driver,WebElement elements) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	public static void fluentVisibilityOfAllElements(WebDriver driver,WebElement elements) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	public static void fluentVisibilityOfAllElements(WebDriver driver,By locator) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public static void fluentVisibilityOf(WebDriver driver,WebElement elements) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(elements));
	}
	public static void fluentVisibilityOfElementLocated(WebDriver driver,By locator) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void fluentVisibilityOfAllElementsList(WebDriver driver,WebElement elements) {
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

}
