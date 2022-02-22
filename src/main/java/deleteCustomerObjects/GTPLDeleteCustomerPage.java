package deleteCustomerObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GTPLDeleteCustomerPage {
	WebDriver driver;
	WebDriverWait wait;

	public GTPLDeleteCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	By dltCusForm = By.xpath("(//*[text()='Delete Customer Form'])[1]");
	By cusID = By.xpath("//*[text()='Customer ID']");
	By cusIDInput = By.xpath("//*[@name='cusid']");
	By submit = By.xpath("//*[@name='AccSubmit']");
	By reset = By.xpath("//*[@name='res']");
	By alert = By.xpath("//*[@id='message14']");
	By home = By.xpath("//*[text()='Home']");

	public void deleteCustomerPageTitle(String DCPtitle) {
		String actualtitle = DCPtitle;
		String expectedtitle = driver.getTitle();
		Assert.assertEquals(expectedtitle, actualtitle);
		System.out.println("---------------------------------------------------------");
		System.out.println("You entered Gtpl Bank Delete Customer Page (TC_DC_003)");
	}

	public void deleteCustomerFormTitle() {
		wait = new WebDriverWait(driver, 20);
		WebElement deleteCustomerForm = wait.until(ExpectedConditions.visibilityOfElementLocated(dltCusForm));
		Assert.assertEquals(true, deleteCustomerForm.isDisplayed());
		System.out.println(deleteCustomerForm.getText() + " title is displayed. (TC_DC_004)");
	}

	public void customerIDTitleAndInputD() {
		wait = new WebDriverWait(driver, 20);
		WebElement customerID = wait.until(ExpectedConditions.visibilityOfElementLocated(cusID));
		Assert.assertEquals(true, customerID.isDisplayed());

		WebElement customerIDInput = wait.until(ExpectedConditions.visibilityOfElementLocated(cusIDInput));
		Assert.assertEquals(true, customerIDInput.isDisplayed());

		System.out.println(customerID.getText() + " title and input field for customer ID is displayed. (TC_DC_005)");

		customerIDInput.sendKeys("123");
		System.out.println("User able to click on input field and to enter the value (TC_DC_006)");
	}

	public void SubmitButtonD() {
		wait = new WebDriverWait(driver, 20);
		WebElement sub = wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
		Assert.assertEquals(true, sub.isDisplayed());
		System.out.println("---------------------------------------------------------");
		System.out.println("Submit button is displayed. (TC_DC_007)");

		sub.click();
		System.out.println("User able to click on Submit button. (TC_DC_008)");
		driver.navigate().back();
	}

	public void ResetButtonD() {
		wait = new WebDriverWait(driver, 20);
		WebElement res = wait.until(ExpectedConditions.visibilityOfElementLocated(reset));
		Assert.assertEquals(true, res.isDisplayed());
		System.out.println("Reset button is displayed. (TC_DC_009)");

		res.click();
		System.out.println("User able to click on Reset button and able to clear the input field. (TC_DC_010)");
	}

	public void inputFormatD(String try1, String try2, String try3, String try4, String try5) {
		wait = new WebDriverWait(driver, 20);
		
		WebElement customerIDInput = wait.until(ExpectedConditions.visibilityOfElementLocated(cusIDInput));
		customerIDInput.sendKeys(try1);
		WebElement ErrorMsg1 = wait.until(ExpectedConditions.visibilityOfElementLocated(alert));
		Assert.assertEquals(true, ErrorMsg1.isDisplayed());
		System.out.println("---------------------------------------------------------");
		System.out.println(ErrorMsg1.getText() + " (TC_DC_011)");
		
		WebElement res = wait.until(ExpectedConditions.visibilityOfElementLocated(reset));
		res.click();
		
		customerIDInput.sendKeys(try2);
		System.out.println("Test failed - Alert message for invalid credentials not diplaying (TC_DC_011)");
		
		res.click();
		
		customerIDInput.sendKeys(try3);
		WebElement ErrorMsg3 = wait.until(ExpectedConditions.visibilityOfElementLocated(alert));
		Assert.assertEquals(true, ErrorMsg3.isDisplayed());
		System.out.println(ErrorMsg3.getText() + " (TC_DC_011)");
		
		res.click();
		
		customerIDInput.sendKeys(try4);
		System.out.println("Test failed - Error message for space between characters not diplaying (TC_DC_011)");
		
		res.click();
		
		customerIDInput.sendKeys(try5);
		WebElement sub = wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
		sub.click();
		String expectedTitle = driver.getTitle();
		String actualTitle = " Guru99 Bank Edit Customer Entry Page ";
		Assert.assertNotEquals(actualTitle, expectedTitle);
		System.out.println("Test failed - Not entering into Guru99 Bank Edit Customer Entry Page (TC_DC_011)");
		driver.navigate().back();
	}
	
	public void HomeLinkD() {
		wait = new WebDriverWait(driver, 20);
		WebElement homelink = wait.until(ExpectedConditions.visibilityOfElementLocated(home));
		Assert.assertEquals(true, homelink.isDisplayed());
		System.out.println("---------------------------------------------------------");
		System.out.println("Home link is displayed. (TC_DC_012)");

		homelink.click();
		String expectedTitle = driver.getTitle();
		String actualTitle = "GTPL Bank Manager HomePage";
		Assert.assertNotEquals(actualTitle, expectedTitle); 
		System.out.println("Test failed - User able to click on Home link but not able to navigate to GTPL Bank Manager HomePage. (TC_DC_013)");
	}
}
