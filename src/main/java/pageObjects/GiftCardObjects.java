package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GiftCardObjects {
	public WebDriver driver = null;
	By close = By.xpath("//a[@class='close-reveal-modal hide-mobile']");
	By giftCard = By.xpath("//a[@href='../../gift-cards?src=header']");
	By amt = By.id("ip_2251506436");
	By nextButton = By.xpath("//button[@type='button']");
	By recipientName = By.id("ip_4036288348"); 
	By recipientEmail = By.id("ip_137656023");
	By fromName = By.id("ip_1082986083");
	By fromEmail = By.id("ip_4081352456");
	By fromPhoneNumber = By.id("ip_2121573464");
	By msg = By.id("ip_582840596");
	
	public GiftCardObjects(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getClose() {
		return driver.findElement(close);
	}
	public WebElement getGiftCard() {
		return driver.findElement(giftCard);
	}
	public WebElement getEvent(String event) {
		By cardEvent = By.xpath("//h3[text()='"+ event + "']");
		return driver.findElement(cardEvent);
	}
	public WebElement getAmount() {
		return driver.findElement(amt);
	}
	public WebElement getNextButton() {
		return driver.findElement(nextButton);
	}
	public WebElement getRecipientName() {
		return driver.findElement(recipientName);
	}
	public WebElement getRecipientEmail() {
		return driver.findElement(recipientEmail);
	}
	public WebElement getFromName() {
		return driver.findElement(fromName);
	}
	public WebElement getFromEmail() {
		return driver.findElement(fromEmail);
	}
	public WebElement getFromPhoneNumber() {
		return driver.findElement(fromPhoneNumber);
	}
	public WebElement getMessage() {
		return driver.findElement(msg);
	}
}
