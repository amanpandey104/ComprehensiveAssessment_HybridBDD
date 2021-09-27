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
import pageObjects.LoginObject;

public class StepDefinitionLogin extends BaseFile{
	public static Logger log = LogManager.getLogger(BaseFile.class.getName());
	public WebDriver driver = null;
	public Properties prop = null;
	
	@Given("^open urban ladder website$")
    public void open_urban_ladder_website() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
    }

	@When("^enter email (.+) and password (.+) for login$")
    public void enter_email_and_password_for_login(String email, String password) throws InterruptedException {
    	LoginObject lo = new LoginObject(driver);
		Thread.sleep(5000);
		lo.getEmail().sendKeys(email);
		log.info("Entering Email and Password");
		lo.getPassword().sendKeys(password);
    }

    @Then("^Login$")
    public void login() {
    	LoginObject lo = new LoginObject(driver);
    	lo.getSubmitButton().click();
    }

    @And("^End of Login Test$")
    public void end_of_login_test() {
    	driver.quit();
		driver = null;
		log.info("End of Login Test Case");
    }
}
