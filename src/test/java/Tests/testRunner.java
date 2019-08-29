package Tests;

import org.testng.TestNG;

public class testRunner {
	static TestNG testng;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    testng=new TestNG();
		testng.setTestClasses(new Class[]{TestImportShipment.class});
		testng.run();
		

	}

}
