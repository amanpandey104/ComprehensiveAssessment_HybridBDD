package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObject {
	public WebDriver driver = null;
	By login = By.xpath("//a[@class='login-link link-color']");
	By email = By.id("spree_user_email");
	By password = By.id("spree_user_password");
	By submit = By.id("ul_site_login");
	public LoginObject(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getLoginButton() {
		return driver.findElement(login);
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
