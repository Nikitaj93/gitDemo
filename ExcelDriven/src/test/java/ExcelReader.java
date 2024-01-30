import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static void main(String[] args) {
        try {
            // Specify the path of the Excel file
            String excelFilePath = "D://Selenium/DemoData.xlsx";

            // Create FileInputStream to read Excel file
            FileInputStream fis = new FileInputStream(new File(excelFilePath));

            // Create workbook instance
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            // Get the sheet
            XSSFSheet sheet = workbook.getSheetAt(0); // Change index as needed

            // Iterate through each row
            for (Row row : sheet) {
                // Iterate through each cell in the row
                for (Cell cell : row) {
                    // Access cell value
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println(); // Move to the next row
            }

            // Close the workbook and FileInputStream
            workbook.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}