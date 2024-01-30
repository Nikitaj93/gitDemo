import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class countLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		driver.findElement(By.tagName("a"));
		
		// get links present on footer only, Limiting Webdriver scope
		
		WebElement footerdriver =driver.findElement(By.id("gf-BIG")); // create subset of  driver class
		
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		// getting count of links only in 1st column in the footer
		
		System.out.println(footerdriver.findElements(By.xpath("//*[@class='gf-t']/tbody/tr/td[1]/ul/li")).size());
		
		//we can also create WebElement and find the count
		
		WebElement colomndriver = footerdriver.findElement(By.xpath("//*[@class='gf-t']/tbody/tr/td[1]/ul"));
		System.out.println(colomndriver.findElements(By.tagName("a")).size());
	
		
		//Click on all the links and see if the pages are opening
		
		for(int i= 1; i<=colomndriver.findElements(By.tagName("a")).size()-1; i++)
		{
			//Press ctrl and click on link will open link in new window
			String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			colomndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(5000L);
		}
			//Get the Tittle of every window opened
			
					 
					 // to get windows id
					Set<String> abc = driver.getWindowHandles();
					 Iterator<String> it = abc.iterator();
					 
		
					 // Switching window
					 
					 while(it.hasNext())
					 {
						 driver.switchTo().window(it.next());
						 System.out.println(driver.getTitle());
					 }
					 
					
		

	}

}
