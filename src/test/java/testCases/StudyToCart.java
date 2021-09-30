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
import pageObjects.StudyToCartObject;

public class StudyToCart extends BaseFile {
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
	@Test
	public void checkCart() throws InterruptedException {
		StudyToCartObject stco = new StudyToCartObject(driver);
		Thread.sleep(5000);
		stco.getClose().click();
		Thread.sleep(2000);
		stco.getStudy().build().perform();
		log.info("Hovering over Study option in Navigation Bar");
		Thread.sleep(2000);
		stco.getBookshelf().click();
		Thread.sleep(2000);
		stco.getProduct().click();
		log.info("Selecting Product");
		stco.getCart().click();
		log.info("Adding Product to Cart");
	}
	@AfterTest
	public void close() {
		driver.quit();
		driver = null;
		log.info("End of Adding Product to Cart Test Case");
	}
}
