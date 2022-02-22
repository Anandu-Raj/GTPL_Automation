package GTPLBank;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomepageGTPL {
	WebDriver driver;
	WebDriverWait wait;

	By Managerpage = By.xpath("//*[text()='Mini Statement']");
	By FirstIframe = By.xpath("//*[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']");
	By SecondIFrame = By.xpath("//*[@id='ad_iframe']");
	By CloseButton = By.xpath("//*[@id='dismiss-button']");

	public HomepageGTPL(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	public void checkUrl() {
		String ActualUrl = "https://demo.guru99.com/V1/html/Managerhomepage.php";
		String ExpectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(ExpectedUrl, ActualUrl);
		System.out.println("Manager HomePage is Displayed");

	}

	public void homepageGTPL() {
		wait = new WebDriverWait(driver, 10);
		WebElement ManagerPage = wait.until(ExpectedConditions.visibilityOfElementLocated(Managerpage));
		Assert.assertEquals(true, ManagerPage.isDisplayed());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ManagerPage);
		WebElement Iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(FirstIframe));
		driver.switchTo().frame(Iframe);
		WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(SecondIFrame));
		driver.switchTo().frame(iframe);
		WebElement Close = wait.until(ExpectedConditions.visibilityOfElementLocated(CloseButton));
		Close.click();
		driver.switchTo().defaultContent();
	}
}
