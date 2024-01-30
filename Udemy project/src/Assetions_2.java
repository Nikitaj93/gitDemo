import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assetions_2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		driver.manage().window().maximize();
		
		
		Assert.assertFalse(driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_friendsandfamily']")).isSelected());
		System.out.println(driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_friendsandfamily']")).isSelected());
		
		driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_friendsandfamily']")).click();
	
		System.out.println(driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_friendsandfamily']")).isSelected());
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_friendsandfamily']")).isSelected());
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		for(int i=1; i<5; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
	
    	Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
    	System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	
	}

}
