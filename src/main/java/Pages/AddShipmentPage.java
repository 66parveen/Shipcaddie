package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.Base;
import Utility.TimeUtil;

public class AddShipmentPage extends Base{
	// LocatorValuesOfRequiredObjectForAddShipment
	@FindBy(xpath = "//span[text()='Add']")
    @CacheLookup
	WebElement addShipmentIcon;

	// ShipmentLocatorValues
	@FindBy(xpath = "//input[@id='orderNumberReference']")
	@CacheLookup
	WebElement orderNo;

	// RecipientLocatorValues
	@FindBy(xpath = "//input[@id='attentionOf']")
	 @CacheLookup
	WebElement recipient;
	
	@FindBy(xpath = "//input[@id='addressLine1']")
	@CacheLookup
	WebElement address;
	
	@FindBy(xpath = "//input[@name='postalCode']")
	@CacheLookup
	WebElement zip;
	
	@FindBy(xpath = "//input[@name='city']")
	@CacheLookup
	WebElement city;
	
	@FindBy(xpath = "//div[text()='Select state']")
	@CacheLookup
	WebElement state;
	
	@FindBy(xpath = "//div[text()='AA - Armed Forces Americas']")
	@CacheLookup
	WebElement selectedValue;
	
	@FindBy(xpath = "//input[@id='phone']")
	@CacheLookup
	WebElement phone;
	
	@FindBy(xpath = "//input[@id='autocomplete-address']")
	@CacheLookup
	WebElement searchAddress;
	
	@FindBy(xpath = "//button[text()='Use Entered']")
	@CacheLookup
	WebElement useEntered;
	
	@FindBy(xpath = "//a[text()='Save Changes']")
	@CacheLookup
	WebElement saveChanges;
	@FindBy(xpath = "//span[text()='remove']")
	WebElement removeAddressLink;

	// LocatrorValuesForPackagingElements
	@FindBy(xpath = "//i[@class='fa fa-calculator']")
	@CacheLookup
	WebElement calcIcon;
	
	@FindBy(xpath = "//input[@id='weightLbs']")
	@CacheLookup
	WebElement weight;
	
	@FindBy(xpath = "//input[@id='dimensionX']")
	@CacheLookup
	WebElement dimensionX;
	
	@FindBy(xpath = "//input[@id='dimensionY']")
	@CacheLookup
	WebElement dimensionY;
	
	@FindBy(xpath = "//input[@id='dimensionZ']")
	@CacheLookup
	WebElement dimensionZ;
	
	@FindBy(xpath = "//i[@class='fa fa-truck']")
	@CacheLookup
	WebElement orangeTruck;
	
	@FindBy(xpath = "//button[text()='Save for Later']")
	@CacheLookup
	WebElement saveLater;
	
	@FindBy(xpath = "//a[text()='Save']")
	@CacheLookup
	WebElement savePrinterOptions;
	
	@FindBy(xpath = "//span[text()='Print']")
	@CacheLookup
	WebElement print;
	
	@FindBy(xpath = "//a[text()='Printer Options']")
	@CacheLookup
	WebElement printerOptions;

	// RecipientLocatorValues
	@FindBy(xpath = "//input[@id='postalCode']")
	@CacheLookup
	WebElement postalCode;
	
	@FindBy(xpath = "//input[@id='city']")
	@CacheLookup
	WebElement cityVal;
	
	@FindBy(xpath = "//div[@id='usProvinceSelect']")
	@CacheLookup
	WebElement stateVal;
	
	@FindBy(xpath = "//input[@id='weightOz']")
	@CacheLookup
	WebElement OZ;
	
	
	// ConstructorToInitalizeVarialeAndMethods
	public AddShipmentPage()
	{
		PageFactory.initElements(driver, this);
	}

	// FunctionToClickOnAddShipmentIcon
	public void clickOnAddShipmentIcon() {
      TimeUtil.clickOn(driver, addShipmentIcon, 30);
		//addShipmentIcon.click();
	}

	// FunctionToTapEnterAddress
	public void enterAddress() {
		 TimeUtil.sendKeys(driver, address, 20,"2605 Executive Pkwy #160");
		//address.sendKeys("2605 Executive Pkwy #160");
	}

	// FunctionToEnterDimension
	public void enterDimension() {
		 TimeUtil.sendKeys(driver, dimensionX, 20,"10");
		 TimeUtil.sendKeys(driver, dimensionY, 20,"10");
		 TimeUtil.sendKeys(driver, dimensionZ, 20,"10");
		
		
		//dimensionX.sendKeys("10");
		//dimensionY.sendKeys("10");
		//dimensionZ.sendKeys("10");
	}

	// FunctionToClearDimension
	public void clearDimension() {
		dimensionX.clear();
		dimensionY.clear();
		dimensionZ.clear();
	}

	// FunctionToEnterWeight
	public void enterWeight() {
		 TimeUtil.sendKeys(driver, weight, 20,"20");
		//weight.sendKeys("20");
	}

	// FunctionToClearWeightField
	public void clearWeight() {
		weight.clear();
	}

	// FunctionToEnterOverWeight
	public void enterOverWeight() {
		 TimeUtil.sendKeys(driver, weight, 20,"71");
		//weight.sendKeys("71");
	}
	
	public void clearOZ()
	{
		OZ.clear();
	}

	// FunctionToClickOnCalCIcon
	public void clickOnCalcIcon() {
	    TimeUtil.clickOn(driver, calcIcon, 20);
		//calcIcon.click();
	}

	// FunctionToEnterZip
	public void enterPostalCode() {
		 TimeUtil.sendKeys(driver, postalCode, 20,"84043");
		//postalCode.sendKeys("84043");
	}

	// FunctionToEnterCity
	public void enterCity() {
		 TimeUtil.sendKeys(driver, cityVal, 20,"lehi");
		 //cityVal.sendKeys("lehi");
	}

	// FunctionToClearCity
	public void clearCity() {
		cityVal.clear();
	}

	// FunctionToTapSelectedAddress
	public void clearZip() {
		postalCode.clear();
	}

	// FunctionToTapSelectState
	public void selectState() throws InterruptedException {
		
		//state.click();
		 TimeUtil.clickOn(driver, cityVal, 20);
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//div[text()='AA - Armed Forces Americas']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	// FunctionToClickOnSearchAddress
	public void clickOnSearchAddress() {
		 TimeUtil.clickOn(driver, searchAddress, 20);

	}

	// FunctionToEnterAddress
	public void enterSearchAddress() {
		
		 TimeUtil.sendKeys(driver, searchAddress, 20,"654");
		//searchAddress.sendKeys("654");
	}

	// FunctionToTapSelectedAddress
	public void selectSearchAddress() {
		searchAddress.sendKeys(Keys.ARROW_DOWN);
		searchAddress.sendKeys(Keys.ENTER);
	}

	// FunctionToClickOnUseEntered
	public void clickOnUseEnteredButton() {
		 TimeUtil.clickOn(driver, useEntered, 20);
		//useEntered.click();
	}

	// FunctionToClickOnSaveChanges
	public void clickOnSaveChnages() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", saveChanges);
		//Thread.sleep(3000);
		 TimeUtil.clickOn(driver, saveChanges, 20);
		//saveChanges.click();
	}

	// FunctionToClickOnPrinterOptions
	public void clickOnPrinterOptions() {
		 TimeUtil.clickOn(driver, printerOptions, 20);
		//printerOptions.click();

	}

	// FunctionToClickOnSavePrinterOptions
	public void clickOnSavePrinterOptions() {
		 TimeUtil.clickOn(driver, savePrinterOptions, 20);
		//savePrinterOptions.click();

	}

	// FunctionToClearRemoveAddress
	public void clickOnRemoveAddress() {
		TimeUtil.clickOn(driver, removeAddressLink, 20);
		//removeAddressLink.click();

	}

	// FunctionToClickEnterKey
	public void tapEnter() {
		orderNo.sendKeys(Keys.ENTER);
	}

	// FunctionToEnterCustomerID
	public void addValidCustomerIDForShipment() {
		 TimeUtil.sendKeys(driver, searchAddress, 20,"9888");
		//searchAddress.sendKeys("9888");
		searchAddress.sendKeys(Keys.ARROW_DOWN);
		searchAddress.sendKeys(Keys.ENTER);

	}

	// FunctionToClickOnTruckIcon
	public void clickOnOrangeTruckIcon() {
		TimeUtil.clickOn(driver, orangeTruck, 20);
		//orangeTruck.click();
	}

	// FunctionToEnterReferenceNumber
	public void enterOrdRefNo() {
		 TimeUtil.sendKeys(driver, orderNo, 20,"DummyReferenceNo");
		//orderNo.sendKeys("DummyReferenceNo");
	}

	// FunctionToEnterRecipient
	
	public void enterRecipient1() {
		 TimeUtil.sendKeys(driver, recipient, 20,"dummyRecipient");
		//recipient.sendKeys("dummyRecipient");
	}

	// FunctionToEnterAddress
	public void enterAddress1() {
		
		 TimeUtil.sendKeys(driver, address, 20,"#305");
		//address.sendKeys("#305");
	}

	// FunctionToEnterZip
	public void enterZip1() {
		 TimeUtil.sendKeys(driver, postalCode, 20,"84043");
		//postalCode.sendKeys("84043");
	}

	// FunctionToEnterCity
	public void enterCity1() {
		 TimeUtil.sendKeys(driver, city, 20,"Lehi");
		//city.sendKeys("Lehi");
	}

	// FunctionToEnterPhone
	public void enterPhone1() {
		 TimeUtil.sendKeys(driver, phone, 20,"8264270071");
		//phone.sendKeys("8264270071");
	}

	// FunctionToClearReferenceNumberField
	public void clearOrder() {
		orderNo.clear();
	}

	// FunctionToClickOnSaveForLater
	public void clickOnSaveLater() {
		TimeUtil.clickOn(driver, saveLater, 20);
		//saveLater.click();
	}

	// FunctionToClickOnPrintButton
	public void clickOnPrintButton() {
		//print.click();
		TimeUtil.clickOn(driver, print, 30);
	}

}
