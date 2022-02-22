package GTPLBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginGTPL {
	WebDriver driver;
	WebDriverWait wait;
	
	By UserID = By.xpath("//*[@name='uid']");
	By Password = By.xpath("//*[@name='password']");
	By LOGIN = By.xpath("//*[@name='btnLogin']");
	By RESET = By.xpath("//*[@name='btnReset']");
	
	
	public LoginGTPL(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	public void Titlepage(By Titlepage) {
		wait = new WebDriverWait(driver, 10);
		String Actualtitle = "GTPL Bank Manager HomePage";
		String Expectedtitle = driver.getTitle();
		Assert.assertEquals(Expectedtitle, Actualtitle);
		System.out.println("The title of GTPL Bank Manager HomePage is Displayed" );
		wait.until(ExpectedConditions.visibilityOfElementLocated(Titlepage)).click();
		
	}
	public void checkURLstatus(By checkURLstatus) {
		wait = new WebDriverWait(driver, 10);
		String ActualUrl = "https://demo.guru99.com/V1";
		String ExpectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(ExpectedUrl, ActualUrl);
		System.out.println("URL is loaded");
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkURLstatus)).click();
	}
	public void UserID(String UID) {
		wait = new WebDriverWait(driver, 10);
		WebElement UserID1 = wait.until(ExpectedConditions.visibilityOfElementLocated(UserID));
		UserID1.sendKeys(UID);
	}
	public void Password(String pswd) {
		wait = new WebDriverWait(driver, 10);
		WebElement pswd1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
		pswd1.sendKeys(pswd);
		WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN));
		submit.click();
	}
}