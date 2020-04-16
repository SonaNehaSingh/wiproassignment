package wipro.WiproAmazonApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class TestBase {
	
	public static AndroidDriver<AndroidElement> driver;
	public static AppiumDriverLocalService service;
	
	public static FileInputStream  fis;
	public static Properties prop;
	
	//This util method to get the data from property file
	public static Properties getPropertyfile() throws IOException {
		
		fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\config.properties");	
		prop = new Properties();
		prop.load(fis);
		return prop;
	
	}
	
	//This util method is to start appium server 
	public AppiumDriverLocalService startServer() {
		
		//boolean flag=checkServerIsRunning((Integer) prop.get("portnumber"));
		boolean flag=checkServerIsRunning(4723);
		
		if (!flag) {
			service= AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		
		return service;
	}
	
	//This util method to set the dependencies to the device
	public static AndroidDriver<AndroidElement> getDependencies(String appName) throws IOException{

		
		String devicename=(String)prop.get("devicename");
		String appurl= prop.getProperty("appurl");
		String automationname=prop.getProperty("frameworkname");
		String packagename=prop.getProperty("packagename");
		String activityname=prop.getProperty("activityname");
		
		if (devicename.contains("emulator")) {
			startEmulator();
		}
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		capabilities.setCapability("appPackage",packagename);
		capabilities.setCapability("appActivity",activityname);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,automationname);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "80");
		
		URL url=new URL(appurl);
	     
		driver = new AndroidDriver<AndroidElement>(url, capabilities);
		
		return driver;		
		
	}
	
	//This util method take port number as a input and it will check that the port number is free or not to run the appium server
	public boolean checkServerIsRunning(int port) {
		boolean isServerRunning=false;
		
		ServerSocket serversocket;
		
		try {
			serversocket=new  ServerSocket(port);
			serversocket.close();
		}catch(IOException ex) {
			
			isServerRunning=true;
			
		}finally {
			serversocket= null;
		}
		return isServerRunning;
	}
	
	//This util method to get the screen shot 
	public static void getScreenShotOnMobile(String testcasename) {
		
		String date= new SimpleDateFormat("yyyy-MM]-dd-hh-mm-ss").format(new Date());
		File source=driver.getScreenshotAs(OutputType.FILE);
		File destination= new File(System.getProperty("user.dir")+"//screenshot//"+testcasename+"//"+testcasename+"_"+date+".png");
		try {
		FileUtils.copyFile(source, destination);
		
		}
		catch(IOException ex) {}
	}
	
	//This util method to start the emulator 
	public static void startEmulator() throws IOException {
		
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"//src//main//java//resources//emulatorBatFile.bat");
	}
	
	
	public static void killAllNode() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /I /FM node.exe");
		Thread.sleep(10000);
	}
}
