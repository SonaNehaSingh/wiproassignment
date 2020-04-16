package wipro.WiproAmazonApp;

import java.util.List;

import org.openqa.selenium.WebElement;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CommonUtils {

	AndroidDriver<AndroidElement> driver;
	public CommonUtils(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		
	}
	
	public void selectmenuitem(List<WebElement> element, String menuname) {
		
		int i=0;
		for(;i<element.size();i++) {
			if(element.get(i).getText().trim().equalsIgnoreCase(menuname)) {
				element.get(i).click();
				break;
			}
		}
	}

}
