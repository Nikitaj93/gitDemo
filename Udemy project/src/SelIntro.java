import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntro {

	public static void main(String[] args) {
		
		//Invoking  Chrome Browser
		
		//WebDriver driver =new ChromeDriver();
		
		//WebDriver driver = new FirefoxDriver();
		
		WebDriver driver = new EdgeDriver();
		
		//Open URL in Browser
		driver.get("https://www.youtube.com/watch?v=8LPUSpaS-hw");
		
		// to display the title in the console
		System.out.println(driver.getTitle());
		
		//to get current url
		System.out.println(driver.getCurrentUrl());
		
		
		driver.close();
		

	}
	

	public String getintro()
	{
		System.out.println("Hello New Jersey");
		return "I am in Chicago";
	}

}
