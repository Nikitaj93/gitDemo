import java.io.IOException;
import java.util.ArrayList;

public class dataSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		dataDriven d = new dataDriven();  // to get data from dataDriven Test method
		
		//dataDrivencopied d1 = new dataDrivencopied();
		
	ArrayList data = d.getData("Add Profile");
		
	 //ArrayList data1= d1.getData1("werwer");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		
		// if want to give input to from excel 
		
		//driver.findElement(By.xpath("sdff")).sendkeys(data.get(1));

	}

}
