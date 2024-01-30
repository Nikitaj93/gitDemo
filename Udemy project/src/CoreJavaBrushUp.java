import java.util.ArrayList;

public class CoreJavaBrushUp {

	public static void main(String[] args) {

		// Data Type
		int num= 5;
		
		String nam ="Nikita";
		char letter ='r';
		double dec= 5.69;
		boolean card=true;
		
		System.out.println(num+"is the number od data type"); // + is imp to print number and string together
		
		//Arrays
		
		int[] arr = new int [5];
		arr[0]=1;
		arr[1]=3;
		arr[2]=0;
		arr[3]=6;
		arr[4]=4;
		
		// or we can print arrays as below
		
		int[] arr2 = {1,3,0,6,4};
		
		System.out.println(arr[4]);
		System.out.println(arr2[3]);
		
		
		//For loop
		
		for(int i=0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
			
		}
		
		// String in for loop
		
		String[] name = {"Nikita","Yogi","Niki","parikh"};
		
		for(int i=0;i<name.length; i++)
		{
			System.out.println(name[i]);
		}
		
		
		
		// Using If in for loop to get all the number divided by 2
		
		int[] arr3= {1,2,4,5,6,7,8,9,10};
		
		for(int i=0; i<arr3.length; i++)
		{
			if (arr3[i] % 2==0)
			{
			System.out.println(arr3[i]);
			break;
		}else
		{
			System.out.println(arr3[i]+ "Is not multiple of 2");
		}
		}
		
		// Dynamic Array using Array list
		
		ArrayList<String> a = new ArrayList<String>();
		
		a.add("Pune");
		a.add("Mumbai");
		a.add("Delhi");
		
		System.out.println(a.get(1));
		
	for(int i =0; i<a.size();i++)
	{
		System.out.println(a.get(i));
	}
		
	System.out.println("***********");
	// Enhanced for loop
	
	for(String val : a)
	{
		System.out.println(val);
	}
		
	// check if the text is present in the array list
	System.out.println(a.contains("Pune"));
	
	
	
	
	}

}
