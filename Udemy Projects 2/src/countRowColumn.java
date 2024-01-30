import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class countRowColumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// count rows
		int rows = driver.findElements(By.xpath("//*[@name='courses']/tbody/tr/td[2]")).size();
		
		int rowsheading = driver.findElements(By.xpath("//*[@name='courses']/tbody/tr/th[2]")).size();
		
		int totalRow = rows+rowsheading;
		System.out.println(totalRow);
		
		//Countcolumns
		
		int col = driver.findElements(By.xpath("//*[@name='courses']/tbody/tr[2]/td")).size();
		System.out.println(col);
		
		//Get text of 2nd Row
		
		System.out.println(driver.findElement(By.xpath("//*[@name='courses']/tbody/tr[3]/td[1]")).getText());	
		System.out.println(driver.findElement(By.xpath("//*[@name='courses']/tbody/tr[3]/td[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@name='courses']/tbody/tr[3]/td[3]")).getText());
	}

}
