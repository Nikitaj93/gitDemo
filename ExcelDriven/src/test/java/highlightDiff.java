
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.logging.log4j.core.util.WatchManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class highlightDiff {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
    	
    
    	System.setProperty("webdriver.chrome.driver", "D://Selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       // driver.get("http://google.com");

        try {
            // Load Excel file
            FileInputStream file = new FileInputStream("D://Selenium/compareData.xlsx");
            Workbook workbook = new XSSFWorkbook(file);

            // Specify sheet names
            String sheetName1 = "TestSheet1";
            String sheetName2 = "TestSheet2";

            // Get sheets
            Sheet sheet1 = workbook.getSheet(sheetName1);
            Sheet sheet2 = workbook.getSheet(sheetName2);

            // Loop through rows and columns
            for (int i = 0; i < sheet1.getPhysicalNumberOfRows(); i++) {
                Row row1 = sheet1.getRow(i);
                Row row2 = sheet2.getRow(i);

                for (int j = 0; j < row1.getPhysicalNumberOfCells(); j++) {
                    Cell cell1 = row1.getCell(j);
                    Cell cell2 = row2.getCell(j);

                    // Compare cell values
                    if (!cell1.toString().equals(cell2.toString())) {
                        // Highlight the difference - You may need to implement the logic to highlight here
                        // For simplicity, let's just print the details
                        System.out.println("Difference found at Sheet1[" + i + "][" + j + "]: " + cell1 + ", Sheet2[" + i + "][" + j + "]: " + cell2);
                    }
                }
            }

            // Close the workbook
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the WebDriver
            driver.quit();
        }
    }
}