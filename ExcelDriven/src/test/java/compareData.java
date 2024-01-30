import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class compareData {

    public static void main(String[] args) throws IOException {
        // Specify the path of the Excel file
        String filePath = "D://Selenium/DemoData.xlsx";

 
        
        // Specify the sheet names to be compared
        String sheet1Name = "TestSheet1";
        String sheet2Name = "TestSheet2";

        // Load the Excel workbook
        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        // Get the sheets by name
        XSSFSheet sheet1 = workbook.getSheet(sheet1Name);
        XSSFSheet sheet2 = workbook.getSheet(sheet2Name);
        
       

        // Iterate through rows and columns to compare data
        compareAndPrintDifferences(sheet1, sheet2);

        // Close the workbook
        workbook.close();
        file.close();
    }

    private static void compareAndPrintDifferences(XSSFSheet sheet1, XSSFSheet sheet2) throws FileNotFoundException, IOException {
        // Assuming both sheets have the same number of rows and columns
        int numRows = sheet1.getPhysicalNumberOfRows();
        int numCols = sheet1.getRow(0).getPhysicalNumberOfCells();
        
        String filePath = "D://Selenium/DemoData.xlsx";
        FileInputStream file1 = new FileInputStream(filePath);
        XSSFWorkbook workbook1 = new XSSFWorkbook(file1);
        //to print results to excel
    	Sheet sheet = workbook1.createSheet("SeleniumResults");
    	
    	final StringBuilder consoleOutput = new StringBuilder();
    
    
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
                    
                  
                    
                    // Create a StringBuilder to capture console output
                      //final StringBuilder consoleOutput = new StringBuilder();

                    // Redirect console output to the StringBuilder
                    
                   
                  
                } 
            
                    // to print data
                    
          // System.out.println("\nCaptured Console Output:\n" + consoleOutput.toString());
                    
                    //System.out.println(consoleOutput.toString());
                    
                 // Write Selenium results to Excel
                    for (int k = 0; k < consoleOutput.length(); k++) {
                        // Create a row
                        Row row = sheet.createRow(k);
                        // Create a cell and set the value
                        Cell cell = row.createCell(0);
                       cell.setCellValue(consoleOutput.toString());
                        //cell.setCellValue(k);
                       
                       System.setOut(new java.io.PrintStream(System.out) {
                           public void println(String message) {
                               super.println(message);
                             consoleOutput.append(message).append("\n");
                             System.out.println(consoleOutput);
                             
                           }
                       });
                    // Save the workbook to a file
                    try (FileOutputStream fileOut = new FileOutputStream("D://Selenium/Result3.xlsx")) {
                        workbook1.write(fileOut);
                    }
                }
            //}

			
        }
            
           

    /*	// Write Selenium results to Excel
        for (int i = 0; i < seleniumResults.length; i++) {
            // Create a row
            Row row = sheet.createRow(i);
            // Create a cell and set the value
            Cell cell = row.createCell(0);
            cell.setCellValue(seleniumResults[i]);
        }

        // Save the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream("D://Selenium/compareData.xlsx")) {
            workbook.write(fileOut);
        }

        // Close the workbook
        workbook.close();}
    
 
        public  void consoleOutputDataCapture() {
            // Create a StringBuilder to capture console output
            final StringBuilder consoleOutput = new StringBuilder();

            // Redirect console output to the StringBuilder
            System.setOut(new java.io.PrintStream(System.out) {
                public void println(String message) {
                    super.println(message);
                    consoleOutput.append(message).append("\n");
                }
            });

            // Your Selenium test or other operations that print to the console
           // System.out.println("Test Case 1 Passed");
            //System.out.println("Test Case 2 Failed");
            //System.out.println("Test Case 3 Passed");
         // Save the workbook to a file
 

            // Print the captured console output
            System.out.println("\nCaptured Console Output:\n" + consoleOutput.toString()); */
       // });
        
    }
   
    }
}

    
   
      
    
