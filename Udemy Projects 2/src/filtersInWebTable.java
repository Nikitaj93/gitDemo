import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class filtersInWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		 driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='table table-bordered']/tbody/tr/td[1]"));
		
		
	List<WebElement> filteredList =	list.stream().filter(lists->lists.getText().contains("Rice")).collect(Collectors.toList());
	
	
	
	Assert.assertEquals(list.size(), filteredList.size());
	System.out.println("this is end");
		
			
		
	}

}
