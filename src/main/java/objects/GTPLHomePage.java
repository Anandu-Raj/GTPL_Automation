package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GTPLHomePage {
	WebDriver driver;
	WebDriverWait wait;

	public GTPLHomePage(WebDriver driver) {
		this.driver = driver;
	}

	By NewCustomer = By.xpath("//*[text()='New Customer']");

	public void checkURL() {
		String actualUrl = "https://demo.guru99.com/V1/html/Managerhomepage.php";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("Correct URL");
	}

	public void menuDisplay() {
		wait = new WebDriverWait(driver, 20);
		WebElement Newcustomer = wait.until(ExpectedConditions.visibilityOfElementLocated(NewCustomer));
		Assert.assertEquals(true, Newcustomer.isDisplayed());
		System.out.println("New Customer menu is displayed");
		WebElement NewcustomerClick = wait.until(ExpectedConditions.visibilityOfElementLocated(NewCustomer));
		NewcustomerClick.click();
	}
}
