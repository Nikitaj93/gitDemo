
public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		
		// String Literal
		
		String s = "Niki Yogi USA India";
		
		String s1 = "Welcome";
		
		String s3 = new String("Welcome");
		
		String s4= new String("Welcome");
		
		String[] splittedString = s.split("Yogi");
		
			System.out.println(splittedString[0]);
			System.out.println(splittedString[1].trim());
		//System.out.println(splittedString[2]);
	
		// Reverse String
			
	    for(int i = s.length()-1; i>=0 ; i-- )
	      {
		   	System.out.println(s.charAt(i));
	      }
	
	   
	    
	    
	}

}
