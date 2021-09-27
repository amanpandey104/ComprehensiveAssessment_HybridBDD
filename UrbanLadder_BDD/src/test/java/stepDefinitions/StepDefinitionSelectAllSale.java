package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.BaseFile;
import pageObjects.SelectAllSaleObject;

public class StepDefinitionSelectAllSale extends BaseFile {
	public static Logger log = LogManager.getLogger(BaseFile.class.getName());
	public WebDriver driver = null;
	public Properties prop = null;
	
	@Given("^open the browser$")
    public void open_the_browser() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
    }

    @When("^click on Sale Option select All Product Sale$")
    public void click_on_sale_option_select_all_product_sale() throws InterruptedException {
    	SelectAllSaleObject saso = new SelectAllSaleObject(driver);
		saso.getClose().click();
		Thread.sleep(2000);
		saso.getSale().build().perform();
		log.info("Hovering on Sale from Navigation Bar");
		Thread.sleep(2000);
		saso.getAllSale().click();
		log.info("Clicking on Sale on All Product");
    }

    @Then("^Check title of Page$")
    public void check_title_of_page() {
    	String actual = driver.getTitle();
		if(!actual.contains("All Products on Sale")) {
			log.info("No we have not Navigated to ALL PRODUCTS ON SALE page");
			Assert.assertTrue(false);
		}else {
			log.info("Yes we Navigated to ALL PRODUCTS ON SALE page");
			Assert.assertTrue(true);
		}
    }

    @And("^Close the All Sale browser$")
    public void close_the_all_sale_browser() {
    	driver.quit();
		driver = null;
		log.info("End of Selecting All Sale Test Case");
    }
}
