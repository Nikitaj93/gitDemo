package TestPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class basicTest {
	// TODO Auto-generated method stub

	@BeforeClass
	public void Bfclass()
	{
		System.out.println("This will execute before the methods of the class");
		
	}
	@Test(groups = {"Smoke"})
	public void Demo() {
	System.out.println("Hello World");
	}
	
	@AfterSuite
	public void AfSuite()
	{
		System.out.println("I am last to execute after suite");
	}
	
	@AfterClass
	public void Afclass()
	{
		System.out.println("This will Execute after the class");
	}
	
	@Test
	public void Demo2() {
	System.out.println("Hello Again World");
	}
}
