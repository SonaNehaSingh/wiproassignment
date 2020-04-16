package wipro.WiproAmazonApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UtilitiesClass {
	
	AndroidDriver<AndroidElement> driver;
	
	public UtilitiesClass(AndroidDriver<AndroidElement> driver) {
		
		this.driver=driver;
	}

	//This util method to scroll to a text
	public void scrollToText(String webelement) {
		 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+webelement+"\").instance(0))");
	}
}

