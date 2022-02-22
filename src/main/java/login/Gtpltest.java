package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gtpltest {
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
	public void EmptyUserIDvalidPassword() {
	Loadurl obj = new Loadurl(driver);
	obj.EmptyUserIDPassword();
	}
	@Test(priority = 0)
	public void InvalidUserEmptyPassword() {
		Loadurl obj = new Loadurl(driver);
		obj.InvalidUserEmptyPassword();
	}
	@Test(priority = 0)
	public void validUserEmptyPassword() {
		Loadurl obj = new Loadurl(driver);
		obj.validUserEmptyPassword();
	}
	
	@Test(priority = 0)
	public void EmptyUserInvalidPassword() {
		Loadurl obj = new Loadurl(driver);
		obj.EmptyUserInvalidPassword();
	}

	@Test(priority = 0)
	public void checkTheUrl() {
		Loadurl obj = new Loadurl(driver);
		obj.CheckURL();
	}
	@Test(priority = 0)
	public void DispalyUserid() {
		Loadurl obj = new Loadurl(driver);
		obj.DispalyUserid();
	}
	@Test(priority = 0)
	public void invalidPassworduserid() {
		Loadurl obj = new Loadurl(driver);
		obj.InvalidPassworduserid();
	}
	@Test(priority = 1)
	public void Displaypassword() {
		Loadurl obj = new Loadurl(driver);
		obj.Displaypassword();
	}
	
	@Test(priority = 2)
	public void DispalyLoginButton() {
		Loadurl obj = new Loadurl(driver);
		obj.DispalyLoginButton();
	}
	@Test(priority = 3)
	public void DisplayReset() {
		Loadurl obj = new Loadurl(driver);
		obj.DisplayReset();
	}
	@Test(priority = 4)
	public void Mandatoryfield() {
		Loadurl obj = new Loadurl(driver);
		obj.Mandatoryfield1();
	}
	@Test(priority = 5)
	public void ResetFunction() {
		Loadurl obj = new Loadurl(driver);
		obj.ResetFunction();
	}
	@Test(priority = 7)
	public void ValidPasswordInvaliduserid() { 
		Loadurl obj = new Loadurl(driver);
		obj.ValidPasswordInvaliduserid();
	}

	@Test(priority = 9)
	@Parameters("ID")
	public void user(String ID) {
		Loadurl obj = new Loadurl(driver);
		obj.UserID(ID);
	}

	@Test(priority = 10)
	@Parameters("password")
	public void passWord(String password) {
		Loadurl obj = new Loadurl(driver);
		obj.PassWord(password);
	}
	@Test(priority = 0)
	public void invalidPasswordvaliduserid() {
		Loadurl obj = new Loadurl(driver);
		obj.InvalidPasswordValiduserid();
	}

	@Test(priority = 12)
	public void TitlePage() {
		Loadurl obj = new Loadurl(driver);
		obj.TitlePage();
	}
	@Test(priority = 13)
	public void DisplayMangerpage() {
		Mangerpage obj = new Mangerpage(driver);
		obj.DisplayMangerpage();
	}

	@Test(priority = 14)
	public void logout() {
		Mangerpage obj = new Mangerpage(driver);
		obj.logout();
	}

	@AfterClass
	public void stop() {
		driver.quit();
	}
}