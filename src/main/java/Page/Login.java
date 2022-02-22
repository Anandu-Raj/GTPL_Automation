package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	WebDriver driver;
	WebDriverWait wait;

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.xpath("//*[@name=\"uid\"]");
	By pass = By.xpath("//*[@name=\"password\"]");
	By submit = By.xpath("//*[@name=\"btnLogin\"]");
	

	public void login(String email, String password) {
		wait = new WebDriverWait(driver, 20);

		WebElement userid = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		userid.click();
		userid.sendKeys(email);
		WebElement we2 = wait.until(ExpectedConditions.visibilityOfElementLocated(pass));
		we2.click();
		we2.sendKeys(password);
		WebElement we3 = wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
		we3.click();
}

}
