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
import pageObjects.ViewStoresObjects;

public class StepDefinitionViewStore extends BaseFile {
	public static Logger log = LogManager.getLogger(BaseFile.class.getName());
	public WebDriver driver = null;
	public Properties prop = null;
	
	@Given("^open website$")
    public void open_website() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
    }

    @When("^Select store option$")
    public void select_store_option() {
    	ViewStoresObjects vso = new ViewStoresObjects(driver);
		vso.getStore().click();
		log.info("Clicking on Store Option in Header Bar");
    }

    @Then("^select a offline store$")
    public void select_a_offline_store() throws IOException {
    	ViewStoresObjects vso = new ViewStoresObjects(driver);
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		String city = prop.getProperty("city");
		log.info("Entering City to get the Store Location");
		vso.getLocation(city).click();
    }

    @And("^close Store scenario$")
    public void close_store_scenario() {
    	driver.quit();
		driver = null;
		log.info("End of View Details for Store Test Case");
    }

}
