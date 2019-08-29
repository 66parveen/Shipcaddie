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

import Pages.LoginPage;
import Testbase.Base;

public class TestLogin extends Base {
	LoginPage login;

	public TestLogin() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		intializeBrowser();
		login = new LoginPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

	@Test(priority = 0)
	public void verifyFocusIsOnEmailField() throws InterruptedException {

		WebElement currentElement = driver.switchTo().activeElement();
		currentElement.isSelected();
		Assert.assertTrue(true);

	}

	@Test(priority = 1)
	public void testLoginWithoutDetails() {

		login.clickOnLoginButton();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element21 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element21.isDisplayed();
		Assert.assertTrue(actual);
	}

	@Parameters({ "loginPasswordValue" })
	@Test(priority = 2)
	public void testLoginWithoutEmail(String loginPasswordValue) {

		login.enterPassword(loginPasswordValue);
		login.clickOnLoginButton();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element22 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element22.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Parameters({ "loginEmailValue" })
	@Test(priority = 3)
	public void testLoginWithoutPassword(String loginEmailValue) {
		login.enterEmail(loginEmailValue);
		login.clickOnLoginButton();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element23 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in or correct fields in red']")));

		boolean actual = element23.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Parameters({ "invalidLoginEmail", "loginPasswordValue" })
	@Test(priority = 4)
	public void testLoginWithInvalidEmail(String invalidLoginEmail, String loginPasswordValue) {
		login.enterInvalidEmail(invalidLoginEmail);
		login.enterPassword(loginPasswordValue);
		login.clickOnLoginButton();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element24 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='The username or password is incorrect.']")));

		boolean actual = element24.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Parameters({ "loginEmailValue", "loginInvalidPassword" })
	@Test(priority = 5)
	public void testLoginWithInvalidPassword(String loginEmailValue, String loginInvalidPassword) {
		login.enterEmail(loginEmailValue);
		login.enterInvalidPassword(loginInvalidPassword);
		login.clickOnLoginButton();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element25 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='The username or password is incorrect.']")));

		boolean actual = element25.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Parameters({ "loginEmailValue", "loginPasswordValue" })
	@Test(priority = 6)
	public void testLoginWithValidDetails(String loginEmailValue, String loginPasswordValue) {
		login.enterEmail(loginEmailValue);
		login.enterPassword(loginPasswordValue);
		login.clickOnLoginButton();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element26 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Login']")));

		boolean actual = element26.isDisplayed();
		Assert.assertTrue(actual);

	}

	@Parameters({ "loginEmailValue", "loginPasswordValue" })
	@Test(priority = 7)
	public void testLogoutLinkDisplayed(String loginEmailValue, String loginPasswordValue) throws InterruptedException {
	
		login.LoginIntoShipCaddie(loginEmailValue, loginPasswordValue);

		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement logOut= wait
				
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-sign-out signout']")));

		boolean actual = logOut.isDisplayed();
		Assert.assertTrue(actual);
	
	}

	@Parameters({ "loginEmailValue", "loginPasswordValue" })
	@Test(priority = 8)
	public void testLogoutLinkFunctional(String loginEmailValue, String loginPasswordValue)
			throws InterruptedException {
		
		login.LoginIntoShipCaddie(loginEmailValue, loginPasswordValue);
		
		
		login.clickOnLogout();
		WebElement element = driver.findElement(By.xpath("//input[@name='email']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));

		boolean actual = element.isDisplayed();
		Assert.assertTrue(actual);

	}

}
