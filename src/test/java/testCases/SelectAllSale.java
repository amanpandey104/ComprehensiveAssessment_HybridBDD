package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BaseFile;
import pageObjects.SelectAllSaleObject;

public class SelectAllSale extends BaseFile {
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
	public void clickSale() throws InterruptedException {
		SelectAllSaleObject saso = new SelectAllSaleObject(driver);
		saso.getClose().click();
		Thread.sleep(2000);
		saso.getSale().build().perform();
		log.info("Hovering on Sale from Navigation Bar");
		Thread.sleep(2000);
		saso.getAllSale().click();
		log.info("Clicking on Sale on All Product");
	}
	@Test(priority = 2)
	public void getTitle() {
		String actual = driver.getTitle();
		if(!actual.contains("All Products on Sale")) {
			log.info("No we have not Navigated to ALL PRODUCTS ON SALE page");
			Assert.assertTrue(false);
		}else {
			log.info("Yes we Navigated to ALL PRODUCTS ON SALE page");
			Assert.assertTrue(true);
		}
	}
	@AfterTest
	public void close() {
		driver.quit();
		driver = null;
		log.info("End of Selecting All Sale Test Case");
	}
}
