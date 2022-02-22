package customstatmnt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login
{
	
	public WebDriver driver;
	public WebDriverWait wait;
	By user = By.xpath("//*[@name='uid']");
	By pass = By.xpath("//*[@name='password']");
	By sbmt = By.xpath("//*[@name='btnLogin']");

	public Login(WebDriver driver) 
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	public void user(String Username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(user)).sendKeys(Username);
	}
	public void pass(String password)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(pass)).sendKeys(password);
	}
	public void sbmt()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(sbmt)).click();
	}
}
