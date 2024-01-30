import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettingStarted {   

 

public void testGoogleSearch() throws InterruptedException {     

  // Optional. If not specified, WebDriver searches the PATH for chromedriver.       System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");           WebDriver driver = new ChromeDriver(); 

  ChromeDriver driver = new ChromeDriver();
  driver.get("http://www.google.com/");    

  Thread.sleep(5000);  // Let the user actually see something!     

  WebElement searchBox = driver.findElement(By.name("q"));

  searchBox.sendKeys("ChromeDriver");     

  searchBox.submit();    

  Thread.sleep(5000);  // Let the user actually see something!     

  driver.quit();  

 } 

}