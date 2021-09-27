package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.BaseFile;
import pageObjects.SignInFacebookObject;
import pageObjects.SignInGoogleObject;

public class SignInGoogle extends BaseFile {
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
	public void gSignIn(String email, String password) throws InterruptedException {
		SignInGoogleObject sigo = new SignInGoogleObject(driver);
		log.info("Sign In using Google Account");
		sigo.getGConnect().click();
		Thread.sleep(2000);
		log.info("Entering Email and Password");
		sigo.getEmail().sendKeys(email);
		sigo.getEmail().sendKeys(Keys.ENTER);
		sigo.getPassword().sendKeys(password);
		sigo.getSubmitButton().click();
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
		log.info("End of Sign In using Google Test Case");
	}
}
