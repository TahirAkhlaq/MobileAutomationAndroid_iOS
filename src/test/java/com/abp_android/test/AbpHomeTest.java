/**
 * 
 */
package com.abp_android.test;

import org.testng.annotations.Test;

import com.abp_android.generic.BaseLib;
import com.abp_android.pom.AbpHomePage;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

/**
 * @author bluepi
 *
 */
public class AbpHomeTest extends BaseLib {

	/**
	 * @param args
	 * @throws IOException
	 */
	

	//@Test
	public void fMethod() throws InterruptedException {
		AbpHomePage ab = new AbpHomePage(driver);
		wLib.implicitWaitForSeconds(driver, 10);
		// ab.clickPopUp(driver);
		ab.article(driver);

	}

//	@Test(priority=1)
	public void verifyHeaders() throws InterruptedException {
		AbpHomePage ab = new AbpHomePage(driver);
		wLib.implicitWaitForSeconds(driver, 10);
		ab.clickPopUp(driver);
	}

	@Test
	public void ios() {
	
		AbpHomePage ab = new AbpHomePage(idriver);
		//wLib.implicitWaitForSeconds(driver, 10);
		ab.iOSMethod(idriver);
	}
}
/*{
	  "platformName": "ios",
	  "deviceName": "iPhone",
	  "bundleId": "com.abpnews.iosapp",
	  "automationName": "XCUITest",
	  "udid": "9ea05e940be938546d5336349bdc1b6c69e968d6"
	}*/