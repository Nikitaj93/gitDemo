import java.time.Duration;
import java.util.List;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class fixibleDateInCalender {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.path2usa.com/travel-companion/");
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	//	Actions a = new Actions(driver);
		//driver.findElement(By.xpath(".//*[@name='form_fields[travel_comp_date]']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).click();
		//a.moveToElement(driver.findElement(By.xpath("//*[@id=\"form-field-travel_to\"]"))).sendKeys("abc").click().keyDown(Keys.TAB);
	
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[1]")).click();
		
		//div[@class='css-1dbjc4n.r-1awozwy.r-1pi2tsx.r-1777fci.r-13qz1uu']
		
		
		// june ---   //*[@id="main-container"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[6]/div/div[1]/div
		

	while(!driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[6]/div/div[1]/div")).getText().contains("June"))
	{
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[1]/svg/g/circle")).click();
	}
		////div[@class='css-1dbjc4n
		//Get all the dates
	List<WebElement> dates= driver.findElements(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]"));
	
	int count = driver.findElements(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]")).size(); 
	
		for(int i=0; i<count ; i++ )
		{
			//String text2 = driver.findElement(By.xpath("//div[@class='css-1dbjc4n.r-1awozwy.r-1pi2tsx.r-1777fci.r-13qz1uu']")).get(i).getText();
			
			String text = driver.findElements(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]")).get(i).getText();
		//	driver.findElement(By.className("css-1dbjc4n")).get(i).click();
		if(text.equalsIgnoreCase("10"));
		{
			driver.findElements(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]")).get(i).click();
			break;
		}
		}
	
	}

}
