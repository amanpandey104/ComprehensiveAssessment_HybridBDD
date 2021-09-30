package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import pageObjects.BaseFile;
import pageObjects.LoginObject;

public class Login extends BaseFile {
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
	public void userLogin(String email, String password) throws InterruptedException {
		LoginObject lo = new LoginObject(driver);
		lo.getClose();
		Thread.sleep(2000);
		Actions hover = new Actions(driver);
		hover.moveToElement(lo.getIcon()).build().perform();
		Thread.sleep(2000);
		lo.getLoginButton().click();
		Thread.sleep(8000);
		lo.getEmail().sendKeys(email);
		log.info("Entering Email and Password");
		lo.getPassword().sendKeys(password);
		lo.getSubmitButton().click();
	}
	@AfterMethod
	public void end() {
		driver.quit();
		driver = null;
		log.info("End of Login Test Case");
	}
	@DataProvider
	public Object[][] testData() throws IOException {
		LoginObject lo = new LoginObject(driver);
		Object[][] data = (Object[][]) lo.excelData();		
		return data;
	}
}
