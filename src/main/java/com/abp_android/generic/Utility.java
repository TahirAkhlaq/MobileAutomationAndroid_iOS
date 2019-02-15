/**
 * 
 */
package com.abp_android.generic;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * @author bluepi
 *
 */
public class Utility {

	public static void scrollVertical(AndroidDriver<AndroidElement> driver) {
		Dimension size = driver.manage().window().getSize();
		/*
		 * System.out.println(size.height + "height"); System.out.println(size.width +
		 * "width"); System.out.println(size);
		 */
		int startPoint = (int) (size.width * 0.4);
		int endPoint = (int) (size.width * 1);
		int ScreenPlace = (int) (size.height * 0.40);
		int y = (int) size.height * 20;

		TouchAction ts = new TouchAction(driver);

		ts.press(PointOption.point(ScreenPlace, endPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(ScreenPlace, startPoint)).release().perform();

	}

	/**
	 *####Scroll By usin Id,text And class child text#############
	 *
	 * MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator( "new
	 * UiScrollable(new
	 * UiSelector().resourceId(\"com.android.vending:id/tab_recycler_view\")).getChildByText("
	 * + "new UiSelector().className(\"android.widget.TextView\"), \"Games We Are
	 * Playing\")"));
	 * 
	 * //Perform the action on the element element.click();
	 * 
	 * 
	 * 
	 * 
	 */

}