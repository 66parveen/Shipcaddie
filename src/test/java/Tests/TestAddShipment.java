package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.AddShipmentPage;
import Pages.ImportShipmentPage;
import Testbase.Base;
import Utility.MScreenRecorder;
import Utility.TimeUtil;

public class TestAddShipment extends Base {

	ImportShipmentPage ship;
	AddShipmentPage calc;
	LoginPage login;

public TestAddShipment()
{
super();	

}

	@Parameters({ "loginEmailValue", "loginPasswordValue" })
	@BeforeMethod
	public void setUp(String loginEmailValue, String loginPasswordValue) throws Exception {
		intializeBrowser();

		login = PageFactory.initElements(driver, LoginPage.class);
		login.LoginIntoShipCaddie(loginEmailValue, loginPasswordValue);

		ship = PageFactory.initElements(driver, ImportShipmentPage.class);
		calc = PageFactory.initElements(driver, AddShipmentPage.class);
	}

	@Test(priority = 0)
	public void testAddShipmentButtonIsDisplayedTC14() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add']")));

		boolean actual = element.isDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 1)
	public void testAddShipmentIconFunctionalTC15() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();

		String ActualTitle = driver.getTitle();
		String ExpectedTitle ="Ready To Ship";

		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	@Test(priority = 2)
	public void testAddShipmentWithInvalidReferenceNoTC16() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		ship.EnterInvalidReferenceNumber();
		ship.tapEnterInReferenceNumberField();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Reference number entry not found.']")));

		boolean actual = element.isDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 3)
	public void testAddShipmentWithValidReferenceNoTC17() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		ship.EnterValidReferenceNumber();
		ship.tapEnterInReferenceNumberField();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h5[text()='Multiple Orders/Shipments Found. Please Choose One. ']")));

		boolean actual = ele.isDisplayed();

		Assert.assertTrue(actual);
	}

	@Test(priority = 4)
	public void blindShipIconDisplayedTC18() throws InterruptedException {
		//Thread.sleep(5000);
		ship.clickOnAddShipPlusIcon();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='isBlindShip']")));

		boolean actual = element5.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 5)
	public void testBlindShipIconFunctionalTC19() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		//Thread.sleep(10000);
		ship.clickOnBlindShip();

		boolean actual = driver.findElement(By.xpath("//label[@for='isBlindShip']")).isEnabled();
		Assert.assertTrue(actual);

	}

	@Test(priority = 6)
	public void testValidationOFPrintButtonWithoutDetailsTC20() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		ship.clickOnPrintButton();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element7 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='blurbtext']")));

		boolean actual = element7.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 7)
	public void testValidationOFSaveForLaterTC21() throws InterruptedException {

		ship.clickOnAddShipPlusIcon();
		ship.clickOnSaveForLater();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement successMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Shipment Successfully Added']")));

		boolean actual = successMessage.isDisplayed();
		Assert.assertTrue(actual);
		
	

	}

	@Test(priority = 8)
	public void testAddShipmentWithoutDetails() throws InterruptedException {

		calc.clickOnAddShipmentIcon();
	    calc.clickOnPrintButton();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement errorMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please correct the fields in red']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 9)
	public void testWeightLimitByDefault() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement wtLimit = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='70 lbs limit']")));

		boolean actual = wtLimit.isDisplayed();
		Assert.assertTrue(actual);

	
	}


	
	@Test(priority = 10)
	public void testShippingRateCalIconDisplayedOnAddShipement() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
      
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement calcIcon = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-calculator']")));

		boolean actual = calcIcon.isDisplayed();
		Assert.assertTrue(actual);
		
	}

	@Test(priority = 11)
	public void testRateCalWithoutWeightAndDimensions() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		calc.clickOnCalcIcon();
	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement errorMessage= wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please correct the fields in red']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);
		

	}

	@Test(priority = 12)
	public void testRateCalWithoutWeight() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		//calc.clearOZ();
		calc.clickOnCalcIcon();


		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement errorMessage= wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please correct the fields in red']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 13)
	public void testRateCalWithoutSize() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement selectShipSite=driver.findElement(By.xpath("//select[@name='clientAddressId']"));
		//wait.until(ExpectedConditions.elementToBeSelected(selectShipSite));
	
	
		TimeUtil.fn_Select1(selectShipSite, "&^&");
		calc.enterWeight();
		//calc.clearDimension();
		calc.clickOnCalcIcon();
	

	
		WebElement errorMessage= wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please correct the fields in red']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 14)
	public void testRateCalWithOverWeight() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		calc.enterOverWeight();
		calc.clickOnCalcIcon();
		calc.clickOnCalcIcon();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement errorMessage= wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='blurbtext']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);


	}
	

	@Test(priority = 15)
	public void testAddShipmentWithoutState() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		calc.enterAddress1();
		calc.enterPostalCode();
		calc.enterCity();
		calc.enterPhone1();
		calc.enterRecipient1();
		calc.enterWeight();
		//calc.enterDimension();
		calc.clickOnPrintButton();
	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement errorMessage= wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='blurbtext']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 16)
	public void testAddShipmentWithoutCity() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		calc.enterAddress1();
		calc.enterPostalCode();
		//calc.enterCity();
		calc.enterPhone1();
		calc.enterRecipient1();
		calc.enterWeight();
		calc.clickOnPrintButton();
	

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement errorMessage= wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='blurbtext']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);
	}

	@Test(priority = 17)
	public void testAddShipmentWithoutZip() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		calc.enterAddress1();
		//calc.enterPostalCode();
		calc.enterCity();
		calc.enterPhone1();
		calc.enterRecipient1();
		calc.enterWeight();
		calc.clickOnPrintButton();
		

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement errorMessage= wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please fill all required details from following: Address, City, State, Zip and Country to verify your address']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);
	
	}

	@Test(priority = 18)
	public void testAddShipmentWithoutAddress() throws Exception {
		ship.clickOnAddShipPlusIcon();
		MScreenRecorder.startRecording("testAddShipmentWithoutAddress");
		//calc.enterAddress1();
		calc.enterPostalCode();
		calc.enterCity();
		calc.enterPhone1();
		calc.enterRecipient1();
		calc.enterWeight();
		calc.clickOnPrintButton();
		

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement errorMessage= wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please fill all required details from following: Address, City, State, Zip and Country to verify your address']")));

		boolean actual = errorMessage.isDisplayed();
		Assert.assertTrue(actual);

		MScreenRecorder.stopRecording();
	}

	@Test(priority = 19)
	public void testUserIsAbleToAddRecipientInfoFromContacts() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		calc.clickOnSearchAddress();
		calc.enterSearchAddress();
		calc.selectSearchAddress();
		 calc.clickOnUseEnteredButton();
		 Thread.sleep(5000);
		calc.clickOnSaveChnages();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement successMessage= wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Successfully Saved Address']")));

		boolean actual = successMessage.isDisplayed();
		Assert.assertTrue(actual);

	

	}

	@Test(priority = 20)
	public void testUserIsAbleToRemoveAddedRecipientInfo() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		calc.clickOnSearchAddress();
		calc.enterSearchAddress();
		calc.selectSearchAddress();
		calc.clickOnUseEnteredButton();
		calc.clickOnSaveChnages();
	
		calc.clickOnRemoveAddress();

		boolean actual = driver.findElement(By.xpath("//input[@id='autocomplete-address']")).isDisplayed();
		Assert.assertTrue(actual);

	}
	
	

	//till here done.....
	@Test(priority = 21)
	public void testRecipientInfoNotSavedWithoutName() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
        // Thread.sleep(10000);
		calc.enterPostalCode();
		calc.enterCity();
		calc.selectState();
		calc.enterAddress();
		calc.enterPhone1();
	calc.clickOnUseEnteredButton();
		//Thread.sleep(10000);
		calc.clickOnPrintButton();

		//Thread.sleep(5000);
		boolean actual = driver.findElement(By.xpath("//span[text()='Please fill either Recipient or Organization.']"))
				.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 22)
	public void testRateCalcWithoutSizeAndWeightDetails() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		calc.clickOnCalcIcon();
		//Thread.sleep(5000);

		boolean actual = driver.findElement(By.xpath("//span[text()='Please correct the fields in red']"))
				.isDisplayed();
		Assert.assertTrue(actual);

	}

	/*
	 * @Test(priority = 23) public void testvalidRateCalcAndshipement() throws
	 * InterruptedException { AddShipment calc = PageFactory.initElements(driver,
	 * AddShipment.class); Thread.sleep(5000);
	 * calc.addValidReferenceNumberForShip(); calc.tapEnter(); Thread.sleep(10000);
	 * 
	 * calc.clickOnCalcIcon(); Thread.sleep(5000); calc.clickOnOrangeTruckIcon();
	 * Thread.sleep(5000);
	 * 
	 * boolean actual =
	 * driver.findElement(By.xpath("//span[contains(text(),'$13.95')]")).isDisplayed
	 * (); Assert.assertTrue(actual); System.out.println("Rate is caluclated."); }
	 */

	@Test(priority = 23)
	public void testValidAddShipment() throws Exception {

		//Thread.sleep(20000);
		calc.clickOnAddShipmentIcon();
		//Thread.sleep(5000);
		// calc.clearOrder();
		calc.enterOrdRefNo();

		WebElement e = driver.findElement(By.xpath("//select[@id='clientAddressId']"));
		Select sel = new Select(e);
		sel.selectByVisibleText("27-05-2019 shipping site 2");

		calc.enterRecipient1();
		calc.enterAddress1();
		calc.enterZip1();
		calc.enterCity1();
		calc.selectState();
		calc.enterPhone1();
		Thread.sleep(10000);

		/*
		 * driver.findElement(By.xpath("//div[text()='Select state']")).click();
		 * WebElement ele =
		 * driver.findElement(By.xpath("//div[text()='AA - Armed Forces Americas']"));
		 * JavascriptExecutor executor = (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].click();", ele);
		 */
		// calc.clickOnSearchAddress();
		// calc.enterSearchAddress();

		// calc.selectSearchAddress();
		calc.clickOnUseEnteredButton();
		// calc.clickOnSaveChnages();
		//Thread.sleep(5000);

		calc.enterDimension();
		calc.enterWeight();
		//Thread.sleep(5000);

		calc.clickOnSaveLater();

		//Thread.sleep(10000);

		boolean actual = driver.findElement(By.xpath("//span[text()='Shipment Successfully Added']")).isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 24)
	public void testPrinterOptionsDisplayed() throws InterruptedException  {
		calc.clickOnAddShipmentIcon();
		//Thread.sleep(10000);
		boolean actual = driver.findElement(By.xpath("//a[@class='PrinterOptions']")).isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 25)
	public void testPrinterOptionsFunctional() throws InterruptedException {
		calc.clickOnAddShipmentIcon();
		//Thread.sleep(10000);

		calc.clickOnPrinterOptions();
		//Thread.sleep(5000);

		boolean actual = driver.findElement(By.xpath("//h2[text()='Printer Options']")).isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 26)
	public void testPrintetSetUPSaved() throws InterruptedException {
		ship.clickOnAddShipPlusIcon();
		//Thread.sleep(10000);
		calc.clickOnPrinterOptions();
		//Thread.sleep(5000);
		calc.clickOnSavePrinterOptions();
		//Thread.sleep(5000);
		
        boolean actual = driver.findElement(By.xpath("//span[text()='Successfully Saved Printer Configurations']"))
				.isDisplayed();
		Assert.assertTrue(actual);

	}

/*
@AfterMethod
public void tearDown() {
 
  driver.quit();
}
*/
}