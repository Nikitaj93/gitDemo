import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shoppingcart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		String[] items = {"Brocolli","Cucumber","Beetroot"};
	
		addItems(driver,items);
		
		// click on cart
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		// Explicit wait
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		//WebDriverWait w = new WebDriverWait(driver,5);
		w.until( ExpectedConditions.visibilityOfElementLocated(( By.cssSelector("input.promoCode"))));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	

		
	}

	
	public static void addItems(WebDriver driver, String[] items){
		
	
		int j=0;
		List<WebElement> products= driver.findElements(By.cssSelector("h4.product-name"));  //findElements - to get all the elemenets
		
		for(int i=0; i<products.size(); i++)
		{
			String[] name = products.get(i).getText().split("-");
			String formattedName= name[0].trim();
			// Format the veggies name from cucumeber -1Kg to cucumber before comparing
			
			//Search if the name you expecpet is present or not
			//convert array into arraylist for easy search
			
			   List itemNeededList = Arrays.asList(items);
		
			   
			if(itemNeededList.contains(formattedName))
			{
				j++;

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==items.length)
				{
					break;
				}
			}
		}
	}
}
