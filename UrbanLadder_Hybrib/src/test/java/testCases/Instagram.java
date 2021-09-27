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
import pageObjects.InstagramObject;

public class Instagram extends BaseFile {
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
	public void openInstagramPage() throws InterruptedException {
		InstagramObject io = new InstagramObject(driver);
		Thread.sleep(5000);
		io.getClose().click();
		Thread.sleep(2000);
		io.getInstagram().click();
		log.info("Clicking Instagram Icon");
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		String parentWindow=I1.next();
		String childWindow=I1.next();
		driver.switchTo().window(childWindow);
		log.info("Switching to Instagram Tab");
		log.info("The Title of current tab is -> " + driver.getTitle());
	}
	@AfterTest
	public void close() {
		driver.quit();
		driver = null;
		log.info("End of Instagram Test Case");
	}
}
