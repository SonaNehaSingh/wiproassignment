package resources;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import wipro.WiproAmazonApp.TestBase;


public class Listener implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		//TestBase.getScreenShotOnMobile(result.getName());
		
		try {
			TestBase.getScreenShotOnMobile(result.getName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
}


