package customstatmnt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Mngr 
{
	
	public WebDriver driver;
	public WebDriverWait wait;
	By mngr = By.xpath("//*[text()='Customised Statement']");
	public Mngr(WebDriver driver) 
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, 10);
		}
	public void mngr()
	{
		Assert.assertTrue(driver.findElement(mngr).isDisplayed());
		System.out.println("Customised Statement menu is displayed");
		wait.until(ExpectedConditions.visibilityOfElementLocated(mngr)).click();
	}
}
