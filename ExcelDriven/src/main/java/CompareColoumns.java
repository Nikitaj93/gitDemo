

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class CompareColoumns {

    public static void main(String[] args) throws IOException {
        // Load Excel file
        FileInputStream file = new FileInputStream(new File("D://Selenium/TrailExcel.xlsx"));
      
        
        // Create workbook instance
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        // Specify the sheet to compare
        String sheetName = "TestSheet1";

        // Get the sheet
        XSSFSheet sheet = workbook.getSheet(sheetName);

        // Columns to compare
        //int[] columnIndices = {3, 7, 4, 8, 5, 9, 6, 10}; // 0-based indexing
        int[] columnIndices = {2,6, 3,7, 4,8, 5, 9}; // 0-based indexing
        // Compare columns and get differences
        List<String> differences = compareColumns(sheet, columnIndices);

        // Create a new workbook for differences
        XSSFWorkbook diffWorkbook = new XSSFWorkbook();
        XSSFSheet diffSheet = diffWorkbook.createSheet(sheetName);

        // Write differences to the new sheet
        writeDifferencesToSheet(differences, diffSheet);

        // Save the new workbook
        try (FileOutputStream outputStream = new FileOutputStream("D://Selenium/abc3.xlsx")) {
            diffWorkbook.write(outputStream);
        }

        // Close all resources
        file.close();
        diffWorkbook.close();

        System.out.println("Differences written to a new Excel file.");
    }

    private static List<String> compareColumns(XSSFSheet sheet, int[] columnIndices) {
        List<String> differences = new ArrayList<>();

        // Iterate through rows to compare column values
        Iterator<Row> iterator = sheet.iterator();

      while (iterator.hasNext()) {
        	
        	//for(int i=9; i<sheet.getPhysicalNumberOfRows() ; i++) {
            Row row = iterator.next();
            //System.out.println("row----"+row.getRowNum());
            if(row.getRowNum()>9) {

           // System.out.println(columnIndices.length);
            StringBuilder differenceBuilder = new StringBuilder();
          //  for (int i = 0; i < columnIndices.length; i += 2) {
            	  for (int i = 0; i < columnIndices.length; i +=2) {
                Cell cell1 = row.getCell(columnIndices[i]);
                Cell cell2 = row.getCell(columnIndices[i+1]);

                DecimalFormat df = new DecimalFormat("#");
                
                Double doubleValue1 = Double.parseDouble(cell1.toString());
                String roundedNumber1 = df.format(doubleValue1);
                
                Double doubleValue2 = Double.parseDouble(cell2.toString());
                String roundedNumber2 = df.format(doubleValue2);
               // System.out.println("double1  ---"+roundedNumber1);
               // System.out.println("double2  ---"+roundedNumber2);
             
                // Compare cell values
               if (!roundedNumber1.toString().equals(roundedNumber2.toString())) {
                    differenceBuilder.append("Row: ").append(row.getRowNum() + 1)
                            .append(", Column").append(columnIndices[i] + 1).append(" vs Column")
                            .append(columnIndices[i + 1] + 1).append("\n").append("  - Value1: ")
                            .append(roundedNumber1.toString()).append(", Value2: ")
                            .append(roundedNumber2.toString()).append("; ").append("\n");
                } 
                
           /*  // Compare cell values
                if (!cell1.toString().equals(cell2.toString())) {
                    differenceBuilder.append("Row: ").append(row.getRowNum())
                            .append(",--- Column").append(columnIndices[i]).append(" --- vs Column")
                            .append(columnIndices[i]).append(" --- Value1: ")
                            .append(cell1.toString()).append(",--- Value2: ")
                            .append(cell2.toString()).append("; ");
                }
                
                *  if (!roundedNumber1.toString().equals(roundedNumber2.toString())) {
                    differenceBuilder.append("Row: ").append(row.getRowNum() + 1)
                            .append(", Column").append(columnIndices[i] + 1).append(" vs Column")
                            .append(columnIndices[i + 1] + 1).append("\n").append("  - Value1: ")
                            .append(roundedNumber1.toString()).append(", Value2: ")
                            .append(roundedNumber2.toString()).append("; ").append("\n");
                } */
            }

            String difference = differenceBuilder.toString().trim();
            if (!difference.isEmpty()) {
                differences.add(difference);
            }
            //System.out.println(difference);
        }

      
      }
	return differences;
    }
    
    
    private static void writeDifferencesToSheet(List<String> differences, XSSFSheet diffSheet) {
    	
        int rownum = 1;
        Row headerRow = diffSheet.createRow(0);
      //  String[] headers = {"GSTIN", "Invoice No.", "Book - Sum of Tax value", "Book - Sum of IGST", "Book - Sum of CGST"};
        String[] headers = {"Location","Differences"};
     // Create cells for headers
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }
    for (String diff : differences) {
        	int rowcount = rownum++;
        	//System.out.println("diff-"+diff+"---number----"+rowcount);
        	 String[] parts = diff.split("-");
        	 System.out.println("length-"+parts.length);
             // Print each part
        	 int column = 0;
        	 Row row = diffSheet.createRow(rowcount);
             for (String part : parts) {
                 System.out.println("part--"+part);   
                 
                 writeData(diffSheet, rowcount, column++, part);
             }  
        	//System.out.println("diffee----"+diff);
//            Cell cell = row.createCell(0);
//            cell.setCellValue(diff);
//            
//            writeData(diffSheet, 0, 0, diff);
//            writeData(diffSheet, 0, 1, diff);
//            writeData(diffSheet, 0, 2, diff);
        }
   }

	private static void writeData(XSSFSheet diffSheet, int i, int j, String string) {
		// TODO Auto-generated method stub
		  Row row = diffSheet.getRow(i);
	        if (row == null) {
	            row = diffSheet.createRow(1);
	        }
	        Cell cell = row.createCell(j);
	        cell.setCellValue(string);
	}
}