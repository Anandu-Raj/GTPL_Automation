package customstatmnt;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Testcustomised {
	public WebDriver driver;
	static WebDriverWait wait;
	public Login loginobj;
	public Mngr mngrobj;
	public Statmnt statobj;

	@Parameters("url")
	@BeforeClass
	public void beforeClass(String ur) 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(ur);
		String exp = "https://demo.guru99.com/V1/";
		String orgn = driver.getCurrentUrl();
		Assert.assertEquals("url matching",orgn, exp);
		System.out.println("Assertion done");
		loginobj=new Login(driver);
		mngrobj=new Mngr(driver);
		statobj=new Statmnt(driver);
		

	}
	@Parameters({ "user", "password" })
	@Test(priority = 0)
	public void login(String Username, String password) 
	{
		loginobj.user(Username);
		loginobj.pass(password);
		loginobj.sbmt();
	}
	
	@Test(priority = 1)
	public void mngr()
	{
		mngrobj.mngr();
	}
	
	@Test(priority = 2)
	public void statmnt()
	{
		statobj.title();
		statobj.accnt();
		statobj.fromdt();
		statobj.todate();
		statobj.amount();
	}
	
	@AfterClass
	public void afterClass() 
	{
		//driver.close();

	}

}
