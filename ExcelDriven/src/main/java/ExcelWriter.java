import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {
    public static void main(String[] args) {
        // Create a new Excel workbook
        Workbook workbook = new XSSFWorkbook(); // for .xlsx format

        // Create a new Excel sheet
        Sheet sheet = workbook.createSheet("Sheet1");

        // Write data to specific columns
        writeData(sheet, 0, 0, "Column 1 Data");
        writeData(sheet, 0, 1, "Column 2 Data");
        writeData(sheet, 0, 2, "Column 3 Data");

        // Write the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream("D://Selenium/output.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel file with data created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the workbook
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to write data to a specific row and column in the Excel sheet
    private static void writeData(Sheet sheet, int rowNum, int colNum, String data) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        Cell cell = row.createCell(colNum);
        cell.setCellValue(data);
    }
}