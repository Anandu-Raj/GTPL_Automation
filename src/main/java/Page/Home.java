package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Home {
	WebDriver driver;
	WebDriverWait wait;

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	By newcustomer = By.xpath("//*[text()='New Account']");
	By FirstIframe = By.xpath("//*[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']");
	By SecondIFrame = By.xpath("//*[@id='ad_iframe']"); 
	By CloseButton = By.xpath("//*[@id='dismiss-button']");
	public void newaccdisplay() {

		wait = new WebDriverWait(driver, 20);
		WebElement newcustomermenu = wait.until(ExpectedConditions.visibilityOfElementLocated(newcustomer));
		Assert.assertEquals(true, newcustomermenu.isDisplayed());
		System.out.println("NewAccount menu tittle verification passed");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", newcustomermenu);
		
		
		WebElement Iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(FirstIframe));
		driver.switchTo().frame(Iframe); 
		WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(SecondIFrame)); 
		driver.switchTo().frame(iframe); WebElement Close = wait.until(ExpectedConditions.visibilityOfElementLocated(CloseButton)); 
		Close.click(); 
		driver.switchTo().defaultContent();

	}
	
	

}
