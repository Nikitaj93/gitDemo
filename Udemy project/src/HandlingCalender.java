import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingCalender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//*[@id=\"dropdownGroup1\"]/div/ul[3]/li[9]")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).getText()); //-- remember to put () while indexing
		
		//driver.findElement(By.xpath("(//a[@value='PNQ'])[2]")).click();  //if we dont want to use indexing then use below step
		
		driver.findElement(By.xpath("//*[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PNQ']")).click(); //Parent child relationship
		
	
	    driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();  // Selects Current date in the calender
	    
	  //  driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled(); // to check if calender is enabled
		
	    System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
			
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))   // 2nd way to check if the return date calender is enabled when clicked on round trip
		{
			System.out.println("Is Enabled");
			Assert.assertTrue(true);
		}
			else
			{
				Assert.assertTrue(false);
		}
	
		
		
		
		
	}

}
