
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class printResultinExcel {
	   StringBuilder consoleOutput = new StringBuilder();
    public static void main(String[] args) throws IOException {
 
            // Create a new Excel workbook
           // Workbook workbook = new XSSFWorkbook();

		// TODO Auto-generated method stub
		

        // Get the sheets by name
       
        
		String sheet1Name = "TestSheet1";
        String sheet2Name = "TestSheet2";
        String filePath = "D://Selenium/DemoData.xlsx";
        // Load the Excel workbook
        FileInputStream file = new FileInputStream(filePath);
    
    	
        XSSFWorkbook workbook = new XSSFWorkbook(file);// Create a sheet
    	
           
            // Specify the sheet names to be compared
    	 XSSFSheet sheet1 = workbook.getSheet(sheet1Name);
         XSSFSheet sheet2 = workbook.getSheet(sheet2Name);
        
        
        // Sample Selenium result data
        //String[] seleniumResults = {"Test Case 1 Passed", "Test Case 2 Failed", "Test Case 3 Passed"};

      /*  // Write Selenium results to Excel
        for (int i = 0; i < seleniumResults.length; i++) {
            // Create a row
            Row row = sheet.createRow(i);
            // Create a cell and set the value
            Cell cell = row.createCell(0);
            cell.setCellValue(seleniumResults[i]);
        }  */
        
 
        int numRows = sheet1.getPhysicalNumberOfRows();
        int numCols = sheet1.getRow(0).getPhysicalNumberOfCells();
        
	
		// TODO Auto-generated method stub
		  for (int i = 0; i < numRows; i++) {
             Row row1 = sheet1.getRow(i);
             Row row2 = sheet2.getRow(i);

             for (int j = 0; j < numCols; j++) {
                 Cell cell1 = row1.getCell(j);
                 Cell cell2 = row2.getCell(j);

                 // Compare cell values
                 if (!cell1.getStringCellValue().equals(cell2.getStringCellValue())) {
                 	
                 
                     // Print the difference
                 	System.out.println("Difference at Row " + (i + 1) + ", Column " + (j + 1) + ":");
                     System.out.println("Sheet1: " + cell1.getStringCellValue());
                     System.out.println("Sheet2: " + cell2.getStringCellValue());
                     System.out.println("---------------------------");
                     
                 }
                 
             	
             
               /*  private static void captureConsoleOutput(Runnable codeToRun) {
         	        System.setOut(new java.io.PrintStream(System.out) {
         	            public void println(String message) {
         	                super.println(message);
         	                consoleOutput.append(message).append("\n");
         	            }
         	        }); */
                 }

         // Save the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream("D://Selenium/abc.xlsx")) {
             workbook.write(fileOut);
            // writeConsoleOutputToExcel("D://Selenium/abc.xlsx");
         }

         // Close the workbook
        	workbook.close();

        // System.out.println("Selenium results written to Excel successfully!");
       
             }
		  } 
     } 

		  
      