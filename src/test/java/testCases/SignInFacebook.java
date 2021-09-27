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
import pageObjects.SignInFacebookObject;

public class SignInFacebook extends BaseFile {
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
	public void fbSignIn(String email, String password) throws InterruptedException {
		SignInFacebookObject sifo = new SignInFacebookObject(driver);
		log.info("Sign In using Facebook Account");
		sifo.getFbConnect().click();
		Thread.sleep(2000);
		log.info("Entering Email and Password");
		sifo.getEmail().sendKeys(email);
		sifo.getPassword().sendKeys(password);
		sifo.getSubmitButton().click();
	}
	@DataProvider
	public Object[][] testData() throws IOException {
		SignInFacebookObject sifo = new SignInFacebookObject(driver);
		Object[][] data = (Object[][]) sifo.excelData();		
		return data;
	}
	@AfterMethod
	public void end() {
		driver.quit();
		driver = null;
		log.info("End of Sign In using Facebook Test Case");
	}
}
