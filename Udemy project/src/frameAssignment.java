import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class frameAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		System.out.println(driver.findElements(By.tagName("frame")).size());
	
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@name='frameset-middle']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@name='frame-top']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@name='frame-middle']")));
		
		System.out.println(driver.findElement(By.xpath("//*[@id='content']")).getText());
	}

}
