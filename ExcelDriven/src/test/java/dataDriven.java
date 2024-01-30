import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	

	public ArrayList<String> getData(String testcaseName) throws IOException
	{
		ArrayList<String> a = new ArrayList<String>();
		//fileInputSteam argument
	
		FileInputStream fis = new FileInputStream("D://Selenium/DemoData.xlsx"); // Object will have permission to read file
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int Sheet =workbook.getNumberOfSheets();
		
		for(int i=0; i<Sheet; i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TestSheet1"))  // to make sure correct sheet is selected and operations are performed
			{
			XSSFSheet xsheet= workbook.getSheetAt(i);
			Iterator<Row> rows= xsheet.iterator();
			Row firstrow = rows.next();
			Iterator<Cell> cel = firstrow.cellIterator();
			int k =0;
			int coloumn = 0;
			while(cel.hasNext())
			{
				Cell value = cel.next();
				if(value.getStringCellValue().equalsIgnoreCase("TestCases")) // grab the coloumn
				{
					coloumn =k;
				}
				k++;
			}
			
			System.out.println(coloumn);
			
			while(rows.hasNext())
			{
				Row r = rows.next();
				System.out.println(r.getCell(coloumn).getStringCellValue());
				if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName))
				{
					Iterator<Cell> cv  = r.cellIterator();
					while(cv.hasNext())
					{
						//System.out.println(cv.next().getStringCellValue());
						a.add(cv.next().getStringCellValue());
						//System.out.println("This is enf=d");
					}
				}
			}
			
			System.out.println("This is enf=d");
		}
			
}
		return a;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
				}

}
