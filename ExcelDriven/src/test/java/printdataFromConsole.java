

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class printdataFromConsole {
	    private static StringBuilder consoleOutput = new StringBuilder();

	    public static void main(String[] args) throws IOException {
	        // Run the code that prints to the console
	    	
	    	String filePath = "D://Selenium/Result.xlsx";
	        
	        // Specify the sheet names to be compared
	        String sheet1Name = "TestSheet1";
	       String sheet2Name = "TestSheet2";

	        // Load the Excel workboo
	        FileInputStream file = new FileInputStream(filePath);
	        XSSFWorkbook workbook = new XSSFWorkbook(file);

	        // Get the sheets by name
	        XSSFSheet sheet1 = workbook.getSheet(sheet1Name);
	       XSSFSheet sheet2 = workbook.getSheet(sheet2Name);
	        
	       
	       int numRows = sheet1.getPhysicalNumberOfRows();
	        int numCols = sheet1.getRow(0).getPhysicalNumberOfCells();
	        
	        // Iterate through rows and columns to compare data
	       // compareAndPrintDifferences(sheet1, sheet2);
	        captureConsoleOutput(() -> {
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
	                 
	                 

	        // Write captured console output to Excel
	        writeConsoleOutputToExcel("D://Selenium/abc.xlsx");
	                 }
	        	 }
	                 });
	        	 	 
	    }

	    private static void captureConsoleOutput(Runnable codeToRun) {
	        System.setOut(new java.io.PrintStream(System.out) {
	            public void println(String message) {
	                super.println(message);
	                consoleOutput.append(message).append("\n");
	            }
	        });

	        // Run the provided code, which may include System.out.println statements
	        codeToRun.run();
	    }

	    private static void writeConsoleOutputToExcel(String filePath) {
	        try {
	            // Create a new Excel workbook
	            Workbook workbook = new XSSFWorkbook();
	            // Create a sheet
	            Sheet sheet = workbook.createSheet("	");

	            // Split the console output into lines and write to Excel
	            String[] lines = consoleOutput.toString().split("\n");
	            for (int i = 0; i < lines.length; i++) {
	                Row row = sheet.createRow(i);
	                Cell cell = row.createCell(0);
	                cell.setCellValue(lines[i]);
	            }

	            // Save the workbook to a file
	            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
	                workbook.write(fileOut);
	            }

	            // Close the workbook
	            workbook.close();
	           
	           // System.out.println("Console output written to Excel successfully!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}