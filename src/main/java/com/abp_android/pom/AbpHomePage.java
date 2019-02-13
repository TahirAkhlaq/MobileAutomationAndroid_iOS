/**
 * 
 */
package com.abp_android.pom;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.abp_android.generic.Utility;
import com.abp_android.generic.WaitStatementLib;
import com.google.common.collect.ImmutableMap;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author bluepi
 *
 */
public class AbpHomePage {
	// Terms pop up
	@AndroidFindBy(id = "android:id/button1")
	private WebElement btn;
	public WaitStatementLib wLib;
	// public Gesture g = new Gesture();

	// Lanhuage Options

//	@FindBy(xpath="[contains(text(),'ABP à¤¨à¥à¤¯à¥à¥ (Hindi)']")
	// private WebElement hindiLanguage;

//	@AndroidFindBy(xpath="")
//	private WebElement englishLanguage;
//	

	@AndroidFindBy(id = "android:id/button1")
	private WebElement accessPermission;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement allowBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private WebElement okBtn;

	@AndroidFindBy(xpath = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement permissionPopUp;

	@AndroidFindBy(id = "com.winit.starnews.hin:id/btnLiveTv")
	private WebElement liveTvTab;

	@AndroidFindBy(id = "com.winit.starnews.hin:id/recentVideoTitleTextView")
	private WebElement liveTvTitle;

	@AndroidFindBy(id = "com.winit.starnews.hin:id/backImageView")
	private WebElement backBtn;

	@AndroidFindBy(id = "com.winit.starnews.hin:id/btnTvShows")
	private WebElement tvShowTab;

	@AndroidFindBy(id = "com.winit.starnews.hin:id/tvShowName")
	private WebElement tvShowName;

	@AndroidFindBy(id = "com.winit.starnews.hin:id/newsHeadingText")
	private List<WebElement> headlinesCount;

	@AndroidFindBy(id = "com.winit.starnews.hin:id/ivSwipingThumb")
	private WebElement Img;

	@AndroidFindBy(xpath = "android.widget.LinearLayout[@index='1']")
	private WebElement cd;

	@AndroidFindBy(xpath = "android.widget.LinearLayout[@index='0']")
	private WebElement HindiLangIndex;

//	@AndroidFindBy(Recommended by Colombia)
	public AbpHomePage(AndroidDriver<AndroidElement> driver) {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickPopUp(AndroidDriver<AndroidElement> driver) throws MalformedURLException {

		driver.findElementByAndroidUIAutomator(("new UiSelector().text(\"ABP न्यूज़ (Hindi)\")")).click();
		wLib = new WaitStatementLib();
		btn.click();

		Reporter.log("HomeScree Lauched", true);
		allowBtn.click();
		allowBtn.click();
		Reporter.log("pop cliked", true);

		liveTvTab.click();
		Reporter.log("Title Of Tab is :" + liveTvTitle.getText(), true);
		backBtn.click();
		tvShowTab.click();

		Reporter.log("Title Of Tv Show is :" + tvShowName.getText(), true);

		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		Reporter.log("Back Key Pressed", true);

	}

	public void article(AndroidDriver<AndroidElement> driver) throws IOException {
		driver.findElementByAndroidUIAutomator(("new UiSelector().text(\"ABP न्यूज़ (Hindi)\")")).click();
		//HindiLangIndex.click();
		wLib = new WaitStatementLib();
		btn.click();

		Reporter.log("HomeScree Lauched", true);
		allowBtn.click();
		allowBtn.click();
		Reporter.log("pop cliked", true);
	//	driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
		
		for (int i = 0; i < 20; i++) {
			Utility.scroll(driver);
		}
		
	/*	for (WebElement webElement : headlinesCount) {
			Reporter.log(webElement.getText());
			webElement.click();
			try {
				Img.isDisplayed();
				new TouchAction(driver).tap(tapOptions().withElement(element(Img))).perform();
				Reporter.log("CLick on Thumb Image performed", true);				
				Utility.scroll(driver);
				//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Recommended by Colombia\"));");	
			} 
			catch (Exception e) {
				Utility.scroll(driver);
				Reporter.log("Thumb Image Not Found", true);			
			}
				Reporter.log("Out From TRY-Catch", true);
			
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		//	Reporter.log("Back Key Pressed", true);
		}*/
	}
}
