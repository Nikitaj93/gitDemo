package TestPackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class basicTest3 {


		// TODO Auto-generated method stub

	@Test(dataProvider = "getdata")
	public void CarWeblogin(String username, String password) {
	System.out.println("Hello This is 3rd basic test");
	System.out.println(username);
	System.out.println(password);
	
	//Selenium
	}
	
	@AfterTest(timeOut = 4000)
	public void afterTest()
	{
		System.out.println(" This is After Test");
	}

	@Test(groups = {"Smoke"})
	public void CarMobilelogin()
	{
		//Appium
		System.out.println("Hello This is Mobilelogin");
	}
	
	
	@BeforeSuite
	public void bfsuite()
	{
		System.out.println("I am no 1 to execute before suite");
	}
	
	@Test(enabled = false)
	public void CarLoginAPI()
	{
		//Rest API automation	
		System.out.println("Hello This is LoginAPI");
	}
	
	@DataProvider()
	public Object[][] getData()
	{
		Object [][] data = new Object[3][2];
		data[0][0] ="Firstname";
		data[0][1]= "FirstPassword";
		// 2nd Set
		data[1][0] ="Secondname";
		data[1][1] ="SecondPassword";
		//3rd set
		data[2][0] ="Thirdname";
		data[2][1]= "ThridPassword";
		return data;
	}
}
