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
import pageObjects.ViewStoresObjects;

public class ViewStores extends BaseFile {
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
	public void clickStore() {
		ViewStoresObjects vso = new ViewStoresObjects(driver);
		vso.getStore().click();
		log.info("Clicking on Store Option in Header Bar");
	}
	@Test
	public void selectLocation() throws IOException {
		ViewStoresObjects vso = new ViewStoresObjects(driver);
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		String city = prop.getProperty("city");
		log.info("Entering City to get the Store Location");
		vso.getLocation(city).click();
	}
	@AfterTest
	public void close() {
		driver.quit();
		driver = null;
		log.info("End of View Details for Store Test Case");
	}

}
