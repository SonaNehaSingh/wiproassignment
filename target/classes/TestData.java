package resources;


import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="MenuDetails")
	public static Object[][] menudata(){
		
		 Object[][] obj= new  Object[][]{
				 {"settings","Counry & Language"}
			 };
		
	     return obj;
	}
	
	
}
