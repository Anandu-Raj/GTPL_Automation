package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GTPLLoginPage {
	WebDriver driver;
	WebDriverWait wait;

	public GTPLLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By UserID = By.xpath("//*[@name='uid']");
	By Password = By.xpath("//*[@name='password']");
	By LOGIN = By.xpath("//*[@name='btnLogin']");

	public void userID(String ID) {
		wait = new WebDriverWait(driver, 20);
		WebElement UserId = wait.until(ExpectedConditions.visibilityOfElementLocated(UserID));
		UserId.sendKeys(ID);
	}

	public void PassWord(String password) {
		wait = new WebDriverWait(driver, 20);
		WebElement passWord = wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
		passWord.sendKeys(password);
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN));
		login.click();
	}

}
