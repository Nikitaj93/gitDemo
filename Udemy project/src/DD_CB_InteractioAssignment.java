import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DD_CB_InteractioAssignment {

	public static void main(String[] args) {
	
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("checkBoxOption2")).click();
		driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).getText();
		String opt = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
	//	System.out.println(opt);
		
		
		WebElement staticoption = driver.findElement(By.xpath("//*[@id='dropdown-class-example']"));

		Select dropdown = new Select(staticoption);
		dropdown.selectByVisibleText(opt);
		
	//	dropdown.selectByValue(opt);
		
		driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(opt);
		
		// CLick on alert button
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		// Switch to driver window
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	
		
		

		
		
		
		
		
	}

}
 