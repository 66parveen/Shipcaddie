package Tests;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.ImportOrdersPage;
import Pages.LoginPage;
import Testbase.Base;

public class TestImportOrders extends Base{
 
    LoginPage login;
	ImportOrdersPage order;
	

	public TestImportOrders()
	{
	super();	

	}
	
	@Parameters({"loginEmailValue", "loginPasswordValue"})
	@BeforeMethod
	public void setUp(String loginEmailValue, String loginPasswordValue) throws IOException, InterruptedException {
        intializeBrowser();
        login = PageFactory.initElements(driver, LoginPage.class);
		login.LoginIntoShipCaddie(loginEmailValue, loginPasswordValue);
		order= PageFactory.initElements(driver, ImportOrdersPage.class);
		
}
	
	
	@Test(priority=0)
	public void testOrdersTabIsDisplayed()
	{
		  WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h3[text()='Orders']")));

			boolean actual = element.isDisplayed();
			Assert.assertTrue(actual);
		
	}
	
	@Test(priority=1)
	public void testOrdersTabIsFunctional() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement orders=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Orders']")));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",orders);

		    //Thread.sleep(5000);
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h1[text()='Open Orders']")));

		 	boolean actual = element.isDisplayed();
			Assert.assertTrue(actual);
	}
	
	
	@Test(priority=2)
	public void testImportOrdersLinkDisplayed() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement orders=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Orders']")));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",orders);
	    //Thread.sleep(10000);

			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[text()='Import Orders']")));

		 	boolean actual = element.isDisplayed();
			Assert.assertTrue(actual);
	}
	
	
	
	@Test(priority=3)
	public void testImportOrdersLinkFunctional() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement orders=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Orders']")));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",orders);
		//Thread.sleep(20000);
		    order.clickOnImportOrdersLink();
			Thread.sleep(5000);
		  
			WebElement element=wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h1[text()='Open Orders']")));
            
		  boolean actual =element.isDisplayed();
			Assert.assertTrue(actual);
			

	}
	
	
	@Test(priority=4)
	public void testOrdersAreNotImportedWithoutCSV() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement orders=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Orders']")));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",orders);
		//Thread.sleep(20000);
		    order.clickOnImportOrdersLink();
			Thread.sleep(5000);
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@rv-show=\"areThereClientMaps\"]")));
			driver.findElement(By.xpath("//span[@rv-show=\"areThereClientMaps\"]")).click();
		 
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[text()='Please choose a CSV file to upload first']")));

		 	boolean actual = element.isDisplayed();
			Assert.assertTrue(actual);
	}
	
	@Test(priority=5)
	public void testOrdersAreImportedWithCSVFile() throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement orders=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Orders']")));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",orders);
		
		//Thread.sleep(20000);
		order.clickOnImportOrdersLink();
		//Thread.sleep(5000);
		WebElement csv=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Choose CSV File']")));
		js.executeScript("arguments[0].scrollIntoView(true);",csv);
		csv.click();
		Thread.sleep(10000);
		Runtime.getRuntime().exec("C:\\Users\\QA\\Desktop\\Order.exe");
		Thread.sleep(10000);
		WebElement change=driver.findElement(By.xpath("//a[text()='change']"));
		js.executeScript("arguments[0].scrollIntoView(true)",change);
		change.click();
		
		WebElement newCSV=driver.findElement(By.xpath("//a[text()='create a new csv mapper']"));
		js.executeScript("arguments[0].scrollIntoView(true)", newCSV);
		newCSV.click();
		
		
		//select Order Dat
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Choose a Field Name']")));
		driver.findElement(By.xpath("//span[text()='Choose a Field Name']")).click();
		//order.clickOnChooseField0();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='OrderDate'])[2]")).click();
		//order.clickOnOrderDate();
		
		
		Thread.sleep(2000);
		System.out.println("drop down for 'Order Date' is working");
		

		//select Order Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
		
		driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
		//order.clickOnChooseField1();
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='OrderNumber'])[2]")).click();
		//order.clickOnOrderNumber();
		
		Thread.sleep(2000);
		System.out.println("drop down for 'Order Number' is working");
		

		//select Attention Of
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='No Mapping'])[10]")));
		driver.findElement(By.xpath("(//span[text()='No Mapping'])[10]")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//li[text()='Name'])[2]")).click();
		 //order.clickOnName();
		Thread.sleep(2000);
		System.out.println("drop down for 'Attention Of' is working");
		

		//select Company
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='No Mapping'])[10]")));
		driver.findElement(By.xpath("(//span[text()='No Mapping'])[10]")).click();
		//order.clickOnNoMapping();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Company'])[2]")).click();
		//order.clickOnCompany();
		Thread.sleep(2000);
		System.out.println("drop down for 'Company' is working");
		

		//select Pho
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
		driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
		//order.clickOnChooseField1();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='PhoneNumber'])[2]")).click();
		//order.clickOnPhone();
		Thread.sleep(2000);
		System.out.println("drop down for 'Phone' is working");
		

		//select Email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='No Mapping'])[10]")));
		driver.findElement(By.xpath("(//span[text()='No Mapping'])[10]")).click();
		//order.clickOnNoMapping();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Email'])[2]")).click();
		//order.clickOnEmail();
		Thread.sleep(2000);
		System.out.println("drop down for 'Email' is working");
		

		//select Address Line 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
		driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
		//order.clickOnChooseField1();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Address1'])[2]")).click();
		//order.clickOnAddress1();
		Thread.sleep(2000);
		System.out.println("drop down for 'Address Line 1' is working");
		

		//select Address Line 2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='No Mapping'])[10]")));
		driver.findElement(By.xpath("(//span[text()='No Mapping'])[10]")).click();
		//order.clickOnNoMapping();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Address2'])[2]")).click();
		//order.clickOnAddress2();
		Thread.sleep(2000);
		System.out.println("drop down for 'Address Line 2' is working");
		

		//select City
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
		driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
		//order.clickOnChooseField1();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='City'])[2]")).click();
		//order.clickOnCity();
		Thread.sleep(2000);
		System.out.println("drop down for 'City' is working");
		

		//select Province
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
		driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
		//order.clickOnChooseField1();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='state'])[2]")).click();
		//order.clickOnState();
		Thread.sleep(2000);
		System.out.println("drop down for 'Province' is working");
		

		//select Postal Code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
		driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='ZipCode'])[2]")).click();
		Thread.sleep(2000);
		System.out.println("drop down for 'Postal Code' is working");
		

		//select Country Cod
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
		driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='Country'])[2]")).click();
		Thread.sleep(2000);
		System.out.println("drop down for 'Country Code' is working");
		

		//select Item SKU
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
		driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='ItemSKU'])[2]")).click();
		Thread.sleep(2000);
		System.out.println("drop down for 'Item Sku' is working");
		

		//select Item Quantity
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
		driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='ItemQTY'])[2]")).click();
		Thread.sleep(2000);
		System.out.println("drop down for 'Item Quantity' is working");
		

		//select Item Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
		driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[text()='ItemName'])[2]")).click();
		Thread.sleep(2000);
		System.out.println("drop down for 'Item Name' is working");
		

		//enter Mapper Nam

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("clientmapname")));
		driver.findElement(By.name("clientmapname")).sendKeys("testing_free");
		Thread.sleep(2000);
		System.out.println("'Mapper Name' button is working");
		

		//select Save CSV Mapper
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Save CSV Mapper']")));
		driver.findElement(By.xpath("//span[text()='Save CSV Mapper']")).click();
		Thread.sleep(10000);
		System.out.println("'Save CSV Mapper' button is working");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Added new CSV Map']")));
		//boolean actual=driver.findElement(By.xpath("//span[text()='Added new CSV Map']")).isDisplayed();
		//Assert.assertTrue(actual);
		System.out.println("verify 'Added new CSV Map' message is pass");
		

		//click Import Orders button
		
	
		
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("@rv-show=\"areThereClientMaps\"]")));
		//driver.findElement(By.xpath("//span[@rv-show=\"areThereClientMaps\"]")).click();
		driver.findElement(By.xpath("//span[text()='Import ']")).click();
		//driver.findElement(By.xpath("//span[text()='Import']")).click();
		//Thread.sleep(20000);
		System.out.println("'Import Orders' button is working");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Successfully Imported Orders']")));
		boolean actual2=driver.findElement(By.xpath("//span[text()='Successfully Imported Orders']")).isDisplayed();
		Assert.assertTrue(actual2);
		System.out.println("verify 'Successfully Imported Orders' message is pass");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}



	/*
	@Test(priority=0)
	public void orders() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebDriverWait wait=new WebDriverWait(driver,20);
	WebElement orders=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Orders']")));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",orders);
	Thread.sleep(10000);
	System.out.println("'Orders' button is working");
	}

	//click Import Orders button
	@Test(priority=1)
	public void importOrders() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebDriverWait wait=new WebDriverWait(driver,20);
	WebElement importOrders=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Import Orders']")));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",importOrders);
	Thread.sleep(4000);
	System.out.println("'Import Orders' button is working");
	}

	//click Choose CSV File button
	@Test(priority=2)
	public void chooseCSVFile() throws InterruptedException, IOException
	{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebDriverWait wait=new WebDriverWait(driver,20);	
	WebElement csv=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Choose CSV File']")));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);",csv);
	csv.click();
	Thread.sleep(2000);
	Runtime.getRuntime().exec("D:\\FileUploaderB1.exe");
	Thread.sleep(4000);
	System.out.println("'Choose CSV File' button is working");

	//click change button
	WebElement change=driver.findElement(By.xpath("//a[text()='change']"));
	js.executeScript("arguments[0].scrollIntoView(true)",change);
	change.click();
	Thread.sleep(1000);
	System.out.println("'Change' button is working");

	//click create a new csv mapper button
	WebElement newCSV=driver.findElement(By.xpath("//a[text()='create a new csv mapper']"));
	js.executeScript("arguments[0].scrollIntoView(true)", newCSV);
	newCSV.click();
	Thread.sleep(2000);
	System.out.println("'create a new csv mapper' button is working");
	}

	//select Order Date
	@Test(priority=3)
	public void selectOrderDate() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Choose a Field Name']")));
	driver.findElement(By.xpath("//span[text()='Choose a Field Name']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='OrderDate'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'Order Date' is working");
	}

	//select Order Number
	@Test(priority=4)
	public void selectOrderNumber() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
	driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='OrderNumber'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'Order Number' is working");
	}

	//select Attention Of
	@Test(priority=5)
	public void selectAttentionOf() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='No Mapping'])[10]")));
	driver.findElement(By.xpath("(//span[text()='No Mapping'])[10]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='Name'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'Attention Of' is working");
	}

	//select Company
	@Test(priority=6)
	public void selectCompany() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='No Mapping'])[10]")));
	driver.findElement(By.xpath("(//span[text()='No Mapping'])[10]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='Company'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'Company' is working");
	}

	//select Phone
	@Test(priority=7)
	public void selectPhoneNumber() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
	driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='PhoneNumber'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'Phone' is working");
	}

	//select Email
	@Test(priority=8)
	public void selectEmail() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='No Mapping'])[10]")));
	driver.findElement(By.xpath("(//span[text()='No Mapping'])[10]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='Email'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'Email' is working");
	}

	//select Address Line 1
	@Test(priority=9)
	public void selectAddressLine1() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
	driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='Address1'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'Address Line 1' is working");
	}

	//select Address Line 2
	@Test(priority=10)
	public void selectAddressLine2() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='No Mapping'])[10]")));
	driver.findElement(By.xpath("(//span[text()='No Mapping'])[10]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='Address2'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'Address Line 2' is working");
	}

	//select City
	@Test(priority=11)
	public void selectCity() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
	driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='City'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'City' is working");
	}

	//select Province
	@Test(priority=12)
	public void selectProvince() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
	driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='state'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'Province' is working");
	}

	//select Postal Code
	@Test(priority=13)
	public void selectPostalCode() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
	driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='ZipCode'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'Postal Code' is working");
	}

	//select Country Code
	@Test(priority=14)
	public void selectCountryCode() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
	driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='Country'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'Country Code' is working");
	}

	//select Item SKU
	@Test(priority=15)
	public void selectItemSKU() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
	driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='ItemSKU'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'Item Sku' is working");
	}

	//select Item Quantity
	@Test(priority=16)
	public void selectItemQuantity() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
	driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='ItemQTY'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'Item Quantity' is working");
	}

	//select Item Name
	@Test(priority=17)
	public void selectItemName() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Choose a Field Name'])[1]")));
	driver.findElement(By.xpath("(//span[text()='Choose a Field Name'])[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//li[text()='ItemName'])[2]")).click();
	Thread.sleep(2000);
	System.out.println("drop down for 'Item Name' is working");
	}

	//enter Mapper Name
	@Test(priority=18)
	public void mapperName() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("clientmapname")));
	driver.findElement(By.name("clientmapname")).sendKeys("testing_free");
	Thread.sleep(2000);
	System.out.println("'Mapper Name' button is working");
	}

	//select Save CSV Mapper
	@Test(priority=19)
	public void saveCSVMapper() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Save CSV Mapper']")));
	driver.findElement(By.xpath("//span[text()='Save CSV Mapper']")).click();
	Thread.sleep(2000);
	System.out.println("'Save CSV Mapper' button is working");

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Added new CSV Map']")));
	boolean actual=driver.findElement(By.xpath("//span[text()='Added new CSV Map']")).isDisplayed();
	Assert.assertTrue(actual);
	System.out.println("verify 'Added new CSV Map' message is pass");
	}

	//click Import Orders button
	@Test(priority=20)
	public void importOrders2() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@rv-show=\"areThereClientMaps\"]")));
	driver.findElement(By.xpath("//span[@rv-show=\"areThereClientMaps\"]")).click();
	Thread.sleep(5000);
	System.out.println("'Import Orders' button is working");

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Successfully Imported Orders']")));
	boolean actual=driver.findElement(By.xpath("//span[text()='Successfully Imported Orders']")).isDisplayed();
	Assert.assertTrue(actual);
	System.out.println("verify 'Successfully Imported Orders' message is pass");
	}
	*/

	
	
	







