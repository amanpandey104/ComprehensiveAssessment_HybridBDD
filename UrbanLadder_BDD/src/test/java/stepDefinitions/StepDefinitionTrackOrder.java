package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.BaseFile;
import pageObjects.TrackOrderObject;

public class StepDefinitionTrackOrder extends BaseFile {
	public static Logger log = LogManager.getLogger(BaseFile.class.getName());
	public WebDriver driver = null;
	public Properties prop = null;
	
	@Given("^open url in broser$")
    public void open_url_in_broser() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
    }

    @When("^Click on Track Order$")
    public void click_on_track_order() throws InterruptedException {
    	TrackOrderObject too = new TrackOrderObject(driver);
		Thread.sleep(5000);
		too.getClose().click();
		Thread.sleep(3000);
		too.getTrack().click();
		log.info("Clicking on Track Order on Header Bar");
		Thread.sleep(2000);
		too.getOrderNumber().clear();
    }

    @Then("^Enter order number (.+) and phone number (.+)$")
    public void enter_order_number_and_phone_number(String orderno, String phoneno) {
    	TrackOrderObject too = new TrackOrderObject(driver);
    	too.getOrderNumber().clear();
		log.info("Entering Order Number and Phone Number from Excel Sheet");
		too.getOrderNumber().sendKeys(orderno);
		too.getPhoneNumber().clear();
		too.getPhoneNumber().sendKeys(phoneno);
		too.getSubmitButton().click();
    }

    @And("^Close the window$")
    public void close_the_window() {
    	driver.quit();
		driver = null;
		log.info("End of Track Order Test Case");
    }
}
