package GTPLBank;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MiniStatement {
	WebDriver driver;
	WebDriverWait wait;

	By title = By.xpath("//*[text()='Mini Statement Form']");
	By accountno = By.xpath("//*[@name='accountno']");
	By alert = By.xpath("//*[text()='Account Number must not be blank']");
	By Submit = By.xpath("//*[@name='AccSubmit']");
	By Reset = By.xpath("//*[@name='res']");
	By HomeLink = By.xpath("//*[text()='Home']");

	By AccountNo = By.xpath("//*[text()='Account No']");

	public MiniStatement(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

//	public void title() {
//		wait = new WebDriverWait(driver, 10);
//		String ActualUrl = "https://demo.guru99.com/V1/html/MiniStatementInput.php";
//		String ExpectedUrl = driver.getCurrentUrl();
//		Assert.assertEquals(ExpectedUrl, ActualUrl);
//		System.out.println("The Mini Statement Form is Displayed");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(title)).click();
//	}
	public void Display() {
		WebElement title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(title));
		Assert.assertEquals(true, title1.isDisplayed());
		System.out.println("Title is displayed");

		WebElement AccountNo1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AccountNo));
		Assert.assertEquals(true, AccountNo1.isDisplayed());
		System.out.println("Account No is displayed");

		WebElement Submit1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Submit));
		Assert.assertEquals(true, Submit1.isDisplayed());
		System.out.println("Submit button is displayed");

		WebElement Reset1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Reset));
		Assert.assertEquals(true, Reset1.isDisplayed());
		System.out.println("Reset button is displayed");

		WebElement HomeLink1 = wait.until(ExpectedConditions.visibilityOfElementLocated(HomeLink));
		Assert.assertEquals(true, HomeLink1.isDisplayed());
		System.out.println("HomeLink is displayed");
	}

	@SuppressWarnings("resource")
	public void accountno() {
		wait = new WebDriverWait(driver, 10);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account Number : ");
		String enteraccountno = sc.nextLine();
		String regex = "[0-9]+";

		if (enteraccountno.matches(regex)) {
			WebElement AccountNum = wait.until(ExpectedConditions.visibilityOfElementLocated(accountno));
			AccountNum.sendKeys(enteraccountno);
		} else if (!enteraccountno.matches(regex) || !enteraccountno.matches("\\s")) {
			WebElement AccountNum = wait.until(ExpectedConditions.visibilityOfElementLocated(accountno));
			AccountNum.sendKeys(enteraccountno);
			WebElement alertaccountno = wait.until(ExpectedConditions.visibilityOfElementLocated(alert));
			System.out.println(alertaccountno.getText());
		}
	}
	public void Resetbutton() {
		driver.navigate().back();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account Number : ");
		String enteraccountno = sc.nextLine();
		WebElement AccountNum = wait.until(ExpectedConditions.visibilityOfElementLocated(accountno));
		AccountNum.sendKeys(enteraccountno);
		WebElement Resetbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(Reset));
		Resetbutton.click();
		System.out.println("The Reset fields cleared");
	}
	public void homeLink() {
		WebElement homeLink = wait.until(ExpectedConditions.visibilityOfElementLocated(HomeLink));
		homeLink.click();
		System.out.println(" " + driver.getTitle());
	}
	public void ministatement() {
		wait = new WebDriverWait(driver, 10);
		WebElement account1 = wait.until(ExpectedConditions.visibilityOfElementLocated(accountno));
		account1.sendKeys("2354867548");
	}
}
