
package stepDefination;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.HelpPage;
import pageObjects.LandingPage;
import resources.ExtentReporterNG;
import resources.base;


@RunWith(Cucumber.class)
public class StepDefination extends base {
	public WebDriver driver;
	public LandingPage landingpage;
	public HelpPage helppage;
	ExtentReports extent = ExtentReporterNG.getReport();
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	 
	

    @Given("^user is on landing page$")
    public void user_is_on_landing_page() throws Throwable {
    	driver = initializeDriver();
    	log.info("Driver is Initialized through cucumber");
    	System.out.println("Driver is Initialized through cucumber");

    	driver.get(prop.getProperty("url"));
    	log.info("URL is Fetched through cucumber");
    	driver.navigate().refresh();
		driver.manage().window().fullscreen();
		landingpage = new LandingPage(driver);
    }
    
    

    @When("^user checks for navigation pane and clicks on help$")
    public void user_checks_for_navigation_pane_and_clicks_on_help() throws Throwable {
    	landingpage.getHelp().click();
   
    }

    @Then("^help page opens$")
    public void help_page_opens() throws Throwable {
    	landingpage.getHelp().click();
    	WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.cssSelector("#home > div > h1"),
				"Help"));
		String bodytext= driver.findElement(By.cssSelector("#home > div > h1")).getText();
    	
		System.out.println("First Output is"+bodytext);
    	bodytext.trim().replace("\r","").replace("\n","");
    	System.out.println("Second Output is"+bodytext);
    	Assert.assertEquals(bodytext,"Help Videos - English");
    	driver.close();

    	
  }
    @Given("user is on help page")
    public void user_is_on_help_page() throws IOException {
    	driver = initializeDriver();
    	log.info("Driver is Initialized through cucumber");
    	System.out.println("Driver is Initialized through cucumber");

    	driver.get(prop.getProperty("helpurl"));
    	log.info("Help URL is Fetched through cucumber");
    	driver.navigate().refresh();
		driver.manage().window().fullscreen();
		helppage = new HelpPage(driver);
        // Write code here that turns the phrase above into concrete actions
    }

    @When("user clicks English tab")
    public void user_clicks_English_tab() {
    	helppage.getEnglishHelp().click();
    	
    	
        // Write code here that turns the phrase above into concrete actions
        
    }

    @Then("english help opens")
    public void english_help_opens() {
        // Write code here that turns the phrase above into concrete actions
    	WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.cssSelector("#home > div > h1"),
				"Help"));
		String bodytext= driver.findElement(By.cssSelector("#home > div > h1")).getText();
		System.out.println("First Output is"+bodytext);
    	bodytext.trim().replace("\r","").replace("\n","");
    	System.out.println("Second Output is"+bodytext);
    	Assert.assertEquals(bodytext,"Help Videos - English");
    	driver.close();

    }

    @When("user clicks Maths tab")
    public void user_clicks_Maths_tab() {
    	helppage.getMathsHelp().click();
        // Write code here that turns the phrase above into concrete actions
      
    }

    @Then("maths help opens")
    public void maths_help_opens() {
    	WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.cssSelector("html > body > div:nth-of-type(3) > div > div:nth-of-type(2) > div > div:nth-of-type(1) > h1"),
				"Mathematics"));
		String bodytext= driver.findElement(By.cssSelector("html > body > div:nth-of-type(3) > div > div:nth-of-type(2) > div > div:nth-of-type(1) > h1")).getText();
		System.out.println("First Output is"+bodytext);
    	bodytext.trim().replace("\r","").replace("\n","");
    	System.out.println("Second Output is"+bodytext);
    	Assert.assertEquals(bodytext,"Help Videos - Mathematics");
    	driver.close();
        // Write code here that turns the phrase above into concrete actions
       
    }

    @When("user clicks Science tab")
    public void user_clicks_Science_tab() {
    	helppage.getScienceHelp().click();
        // Write code here that turns the phrase above into concrete actions
       
    }

    @Then("science help opens")
    public void science_help_opens() {
    	WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.cssSelector("html > body > div:nth-of-type(3) > div > div:nth-of-type(3) > h1"),
				"Coming"));
		String bodytext= driver.findElement(By.cssSelector("html > body > div:nth-of-type(3) > div > div:nth-of-type(3) > h1")).getText();
		System.out.println("First Output is"+bodytext);
    	bodytext.trim().replace("\r","").replace("\n","");
    	System.out.println("Second Output is"+bodytext);
    	Assert.assertEquals(bodytext,"Coming Soon!");
    	driver.close();
        // Write code here that turns the phrase above into concrete actions
        
    }




}
