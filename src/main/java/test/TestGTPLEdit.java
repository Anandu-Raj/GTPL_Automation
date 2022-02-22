package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import editCustomerObjects.GTPLEditCustomerPage;
import loginAndHomeObjects.GTPLHomePage;
import loginAndHomeObjects.GTPLLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestGTPLEdit {
	WebDriver driver;
	
	@BeforeClass
	@Parameters("url")
	public void driverInstance1(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}
	
	@Test(priority = 0)
	@Parameters("LPTitle")
	public void loginPageTitleTest(String LPTitle) {
		GTPLLoginPage page1=new GTPLLoginPage(driver);
		page1.loginPageTitle(LPTitle);
	}
	
	@Test(priority = 1)
	@Parameters({"uid", "pword"})
	public void EnterCredentialsTest(String uid, String pword) {
		GTPLLoginPage page2=new GTPLLoginPage(driver);
		page2.EnterCredentials(uid, pword);
	}
	
	@Test(priority = 2)
	public void submitCredentialsTest() {
		GTPLLoginPage page3=new GTPLLoginPage(driver);
		page3.submitCredentials();
	}
	
	@Test(priority = 3)
	@Parameters("HPTitle")
	public void homePageTitleTest(String HPTitle) {
		GTPLHomePage page4=new GTPLHomePage(driver);
		page4.homePageTitle(HPTitle);
	}
	

	@Test(priority = 4)
	public void editCustomerMenuTest() {
		GTPLHomePage page5=new GTPLHomePage(driver);
		page5.editCustomerMenu();
	}
	
	@Test(priority = 5)
	@Parameters("ECPTitle")
	public void editCustomerPageTitleTest(String ECPTitle) {
		GTPLEditCustomerPage page6=new GTPLEditCustomerPage(driver);
		page6.editCustomerPageTitle(ECPTitle);
	}
	
	@Test(priority = 6)
	public void editCustomerFormTitleTest() {
		GTPLEditCustomerPage page7=new GTPLEditCustomerPage(driver);
		page7.editCustomerFormTitle();
	}
	
	@Test(priority = 7)
	public void customerIDTitleAndInputTest() {
		GTPLEditCustomerPage page8=new GTPLEditCustomerPage(driver);
		page8.customerIDTitleAndInput();
	}
	
	@Test(priority = 8)
	public void SubmitButtonTest() {
		GTPLEditCustomerPage page9=new GTPLEditCustomerPage(driver);
		page9.SubmitButton();
	}
	
	@Test(priority = 9)
	public void ResetButtonTest() {
		GTPLEditCustomerPage page10=new GTPLEditCustomerPage(driver);
		page10.ResetButton();
	}
	
	@Test(priority = 10)
	@Parameters({"try1","try2","try3","try4","try5"})
	public void inputFormatTest(String try1, String try2, String try3, String try4, String try5) {
		GTPLEditCustomerPage page11=new GTPLEditCustomerPage(driver);
		page11.inputFormat(try1, try2, try3, try4, try5);
	}
	
	@Test(priority = 11)
	public void HomeLinkTest() {
		GTPLEditCustomerPage page10=new GTPLEditCustomerPage(driver);
		page10.HomeLink();
	}
	
	@AfterClass
	public void driverInstance2() {
		driver.quit();
	}
}
