/**
 * 
 */
package com.abp_android.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author bluepi
 *
 */
public class FirstScript {

	/**
	 * @param args
	 * @return
	 * @throws MalformedURLException
	 */
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

		File f = new File("src");
		File fs = new File(f, "ABP_News_Debug_Staging.apk");

		DesiredCapabilities cap = new DesiredCapabilities();

	//	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Huawei P20 Lite");
	//	cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		// cap.setCapability(MobileCapabilityType.DEVICE_NAME, "BluepiEmulator" );
		//cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.winit.starnews.hin");

		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.winit.starnews.hin.activities.Welcome");
		
		String baseURL = "http://0.0.0.0:";
		String minorURL = "/wd/hub";
		String port = "4723";
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL(baseURL + port + minorURL), cap);
		return driver;
	}

}
