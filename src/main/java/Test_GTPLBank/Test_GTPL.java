package Test_GTPLBank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GTPLBank.HomepageGTPL;
import GTPLBank.LoginGTPL;
import GTPLBank.MiniStatement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_GTPL {
	WebDriver driver;
	WebDriverWait wait;
	public LoginGTPL loginobj;
	public HomepageGTPL Homepageobj;
	public MiniStatement Ministmtobj;
	

	  @BeforeClass
	  @Parameters("url")
	  public void driverInstance1(String url) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(url);
//			String ExpectedUrl = "https://demo.guru99.com/V1";
//			String ActualUrl = driver.getCurrentUrl();
//			Assert.assertEquals(ExpectedUrl, ActualUrl);
//			System.out.println("Assertion is done");
			loginobj = new LoginGTPL(driver);
			Homepageobj = new HomepageGTPL(driver);
			Ministmtobj = new MiniStatement(driver);
				
	  }
	  @Test(priority = 0)
		@Parameters("Userid")
		public void UserID(String Userid) {
		  LoginGTPL loginobj = new LoginGTPL(driver);
			loginobj.UserID(Userid);
		}
 
		@Test(priority = 1)
		@Parameters("Password")
		public void password(String Password) {
			LoginGTPL loginobj = new LoginGTPL(driver);
			loginobj.Password(Password);
		}
		@Test(priority = 2)
		public void checkUrl() {
			HomepageGTPL Homepageobj = new HomepageGTPL(driver);
			Homepageobj.checkUrl();
		}
		@Test(priority = 3)
		public void homepageGTPL() {
			HomepageGTPL Homepageobj = new HomepageGTPL(driver);
			Homepageobj.homepageGTPL();
		}
		@Test(priority = 4)
		public void MiniStatement() {
			MiniStatement Ministmtobj = new MiniStatement(driver);
			Ministmtobj.ministatement();
			Ministmtobj.Display();
			Ministmtobj.accountno();
			Ministmtobj.Resetbutton();
			Ministmtobj.homeLink();			
		}
		@AfterClass
		public void stop() {
			driver.quit();	
			
		}	
}
