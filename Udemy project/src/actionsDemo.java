import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@href='/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc']"))).contextClick().build().perform(); 
		//contextClick() is used to right click
		
		//build - to get the step ready for execution & perform() - to Execute the step
		
		a.moveToElement(driver.findElement(By.xpath("//a[@href='/deals?ref_=nav_cs_gb']"))).click().build().perform();
		
		a.moveToElement(driver.findElement(By.name("field-keywords"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		
		
		

	}

}
