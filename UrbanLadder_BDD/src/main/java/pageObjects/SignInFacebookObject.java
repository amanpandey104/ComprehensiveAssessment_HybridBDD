package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SignInFacebookObject {
	public WebDriver driver = null;
	By close = By.xpath("//a[@class='close-reveal-modal hide-mobile']");
	By icon = By.xpath("//span[@class='header-icon-link user-profile-icon']");
	By signin = By.xpath("//a[@class='signup-link authentication_popup']");
	By fbConnect = By.id("facebook_login");
	By email = By.id("email");
	By password = By.id("pass");
	By submit = By.id("loginbutton");
	public SignInFacebookObject(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getClose() {
		return driver.findElement(close);
	}
	public Actions getIcon() {
		WebElement iconNav = driver.findElement(icon);
		Actions s = new Actions(driver);
		return s.moveToElement(iconNav);
	}
	public WebElement getFbConnect() {
		return driver.findElement(fbConnect);
	}
	public WebElement getSigninButton() {
		return driver.findElement(signin);
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
