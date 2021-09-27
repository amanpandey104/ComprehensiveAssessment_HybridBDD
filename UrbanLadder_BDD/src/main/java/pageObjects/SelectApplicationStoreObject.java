package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectApplicationStoreObject {
	public WebDriver driver = null;
	public String appStore = "";
	By close = By.xpath("//a[@class='close-reveal-modal hide-mobile']");
	public SelectApplicationStoreObject(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getClose() {
		return driver.findElement(close);
	}
	public WebElement getAppStore(String appStore) {
		this.appStore = appStore;
		By store = By.xpath("//img[@class='"+ appStore + "']");
		return driver.findElement(store);
	}
}
