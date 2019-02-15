/**
 * 
 */
package com.abp_android.test;

import org.testng.annotations.Test;

import com.abp_android.generic.BaseLib;
import com.abp_android.pom.AbpHomePage;

/**
 * @author bluepi
 *
 */
public class AbpHomeTest extends BaseLib {

	/**
	 * @param args
	 * @throws IOException
	 */
	

	@Test
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

}
