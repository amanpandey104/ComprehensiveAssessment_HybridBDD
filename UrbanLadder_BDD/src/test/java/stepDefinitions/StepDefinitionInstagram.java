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
import pageObjects.InstagramObject;

public class StepDefinitionInstagram extends BaseFile{
	public static Logger log = LogManager.getLogger(BaseFile.class.getName());
	public WebDriver driver = null;
	public Properties prop = null;
	@Given("^open a browser$")
    public void open_a_browser() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\Utilities\\datadriven.properties");
		prop.load(fis);
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
    }

    @When("^Click on Instagram Icon$")
    public void click_on_instagram_icon() throws InterruptedException {
    	InstagramObject io = new InstagramObject(driver);
		Thread.sleep(5000);
		io.getClose().click();
		Thread.sleep(2000);
		io.getInstagram().click();
		log.info("Clicking Instagram Icon");
    }

    @Then("^Display Title of Page$")
    public void display_title_of_page() throws InterruptedException {
    	Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		String parentWindow=I1.next();
		String childWindow=I1.next();
		driver.switchTo().window(childWindow);
		log.info("Switching to Instagram Tab");
		log.info("The Title of current tab is -> " + driver.getTitle());
		Thread.sleep(2000);
    }

    @And("^Close the Browser$")
    public void close_the_browser() {
    	driver.quit();
		driver = null;
		log.info("End of Instagram Test Case");
    }
}
