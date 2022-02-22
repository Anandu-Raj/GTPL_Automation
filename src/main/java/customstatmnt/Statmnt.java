package customstatmnt;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Statmnt
{
	
	public WebDriver driver;
	public WebDriverWait wait;
	Scanner sc = new Scanner(System.in);
	By title=By.xpath("//*[text()='Customized Statement Form']");
	By accnt = By.xpath("//*[@name='accountno']");
	By alert1=By.xpath("//*[@id='message2']");
	By alert2=By.xpath("//*[text()='Account Number must not be blank']");
	By fromDate=By.xpath("//*[text()='From Date ']");
	By fromDate1=By.xpath("//*[@name='fdate']");
	By toDate=By.xpath("//*[text()='To Date ']");
	By toDate1=By.xpath("//*[@name='tdate']");
	By amountL=By.xpath("//*[text()='Amount Lower Limit']");
	By amount1=By.xpath("//*[@name='loweramt']");
	public Statmnt(WebDriver driver) 
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, 10);
	}
	public void title()
	{
		Assert.assertTrue(driver.findElement(title).isDisplayed());
		System.out.println("Title is displayed");
	}
	public void accnt()
	{
		Assert.assertTrue(driver.findElement(accnt).isDisplayed());
		System.out.println("Account Number field is displayed");
		wait = new WebDriverWait(driver, 10); 
	    //Scanner sc = new Scanner(System.in);  //@SuppressWarnings("resource") 
		System.out.println("Enter the Account Number : ");
		String account = sc.nextLine();
		String regex = "[0-9]{1,10}";    //^\\d{9,18}$,,,,//[0-9]+
		
		if(account.matches(regex) &&  (account.length()<=10) )
		{
			WebElement accNo = wait.until(ExpectedConditions.visibilityOfElementLocated(accnt)); 
			accNo.sendKeys(account); 
		}
		else if(account.length()>10)
		{
			System.out.println("**Account Number can not exceed 10 digits**");
		}
		else if(account.isBlank())
		{
			WebElement accNo = wait.until(ExpectedConditions.visibilityOfElementLocated(accnt)); 
			accNo.sendKeys(account); 
			WebElement alertnull = wait.until(ExpectedConditions.visibilityOfElementLocated(alert2)); 
	  		System.out.println(alertnull.getText());
		}
		else if (!account.matches(regex)) 
		{
		WebElement accNo = wait.until(ExpectedConditions.visibilityOfElementLocated(accnt)); 
		accNo.sendKeys(account); 
		WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alert1)); 
  		System.out.println(alert.getText());
		}}
	public void fromdt()
	{
		Assert.assertTrue(driver.findElement(fromDate).isDisplayed());
		System.out.println("From Date is displayed");
		wait = new WebDriverWait(driver, 10); 
	    //Scanner sc = new Scanner(System.in);  //@SuppressWarnings("resource") 
		System.out.println("Enter the From Date: ");
		String fromD = sc.nextLine();
		String regex = "^(1[0-2]|0[1-9])/(3[01]"+"|[12][0-9]|0[1-9])/[0-9]{4}$";
		if(fromD.matches(regex))
		{
			WebElement from= wait.until(ExpectedConditions.visibilityOfElementLocated(fromDate1)); 
			from.sendKeys(fromD);
		}
		else
		{
			System.out.println("**Date is not in format**");
		}
	}
	public void todate()
	{
		wait = new WebDriverWait(driver, 10); 
		Assert.assertTrue(driver.findElement(toDate).isDisplayed());
		System.out.println("To Date is displayed");
		//Scanner sc = new Scanner(System.in);  //@SuppressWarnings("resource") 
		System.out.println("Enter the To Date: ");
		String toD = sc.nextLine();
		String regex = "^(1[0-2]|0[1-9])/(3[01]"+"|[12][0-9]|0[1-9])/[0-9]{4}$";
		if(toD.matches(regex))
		{
			WebElement to= wait.until(ExpectedConditions.visibilityOfElementLocated(toDate1)); 
			to.sendKeys(toD);
		}
		else
		{
			System.out.println("**Date is not in format**");
		}
	}
	public void amount()
	{
		wait = new WebDriverWait(driver, 10); 
		Assert.assertTrue(driver.findElement(amountL).isDisplayed());
		System.out.println("Amount Lower Limit is displayed");
		System.out.println("Enter the lower limit : ");
		String lower= sc.nextLine();
		String regex="[0-9]+";
		String spec="[^a-zA-Z0-9]+";
		String alp="^[a-zA-Z]*$";
		if(lower.matches(regex))
		{
			WebElement lower1= wait.until(ExpectedConditions.visibilityOfElementLocated(amount1)); 
			lower1.sendKeys(lower);
		}
		else if (lower.isBlank())
		{
			WebElement lower1= wait.until(ExpectedConditions.visibilityOfElementLocated(amount1)); 
			lower1.sendKeys(lower);
			System.out.println("**Amount Lower Limit must not be blank**");
		}
		else if (lower.matches(spec))
		{
			WebElement lower1= wait.until(ExpectedConditions.visibilityOfElementLocated(amount1)); 
         	lower1.sendKeys(lower);
			System.out.println("**Special Characters are not allowed**");
		}
		else if (lower.matches(alp))
		{
			WebElement lower1= wait.until(ExpectedConditions.visibilityOfElementLocated(amount1)); 
         	lower1.sendKeys(lower);
			System.out.println("**Characters are not allowed**");
		}
		
	}
	}
