import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 WebDriver driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		 driver.manage().window().maximize();
		
		 driver.findElement(By.cssSelector(".blinkingText")).click();
		 
		 Set<String> windows = driver.getWindowHandles(); // windows is stored as [parentid,childid,subchild]
		 
		 // to get windows id
		 Iterator<String> it= windows.iterator();
		 String parentId= it.next();  // control will go to next window
		 String childId= it.next();
		 
		 // Switching window
		 
		 driver.switchTo().window(childId);
		 
		 // Control is now on 2nd window
		 
	System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());  // xpath - //*[@class='im-para red']
	
	String email= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
	
	driver.switchTo().window(parentId);
	driver.findElement(By.id("username")).sendKeys(email);
	}

}
