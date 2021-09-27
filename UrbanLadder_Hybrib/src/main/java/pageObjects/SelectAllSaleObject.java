package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SelectAllSaleObject {
	public WebDriver driver = null;
	By close = By.xpath("//a[@class='close-reveal-modal hide-mobile']");
	By sale = By.xpath("//li[@class='topnav_item saleunit']");
	By allSale = By.xpath("//a[@href='/all-products-on-sale-freedom-sale?src=g_topnav_sale_promotions_all-products-on-sale']");
	
	public SelectAllSaleObject (WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getClose() {
		return driver.findElement(close);
	}
	public Actions getSale() {
		WebElement saleNav = driver.findElement(sale);
		Actions s = new Actions(driver);
		return s.moveToElement(saleNav);
	}
	public WebElement getAllSale() {
		return driver.findElement(allSale);
	}
}
