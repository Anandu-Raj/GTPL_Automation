package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.GTPLHomePage;
import objects.GTPLLoginPage;
import objects.GTPLNewCustomerEntryPage;

public class GTPLTest {
	WebDriver driver;

	@BeforeClass
	@Parameters("url")
	public void start(String url) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.navigate().to(url);
	}

	@Test(priority = 0)
	@Parameters("ID")
	public void user(String ID) {
		GTPLLoginPage obj = new GTPLLoginPage(driver);
		obj.userID(ID);
	}

	@Test(priority = 1)
	@Parameters("password")
	public void passWord(String password) {
		GTPLLoginPage obj = new GTPLLoginPage(driver);
		obj.PassWord(password);
	}

	@Test(priority = 2)
	public void functionalityNewCustomer() {
		GTPLHomePage obj = new GTPLHomePage(driver);
		obj.checkURL();
		obj.menuDisplay();
	}

	@Test(priority = 3)
	public void titleNewCustomerEntryPage() {
		GTPLNewCustomerEntryPage obj = new GTPLNewCustomerEntryPage(driver);
		obj.NewCustomerEntryPageTitle();
	}

	@Test(priority = 4)
	public void displayNewCustomerEntryPage() {
		GTPLNewCustomerEntryPage obj = new GTPLNewCustomerEntryPage(driver);
		obj.NewCustomerEntryPageDisplay();
	}

	@Test(priority = 5)
	public void CustomerNameFormat() {
		GTPLNewCustomerEntryPage obj = new GTPLNewCustomerEntryPage(driver);
		obj.formatCustomerName();
	}

	@Test(priority = 6)
	public void DateOfBirthFormat() {
		GTPLNewCustomerEntryPage obj = new GTPLNewCustomerEntryPage(driver);
		obj.formatDateOfBirth();
	}

	@Test(priority = 7)
	public void AddressFormat() {
		GTPLNewCustomerEntryPage obj = new GTPLNewCustomerEntryPage(driver);
		obj.formatAddress();
	}

	@Test(priority = 8)
	public void CityFormat() {
		GTPLNewCustomerEntryPage obj = new GTPLNewCustomerEntryPage(driver);
		obj.formatCity();
	}

	@Test(priority = 9)
	public void StateFormat() {
		GTPLNewCustomerEntryPage obj = new GTPLNewCustomerEntryPage(driver);
		obj.formatState();
	}

	@Test(priority = 10)
	public void PINFormat() {
		GTPLNewCustomerEntryPage obj = new GTPLNewCustomerEntryPage(driver);
		obj.formatPIN();
	}

	@Test(priority = 11)
	public void TelephoneNumberFormat() {
		GTPLNewCustomerEntryPage obj = new GTPLNewCustomerEntryPage(driver);
		obj.formatTelephoneNumber();
	}

	@Test(priority = 12)
	public void EmailIdFormat() {
		GTPLNewCustomerEntryPage obj = new GTPLNewCustomerEntryPage(driver);
		obj.formatEmailId();
	}

	@Test(priority = 13)
	public void SubmitButtonFunctionality() {
		GTPLNewCustomerEntryPage obj = new GTPLNewCustomerEntryPage(driver);
		obj.functionalitySubmitButton();
	}

	@Test(priority = 14)
	public void ResetButtonFunctionality() {
		GTPLNewCustomerEntryPage obj = new GTPLNewCustomerEntryPage(driver);
		obj.functionalityResetButton();
	}

	@Test(priority = 15)
	public void HomeLinkFunctionality() {
		GTPLNewCustomerEntryPage obj = new GTPLNewCustomerEntryPage(driver);
		obj.functionalityHomeLink();
	}

//	@AfterClass
//	public void stop() {
//		driver.quit();
//	}
}
