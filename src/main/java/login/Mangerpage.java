package login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Mangerpage {

	WebDriver driver;
	WebDriverWait wait;

	public Mangerpage(WebDriver driver) {
		this.driver = driver;
	}

	By NewCustomer = By.xpath("//*[text()='New Customer']");
	By EditCustomer = By.xpath("//*[text()='Edit Customer']");
	By EditAccount = By.xpath("//*[text()='Edit Account']");
	By DeleteCustomer = By.xpath("//*[text()='Delete Customer']");
	By DeleteAccount = By.xpath("//*[text()='Delete Account']");
	By MiniStatementd = By.xpath("//*[text()='Mini Statement']");
	By Logout = By.xpath("//*[text()='Log out']");
	By Message = By.xpath("[text() ='Welcome To Manager's Page of GTPL Bank']");
	By CustomisedStatement = By.xpath("//*[text()='Customised Statement']");

	public void DisplayMangerpage() {
		wait = new WebDriverWait(driver, 20);
		WebElement NewCustomer1 = wait.until(ExpectedConditions.visibilityOfElementLocated(NewCustomer));
		Assert.assertEquals(true, NewCustomer1.isDisplayed());
		System.out.println("NewCustomer is displayed");
	
		WebElement EditCustomer1 = wait.until(ExpectedConditions.visibilityOfElementLocated(EditCustomer));
		Assert.assertEquals(true, EditCustomer1.isDisplayed());
		System.out.println("EditCustomer  is displayed");

	
		WebElement EditAccount1 = wait.until(ExpectedConditions.visibilityOfElementLocated(EditAccount));
		Assert.assertEquals(true, EditAccount1.isDisplayed());
		System.out.println(" EditAccount is displayed");

		
		WebElement MiniStatementd1 = wait.until(ExpectedConditions.visibilityOfElementLocated(MiniStatementd));
		Assert.assertEquals(true, MiniStatementd1.isDisplayed());
		System.out.println("MiniStatementd is displayed");

	
		WebElement DeleteCustomer1 = wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteCustomer));
		Assert.assertEquals(true, DeleteCustomer1.isDisplayed());
		System.out.println("DeleteCustomer  is displayed");
	
		
		WebElement DeleteAccount1 = wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteAccount));
		Assert.assertEquals(true, DeleteAccount1.isDisplayed());
		System.out.println("DeleteAccount  is displayed");
	}
		public void logout()
	{
		wait = new WebDriverWait(driver, 20);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		WebElement CustomisedStatement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomisedStatement));
		Assert.assertEquals(true, CustomisedStatement1.isDisplayed());
		System.out.println("CustomisedStatement  is displayed");
		WebElement Logout1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Logout));
		Assert.assertEquals(true, Logout1.isDisplayed());
		System.out.println("Logout  is displayed");
		

	}
}
