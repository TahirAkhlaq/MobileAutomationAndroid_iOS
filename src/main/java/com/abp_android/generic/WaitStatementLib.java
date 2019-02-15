/**
 * 
 */
package com.abp_android.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author bluepi
 *
 */
public class WaitStatementLib {
	
	public WebDriverWait wait;
	public FluentWait<WebDriver> fw;
	
	public void explicitWait(WebDriver driver, int time, WebElement element) {
		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void implicitWaitForSeconds(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void elementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void elementClickble(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
