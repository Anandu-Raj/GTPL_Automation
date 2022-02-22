package login;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Loadurl {
	WebDriver driver;
	WebDriverWait wait;

public Loadurl(WebDriver driver) {
		this.driver = driver;
	}

	By UserID = By.xpath("//*[@name='uid']");
	By Password = By.xpath("//*[@name='password']");
	By LOGIN = By.xpath("//*[@name='btnLogin']");
	By Reset = By.xpath("//input[@name='btnReset']");
	By Mandatoryfield = By.xpath("//*[text()='* mandatory field']");

public void TitlePage() {

		String actualtitle = "GTPL Bank Manager HomePage";
		String expectedtitle = driver.getTitle();
		Assert.assertEquals(expectedtitle, actualtitle);
		System.out.println("Actual tittle = Expected title");
		
		System.out.println("===================================================");
	}

public void CheckURL() {
		String actualUrl = "https://demo.guru99.com/V1/index.php";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("Actual URL = Expected URL");
		System.out.println("===================================================");
	}

public void UserID(String ID) {
		wait = new WebDriverWait(driver, 20);
		WebElement UserId = wait.until(ExpectedConditions.visibilityOfElementLocated(UserID));
		UserId.sendKeys(ID);
	}

public void PassWord(String password) {
		wait = new WebDriverWait(driver, 20);
		WebElement Password1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
		Password1.sendKeys(password);
		WebElement login1 = wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN));
		login1.click();
	}

public void DispalyLoginButton() {
		wait = new WebDriverWait(driver, 20);
		WebElement LoginButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='btnLogin']")));
		Assert.assertEquals(true, LoginButton.isDisplayed());
		System.out.println("LoginButton menu is displayed");
		System.out.println("===================================================");
	}

public void DispalyUserid() {
		wait = new WebDriverWait(driver, 20);
		WebElement DispalyUserid = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='uid']")));
		Assert.assertEquals(true, DispalyUserid.isDisplayed());
		System.out.println("UserID  is displayed");
		System.out.println("===================================================");
	}

public void Displaypassword() {
		wait = new WebDriverWait(driver, 20);
		WebElement DispalyUserid = wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
		Assert.assertEquals(true, DispalyUserid.isDisplayed());
		System.out.println("Password  is displayed");
		System.out.println("===================================================");
	}

public void DisplayReset() {
		wait = new WebDriverWait(driver, 20);
		WebElement DispalyUserid = wait.until(ExpectedConditions.visibilityOfElementLocated(Reset));
		Assert.assertEquals(true, DispalyUserid.isDisplayed());
		System.out.println("Reset is displayed");
		System.out.println("===================================================");
	}

public void Mandatoryfield1() {
		wait = new WebDriverWait(driver, 20);
		WebElement DispalyUserid = wait.until(ExpectedConditions.visibilityOfElementLocated(Mandatoryfield));
		Assert.assertEquals(true, DispalyUserid.isDisplayed());
		System.out.println("MandatoryField  is displayed");
		System.out.println("===================================================");
	}

public void ResetFunction() {
		wait = new WebDriverWait(driver, 20);

		WebElement UserID1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='uid']")));
		UserID1.sendKeys("abcd@gmail.com");
		WebElement password1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='password']")));
		password1.sendKeys("abcdefghlkjl");

		WebElement Resetfunction = wait.until(ExpectedConditions.visibilityOfElementLocated(Reset));
		Resetfunction.click();
		Assert.assertEquals(true, Resetfunction.isDisplayed());
		System.out.println("All Values are cleared ,Reset is working fine");
		System.out.println("===================================================");
	}

public void ValidPasswordInvaliduserid() {

		driver.findElement(By.xpath("//*[@name='uid']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("pUnEteq");
		driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
		Alert a = driver.switchTo().alert();
		String x1 = a.getText();
		System.out.println("ValidPassword and Invaliduserid is "+x1);
		System.out.println("===================================================");
		a.accept();
	}

public void InvalidPassworduserid() {

		driver.findElement(By.xpath("//*[@name='uid']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("abcdefghlkjl");
		driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
		Alert a = driver.switchTo().alert();
		String x2 = a.getText();
		System.out.println("InvalidPassword and Invaliduserid is"+x2);
		System.out.println("===================================================");
		a.accept();
	}

public void InvalidPasswordValiduserid() {

	driver.findElement(By.xpath("//*[@name='uid']")).sendKeys("mngr384160");
	driver.findElement(By.xpath("//*[@name='password']")).sendKeys("abcdefghlkjl");
	driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
		Alert a = driver.switchTo().alert();
		String x3 = a.getText();
		System.out.println("InvalidPassword and Validuserid is "+x3);
		System.out.println("===================================================");
		a.accept();
	}

public void EmptyUserIDPassword(){
	WebElement Emptyuser= driver.findElement(By.xpath("//*[@name='uid']"));
	Emptyuser.sendKeys("  ");
	WebElement Emptypassword= driver.findElement(By.xpath("//*[@name='password']"));
	Emptypassword.sendKeys(" ");
	driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
		Alert a1 = driver.switchTo().alert();
		String x4 = a1.getText();
		a1.accept();
			System.out.println("EmptyUserID and EmptyPassword  is "+x4);
			System.out.println("===================================================");
}

			
public void EmptyUservalidPassword(){
			WebElement Emptyuser= driver.findElement(By.xpath("//*[@name='uid']"));
			Emptyuser.sendKeys("  ");
			WebElement validpassword= driver.findElement(By.xpath("//*[@name='password']"));
			validpassword.sendKeys("pUnEteq");
			driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
			Alert a2 = driver.switchTo().alert();
			String x5 = a2.getText();
			a2.accept();
				
					System.out.println("EmptyUserid and validPassword is " +x5);
					System.out.println("===================================================");
		}

public void validUserEmptyPassword(){
	WebElement Emptyuser= driver.findElement(By.xpath("//*[@name='uid']"));
	Emptyuser.sendKeys("mngr384160");
	WebElement validpassword= driver.findElement(By.xpath("//*[@name='password']"));
	validpassword.sendKeys(" ");
	driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
	Alert a2 = driver.switchTo().alert();
	String x5 = a2.getText();
	a2.accept();
		
			System.out.println("ValidUser and EmptyPassword is " +x5);
			System.out.println("===================================================");
}

public void InvalidUserEmptyPassword(){
	WebElement Emptyuser= driver.findElement(By.xpath("//*[@name='uid']"));
	Emptyuser.sendKeys("4160");
	WebElement validpassword= driver.findElement(By.xpath("//*[@name='password']"));
	validpassword.sendKeys(" ");
	driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
	Alert a2 = driver.switchTo().alert();
	String x5 = a2.getText();
	a2.accept();
		
			System.out.println("InvalidUser and EmptyPassword is " +x5);
			System.out.println("===================================================");
	
}
public void EmptyUserInvalidPassword(){
	WebElement Emptyuser= driver.findElement(By.xpath("//*[@name='uid']"));
	Emptyuser.sendKeys(" ");
	WebElement validpassword= driver.findElement(By.xpath("//*[@name='password']"));
	validpassword.sendKeys("gdf");
	driver.findElement(By.xpath("//*[@name='btnLogin']")).click();
	Alert a2 = driver.switchTo().alert();
	String x5 = a2.getText();
	a2.accept();
		
			System.out.println("EmptyUser and InvalidPassword is " +x5);
			System.out.println("===================================================");
}
}








