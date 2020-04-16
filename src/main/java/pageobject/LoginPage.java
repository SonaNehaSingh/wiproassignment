package pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	public LoginPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//	@AndroidFindBy()
//	public WebElement exitingcustomersigninbtn;
	
	@AndroidFindBy(xpath="//android.widget.Button")
	public List<WebElement> buttons;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='English - EN']")
	public WebElement englishradiobtn;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Save Changes']")
	public WebElement savechangesbtn;
	
//	@AndroidFindBy()
//	public WebElement usernamefield;
//	
//	@AndroidFindBy()
//	public WebElement passwordtextfield;
//	
//	@AndroidFindBy()
//	public WebElement logingbtn;
}
