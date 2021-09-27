package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BaseFile;
import pageObjects.SelectApplicationStoreObject;

public class SelectApplicationStore extends BaseFile {
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
	public void openApplicationStore() throws IOException, InterruptedException {
		SelectApplicationStoreObject saso = new SelectApplicationStoreObject(driver);
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		String store = prop.getProperty("store");
		Thread.sleep(5000);
		saso.getClose().click();
		Thread.sleep(2000);
		saso.getAppStore(store).click();
		log.info("Clicking on Application store to download Urban Ladder Application");
		Thread.sleep(3000);
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		String parentWindow=I1.next();
		String childWindow=I1.next();
		driver.switchTo().window(childWindow);
		log.info("Switched to Store Download Page");
		Thread.sleep(2000);
		log.info("The title for the Store Page is -> " + driver.getTitle());
	}
	@AfterTest
	public void close() {
		driver.quit();
		driver = null;
		log.info("End of Download Application Test Case");
	}
}
