package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.Base;
import Utility.TimeUtil;

public class ImportOrdersPage extends Base {

	@FindBy(xpath = "//h3[text()='Orders']")
	@CacheLookup
	WebElement OrdersTab;

	@FindBy(xpath = "//span[text()='Import Orders']")
	@CacheLookup
	WebElement ImportOrdersLink;

	@FindBy(xpath = "//span[text()='Import']")
	@CacheLookup
	WebElement ImportOrdersButton;
	
	
	@FindBy(xpath = "//span[text()='Choose a Field Name']")
	@CacheLookup
	WebElement chooseField0;
	
	@FindBy(xpath = "//span[text()='Choose a Field Name'])[1]")
	@CacheLookup
	WebElement chooseField01;
	
	
	@FindBy(xpath = "//li[text()='OrderDate'])[2]")
	@CacheLookup
	WebElement orderDate;
	
	@FindBy(xpath = "//li[text()='OrderNumber'])[2]")
	@CacheLookup
	WebElement orderNumber;
	
	
	@FindBy(xpath = "//span[text()='No Mapping'])[10]")
	@CacheLookup
	WebElement noMapping;
	
	
	@FindBy(xpath = "//li[text()='Name'])[2]")
	@CacheLookup
	WebElement name;
	

	@FindBy(xpath = "//li[text()='Company'])[2]")
	@CacheLookup
	WebElement company;
	
	
	@FindBy(xpath = "//li[text()='PhoneNumber'])[2]")
	@CacheLookup
	WebElement phone;
	
	
	@FindBy(xpath = "//li[text()='Email'])[2]")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath = "//li[text()='Address1'])[2]")
	@CacheLookup
	WebElement address1;
	
	
	@FindBy(xpath = "//li[text()='Email'])[2]")
	@CacheLookup
	WebElement address2;
	
	@FindBy(xpath = "//li[text()='City'])[2]")
	@CacheLookup
	WebElement city;
	
	@FindBy(xpath = "//li[text()='state'])[2]")
	@CacheLookup
	WebElement state;
	
	
	
	public void clickOnChooseField0()
	{
		chooseField0.click();
		
	}
	
	public void clickOnChooseField1()
	{
		chooseField01.click();
		
	}
	
	public void clickOnOrderDate()
	{
		orderDate.click();
		
	}
	
	public void clickOnOrderNumber()
	{
		orderNumber.click();
		
	}
	
	
	public void clickOnNoMapping()
	{
		noMapping.click();
		
	}
	
	public void clickOnName()
	{
		
		name.click();
	}
	
	public void clickOnCompany()
	{
		company.click();
	}
	
	
	public void clickOnPhone()
	{
		phone.click();
	}
	
	public void clickOnEmail()
	{
		email.click();
	}
	
	public void clickOnAddress1()
	{
		address1.click();
	}
	
	public void clickOnAddress2()
	{
		address2.click();
	}
	
	public void clickOnCity()
	{
		city.click();
	}

	
	public void clickOnState()
	{
		state.click();
	}


	public ImportOrdersPage() {
		PageFactory.initElements(driver, this);

	}

	public void clickOnOrdersTab() {
		OrdersTab.click();

	}

	public void clickOnImportOrdersLink() {

		TimeUtil.clickOn(driver, ImportOrdersLink,20);

	}

	public void clickOnImportOrdersButton() {
	
		TimeUtil.clickOn(driver, ImportOrdersButton,10);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@FindBy(name="email")
	@CacheLookup
	private WebElement email;
	
	@FindBy(name="password")
	@CacheLookup
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Sign In']")
	@CacheLookup
	private WebElement signIn;
	
	@FindBy(xpath="//h3[text()='Orders']")
	@CacheLookup
	private WebElement orders;
	
	@FindBy(xpath="//span[text()='Import Orders']")
	@CacheLookup
	private WebElement importOrders;
	
	@FindBy(xpath="//label[text()='Choose CSV File']")
	@CacheLookup
	private WebElement csvFile;
	
	@FindBy(xpath="//a[text()='change']")
	@CacheLookup
	private WebElement change;
	
	@FindBy(xpath="//a[text()='create a new csv mapper']")
	@CacheLookup
	private WebElement newCSVMapper;
	
	@FindBy(xpath="(//span[text()='Choose a Field Name'])[1]")
	@CacheLookup
	private WebElement fieldName;
	
	@FindBy(xpath="(//span[text()='No Mapping'])[10]")
	@CacheLookup
	private WebElement noMapping;
	
	@FindBy(xpath="(//li[text()='OrderDate'])[2]")
	@CacheLookup
	private WebElement selectOrderDate;
	
	@FindBy(xpath="(//li[text()='OrderNumber'])[2]")
	@CacheLookup
	private WebElement selectOrderNumber;
	
	@FindBy(xpath="(//li[text()='Name'])[2]")
	@CacheLookup
	private WebElement selectAttentionOf;
	
	@FindBy(xpath="(//li[text()='Company'])[2]")
	@CacheLookup
	private WebElement selectCompany;
	
	@FindBy(xpath="(//li[text()='PhoneNumber'])[2]")
	@CacheLookup
	private WebElement selectPhoneNumber;
	
	@FindBy(xpath="(//li[text()='Email'])[2]")
	@CacheLookup
	private WebElement selectEmail;
	
	@FindBy(xpath="(//li[text()='Address1'])[2]")
	@CacheLookup
	private WebElement selectAddressLine1;
	
	@FindBy(xpath="(//li[text()='Address2'])[2]")
	@CacheLookup
	private WebElement selectAddressLine2;
	
	@FindBy(xpath="(//li[text()='City'])[2]")
	@CacheLookup
	private WebElement selectCity;
	
	@FindBy(xpath="(//li[text()='state'])[2]")
	@CacheLookup
	private WebElement selectProvince;
	
	@FindBy(xpath="(//li[text()='ZipCode'])[2]")
	@CacheLookup
	private WebElement selectPostalCode;
	
	@FindBy(xpath="(//li[text()='Country'])[2]")
	@CacheLookup
	private WebElement selectCountryCode;
	
	@FindBy(xpath="(//li[text()='ItemSKU'])[2]")
	@CacheLookup
	private WebElement selectItemSKU;
	
	@FindBy(xpath="(//li[text()='ItemQTY'])[2]")
    @CacheLookup
	private WebElement selectItemQuantity;
	
	@FindBy(xpath="(//li[text()='ItemName'])[2]")
	@CacheLookup
	private WebElement selectItemName;
	
	@FindBy(name="clientmapname")
	@CacheLookup
	private WebElement mapperName;
	
	@FindBy(xpath="//span[text()='Save CSV Mapper']")
	@CacheLookup
	private WebElement saveCSVMapper;
	
	@FindBy(xpath="//span[@rv-show=\"areThereClientMaps\"]")
	@CacheLookup
	private WebElement importOrders2;


	public ImportOrdersPage()
	{
		PageFactory.initElements(driver,this);
	}

	public void email(String un)
	{
		email.sendKeys(un);
	}
	public void password(String pw)
	{
		password.sendKeys(pw);
	}
	public void signIn()
	{
		signIn.click();
	}
	public void orders()
	{
		orders.click();
	}
	public void importOrders()
	{
		importOrders.click();
	}
	public void csvFile()
	{
		csvFile.click();
	}
	public void change()
	{
		change.click();
	}
	public void newCSVMapper()
	{
		newCSVMapper.click();
	}
	
	public void fieldName()
	{
		fieldName.click();
	}
	
	public void noMapping()
	{
		noMapping.click();
	}
	
	public void selectOrderDate()
	{
		selectOrderDate.click();
	}
	
	public void selectOrderNumber()
	{
		selectOrderNumber.click();
	}
	
	public void selectAttentionOf()
	{
		selectAttentionOf.click();
	}
	
	public void selectCompany()
	{
		selectCompany.click();
	}
	
	public void selectPhoneNumber()
	{
		selectPhoneNumber.click();
	}
	
	public void selectEmail()
	{
		selectEmail.click();
	}
	
	public void selectAddressLine1()
	{
		selectAddressLine1.click();
	}
	
	public void selectAddressLine2()
	{
		selectAddressLine2.click();
	}
	
	public void selectCity()
	{
		selectCity.click();
	}
	
	public void selectProvince()
	{
		selectProvince.click();
	}
	
	public void selectPostalCode()
	{
		selectPostalCode.click();
	}
	
	public void selectCountryCode()
	{
		selectCountryCode.click();
	}
	
	public void selectItemSKU()
	{
		selectItemSKU.click();
	}
	
	public void selectItemQuantity()
	{
		selectItemQuantity.click();
	}
	
	public void selectItemName()
	{
		selectItemName.click();
	}
	
	public void mapperName(String mn)
	{
		mapperName.sendKeys(mn);
	}
	
	public void saveCSVMapper()
	{
		saveCSVMapper.click();
	}
	
	public void importOrders2()
	{
		importOrders2.click();
	}*/
	}


