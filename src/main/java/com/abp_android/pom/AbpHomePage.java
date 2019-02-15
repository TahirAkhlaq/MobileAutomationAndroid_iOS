/**
 * 
 */
package com.abp_android.pom;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.aspectj.weaver.WeaverStateInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.testng.Reporter;

/**
 * @author bluepi
 * 
 *
 * 
 * 
 */
public class AbpHomePage {
	WaitStatementLib wLib;
	// Terms pop up
	@iOSXCUITFindBy( id = "ABP न्यूज़ (Hindi)")
	@AndroidFindBy(uiAutomator = ("new UiSelector().text(\"ABP न्यूज़ (Hindi)\")"))
	WebElement hindiLanguage;

	@AndroidFindBy(uiAutomator = ("new UiSelector().text(\"LIVE BLOG | ABP News Bureau\")"))
	WebElement liveBlogTxt;
	@AndroidFindBy(id = "android:id/button1")
	private WebElement btn;

	@AndroidFindBy(uiAutomator = ("new UiSelector().text(\"OK\")"))
	WebElement okBtn1;
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement allowBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private WebElement okBtn;
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeOther[@name=\"ABP Live \"]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther\n")
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

	@AndroidFindBy(id = "com.winit.starnews.hin:id/tvShowHeaderText")
	WebElement tvShowHeadlinName;

	@AndroidFindBy(id = "com.winit.starnews.hin:id/newsHeadingText")
	private List<WebElement> headlinesCount;

	@AndroidFindBy(id = "com.winit.starnews.hin:id/ivSwipingThumb")
	private WebElement Img;

	@AndroidFindBy(xpath = "android.widget.LinearLayout[@index='1']")
	WebElement qa;
	// private WebElement cd;

	@AndroidFindBy(xpath = "android.widget.LinearLayout[@index='0']")
	private WebElement HindiLangIndex;

	@AndroidFindBy(id = "com.winit.starnews.hin:id/tvChannel")
	WebElement getLiveBlogCategoryName;

	@AndroidFindBy(id = "com.winit.starnews.hin:id/sectionTextview")
	WebElement getArticleCategoryName;

	@AndroidFindBy(id = "com.winit.starnews.hin:id/recentVideoTitleTextView")
	WebElement getVideoTitleName;

	public AbpHomePage(AndroidDriver<AndroidElement> driver) {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public AbpHomePage(IOSDriver<IOSElement> idriver) {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(idriver), this);
	}

	public void clickPopUp(AndroidDriver<AndroidElement> driver) throws InterruptedException {

		hindiLanguage.click();
		okBtn1.click();
		Reporter.log("HomeScree Lauched", true);
		allowBtn.click();
		allowBtn.click();
		Reporter.log("pop cliked", true);
		liveTvTab.click();
		Reporter.log("Title Of Tab is :" + liveTvTitle.getText(), true);
		backBtn.click();
		tvShowTab.click();
		Reporter.log("Title Of Tv Show is :" + tvShowName.getText(), true);
		Reporter.log("Headline Of Tv Show is :" + tvShowHeadlinName.getText());
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		Reporter.log("Back Key Pressed", true);
	}

	public void article(AndroidDriver<AndroidElement> driver) {
		// driver.findElementByAndroidUIAutomator(("new UiSelector().text(\"ABP न्यूज़
		// (Hindi)\")")).click();
		hindiLanguage.click();
		okBtn1.click();
		Reporter.log("HomeScreen Lauched", true);
		allowBtn.click();
		allowBtn.click();
		Reporter.log("Cliked on Permission Pop", true);
		for (WebElement webElement1 : headlinesCount) {
			Reporter.log("Headline is :" + webElement1.getText(), true);
			webElement1.click();
			try {
				if (Img.isDisplayed()) {
					new TouchAction(driver).tap(tapOptions().withElement(element(Img))).perform();
					Reporter.log("CLick on Thumb Image performed", true);
					Reporter.log("Category name is " + getArticleCategoryName.getText(), true);
				} else {
					Reporter.log("Category name is " + getArticleCategoryName.getText(), true);
				}
				driver.findElementByAndroidUIAutomator(
						"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Recommended by Colombia\"));");
			} catch (Exception e) {
				// Reporter.log("Category name is" + liveBlogTxt.getText(), true);
				for (int i = 0; i < 22; i++) {
					Utility.scrollVertical(driver);
				}
				Reporter.log("Thumb Image Not Found", true);
			}
			Reporter.log("Seraching The Articles", true);
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			Reporter.log("Back Key Pressed", true);
		}

	}

	public void iOSMethod(IOSDriver<IOSElement> idriver) {
		//permissionPopUp.click();
		hindiLanguage.click();
		System.out.println("clicked");
	/*	idriver.findElementByAccessibilityId("Alert Views").click();
		idriver.findElementByXPath("//*[@value='Text Entry']").click();
		idriver.findElementByClassName("XCUIElementTypeTextField").sendKeys("Hello");
		idriver.findElementByName("OK").click();*/
	}
}
