package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrackOrderObject {
	public WebDriver driver = null;
	By close = By.xpath("//a[@class='close-reveal-modal hide-mobile']");
	By track = By.xpath("//a[@href='/orders']");
	By orderNumber = By.xpath("//input[@placeholder='Order Number']");
	By phoneNumber = By.xpath("//input[@placeholder='Phone Number']");
	By submitButton = By.xpath("//button[@type='submit']");
	
	public TrackOrderObject(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getClose() {
		return driver.findElement(close);
	}
	public WebElement getTrack() {
		return driver.findElement(track);
	}
	public WebElement getOrderNumber() {
		return driver.findElement(orderNumber);
	}
	public WebElement getPhoneNumber() {
		return driver.findElement(phoneNumber);
	}
	public WebElement getSubmitButton() {
		return driver.findElement(submitButton);
	}
}
