/**
 * 
 */
package com.abp_android.test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.screenrecording.BaseStartScreenRecordingOptions;


/**
 * @author bluepi
 *
 */
public class Gesture extends FirstScript{

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		AndroidDriver<AndroidElement> driver=capabilities();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     System.out.println(driver.currentActivity());
	     driver.fingerPrint(1);
	  //   driver.toggleLocationServices();
	   /*  List<List<Object>> performanceData = driver.getPerformanceData("my.app.package", "cpuinfo", 5);
	    System.out.println(performanceData);
	     driver.startRecordingScreen();
	     driver.startRecordingScreen(new BaseStartScreenRecordingOptions(....));*/

	   //  driver.toggleAirplaneMode();
	     

	     driver.runAppInBackground(Duration.ofSeconds(3));

	     System.out.println(driver.getContext());
	     //views - Native , Hybrid, Webview
	     System.out.println(driver.getOrientation());
	   //  driver.lockDevice();
	     System.out.println(driver.isDeviceLocked());
	     //driver.getKeyboard();
	     driver.unlockDevice();
	     Thread.sleep(1000);
	     
	    // driver.hideKeyboard();
	 	 driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
//	     driver.startRecordingScreen()
	  //  driver.hideKeyboard();
	 	

	}
	
	public void horizontalSwipeByPercentage(double startPercentage, double endPercentage, double anchorPercentage) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=capabilities();
		   Dimension size = driver.manage().window().getSize();
		   int anchor = (int) (size.height * anchorPercentage);
		   int startPoint = (int) (size.width * startPercentage);
		   int endPoint = (int) (size.width * endPercentage);
		 
		   new TouchAction(driver).press(point(startPoint, anchor)).waitAction(waitOptions(ofMillis(1000)))
		         .moveTo(point(endPoint, anchor)).release().perform();
		}
		 
	
		// Vertical Swipe by percentages
		public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) throws MalformedURLException {
			AndroidDriver<AndroidElement> driver=capabilities();
		   Dimension size = driver.manage().window().getSize();
		   int anchor = (int) (size.width * anchorPercentage);
		   int startPoint = (int) (size.height * startPercentage);
		   int endPoint = (int) (size.height * endPercentage);
		 
		   new TouchAction(driver).press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(1000)))
		         .moveTo(point(anchor, endPoint)).release().perform();
		}
		 
		// Swipe by elements
		public void swipeByElements(MobileElement startElement, MobileElement endElement) throws MalformedURLException {
			AndroidDriver<AndroidElement> driver=capabilities();
		   int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
		   int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
		 
		   int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
		   int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
		 
		   new TouchAction(driver).press(point(startX, startY)).waitAction(waitOptions(ofMillis(1000)))
		         .moveTo(point(endX, endY)).release().perform();
		}

		 public void scroller() throws IOException 
		 {
			 AndroidDriver<AndroidElement> driver=capabilities();
		       Dimension dimensions = driver.manage().window().getSize();
		       System.out.println("Size of Window= " +dimensions);
		       int scrollStart = (int) (dimensions.getHeight() * 0.5);
		      // System.out.println("Size of scrollStart= " +scrollStart);
		       int scrollEnd = (int) (dimensions.getHeight() * 0.2);
		    //   System.out.println("Size of cscrollEnd= " + scrollEnd);      
		       int anchor = (int) (dimensions.width );
		       System.out.println(anchor);
		       new TouchAction(driver).press(point(anchor, scrollStart)).waitAction(waitOptions(ofMillis(1000)))
		         .moveTo(point(anchor, scrollEnd)).release().perform();
		        
		       System.out.println("Screen Swiped " );
		  }
}
