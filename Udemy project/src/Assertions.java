

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Assertions {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.instagram.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")).sendKeys("EnglisshGarmaer");
		driver.findElement(By.name("password")).sendKeys("Putujutyutne");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Xpath locator
		//driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button")).click();
		
		driver.findElement(By.xpath("//form/div/div[3]")).click();
		// CSS locator
		System.out.println(driver.findElement(By.cssSelector("div._ab2z")).getText());
		
		//LinkText
		
		driver.findElement(By.linkText("Forgot password?")).click();
		
		//driver.findElement(By.name("cppEmailOrUsername")).sendKeys("nikita");
		
		driver.findElement(By.xpath("//input[@name='cppEmailOrUsername']")).sendKeys("Pune@gmail.com");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@name='cppEmailOrUsername']")).clear();
		//Thread.sleep(9000);
		
		System.out.println("Reached till here");
		
		//System.out.println(driver.findElement(By.xpath("//input[@name='cppEmailOrUsername']")));
		
		driver.findElement(By.xpath("//a[@href='/accounts/emailsignup/']")).click();
		
        // System.out.println(driver.findElement(By.xpath("//div[@class='_aahw']")).getText();
         
         Assert.assertEquals(driver.findElement(By.xpath("//div[@class='_aahw']")).getText(), "Sign up to see photos and videos from your friends.");

	}

}
