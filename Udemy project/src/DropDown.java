
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class DropDown {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		// Static DropDown
		WebElement Staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropdown = new Select(Staticdropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		// Update Dropdown
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
	/*	int i =1;
		while(i<5)
		{
		driver.findElement(By.id("hrefIncAdt")).click();
		i++;
		} */
		
		//we can also use for loop for above
		
		for(int i=1; i<5; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//*[@id=\"dropdownGroup1\"]/div/ul[3]/li[9]")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).getText()); //-- remember to put () while indexing
		
		//driver.findElement(By.xpath("(//a[@value='PNQ'])[2]")).click();  //if we dont want to use indexing then use below step
		
		driver.findElement(By.xpath("//*[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PNQ']")).click(); //Parent child relationship
		
		//Auto suggestive dropdown
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		
		Thread.sleep(3000);
		
		// Auto suggestion box
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for (WebElement option : options) {
			{
				if(option.getText().equalsIgnoreCase("India"))
				{
					option.click();
					break;
				}
			}
		}
		
		driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_friendsandfamily']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_friendsandfamily']")).isSelected());
		
		//Count the number of checkbox
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());  // will give count of checkboxes
		
		
		//driver.findElement(By.xpath("//*[@class='ui-datepicker-trigger']")).click();
		
		//*[@id="dropdownGroup1"]/div/ul[3]/li[7]/a
	//*[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']
		
		
		
	}

}
