package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deleteCustomerObjects.GTPLDeleteCustomerPage;
import loginAndHomeObjects.GTPLHomePage;
import loginAndHomeObjects.GTPLLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestGTPLDelete {
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
	public void deleteCustomerMenuTest() {
		GTPLHomePage page5=new GTPLHomePage(driver);
		page5.deleteCustomerMenu();
	}
	
	@Test(priority = 5)
	@Parameters("DCPTitle")
	public void deleteCustomerPageTitleTest(String DCPTitle) {
		GTPLDeleteCustomerPage page6=new GTPLDeleteCustomerPage(driver);
		page6.deleteCustomerPageTitle(DCPTitle);
	}
	
	@Test(priority = 6)
	public void deleteCustomerFormTitleTest() {
		GTPLDeleteCustomerPage page7=new GTPLDeleteCustomerPage(driver);
		page7.deleteCustomerFormTitle();
	}
	
	@Test(priority = 7)
	public void customerIDTitleAndInputDTest() {
		GTPLDeleteCustomerPage page8=new GTPLDeleteCustomerPage(driver);
		page8.customerIDTitleAndInputD();
	}
	
	@Test(priority = 8)
	public void SubmitButtonDTest() {
		GTPLDeleteCustomerPage page9=new GTPLDeleteCustomerPage(driver);
		page9.SubmitButtonD();
	}
	
	@Test(priority = 9)
	public void ResetButtonDTest() {
		GTPLDeleteCustomerPage page10=new GTPLDeleteCustomerPage(driver);
		page10.ResetButtonD();
	}
	
	@Test(priority = 10)
	@Parameters({"try1","try2","try3","try4","try5"})
	public void inputFormatDTest(String try1, String try2, String try3, String try4, String try5) {
		GTPLDeleteCustomerPage page11=new GTPLDeleteCustomerPage(driver);
		page11.inputFormatD(try1, try2, try3, try4, try5);
	}
	
	@Test(priority = 11)
	public void HomeLinkDTest() {
		GTPLDeleteCustomerPage page10=new GTPLDeleteCustomerPage(driver);
		page10.HomeLinkD();
	}
	
	@AfterClass
	public void driverInstance2() {
		driver.quit();
	}
}
