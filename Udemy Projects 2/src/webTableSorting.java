import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class webTableSorting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		Thread.sleep(2000);
		//Click on Coloumn
		//driver.findElement(By.xpath("//*[@class='table table-bordered']/thead/tr/th[1]/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div/table/thead/tr/th[1]")).click();
		//*[@class='sort-icon sort-ascending']
		Thread.sleep(2000);
		// Get all the WebElements in list
		
	//List<WebElement> list =	driver.findElements(By.xpath("//*[@class='table table-bordered']/tbody/tr/td[1]"));
	List<WebElement> list =	driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div/table/tbody/tr/td[1]"));
	
	//Capture Text of all WebElements into new(original) list
	List<String> originalList=  list.stream().map(s->s.getText()).collect(Collectors.toList());
	
	originalList.stream().sorted().collect(Collectors.toList());
	
		
	// compare Original and sorted list
	
	Assert.assertTrue(list.equals(originalList));
	
	//Scan name coloumn and get Beans and print price
	
	list.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceofBeans()).collect(Collectors.toList());
	
		
	}

	private static Object getPriceofBeans() {
		// TODO Auto-generated method stub
		return null;	
	}

}
