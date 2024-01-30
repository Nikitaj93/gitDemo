import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text= "Kashi";
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		// Enter name in text box
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.xpath("//*[@value='Alert']")).click();
		
		//using CSS Selector
		//driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		
		// Switch to alert window
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept(); // to accept or OK
		
		//alert with 2 options
		
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss(); // to cancel /NO

	
		
	}

}
