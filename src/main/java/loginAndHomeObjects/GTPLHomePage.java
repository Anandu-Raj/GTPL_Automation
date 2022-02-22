package loginAndHomeObjects;

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

	By edCustomer = By.xpath("//*[text()='Edit Customer']");
	By dltCustomer = By.xpath("//*[text()='Delete Customer']");
	By FirstIframe = By.xpath("//*[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']");
	By SecondIFrame = By.xpath("//*[@id='ad_iframe']"); 
	By CloseButton = By.xpath("//*[@id='dismiss-button']");
	
	public void homePageTitle(String HPtitle) {
		String actualtitle = HPtitle;
		String expectedtitle = driver.getTitle();
		Assert.assertEquals(expectedtitle, actualtitle);
		System.out.println("You entered GTPL Bank Manager HomePage");
	}

	public void editCustomerMenu() {
		wait = new WebDriverWait(driver, 20);
		WebElement editCustomerMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(edCustomer));
		Assert.assertEquals(true, editCustomerMenu.isDisplayed());
		System.out.println("Edit Customer Menu is displayed. Click on it. (TC_EC_001)");
		editCustomerMenu.click();
		WebElement Iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(FirstIframe));
		if (Iframe.isDisplayed()) {
			driver.switchTo().frame(Iframe);
			WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(SecondIFrame));
			driver.switchTo().frame(iframe);
			WebElement Close = wait.until(ExpectedConditions.visibilityOfElementLocated(CloseButton));
			Close.click();
			driver.switchTo().defaultContent();
			System.out.println("Edit Customer Menu clicked. (TC_EC_002)");
		}
		else {
			System.out.println("Edit Customer Menu clicked. (TC_EC_002)");
		}
	}

	public void deleteCustomerMenu() {
		wait = new WebDriverWait(driver, 20);
		WebElement deleteCustomerMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(dltCustomer));
		Assert.assertEquals(true, deleteCustomerMenu.isDisplayed());
		System.out.println("Delete Customer Menu is displayed. Click on it. (TC_DC_001)");
		deleteCustomerMenu.click();
		WebElement Iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(FirstIframe));
		if (Iframe.isDisplayed()) {
			driver.switchTo().frame(Iframe);
			WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(SecondIFrame));
			driver.switchTo().frame(iframe);
			WebElement Close = wait.until(ExpectedConditions.visibilityOfElementLocated(CloseButton));
			Close.click();
			driver.switchTo().defaultContent();
			System.out.println("Delete Customer Menu clicked. (TC_DC_002)");
		}
		else {
			System.out.println("Delete Customer Menu clicked. (TC_DC_002)");
		}
	}

}
