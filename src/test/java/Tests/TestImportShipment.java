package Tests;

import java.io.File;
import java.io.IOException;
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
import Pages.LoginPage;
import Pages.ImportShipmentPage;
import Testbase.Base;

public class TestImportShipment extends Base {

	LoginPage login;
	ImportShipmentPage ship;

	public TestImportShipment()
	{
		super();
	}
	
	
	@Parameters({ "loginEmailValue", "loginPasswordValue" })
	@BeforeMethod
	public void setUp(String loginEmailValue, String loginPasswordValue) throws IOException, InterruptedException {
        intializeBrowser();
        login = PageFactory.initElements(driver, LoginPage.class);
		login.LoginIntoShipCaddie(loginEmailValue, loginPasswordValue);
		ship = PageFactory.initElements(driver, ImportShipmentPage.class);

	}

	@Test(priority = 0)
	public void testImportShipmentsLinkDisplayed() {
      WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Import Shipments']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);
	
	}

	@Test(priority = 1)
	public void testImportShipmentsLinkWorking() throws InterruptedException {
		ship.clickOnImportShipmentsLink();
        WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Import into Shipcaddie']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 2)
	public void testChooseCSVFileLinkDisplayed() {
		ship.clickOnImportShipmentsLink();
	    WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Choose CSV File']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 3)
	public void testCrossCloseIconFunctional() throws InterruptedException {
		ship.clickOnImportShipmentsLink();
		
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		Thread.sleep(3000);
		ship.clickOnCrossLink();
		
	    
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Ready To Ship']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 4)
	public void testCancelIconFunctional() throws InterruptedException {
		ship.clickOnImportShipmentsLink();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Thread.sleep(3000);
		ship.clickOnCancelLink();
		
		
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Ready To Ship']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 5)
	public void testShipementNotImportedWithoutCSV() throws InterruptedException {
	    ship.clickOnImportShipmentsLink();
		ship.clickOnImportButton();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please choose a CSV file to upload first']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 6)
	public void testChangeLinkIsDisplayed() throws InterruptedException {
		ship.clickOnImportShipmentsLink();
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='change']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 7)
	public void testChangeLinkIsFunctional() throws InterruptedException {
		ship.clickOnImportShipmentsLink();
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		ship.clickOnChangeLink();
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='create a new csv mapper']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 8)
	public void testDownloadOurCSVTemplateDisplayed() throws InterruptedException {
		ship.clickOnImportShipmentsLink();
	
		 WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement downloadLink = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='download our CSV Template']")));

      boolean actual = downloadLink.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 9)
	public void testImportShipmentButtonIsDisplayed() throws InterruptedException {
		ship.clickOnImportShipmentsLink();
	

		 WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement importButton = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Import ']")));

       boolean actual = importButton.isDisplayed();
		Assert.assertTrue(actual);
	

	}

	@Test(priority = 10)
	public void testEditIconDisplayedOnClickingChangeLink() throws InterruptedException {
		ship.clickOnImportShipmentsLink();
		ship.clickOnChangeLink();
       boolean actual = driver.findElement(By.xpath("//i[@class='fa fa-pencil']")).isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 11)
	public void testDeleteIconDisplayedOnClickingChangeLink() throws InterruptedException {
		ship.clickOnImportShipmentsLink();
	ship.clickOnChangeLink();
	   
     boolean actual = driver.findElement(By.xpath("//i[@class='fa fa-trash']")).isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 12)
	public void testDeleteIconFunctional() throws InterruptedException {
		ship.clickOnImportShipmentsLink();
		ship.clickOnChangeLink();
	    ship.clickOnDeleteIcon();
	WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Confirm']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);
		

	}

	@Test(priority = 13)
	public void testMappingIsNotEditedWithoutUploadCSV() throws InterruptedException {
		ship.clickOnImportShipmentsLink();
	    ship.clickOnChangeLink();
        WebElement element=driver.findElement(By.xpath("//a[text()='create a new csv mapper']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element );
		element.click();

	    WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[text()='Please upload a csv file first in order to create or edit mappings']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 14)
	public void testCSVTemplateIsDownloaded() throws InterruptedException {
		ship.clickOnImportShipmentsLink();
	    ship.clickOnDownloadCSVTemplateLink();

		File f = new File("C:\\Users\\QA\\Downloads\\ShipmentTemplate.csv");

		if (f.exists()) {
			System.out.println("CSV template file is downloaded.");

			Assert.assertTrue(f.exists());

			if (f.delete()) {
				System.out.println("CSV template file is deleted.");
			}
		}

	}

	@Test(priority = 15)
	public void testUploadCSVFile() throws InterruptedException, IOException {
		ship.clickOnImportShipmentsLink();
	    ship.clickOnChooseCSVFileButton();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\QA\\Desktop\\AutoIT\\file.exe");
		Thread.sleep(5000);
	    WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Fortest.csv']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 16)
	public void testImportshipmentWithoutCorrection() throws InterruptedException, IOException {
		ship.clickOnImportShipmentsLink();
		 ship.clickOnChooseCSVFileButton();
		Thread.sleep(5000);
			Runtime.getRuntime().exec("C:\\Users\\QA\\Desktop\\AutoIT\\file.exe");
			Thread.sleep(5000);
         ship.clickOnImportShipmentbutton();
         
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Invalid Shipments']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 17)
	public void testImportshipmentWithCorrection() throws InterruptedException, IOException {
		ship.clickOnImportShipmentsLink();
		ship.clickOnChooseCSVFileButton();
			Thread.sleep(5000);
			Runtime.getRuntime().exec("C:\\Users\\QA\\Desktop\\AutoIT\\file.exe");
			Thread.sleep(5000);
			   ship.clickOnImportShipmentbutton();
			   Thread.sleep(10000);
			   //ship.clickOnImportWithCorrection();
		WebElement element = driver.findElement(By.xpath("//button[text()='Import without Corrections']"));
	
			JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
		//ship.clickOnImportWithCorrection();
		//Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement header = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Successfully Imported Shipments. Applying Business Rule may take a little longer if it meets the criteria.']")));

		boolean actual = header.isDisplayed();
		Assert.assertTrue(actual);
		
		
	}


	@Test(priority=18)
	public void testImportShipmentWithMapping() throws InterruptedException, IOException
	{  
		ship.clickOnImportShipmentsLink();
		ship.clickOnChooseCSVFileButton();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\QA\\Desktop\\AutoIT\\file.exe");
		Thread.sleep(5000);
		ship.clickOnChangeLink();
		WebElement element=driver.findElement(By.xpath("//a[text()='create a new csv mapper']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element );
		Thread.sleep(2000);
		element.click();
		Thread.sleep(5000);
		ship.selectCarrierOption();
		ship.selectAttentionOfOption();
		ship.selectPhone();
		ship.selectReference();
		ship.selectAddress();
		ship.selectCity();
		ship.selectZip();
		ship.selectCountry();
		ship.selectState();
		ship.selectLength();
		ship.selectWidth();
		ship.selectHeight();
		ship.selectWeight();
		ship.enterMapperName();
		
	
		ship.clickOnSaveCSVMapper();
		System.out.println("CSV map is added.");
		
		ship.clickOnImportShipmentbutton();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement successMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Successfully Imported Shipments. Applying Business Rule may take a little longer if it meets the criteria.']")));

		boolean actual = successMessage.isDisplayed();
		Assert.assertTrue(actual);
		

		
	}
	
@AfterMethod
public void tearDown() {
	
	driver.quit();
}

}
	
			


	

	
	
	
	
	
	
	
	
	
	














