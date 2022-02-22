package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Page.Addaccount;
import Page.Home;
import Page.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Gtpltest {
	 WebDriver driver;
		
		@BeforeClass
		
		@Parameters("url")
		public void Load(String url)
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(url);
			
			String title=driver.getTitle();
			 System.out.println(title);
			String acltitle="GTPL Bank Home Page";
			 System.out.println(acltitle);
			Assert.assertEquals(title, acltitle);
	        System.out.println("GTPL Bank Tittle verification passed");
		}
		@Test(priority = 1 )
		 @Parameters({"email","password"})
		public void emailtest(String email,String password)
		{
			Login ob=new Login(driver);
			ob.login(email, password);
		}
		@Test(priority = 2 )
		public void searchtest() 
		{
			Home ob=new Home(driver);
			ob.newaccdisplay();
			
		}
		@Test(priority = 3 )
		public void Newaccounttest()
		{
			Addaccount ob=new Addaccount(driver);
			ob.Customerid_display();
			ob.Accounttype_display();
			ob.Initialdeposit_display();
			//ob.Submit_display();
			ob.Reset_display();
			
		}
		

}
