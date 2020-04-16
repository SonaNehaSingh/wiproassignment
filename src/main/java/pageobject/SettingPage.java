package pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingPage {

	public SettingPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/drawer_item_title")
	public List<WebElement> menunames;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Country/Region')]")
	public WebElement countrybtn;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[contains(@text,'Australia')]")
	public WebElement australiaradiobtn;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Done']")
	public WebElement donebtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Country & Language']")
	public WebElement countryandlangmenu;
}
