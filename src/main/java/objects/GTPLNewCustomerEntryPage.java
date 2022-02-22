package objects;

import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GTPLNewCustomerEntryPage {
	WebDriver driver;
	WebDriverWait wait;

	public GTPLNewCustomerEntryPage(WebDriver driver) {
		this.driver = driver;
	}

	By CustomerName = By.xpath("//*[@name='name']");
	By Gender = By.xpath("//*[@name='rad1']");
	By DateOfBirth = By.xpath("//*[@name='dob']");
	By Address = By.xpath("//*[@name='addr']");
	By City = By.xpath("//*[@name='city']");
	By State = By.xpath("//*[@name='state']");
	By PIN = By.xpath("//*[@name='pinno']");
	By TelephoneNumber = By.xpath("//*[@name='telephoneno']");
	By Email = By.xpath("//*[@name='emailid']");
	By SubmitButton = By.xpath("//*[@name='sub']");
	By Reset = By.xpath("//*[@name='res']");
	By Home = By.xpath("//*[text()='Home']");
	By AlertCustomerName = By.xpath("//*[@id='message']");
	By AlertCity = By.xpath("//*[@id='message4']");
	By AlertState = By.xpath("//*[@id='message5']");
	By AlertPIN = By.xpath("//*[@id='message6']");
	By AlertTelephoneNumber = By.xpath("//*[@id='message7']");
	By AlertEmailId = By.xpath("//*[@id='message9']");

	public void NewCustomerEntryPageTitle() {
		String actualTitle = "Gtpl Bank New Customer Entry Page";
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("The title of the page is displayed as Gtpl Bank New Customer Entry Page");
	}

	public void NewCustomerEntryPageDisplay() {
		wait = new WebDriverWait(driver, 20);
		WebElement customerName = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerName));
		Assert.assertEquals(true, customerName.isDisplayed());
		System.out.println("Customer Name field is displayed");

		WebElement gender = wait.until(ExpectedConditions.visibilityOfElementLocated(Gender));
		Assert.assertEquals(true, gender.isDisplayed());
		System.out.println("Gender field is displayed");

		WebElement dateOfBirth = wait.until(ExpectedConditions.visibilityOfElementLocated(DateOfBirth));
		Assert.assertEquals(true, dateOfBirth.isDisplayed());
		System.out.println("Date of Birth field is displayed");

		WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(Address));
		Assert.assertEquals(true, address.isDisplayed());
		System.out.println("Address field is displayed");

		WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(City));
		Assert.assertEquals(true, city.isDisplayed());
		System.out.println("City field is displayed");

		WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(State));
		Assert.assertEquals(true, state.isDisplayed());
		System.out.println("State field is displayed");

		WebElement pin = wait.until(ExpectedConditions.visibilityOfElementLocated(PIN));
		Assert.assertEquals(true, pin.isDisplayed());
		System.out.println("PIN field is displayed");

		WebElement telephoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(TelephoneNumber));
		Assert.assertEquals(true, telephoneNumber.isDisplayed());
		System.out.println("Telephone Number field is displayed");

		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
		Assert.assertEquals(true, email.isDisplayed());
		System.out.println("Email Id field is displayed");

		WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(SubmitButton));
		Assert.assertEquals(true, submit.isDisplayed());
		System.out.println("Submit button is displayed");

		WebElement reset = wait.until(ExpectedConditions.visibilityOfElementLocated(Reset));
		Assert.assertEquals(true, reset.isDisplayed());
		System.out.println("Reset button is displayed");

		WebElement home = wait.until(ExpectedConditions.visibilityOfElementLocated(Home));
		Assert.assertEquals(true, home.isDisplayed());
		System.out.println("Home link is displayed");
	}

	public void formatCustomerName() {
		wait = new WebDriverWait(driver, 20);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Customer Name : ");
		String Customername = sc.nextLine();
		String regex = "[a-zA-Z]+";

		if (Customername.matches(regex)) {
			WebElement customerName = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerName));
			customerName.sendKeys(Customername);
		}

		else if (!Customername.matches(regex) || !Customername.matches("\\s")) {
			WebElement customerName = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerName));
			customerName.sendKeys(Customername);
			WebElement alertCustomerName = wait.until(ExpectedConditions.visibilityOfElementLocated(AlertCustomerName));
			System.out.println(alertCustomerName.getText());
		}
	}

	public void formatDateOfBirth() {
		wait = new WebDriverWait(driver, 20);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Date of Birth : ");
		String enterdateOfBirth = sc.nextLine();
		String regex = "[0-9]+";

		if (enterdateOfBirth.matches(regex)) {
			WebElement dateOfBirth = wait.until(ExpectedConditions.visibilityOfElementLocated(DateOfBirth));
			dateOfBirth.sendKeys(enterdateOfBirth);
		} else if (!enterdateOfBirth.matches(regex)) {
			WebElement dateOfBirth = wait.until(ExpectedConditions.visibilityOfElementLocated(DateOfBirth));
			dateOfBirth.sendKeys(enterdateOfBirth);
			System.out.println("invalid");
		}

	}

	public void formatAddress() {
		wait = new WebDriverWait(driver, 20);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Address : ");
		String enterAddress = sc.nextLine();
		String regexNumbers = "[0-9]+";
		String regexCharacters = "[a-zA-Z]+";

		if (enterAddress.matches(regexNumbers) || enterAddress.matches(regexCharacters)) {
			WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(Address));
			address.sendKeys(enterAddress);
		}

		else if (!enterAddress.matches(regexNumbers) || !enterAddress.matches(regexCharacters)
				|| !enterAddress.matches("\\s")) {
			WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(Address));
			address.sendKeys(enterAddress); // error message doesn't displays

		}
	}

	public void formatCity() {
		wait = new WebDriverWait(driver, 20);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the City : ");
		String enterCity = sc.nextLine();
		String regex = "[a-zA-Z]+";

		if (enterCity.matches(regex)) {
			WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(City));
			city.sendKeys(enterCity);
		}

		else if (!enterCity.matches(regex) || !enterCity.matches("\\s")) {
			WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(City));
			city.sendKeys(enterCity);
			WebElement alertcity = wait.until(ExpectedConditions.visibilityOfElementLocated(AlertCity));
			System.out.println(alertcity.getText());
		}
	}

	public void formatState() {
		wait = new WebDriverWait(driver, 20);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the State : ");
		String enterState = sc.nextLine();
		String regex = "[a-zA-Z]+";

		if (enterState.matches(regex)) {
			WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(State));
			state.sendKeys(enterState);
		}

		else if (!enterState.matches(regex) || !enterState.matches("\\s")) {
			WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(State));
			state.sendKeys(enterState);
			WebElement alertstate = wait.until(ExpectedConditions.visibilityOfElementLocated(AlertState));
			System.out.println(alertstate.getText());
		}
	}

	public void formatPIN() {
		wait = new WebDriverWait(driver, 20);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the PIN : ");
		String enterPIN = sc.nextLine();
		String regex = "^[0-9]{6}$";

		if (enterPIN.matches(regex)) {
			WebElement pin = wait.until(ExpectedConditions.visibilityOfElementLocated(PIN));
			pin.sendKeys(enterPIN);
		}

		else if (!enterPIN.matches(regex) || !enterPIN.matches("\\s") || !enterPIN.matches("\\s[0-9]{5}")) {
			WebElement pin = wait.until(ExpectedConditions.visibilityOfElementLocated(PIN));
			pin.sendKeys(enterPIN);
			WebElement alertPIN = wait.until(ExpectedConditions.visibilityOfElementLocated(AlertPIN));
			System.out.println(alertPIN.getText());
		}
	}

	public void formatTelephoneNumber() {
		wait = new WebDriverWait(driver, 20);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Telephone Number : ");
		String enterTelephoneNumber = sc.nextLine();
		String regex = "[0-9]+";

		if (enterTelephoneNumber.matches(regex)) {
			WebElement telephoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(TelephoneNumber));
			telephoneNumber.sendKeys(enterTelephoneNumber);
		}

		else if (!enterTelephoneNumber.matches(regex) || !enterTelephoneNumber.matches("\\s")) {
			WebElement telephoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(TelephoneNumber));
			telephoneNumber.sendKeys(enterTelephoneNumber);
			WebElement alertTelephoneNumber = wait
					.until(ExpectedConditions.visibilityOfElementLocated(AlertTelephoneNumber));
			System.out.println(alertTelephoneNumber.getText());
		}
	}

	public void formatEmailId() {
		wait = new WebDriverWait(driver, 20);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Email Id : ");
		String enterEmailId = sc.nextLine();
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

		if (enterEmailId.matches(regex)) {
			WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
			email.sendKeys(enterEmailId);
		}

		else if (!enterEmailId.matches(regex) || !enterEmailId.matches("\\s")) {
			WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
			email.sendKeys(enterEmailId);
			WebElement alertEmailId = wait.until(ExpectedConditions.visibilityOfElementLocated(AlertEmailId));
			System.out.println(alertEmailId.getText());
		}
	}

	public void functionalitySubmitButton() {
		wait = new WebDriverWait(driver, 20);
		WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(SubmitButton));
		submit.click();

	}

	public void functionalityResetButton() {
		wait = new WebDriverWait(driver, 20);
		driver.navigate().back();
		WebElement reset = wait.until(ExpectedConditions.visibilityOfElementLocated(Reset));
		reset.click();

	}

	public void functionalityHomeLink() {
		wait = new WebDriverWait(driver, 20);
		WebElement homeLink = wait.until(ExpectedConditions.visibilityOfElementLocated(Home));
		homeLink.click();
		String actualUrl = "https://demo.guru99.com/V1/html/Managerhomepage.php";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("Navigated to Home Page");
	}
}
