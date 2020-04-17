package settings;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.SettingPage;
import resources.TestData;
import wipro.WiproAmazonApp.CommonUtils;
import wipro.WiproAmazonApp.TestBase;
import wipro.WiproAmazonApp.UtilitiesClass;


public class CountrySetting extends TestBase {
	
	HomePage homepage;
	UtilitiesClass u;
	SettingPage spage;
	LoginPage loginpage;
	CommonUtils utils;
	
	public WebDriverWait wait;
	
	@BeforeTest
	public void killNodes() throws IOException, InterruptedException {
		killAllNode();
		Thread.sleep(4000);
	}
	
	@Test(dataProvider="MenuDetails", dataProviderClass=TestData.class)
	public void changeCountryName(String menuname,String submenuame) throws IOException, InterruptedException {
	
		getPropertyfile();
		service=startServer();
		
		driver= getDependencies("generalstoreappname");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		wait= new WebDriverWait(driver,20);
		
		homepage= new HomePage(driver);
		spage = new SettingPage(driver);
		loginpage = new LoginPage(driver);
		u= new UtilitiesClass(driver);
		utils= new CommonUtils(driver);
		
		loginpage.buttons.get(0).click();
		loginpage.englishradiobtn.click();
		loginpage.savechangesbtn.click();
			
		Assert.assertTrue(homepage.amazonhomelogo.isDisplayed(), "Amazon shopping app");
		
		if (homepage.humbergemenuimage.isDisplayed()) {
			homepage.humbergemenuimage.click();
		}
		
		u.scrollToText(menuname); Thread.sleep(3000);
		utils.selectmenuitem(spage.menunames, menuname);
		
		spage.countryandlangmenu.click();
		spage.countrybtn.click();
		spage.australiaradiobtn.click();
		
		String actualcountryaame=spage.countrybtn.getText();
		String expectedcountryname=prop.getProperty("expectedcountryname");
		
		Assert.assertTrue(actualcountryaame.contains(expectedcountryname));
		
		spage.donebtn.click();
		
		service.stop();
		
	}
	
	
}
