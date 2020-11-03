package com.clix.clixoerwebsite;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;


public class Checki2cCheckboxContentinHindi extends base{
	public WebDriver driver;
	public LandingPage landingpage;
	
	public static Logger log = LogManager.getLogger(base.class.getName());
@BeforeTest
public void bringup() throws IOException
{
	driver = initializeDriver();
	log.info("Driver is Initialized");

	driver.get(prop.getProperty("url"));
	log.info("URL is Fetched");

}
	@Test
	
	public void basePageNavigation() throws IOException
	{
		
		driver.navigate().refresh();
		driver.manage().window().fullscreen();
		landingpage = new LandingPage(driver);
				
	}
	@Test

	public void countLinks()
	{
		 List<WebElement> links = driver.findElements(By.xpath("//a"));    //Identify the number of Link on webpage and assign into Webelement List 
         
         int linkCount = links.size();     // Count the total Link list on Web Page
         
         System.out.println("Total Number of link count on webpage by one class = "  + linkCount);    //Print the total count of links on webpage
	    log.info("The number of links is" + linkCount);
	}
	
	
	@Test
	public void verifyi2cmodulesinHindicheckbox()
	

	{
		landingpage.getEnglishLanguage().click();
		landingpage.getHindiLanguage().click();
		
		
		
		if (landingpage.geti2ccheckbox().isDisplayed())
		{
		log.info("Check Box Exists since its visible"+landingpage.geti2ccheckbox().isDisplayed());
		
		
		}

		
		
	}

	
@Test
public void checki2cContentChecked()
{
	landingpage.geti2ccheckbox().click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#jar > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div:nth-of-type(1)"), "i2C"));
	System.out.println("Content Checked "+driver.findElement(By.cssSelector("#jar > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div:nth-of-type(1)")).getText());															   
	
	
	String i2ctext =landingpage.getAs().getText();
	i2ctext.trim().replace("\r","").replace("\n","");
	Assert.assertTrue(landingpage.getAs().isDisplayed());	
	Assert.assertEquals(i2ctext,"i2C");
	
	
	
	log.info("i2c Modules exists in Hindi Language");
	   System.out.println("i2c Modules exists in Hindi Language Count");
	  
	

}
@Test
public void counti2cModules() throws InterruptedException
{
	Thread.sleep(1000);
	 List<WebElement> links = driver.findElements(By.xpath("//*[@class=\"module_module\"]/div/span/img"));    //Identify the number of Link on webpage and assign into Webelement List 
     
     int linkCount = links.size();     // Count the total Link list on Web Page
     
     System.out.println("Total Number of i2c module count on webpage = "  + linkCount);    //Print the total count of links on webpage

      System.out.println("The number of i2c modules is" + linkCount);
    log.info("The number of i2c modules is" + linkCount);
    assertEquals(linkCount, 1);
    log.info("i2c Modules Checked in Hindi");
    System.out.println("i2c Modules exists in Hindi Language Counted");
}	



	

	

@AfterTest

public void teardown()
{
	driver.close();
}

}




	

	
