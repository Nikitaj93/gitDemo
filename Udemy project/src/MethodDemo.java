
public class MethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MethodDemo demo = new MethodDemo();
		SelIntro sel = new SelIntro();
		sel.getintro();
		
		demo.getdata();
		// we can store the value in variable and use later
		
		String name = demo.getData1();
		System.out.println(name);
		
		String state = sel.getintro();
		System.out.println(state);
	}
	
	//void doesnt return anything
	
	public void getdata()
	{
		System.out.println("Hello World");
	}
	
	// it returns value so we use String 
	public String getData1()
	{
		System.out.println("Hello Usa");
		return "I am in New york";
	}
	
	// Calling Methods from different page
	
	

}
