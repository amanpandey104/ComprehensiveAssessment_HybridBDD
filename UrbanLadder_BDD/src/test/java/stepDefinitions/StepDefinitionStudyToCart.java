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
import pageObjects.StudyToCartObject;

public class StepDefinitionStudyToCart extends BaseFile{
	public static Logger log = LogManager.getLogger(BaseFile.class.getName());
	public WebDriver driver = null;
	public Properties prop = null;
	
	@Given("^open url$")
    public void open_url() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
    }

    @When("^Selecting bookself in Study$")
    public void selecting_bookself_in_study() throws InterruptedException {
    	StudyToCartObject stco = new StudyToCartObject(driver);
		Thread.sleep(5000);
		stco.getClose().click();
		Thread.sleep(2000);
		stco.getStudy().build().perform();
		log.info("Hovering over Study option in Navigation Bar");
		Thread.sleep(2000);
		stco.getBookshelf().click();
		stco.getProduct().click();
		log.info("Selecting Product");
    }

    @Then("^Add to cart$")
    public void add_to_cart() {
    	StudyToCartObject stco = new StudyToCartObject(driver);
    	stco.getCart().click();
		log.info("Adding Product to Cart");
    }

    @And("^End the Cart Test scenatio$")
    public void end_the_cart_test_scenatio() {
    	driver.quit();
		driver = null;
		log.info("End of Adding Product to Cart Test Case");
    }
}
