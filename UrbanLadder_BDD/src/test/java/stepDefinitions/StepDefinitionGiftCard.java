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
import pageObjects.GiftCardObjects;

public class StepDefinitionGiftCard extends BaseFile {
	public static Logger log = LogManager.getLogger(BaseFile.class.getName());
	public WebDriver driver = null;
	public Properties prop = null;
	@Given("^Load the Website$")
    public void load_the_website() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
    }

    @When("^Click on Gift Card Option$")
    public void click_on_gift_card_option() throws InterruptedException {
    	GiftCardObjects gfo = new GiftCardObjects(driver);
		Thread.sleep(10000);
		gfo.getClose().click();
		Thread.sleep(5000);
		gfo.getGiftCard().click();
		log.info("Selecting Gift Card Option from Header Bar");
    }

    @Then("^Enter details for Gift Card$")
    public void enter_details_for_gift_card() throws IOException {
    	GiftCardObjects gfo = new GiftCardObjects(driver);
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		String event = prop.getProperty("event");
		log.info("Selecting Event for Gift Card");
		gfo.getEvent(event).click();
		gfo.getAmount().sendKeys(prop.getProperty("amount"));
		log.info("Entering Amount of Gift Card");
		gfo.getNextButton().click();
		gfo.getRecipientName().sendKeys(prop.getProperty("recipientName"));
		gfo.getRecipientEmail().sendKeys(prop.getProperty("recipientEmail"));
		gfo.getFromName().sendKeys(prop.getProperty("fromName"));
		gfo.getFromEmail().sendKeys(prop.getProperty("fromEmail"));
		gfo.getFromPhoneNumber().sendKeys(prop.getProperty("fromPhoneNumber"));
		gfo.getMessage().sendKeys(prop.getProperty("message"));
		log.info("Entering Recipient's INFO and From's INFO");
    }

    @And("^Close the browser$")
    public void close_the_browser() {
    	driver.quit();
		driver = null;
		log.info("End of Gift Card Test Case");
    }

}
