package Page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Addaccount {
	WebDriver driver;
	WebDriverWait wait;

	public Addaccount(WebDriver driver) {
		this.driver = driver;
	}

	By customerid = By.xpath("//*[@name=\"cusid\"]");
	By accounttype = By.xpath("//*[@name=\"selaccount\"]");
	By initialdeposit = By.xpath("//*[@name=\"inideposit\"]");
	By submit = By.xpath("//*[@name=\"button2\"]");
	By reset = By.xpath("//*[@name=\"reset\"]");
	By homelink = By.xpath("//*[text()=\"home\"]");

	public void Customerid_display() {
		wait = new WebDriverWait(driver, 20);
		WebElement custid = wait.until(ExpectedConditions.visibilityOfElementLocated(customerid));
		custid.sendKeys("87185");
		Assert.assertEquals(true, custid.isDisplayed());
		System.out.println("Customer ID field displayed");

		String fieldText = custid.getAttribute("value");
		System.out.println("Input=" + fieldText);

		if (fieldText.matches("[0-9]+")) {
			System.out.println("**********valid input in CustomerID field");
		} else {
			System.out.println("**********Invalid input in CustomerID field ");
		}

	}

	public void Accounttype_display() {
		wait = new WebDriverWait(driver, 20);
		WebElement acctype = wait.until(ExpectedConditions.visibilityOfElementLocated(accounttype));
		Select type = new Select(acctype);
		type.selectByVisibleText("current");
		Assert.assertEquals(true, acctype.isDisplayed());
		System.out.println("Account type field displayed");
		boolean status = type.isMultiple();

		if (status) {
			System.out.println("Allows multiple selection");
		} else {
			System.out.println("*************Does not allow multiple selection");
		}

	}

	public void Initialdeposit_display() {
		wait = new WebDriverWait(driver, 20);
		WebElement inideposit = wait.until(ExpectedConditions.visibilityOfElementLocated(initialdeposit));
		inideposit.sendKeys("400");
		Assert.assertEquals(true, inideposit.isDisplayed());
		System.out.println("Initial deposit field displayed");

		String fieldText = inideposit.getAttribute("value");
		System.out.println("Input=" + fieldText);

		if (fieldText.matches("[0-9]+")) {
			int deposit = Integer.parseInt(fieldText);
			if (deposit >= 500) {
				System.out.println("**********valid initial deposit");
			} else {
				System.out.println("enter grate than 500");
			}
		}
     else {
			System.out.println("**********Invalid input in Initial deposit field ");
		}

	}

	public void Submit_display() {
		wait = new WebDriverWait(driver, 20);
		WebElement submitbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
		Assert.assertEquals(true, submitbtn.isDisplayed());
		System.out.println("Submitt button displayed");
		
		WebElement custid = wait.until(ExpectedConditions.visibilityOfElementLocated(customerid));
		WebElement inideposit = wait.until(ExpectedConditions.visibilityOfElementLocated(initialdeposit));
		String custidText = custid.getAttribute("value");
		String inidepositText = inideposit.getAttribute("value");
		if(custidText.isEmpty()&& inidepositText.isEmpty())
		{
		   System.out.println("Customer id field is empty");
		   System.out.println("Initial deposit field is empty");
		}
		else if(custidText.isEmpty())
		{
			System.out.println("Customer id field is empty");
		}
		else if(inidepositText.isEmpty())
		{
			System.out.println("Initial deposit field is empty");
		}
		else
		{
			submitbtn.click();
		}
		

	}

	public void Reset_display() {
		wait = new WebDriverWait(driver, 20);
		WebElement clear = wait.until(ExpectedConditions.visibilityOfElementLocated(reset));
		
		Assert.assertEquals(true, clear.isDisplayed());
		System.out.println("Clear button displayed");
		clear.click();
		WebElement custid = wait.until(ExpectedConditions.visibilityOfElementLocated(customerid));
		WebElement inideposit = wait.until(ExpectedConditions.visibilityOfElementLocated(initialdeposit));
		String custidText = custid.getAttribute("value");
		String inidepositText = inideposit.getAttribute("value");
		if(custidText.isEmpty()&& inidepositText.isEmpty())
		{
		   System.out.println("fields are empty");
		   
		}
	}

}
