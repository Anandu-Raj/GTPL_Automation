package GTPL_DeleteAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class GTPLBank_HomePage {
	WebDriver driver;
	WebDriverWait wait;

	public GTPLBank_HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By DeleteAccount = By.xpath("//*[text()='Delete Account']");
	By FirstIframe = By.xpath("//*[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']");
	By SecondIFrame = By.xpath("//*[@id='ad_iframe']");
	By CloseButton = By.xpath("//*[@id='dismiss-button']");

	public void checkURL() {
		String actualUrl = "https://demo.guru99.com/V1/html/Managerhomepage.php";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("------------------------------------------------");
		System.out.println(" > URL Matched " + driver.getCurrentUrl());
	}

	public void checkModule() {
		wait = new WebDriverWait(driver, 20);
		WebElement Deleteaccount = wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteAccount));
		Assert.assertEquals(true, Deleteaccount.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Delete Account menu is displayed");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", Deleteaccount);
		WebElement Iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(FirstIframe));
		driver.switchTo().frame(Iframe);
		WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(SecondIFrame));
		driver.switchTo().frame(iframe);
		WebElement Close = wait.until(ExpectedConditions.visibilityOfElementLocated(CloseButton));
		Close.click();
		driver.switchTo().defaultContent();
	}
}
