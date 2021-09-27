package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseFile {
	public static WebDriver driver;
	public static WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			//chrome
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe" );
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			//firefox
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe" );
			driver = new FirefoxDriver();
		}else {
			//edge
			System.setProperty("webdriver.edge.driverr", ".\\Drivers\\msedgedriver.exe" );
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit wait
		return driver;
	}
	public void getScreenShot(String name) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\ScreenShots\\"+name+"screenshot.png"));
	}
}
