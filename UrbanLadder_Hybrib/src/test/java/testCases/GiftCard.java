package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BaseFile;
import pageObjects.GiftCardObjects;

public class GiftCard extends BaseFile {
	public static Logger log = LogManager.getLogger(BaseFile.class.getName());
	public WebDriver driver = null;
	public Properties prop = null;
	@BeforeTest
	public void openBrowser() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
	public void selectGiftCard() throws InterruptedException {
		GiftCardObjects gfo = new GiftCardObjects(driver);
		Thread.sleep(5000);
		gfo.getClose().click();
		Thread.sleep(3000);
		gfo.getGiftCard().click();
		log.info("Selecting Gift Card Option from Header Bar");
	}
	@Test(priority = 2)
	public void selectEvent() throws IOException {
		GiftCardObjects gfo = new GiftCardObjects(driver);
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		String event = prop.getProperty("event");
		log.info("Selecting Event for Gift Card");
		gfo.getEvent(event).click();
	}
	@Test(priority = 3)
	public void enterAmount() throws IOException {
		GiftCardObjects gfo = new GiftCardObjects(driver);
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		gfo.getAmount().sendKeys(prop.getProperty("amount"));
		log.info("Entering Amount of Gift Card");
	}
	@Test(priority = 4)
	public void clickNext() {
		GiftCardObjects gfo = new GiftCardObjects(driver);
		gfo.getNextButton().click();
	}
	@Test(priority = 5)
	public void enterDetails() throws IOException {
		GiftCardObjects gfo = new GiftCardObjects(driver);
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		gfo.getRecipientName().sendKeys(prop.getProperty("recipientName"));
		gfo.getRecipientEmail().sendKeys(prop.getProperty("recipientEmail"));
		gfo.getFromName().sendKeys(prop.getProperty("fromName"));
		gfo.getFromEmail().sendKeys(prop.getProperty("fromEmail"));
		gfo.getFromPhoneNumber().sendKeys(prop.getProperty("fromPhoneNumber"));
		gfo.getMessage().sendKeys(prop.getProperty("message"));
		log.info("Entering Recipient's INFO and From's INFO");
	}
	@AfterTest
	public void close() {
		driver.quit();
		driver = null;
		log.info("End of Gift Card Test Case");
	}
}
