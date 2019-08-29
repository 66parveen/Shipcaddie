package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.Base;
import Utility.TimeUtil;

public class LoginPage extends Base {
	

	// LocatorValuesForEmailPasswordAndSignInButton
	@FindBy(xpath = "//input[@name='email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath = "//button[@type='button']")
	@CacheLookup
	WebElement loginButton;

	@FindBy(xpath = "//i[@class='fa fa-sign-out signout']")
	@CacheLookup
	WebElement logout;
	
	// ConstructorForIntializationOfVariableAndMethods
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// FunctionToEnterInvalidEmail
	public void enterEmail(String loginEmailValue) {
		TimeUtil.sendKeys(driver, email, 10,loginEmailValue);
		

	}

	// FunctionToEnterInvalidPassword
	public void enterPassword(String loginPasswordValue) {

		TimeUtil.sendKeys(driver, password, 5,loginPasswordValue);

	}

	// FunctionToEnterInvalidEmailAddress
	public void enterInvalidEmail(String loginInvalidEmail) {
		
		TimeUtil.sendKeys(driver, email, 10,loginInvalidEmail);
	}

	// FunctionToEnterValidPassword
	public void enterInvalidPassword(String loginInvalidPassword) {
		
		TimeUtil.sendKeys(driver, password, 10,loginInvalidPassword);
	}

	// FunctionToClickOnLoginButton
	public void clickOnLoginButton() {

		TimeUtil.clickOn(driver,loginButton,5);
	}

	// Valid Login
	public void LoginIntoShipCaddie(String loginEmailValue, String loginPasswordValue) {
		
		TimeUtil.sendKeys(driver, email, 10,loginEmailValue);
		TimeUtil.sendKeys(driver, password, 10,loginPasswordValue);
		TimeUtil.clickOn(driver,loginButton,5);
		
	}
	
	// FunctionToClickOnLogoutIcon
		public void clickOnLogout() {
			TimeUtil.clickOn(driver,logout,15);

		}
	
	//clear Email Field
	public void clearEmail()
	{
		email.clear();
		
	}

	//clear Password Field
	public void clearPassword()
	{
		password.clear();
		
	}

	
}
