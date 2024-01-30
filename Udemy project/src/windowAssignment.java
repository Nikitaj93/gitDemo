import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new  ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		String parentId = it.next();
		String childId=it.next();
		
		// swtich to child window
		
		driver.switchTo().window(childId);
	    System.out.println(driver.findElement(By.xpath("//*[@class='example']/h3")).getText());
		driver.switchTo().window(parentId);
		
		System.out.println(driver.findElement(By.xpath("//*[@class='example']/h3")).getText());
		
	}

}
