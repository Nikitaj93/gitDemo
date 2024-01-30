package TestPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ItestListener interface implements TestNG Listeners

public class Listeners implements ITestListener{
	
	
	  @Override		
	    public void onFinish(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
		  System.out.println("This Test IS Finished"+ arg0.getName());
	    }		

	    @Override		
	    public void onStart(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailure(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        	System.out.println("This Test IS Failed"+ arg0.getName());
	    }		

	    @Override		
	    public void onTestSkipped(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestStart(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestSuccess(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		System.out.println("All the Test case is passed");
	    }		
	

}
