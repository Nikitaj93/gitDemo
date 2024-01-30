import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Assignment_form {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
			
			driver.findElement(By.name("name")).sendKeys("olly");
			driver.findElement(By.name("email")).sendKeys("abc@ddee.com");
			driver.findElement(By.id("exampleInputPassword1")).sendKeys("wqererrre");
			driver.findElement(By.id("exampleCheck1")).click();
			
			WebElement Staticdropdown = driver.findElement(By.id("exampleFormControlSelect1"));
			
			Select dropdown = new Select(Staticdropdown);
			dropdown.selectByIndex(1);
			
			driver.findElement(By.name("inlineRadioOptions")).click();
			driver.findElement(By.name("bday")).sendKeys("13-04-1998");
			driver.findElement(By.xpath("//*[@value='Submit']")).click();
			
			System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")));
			
			driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
			
		//	Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText(),"Success! The Form has been submitted successfully!.");
	}

}

