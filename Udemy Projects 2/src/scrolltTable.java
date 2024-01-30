import java.awt.Window;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

import dev.failsafe.internal.util.Assert;

public class scrolltTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll whole page
		js.executeScript("window.scroll(0,500)");
		//Thread.sleep(3000);
		// Scroll the table content
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		// to Add all the amount in the table
		
	List<WebElement> list =	driver.findElements(By.xpath("//*[@class='tableFixHead']/table/tbody/tr/td[4]")); // Css for this - .tableFixHead td :nth-child(4)
		int sum = 0;
		for(int i=0; i<list.size() ;i++)
		{
			//System.out.println(Integer.parseInt(list.get(i).getText())); // to print list of amount
			sum= sum + Integer.parseInt(list.get(i).getText());
		}
		System.out.println(sum);
		
		int total =Integer.parseInt(driver.findElement(By.xpath("//*[@class='totalAmount']")).getText().split(":")[1].trim()); // to get total value which is displayed at end od table
		// to compare sum and total
		org.testng.Assert.assertEquals(sum,total);
		//System.out.println(sum=total);
		
		
}
}
