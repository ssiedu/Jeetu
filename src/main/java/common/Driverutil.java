package common;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;


public class Driverutil {
	public static WebDriver driver ;
	public static Actions builder;
	
	/**
	 * Wait for element display in given seconds
	 * 
	 * @param locator
	 * @param seconds
	 * 
	 */

	@SuppressWarnings("deprecation")
	public static void waitElementDisplayedImplicitlyForSeconds(final By locator, int seconds) {
		new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(WebDriverException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	@SuppressWarnings("deprecation")
	public static void waitElementTextToBePresentImplicitlyForSeconds(final By locator, final String text, int seconds) {
		new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}
	
	@SuppressWarnings("deprecation")
	public static void waitElementTextToBePresentInValueImplicitlyForSeconds(final By locator, final String text, int seconds) {
		new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
	}
	
	@SuppressWarnings("deprecation")
	public static void waitElementIsClickableImplicitlyForSeconds(final By locator, int seconds) {
		new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	@SuppressWarnings("deprecation")
	public static void waitElementAttributeToBePresentImplicitlyForSeconds(final By locator, final String attributeName, String value, int seconds) {
		new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.attributeContains(locator, attributeName, value));
	}
	
	public static WebElement find(By locator)
	{
		WebElement w = driver.findElement(locator);
		return w;
	}

	public static void typeInTextField(final By locator, String str) {
		//driver.findElement(locator).clear();
		find(locator).clear();
		find(locator).sendKeys(str);
	}
	
	public static void ClickOnTheElement(final By locator) {
		find(locator).click();
	}
	
	public static Boolean DisplayElement(final By locator)
	{
		Boolean b = find(locator).isDisplayed();

		return b;
	}
	
	public static String GetInnerText(final By locator)
	{
		String s = find(locator).getText();
		return s;
	}
	public static void Entertext(String s, final By locator)
	{
		
		waitElementDisplayedImplicitlyForSeconds(locator, 30);
		find(locator).clear();
		find(locator).sendKeys(s);
	}
	
	public static void selectOption(String s, final By locator)
	{
		waitElementDisplayedImplicitlyForSeconds(locator, 30);
		Select drp = new Select (find(locator));
		drp.selectByVisibleText(s);
	}
	
	public static String getselectedOption(final By locator)
	{
		waitElementDisplayedImplicitlyForSeconds(locator, 30);
		Select drp = new Select (Driverutil.find(locator));
		String s1 = drp.getFirstSelectedOption().getText();
		return s1;
		
	}
	public static void clearThetextField(final By locator)
	{
//		builder = new Actions(driver);
//		 WebElement textField = driver.findElement(locator);    
//         
//         builder
//                 .moveToElement(textField).click().keyDown(textField, Keys.CONTROL + "a" + Keys.DELETE)
//                 .keyUp(textField, Keys.CONTROL + "a" + Keys.DELETE).build().perform();
                 
         find(locator).sendKeys(Keys.CONTROL + "a");
         find(locator).sendKeys(Keys.DELETE);
	}
	public static Boolean isCheckboxChecked(final By locator)
	{
		Boolean b = find(locator).isSelected();
		return b;
	}
	
}
