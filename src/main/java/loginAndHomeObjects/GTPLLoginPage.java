package loginAndHomeObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GTPLLoginPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public GTPLLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By userID = By.xpath("//*[@name='uid']");
	By password = By.xpath("//*[@name='password']");
	By loginButton = By.xpath("//*[@name='btnLogin']");
	
	public void loginPageTitle(String LPTitle) { 
			String actualtitle = LPTitle; 
			String expectedtitle = driver.getTitle(); 
			Assert.assertEquals(expectedtitle,actualtitle ); 
			System.out.println("You entered GTPL Bank Home Page");
	}
	
	public void EnterCredentials(String uid, String pword) {
		wait = new WebDriverWait(driver, 20);
		WebElement uidBox=wait.until(ExpectedConditions.visibilityOfElementLocated(userID));
		uidBox.click();
		uidBox.sendKeys(uid);
		WebElement passwordBox=wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		passwordBox.click();
		passwordBox.sendKeys(pword);
	}
	
	public void submitCredentials() {
		wait = new WebDriverWait(driver, 20);
		WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		login.click();
	}
}
