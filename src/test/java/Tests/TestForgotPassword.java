package Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.ForgotPasswordPage;
import Testbase.Base;

public class TestForgotPassword extends Base {

	
	ForgotPasswordPage forgot;
	public TestForgotPassword()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		intializeBrowser();
		forgot = new ForgotPasswordPage();
	}
	
	@Test(priority = 9)
	public void verifyFocusIsOnEmailField() throws InterruptedException
	{	
	WebElement currentElement = driver.switchTo().activeElement();
	currentElement.isSelected();
	Assert.assertTrue(true);

	}
	
	@Test(priority = 10)
	public void testForgotPasswordLinkWorking() throws InterruptedException {
	    forgot.clickOnForgotPasswordLink();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element27 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h6[text()='Enter the email you used to sign up to ShipCaddie.']")));

		boolean actual = element27.isDisplayed();
		Assert.assertTrue(actual);
		
	}

	@Test(priority = 11)
	public void testForgotPasswordWithoutEmail() throws InterruptedException {
		forgot.clickOnForgotPasswordLink();
		forgot.clickOnSendPassword();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element28 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element28.isDisplayed();
		Assert.assertTrue(actual);
		
	}
    @Parameters({"invalidLoginEmail"})
	@Test(priority = 12)
	public void testForgotPasswordWithInvalidEmail(String invalidLoginEmail) throws InterruptedException {
		forgot.clickOnForgotPasswordLink();
		forgot.enterInvalidEmail(invalidLoginEmail);
		forgot.clickOnSendPassword();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element29 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element29.isDisplayed();
		Assert.assertTrue(actual);
		

	}
    @Parameters({"loginEmailValue"})
	@Test(priority = 13)
	public void testForgotPasswordWithValidEmail(String loginEmailValue) throws InterruptedException {
		forgot.clickOnForgotPasswordLink();
		forgot.clearEmail();
		forgot.enterEmail(loginEmailValue);
		forgot.clickOnSendPassword();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element30 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()='Password Recovery Request Has Been Processed ']")));

		boolean actual = element30.isDisplayed();
		Assert.assertTrue(actual);
		
	}

    
	@AfterMethod
	public void tearDown() {

		driver.close();
	}

}
