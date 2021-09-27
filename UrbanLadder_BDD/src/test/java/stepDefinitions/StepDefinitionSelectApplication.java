package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.BaseFile;
import pageObjects.SelectApplicationStoreObject;

public class StepDefinitionSelectApplication extends BaseFile {
	public static Logger log = LogManager.getLogger(BaseFile.class.getName());
	public WebDriver driver = null;
	public Properties prop = null;
	
	@Given("^Access the website$")
    public void access_the_website() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
    }

    @When("^Click on download icon$")
    public void click_on_download_icon() throws IOException, InterruptedException {
    	SelectApplicationStoreObject saso = new SelectApplicationStoreObject(driver);
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		String store = prop.getProperty("store");
		Thread.sleep(5000);
		saso.getClose().click();
		Thread.sleep(2000);
		saso.getAppStore(store).click();
		log.info("Clicking on Application store to download Urban Ladder Application");
    }

    @Then("^Capture title of store page$")
    public void capture_title_of_store_page() throws InterruptedException {
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

    @And("^end the Store Test Case$")
    public void end_the_store_test_case() {
    	driver.quit();
		driver = null;
		log.info("End of Download Application Test Case");
    }
}
