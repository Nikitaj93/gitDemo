import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndToEndFlow {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		// select Destination

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//*[@id=\"dropdownGroup1\"]/div/ul[3]/li[9]")).click();
		Thread.sleep(2000);

		System.out.println(driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).getText()); // -- remember to put ()
																								// while indexing

		// driver.findElement(By.xpath("(//a[@value='PNQ'])[2]")).click(); //if we dont
		// want to use indexing then use below step

		driver.findElement(By.xpath("//*[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PNQ']"))
				.click(); // Parent child relationship

		// Auto suggestive dropdown

		driver.findElement(By.id("autosuggest")).sendKeys("ind");

		Thread.sleep(3000);
		// Auto suggestion box

		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : options) {
			{
				if (option.getText().equalsIgnoreCase("India")) {
					option.click();
					break;
				}

				// select date from calender

				driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click(); // Selects Current
																									// date in the
																									// calender

				// driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled(); //
				// to check if calender is enabled

				System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

				driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

				System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

				if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) // 2nd way to check if the
																							// return date calender is
																							// enabled when clicked on
																							// round trip
				{
					System.out.println("Is Enabled");
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
				// Select number of passengers

				Assert.assertFalse(driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_friendsandfamily']"))
						.isSelected());
				System.out.println(driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_friendsandfamily']"))
						.isSelected());

				driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_friendsandfamily']")).click();

				System.out.println(driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_friendsandfamily']"))
						.isSelected());

				Assert.assertTrue(driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_friendsandfamily']"))
						.isSelected());

				driver.findElement(By.id("divpaxinfo")).click();
				Thread.sleep(2000);

				for (int i = 1; i < 5; i++) {
					driver.findElement(By.id("hrefIncAdt")).click();
				}
				driver.findElement(By.id("btnclosepaxoption")).click();

				// Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5
				// Adult");
				System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

				// Select Currency
				// Static DropDown
				WebElement Staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

				Select dropdown = new Select(Staticdropdown);
				dropdown.selectByIndex(3);
				System.out.println(dropdown.getFirstSelectedOption().getText());
				dropdown.selectByVisibleText("AED");
				System.out.println(dropdown.getFirstSelectedOption().getText());
				dropdown.selectByValue("INR");
				System.out.println(dropdown.getFirstSelectedOption().getText());

				// Click on Search button

				driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
				System.out.println("The Test has Completed");

			}

		}
	}
}
