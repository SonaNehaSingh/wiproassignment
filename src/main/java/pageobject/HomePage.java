package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	public HomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/action_bar_home_logo")
	public AndroidElement amazonhomelogo;
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/action_bar_burger_icon")
	public WebElement humbergemenuimage;


}
