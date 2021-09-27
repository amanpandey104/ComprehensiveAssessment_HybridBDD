package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewStoresObjects {	
	public WebDriver driver = null;
	public String city = "";
	By close = By.xpath("//a[@class='close-reveal-modal hide-mobile']");
	By store = By.xpath("//a[@href='../../furniture-stores?src=header']");
	public ViewStoresObjects(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getClose() {
		return driver.findElement(close);
	}
	public WebElement getStore() {
		return driver.findElement(store);
	}
	public WebElement getLocation(String city) {
		this.city = city;
		By loc = By.xpath("//h3[text()='"+ city + "']");
		return driver.findElement(loc);
	}
}
