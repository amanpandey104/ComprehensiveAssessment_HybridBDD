package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.BaseFile;
import pageObjects.TrackOrderObject;

public class TrackOrder extends BaseFile {
	public static Logger log = LogManager.getLogger(BaseFile.class.getName());
	public WebDriver driver = null;
	public Properties prop = null;
	@BeforeMethod
	public void openBrowser() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	@Test(dataProvider = "testData")
	public void submitOrderDetails(String orderNo, String mobileNo) throws InterruptedException {
		TrackOrderObject too = new TrackOrderObject(driver);
		Thread.sleep(5000);
		too.getClose().click();
		Thread.sleep(3000);
		too.getTrack().click();
		log.info("Clicking on Track Order on Header Bar");
		Thread.sleep(2000);
		too.getOrderNumber().clear();
		log.info("Entering Order Number and Phone Number from Excel Sheet");
		too.getOrderNumber().sendKeys(orderNo);
		too.getPhoneNumber().clear();
		too.getPhoneNumber().sendKeys(mobileNo);
		too.getSubmitButton().click();
	}
	@AfterMethod
	public void end() {
		driver.quit();
		driver = null;
		log.info("End of Track Order Test Case");
	}
	@DataProvider
	public Object[][] testData() throws IOException {
		TrackOrderObject too = new TrackOrderObject(driver);
		Object[][] data = (Object[][]) too.excelData();		
		return data;
	}
}
