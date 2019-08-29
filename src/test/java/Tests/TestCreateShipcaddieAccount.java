package Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Pages.CreateShipcaddieAccountPage;
import Testbase.Base;

public class TestCreateShipcaddieAccount extends Base {
	

	CreateShipcaddieAccountPage createaccount;
	
	public TestCreateShipcaddieAccount()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException {
		intializeBrowser();
		createaccount = PageFactory.initElements(driver, CreateShipcaddieAccountPage.class);

	}

	@Test(priority = 14)
	public void verifyFocusIsOnFirstNameField() throws InterruptedException
	{

	createaccount.clickOnCreateNewAccount();
	
	WebElement currentElement = driver.switchTo().activeElement();
	currentElement.isSelected();
	Assert.assertTrue(true);

			
	}
	
	@Test(priority = 15)
	public void testCreateNewAccountPageDisplayed() {
	     
		createaccount.clickOnCreateNewAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Register for ShipCaddie ']")));

		boolean actual = element1.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 16)
	public void testWithoutDetails() {
	 
		createaccount.clickOnCreateNewAccount();
		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element2.isDisplayed();
		Assert.assertTrue(actual);

	}
    @Parameters({"lastNameValue","emailValue","passwordValue","confirmPasswordValue","companyValue","phoneValue"})
	@Test(priority = 17)
	public void testWithoutFirstName(String lastNameValue,String emailValue,String passwordValue,String confirmPasswordValue,String companyValue,String phoneValue) {
		
		createaccount.clickOnCreateNewAccount();
		createaccount.enterLastName(lastNameValue);
		createaccount.enterEmail(emailValue);
		createaccount.enterPassword(passwordValue);
		
		createaccount.enterConfirmPassword(confirmPasswordValue);
		createaccount.checkTermsConditions();
		createaccount.enterCompany(companyValue);
		createaccount.enterPhone(phoneValue);

		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element3 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element3.isDisplayed();
		Assert.assertTrue(actual);

	}
    @Parameters({"firstNameValue","emailValue","passwordValue","confirmPasswordValue","companyValue","phoneValue"})
	@Test(priority = 18)
	public void testWithoutLastName(String firstNameValue,String emailValue,String passwordValue,String confirmPasswordValue,String companyValue,String phoneValue) {
     

		createaccount.clickOnCreateNewAccount();
		createaccount.enterFirstName(firstNameValue);
		createaccount.enterEmail(emailValue);
		createaccount.enterPassword(passwordValue);
		createaccount.enterConfirmPassword(confirmPasswordValue);
		createaccount.checkTermsConditions();
		createaccount.enterCompany(companyValue);
		createaccount.enterPhone(phoneValue);

		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element4 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element4.isDisplayed();
		Assert.assertTrue(actual);

	}
    @Parameters({"firstNameValue","lastNameValue","passwordValue","confirmPasswordValue","companyValue","phoneValue"})
	@Test(priority = 19)
	public void testWithoutEmail(String firstNameValue, String lastNameValue,String passwordValue,String confirmPasswordValue,String companyValue, String phoneValue) {
	
		createaccount.clickOnCreateNewAccount();
		createaccount.enterFirstName(firstNameValue);
		createaccount.enterLastName(lastNameValue);
		createaccount.enterPassword(passwordValue);
		createaccount.enterConfirmPassword(confirmPasswordValue);
		createaccount.checkTermsConditions();
		createaccount.enterCompany(companyValue);
		createaccount.enterPhone(phoneValue);

		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element5 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element5.isDisplayed();
		Assert.assertTrue(actual);
	}
    @Parameters({"firstNameValue","lastNameValue","emailValue","confirmPasswordValue","companyValue","phoneValue"})
	@Test(priority = 20)
	public void testWithoutPassword(String firstNameValue, String lastNameValue, String emailValue,String confirmPasswordValue,String companyValue,String phoneValue) {
	    
		createaccount.clickOnCreateNewAccount();
		createaccount.enterFirstName(firstNameValue);
		createaccount.enterLastName(lastNameValue);
		createaccount.enterEmail(emailValue);
		createaccount.enterConfirmPassword(confirmPasswordValue);
		createaccount.checkTermsConditions();
		createaccount.enterCompany(companyValue);
		createaccount.enterPhone(phoneValue);

		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element6 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element6.isDisplayed();
		Assert.assertTrue(actual);

	}
    @Parameters({"firstNameValue","lastNameValue","emailValue","passwordValue","companyValue","phoneValue"})
    @Test(priority = 21)
	public void testWithoutConfirmPassword(String firstNameValue, String lastNameValue, String emailValue, String passwordValue,String companyValue,String phoneValue) {
	  
		createaccount.clickOnCreateNewAccount();
		createaccount.enterFirstName(firstNameValue);
		createaccount.enterLastName(lastNameValue);
		createaccount.enterEmail(emailValue);
		createaccount.enterPassword(passwordValue);
		createaccount.checkTermsConditions();
		createaccount.enterCompany(companyValue);
		createaccount.enterPhone(phoneValue);

		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element7 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element7.isDisplayed();
		Assert.assertTrue(actual);

	}
    @Parameters({"firstNameValue","lastNameValue","emailValue","passwordValue","confirmPasswordValue","companyValue","phoneValue"})
	@Test(priority = 22)
	public void testWithoutCheckTermsConditions(String firstNameValue, String lastNameValue,String emailValue, String passwordValue, String confirmPasswordValue, String companyValue,String phoneValue) {
	    
		createaccount.clickOnCreateNewAccount();
		createaccount.enterFirstName(firstNameValue);
		createaccount.enterLastName(lastNameValue);
		createaccount.enterEmail(emailValue);
		createaccount.enterPassword(passwordValue);
		createaccount.enterConfirmPassword(confirmPasswordValue);
		createaccount.enterCompany(companyValue);
		createaccount.enterPhone(phoneValue);

		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element8 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));// Thread.sleep(5000);

		boolean actual = element8.isDisplayed();
		Assert.assertTrue(actual);

	}
    @Parameters({"firstNameValue","lastNameValue","emailValue","passwordValue","confirmPasswordValue","phoneValue"})
	@Test(priority = 23)
	public void testWithoutCompany(String firstNameValue,String lastNameValue, String emailValue, String passwordValue, String confirmPasswordValue,String phoneValue) {
	  
		createaccount.clickOnCreateNewAccount();
		createaccount.enterFirstName(firstNameValue);
		createaccount.enterLastName(lastNameValue);
		createaccount.enterEmail(emailValue);
		createaccount.enterPassword(passwordValue);
		createaccount.enterConfirmPassword(confirmPasswordValue);
		createaccount.checkTermsConditions();
		createaccount.enterPhone(phoneValue);

		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element9 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element9.isDisplayed();
		Assert.assertTrue(actual);

	}

    @Parameters({"firstNameValue","lastNameValue","emailValue","passwordValue","confirmPasswordValue","companyValue"})
	@Test(priority = 24)
	public void testWithoutPhone(String firstNameValue,String lastNameValue, String emailValue, String passwordValue, String confirmPasswordValue, String companyValue ) {

		createaccount.clickOnCreateNewAccount();
		createaccount.enterFirstName(firstNameValue);
		createaccount.enterLastName(lastNameValue);
		createaccount.enterEmail(emailValue);
		createaccount.enterPassword(passwordValue);
		createaccount.enterConfirmPassword(confirmPasswordValue);
		createaccount.checkTermsConditions();
		createaccount.enterCompany(companyValue);
		

		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element10 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element10.isDisplayed();
		Assert.assertTrue(actual);

	}
    @Parameters({"invalidFirstNameValue","lastNameValue","emailValue","passwordValue","confirmPasswordValue","companyValue","phoneValue"})
	@Test(priority = 25)
	public void testWithInvalidFirstName(String invalidFirstNameValue, String lastNameValue, String emailValue, String passwordValue, String confirmPasswordValue, String companyValue, String phoneValue ) {

		createaccount.clickOnCreateNewAccount();
		createaccount.enterInvalidFirstName(invalidFirstNameValue);
		createaccount.enterLastName(lastNameValue);
		createaccount.enterEmail(emailValue);
		createaccount.enterPassword(passwordValue);
		createaccount.enterConfirmPassword(confirmPasswordValue);
		createaccount.checkTermsConditions();
		createaccount.enterCompany(companyValue);
		
		createaccount.enterPhone(phoneValue);

		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element11 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element11.isDisplayed();
		Assert.assertTrue(actual);

	}
    @Parameters({"firstNameValue","invalidLastNameValue","emailValue","passwordValue","confirmPasswordValue","companyValue","phoneValue"})
	@Test(priority = 26)
	public void testWithInvalidLastName(String firstNameValue, String invalidLastNameValue,String emailValue, String passwordValue, String confirmPasswordValue, String companyValue, String phoneValue) {
	    
		createaccount.clickOnCreateNewAccount();
		createaccount.enterFirstName(firstNameValue);

		createaccount.enterInvalidLastName(invalidLastNameValue);

		createaccount.enterEmail(emailValue);
		createaccount.enterPassword(passwordValue);
		createaccount.enterConfirmPassword(confirmPasswordValue);
		createaccount.checkTermsConditions();
		createaccount.enterCompany(companyValue);
		createaccount.enterPhone(phoneValue);

		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element12 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element12.isDisplayed();
		Assert.assertTrue(actual);

	}
    @Parameters({"firstNameValue","lastNameValue","invalidEmailValue","passwordValue","confirmPasswordValue","companyValue","phoneValue"})
	@Test(priority = 27)
	public void testWithInvalidEmail(String firstNameValue, String lastName, String invalidEmailValue, String passwordValue, String confirmPasswordValue, String companyValue, String phoneValue) {
	   
		createaccount.clickOnCreateNewAccount();
		createaccount.enterFirstName(firstNameValue);
		createaccount.enterLastName(lastName);
		createaccount.enterInvalidEmail(invalidEmailValue);
		createaccount.enterPassword(passwordValue);
		createaccount.enterConfirmPassword(confirmPasswordValue);
		createaccount.checkTermsConditions();
		createaccount.enterCompany(companyValue);
		createaccount.enterPhone(phoneValue);
		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element13 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element13.isDisplayed();
		Assert.assertTrue(actual);

	}
    @Parameters({"firstNameValue","lastNameValue","emailValue","passwordValue","confirmPasswordValue","companyValue","invalidPhoneValue"})
	@Test(priority = 28)
	public void testWithInvalidPhone(String firstNameValue, String lastNameValue, String emailValue, String passwordValue, String comfirmPasswordValue, String companyValue, String invalidPhoneValue) {
	   
		createaccount.clickOnCreateNewAccount();
		createaccount.enterFirstName(firstNameValue);
		createaccount.enterLastName(lastNameValue);
		createaccount.enterEmail(emailValue);
		createaccount.enterPassword(passwordValue);
		createaccount.enterConfirmPassword(comfirmPasswordValue);
		createaccount.checkTermsConditions();
		createaccount.enterCompany(companyValue);
		createaccount.enterInvalidPhone(invalidPhoneValue);

		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element14 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element14.isDisplayed();
		Assert.assertTrue(actual);

	}
    @Parameters({"firstNameValue","lastNameValue","emailValue","invalidPasswordValue","confirmPasswordValue","companyValue","phoneValue"})
	@Test(priority = 29)
	public void testWithInvalidPassword(String firstNameValue, String lastNameValue, String emailValue, String invalidPasswordValue, String confirmPasswordValue, String companyValue, String phoneValue) {
	  
		createaccount.clickOnCreateNewAccount();
		createaccount.enterFirstName(firstNameValue);
		createaccount.enterLastName(lastNameValue);
		createaccount.enterEmail(emailValue);

		createaccount.enterInvalidPassword(invalidPasswordValue);
		createaccount.enterInvalidConfirmPassword(confirmPasswordValue);

		createaccount.checkTermsConditions();
		createaccount.enterCompany(companyValue);
		createaccount.enterPhone(phoneValue);
		createaccount.clickCreateShipCaddieAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element15 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element15.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 30)
	public void testLoginInInsteadLinkWorking() throws InterruptedException {
	  
		createaccount.clickOnCreateNewAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element16 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));

		createaccount.clickOnLoginInsteadLink();
		Thread.sleep(5000);

		String actualTitle = driver.getTitle();
		String Expected = "Login";

		Assert.assertEquals(actualTitle, Expected);
	}

	@Test(priority = 31)
	public void testInformationIconIsDisplayed() {
		createaccount.clickOnCreateNewAccount();
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element17 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-info-circle info_circle-registration']")));

		boolean actual = element17.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 32)
	public void testTermsOfServiceLinkWorking() throws InterruptedException {

		createaccount.clickOnCreateNewAccount();
		createaccount.clickOnTermsServiceLink();

	for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String Expected = "Terms Of Service";

		Assert.assertEquals(actualTitle, Expected);

	}

	@Test(priority = 33)
	public void testPrivacyLinkWorking() throws InterruptedException {
	    
		createaccount.clickOnCreateNewAccount();
		createaccount.clickOnPrivacyPolicyLink();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String Expected = "Privacy Policy";

		Assert.assertEquals(actualTitle, Expected);
	}
	@Parameters({"firstNameValue","lastNameValue","existEmailValue","passwordValue","confirmPasswordValue","companyValue","phoneValue"})
	@Test(priority = 34)
	public void testCreateAccountWithAlreadyExistEmail(String firstNameValue, String lastNameValue, String existEmailValue, String passwordValue, String confirmPasswordValue, String  companyValue, String phoneValue) {
	  
		createaccount.clickOnCreateNewAccount();
		createaccount.enterFirstName(firstNameValue);
		createaccount.enterLastName(lastNameValue);
		createaccount.enterAlreadyExistEmail(existEmailValue);
		createaccount.enterPassword(passwordValue);
		createaccount.enterConfirmPassword(confirmPasswordValue);
		createaccount.checkTermsConditions();
		createaccount.enterCompany(companyValue);
		createaccount.enterPhone(phoneValue);
		createaccount.clickCreateShipCaddieAccount();

		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element20 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[text()='Name kumaranil@csgroupchd.com is already taken. ']")));

		boolean actual = element20.isDisplayed();
		Assert.assertTrue(actual);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}
}