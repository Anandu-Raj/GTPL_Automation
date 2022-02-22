package GTPL_DeleteAccount;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class GTPL_DeleteAccountPage {
	WebDriver driver;
	WebDriverWait wait;

	public GTPL_DeleteAccountPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By Heading = By.xpath("//*[text()='Delete Account Form']");
	By AccountNo = By.xpath("//*[text()='Account No']");
	By SubmitButton = By.xpath("//*[@name='AccSubmit']");
	By ResetButton = By.xpath("//*[@name='res']");
	By HomeLink = By.xpath("//*[text()='Home']");

	By accountNo = By.xpath("//*[@name='accountno']");
	By alert = By.xpath("//*[@id='message2']");

	public void display() {
		// TODO Auto-generated method stub
		wait = new WebDriverWait(driver, 20);

		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(Heading));
		Assert.assertEquals(true, heading.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Heading is displayed" + heading.getText());

		WebElement accountNo = wait.until(ExpectedConditions.visibilityOfElementLocated(AccountNo));
		Assert.assertEquals(true, accountNo.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Account No is displayed");

		WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(SubmitButton));
		Assert.assertEquals(true, submitButton.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Submit Button is displayed");

		WebElement resetButton = wait.until(ExpectedConditions.visibilityOfElementLocated(ResetButton));
		Assert.assertEquals(true, resetButton.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Reset Button is displayed");

		WebElement homeLink = wait.until(ExpectedConditions.visibilityOfElementLocated(HomeLink));
		Assert.assertEquals(true, homeLink.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Home Link is displayed");
	}

	public void deleteAccountValidation() {
		// TODO Auto-generated method stub
		wait = new WebDriverWait(driver, 20);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("------------------------------------------------");
		System.out.println(" > Enter the Account Number : ");
		String enterAccountNumber = sc.nextLine();
		String regex = "[0-9]+";

		if (enterAccountNumber.matches(regex)) {
			WebElement accountNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(accountNo));
			accountNumber.sendKeys(enterAccountNumber);
			WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(SubmitButton));
			submitButton.click();
			System.out.println("------------------------------------------------");
			System.out.println(" > Delete Account page is displayed ");
		}

		else if (!enterAccountNumber.matches(regex) || !enterAccountNumber.matches("\\s")) {
			WebElement accountNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(accountNo));
			accountNumber.sendKeys(enterAccountNumber);
			WebElement Alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alert));
			System.out.println(Alert.getText());
		}

	}
	public void validation() {
		
	}

	public void resetButton() {
		driver.navigate().back();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("------------------------------------------------");
		System.out.println(" > Enter the Account Number : ");
		String enterAccountNumber = sc.nextLine();
		WebElement AccountNo = wait.until(ExpectedConditions.visibilityOfElementLocated(accountNo));
		AccountNo.sendKeys(enterAccountNumber);
		WebElement resetButton = wait.until(ExpectedConditions.visibilityOfElementLocated(ResetButton));
		resetButton.click();
		System.out.println("------------------------------------------------");
		System.out.println(" > Fields cleared");
	}

	public void homeLink() {
		WebElement homeLink = wait.until(ExpectedConditions.visibilityOfElementLocated(HomeLink));
		homeLink.click();
		System.out.println("------------------------------------------------");
		System.out.println(" > " + driver.getTitle());
	}
}
