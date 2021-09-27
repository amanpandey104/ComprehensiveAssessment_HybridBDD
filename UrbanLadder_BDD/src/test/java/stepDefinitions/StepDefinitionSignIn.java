package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.BaseFile;
import pageObjects.SignInFacebookObject;
import pageObjects.SignInGoogleObject;

public class StepDefinitionSignIn extends BaseFile{
	public static Logger log = LogManager.getLogger(BaseFile.class.getName());
	public WebDriver driver = null;
	public Properties prop = null;
	
	@Given("^open urban ladder url$")
    public void open_urban_ladder_url() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
    }
	
	@When("^Navigate to Facebook and Sign in$")
    public void navigate_to_facebook_and_sign_in() throws InterruptedException {
		SignInFacebookObject sifo = new SignInFacebookObject(driver);
		log.info("Sign In using Facebook Account");
		sifo.getFbConnect().click();
		Thread.sleep(2000);
    }

    @When("^Navigate to Google account and Sign in$")
    public void navigate_to_google_account_and_sign_in() throws InterruptedException {
    	SignInGoogleObject sigo = new SignInGoogleObject(driver);
		log.info("Sign In using Google Account");
		sigo.getGConnect().click();
		Thread.sleep(2000);
    }

    @Then("^enter email (.+) and password (.+) of facebook$")
    public void enter_email_and_password_of_facebook(String email, String password) {
    	SignInFacebookObject sifo = new SignInFacebookObject(driver);
    	log.info("Entering Email and Password");
		sifo.getEmail().sendKeys(email);
		sifo.getPassword().sendKeys(password);
		sifo.getSubmitButton().click();
    	
    }

    @Then("^enter email (.+) and password (.+) of google$")
    public void enter_email_and_password_of_google(String email, String password) {
    	SignInGoogleObject sigo = new SignInGoogleObject(driver);
    	log.info("Entering Email and Password");
		sigo.getEmail().sendKeys(email);
		sigo.getEmail().sendKeys(Keys.ENTER);
		sigo.getPassword().sendKeys(password);
		sigo.getSubmitButton().click();
    }

    @And("^End of signin Test$")
    public void end_of_signin_test() {
    	driver.quit();
		driver = null;
		log.info("End of Sign In Test Case");
    }
}
