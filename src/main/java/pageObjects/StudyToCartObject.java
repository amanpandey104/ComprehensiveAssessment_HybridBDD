package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class StudyToCartObject {
	public WebDriver driver = null;
	By close = By.xpath("//a[@class='close-reveal-modal hide-mobile']");
	By study = By.xpath("//li[@class='topnav_item studyunit']"); 
	By bookshelf = By.xpath("//a[@href='/bookshelf?src=g_topnav_study_storage_bookshelves']");
	By product = By.xpath("//a[@href='/products/alberto-bookshelf?sku=FNSGBR11TK30086&src=subcat']");
	By cart = By.id("add-to-cart-button");
	public StudyToCartObject(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getClose() {
		return driver.findElement(close);
	}
	public Actions getStudy() {
		WebElement studyNav = driver.findElement(study);
		Actions s = new Actions(driver);
		return s.moveToElement(studyNav);
	}
	public WebElement getBookshelf() {
		return driver.findElement(bookshelf);
	}
	public WebElement getProduct() {
		return driver.findElement(product);
	}
	public WebElement getCart() {
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		String parentWindow=I1.next();
		String childWindow=I1.next();
		driver.switchTo().window(childWindow);
		return driver.findElement(cart);
	}
}
