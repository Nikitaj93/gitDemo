package TestPackage;

import org.testng.Assert;

import org.testng.annotations.Test;

public class basicTest4 {


	@Test(groups = {"Smoke"})
	public void HomeWeblogin() {
	System.out.println("Hello This is 3rd basic test");
	
	//Selenium
	}
	

	@Test
	public void HomeMobilelogin()
	{
		//Appium
		System.out.println("Hello This is Mobilelogin");
	

	}
	
	@Test
	public void HomeLoginAPI()
	{
		//Rest API automation	
		System.out.println("Hello This is LoginAPI");
		Assert.assertTrue(false);
	}

}
