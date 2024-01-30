import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_loginpage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 WebDriver driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("learning");
	
		driver.findElement(By.xpath("//span[@class='checkmark']")).click();
	
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(2);
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info']")));
		
		
		List<WebElement> products= driver.findElements(By.cssSelector("h4.card-title")); 
		
		for(int i=0; i<products.size(); i++)
		{
			driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		}
	
		
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
	}

}
