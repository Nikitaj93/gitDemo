import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();  //  maximize the window
		
		driver.navigate().to("https://www.youtube.com/");  // navigate from google to youtube
		driver.navigate().back();  // navigate from youtube back to google
		driver.navigate().forward();
		
	}

}
