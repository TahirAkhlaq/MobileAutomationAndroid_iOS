/**
 * 
 */
package com.abp_android.generic;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

/**
 * @author bluepi
 *
 */
public class BaseLib {
	
	public WaitStatementLib wLib;
	public AndroidDriver<AndroidElement> driver;
	public IOSDriver<IOSElement> idriver;


	//@BeforeMethod
	public void androidCapabilities() throws MalformedURLException {
		File f = new File("src");
		File fs = new File(f, "abp-news_staging.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		// cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Huawei P20 Lite");
		// cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		// cap.setCapability(MobileCapabilityType.DEVICE_NAME, "BluepiEmulator" );
		// cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		 cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.winit.starnews.hin");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.winit.starnews.hin.activities.Welcome");
		String baseURL = "http://0.0.0.0:";
		String minorURL = "/wd/hub";
		String port = "4723";
		driver = new AndroidDriver<AndroidElement>(new URL(baseURL + port + minorURL), cap);
		wLib = new WaitStatementLib();
	}
	
	@BeforeMethod
	public void iOSCapabilities() throws MalformedURLException {
		
		
			DesiredCapabilities d = new DesiredCapabilities();
			d.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID,"6RFVY9SM98");
			d.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, "iPhone Developer");
			d.setCapability(MobileCapabilityType.UDID, "9ea05e940be938546d5336349bdc1b6c69e968d6");
			d.setCapability(IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID, "com.abpnews.iosapp");
			d.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
			d.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
			d.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
			//d.setCapability(MobileCapabilityType.APP, "//Users//bluepi//Documents//UICatalog.app");
			d.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.abpnews.iosapp");
			IOSDriver<IOSElement> driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),d);
					
		
		}
	//udid-32d41d0496b327f603b103164c99dba3734390f8
	

	@AfterMethod
	public void postCondition() {
	//	AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
//		service.stop();
	}

}
