package TestPackage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class basicTest2 {

	
		// TODO Auto-generated method stub

	@BeforeMethod
	public void Demo3() {
	System.out.println("Hello This is 2nd basic test");
	}
	
	@BeforeMethod(dependsOnMethods = {"Demo3"})
	public void BfMethod()
	{
		System.out.println("This will execute before every method");
	}
	@Parameters({"URL","username"})
	@Test
	public void testclass(String urlname,String user) {
	System.out.println("Hello This is testclass");
	System.out.println(urlname);
	System.out.println(user);
	}
	
	@org.testng.annotations.AfterMethod
	public void AfterMethod()
	{
		System.out.println("This will Execute After Every Method");
	}
	
	@BeforeTest
	public void beforetest() {
		System.out.println("This will execute Before Test");
		}
}
