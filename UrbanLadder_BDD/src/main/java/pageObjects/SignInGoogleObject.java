package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInGoogleObject {
	public WebDriver driver = null;
	By gConnect = By.id("google_login");
	By email = By.id("identifierId");
	By password = By.xpath("//input[@name='password']");
	By submit = By.xpath("//button[@type='button']");
	public SignInGoogleObject(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getGConnect() {
		return driver.findElement(gConnect);
	}
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getSubmitButton() {
		return driver.findElement(submit);
	}
	
}
