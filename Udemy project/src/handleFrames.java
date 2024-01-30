import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class handleFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver =new ChromeDriver();
		 driver.get("https://jqueryui.com/droppable/");
		 // get the count of the frames in application 
		 System.out.println(driver.findElements(By.tagName("iframe")).size());
		 // using switch frame by index
		 driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));
		driver.findElement(By.id("draggable")).click();
		
		Actions a = new Actions(driver);
		a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
		
		// To bring out control from frame to HTML
		
		driver.switchTo().defaultContent();
	}

}
