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


public class CheckScienceCheckboxContent extends base{
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
	public void verifySciencemodulesinEnglishcheckbox()
	

	{
		
		
		
		if (landingpage.getSciencecheckbox().isDisplayed())
		{
		log.info("Check Box Exists since its visible"+landingpage.getSciencecheckbox().isDisplayed());
		
		
		}

		
		
	}

	
@Test
public void checkScienceContentChecked()
{
	landingpage.getSciencecheckbox().click();
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#jar > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div:nth-of-type(1)"), "Atomic"));
	System.out.println("Content Checked "+driver.findElement(By.cssSelector("#jar > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div:nth-of-type(1)")).getText());															   
	
	
	String astext =landingpage.getAs().getText();
	astext.trim().replace("\r","").replace("\n","");
	Assert.assertTrue(landingpage.getAs().isDisplayed());	
	Assert.assertEquals(astext,"Atomic Structure");
	
	String batext =landingpage.getBa().getText();
	batext.trim().replace("\r","").replace("\n","");
	Assert.assertTrue(landingpage.getBa().isDisplayed());		
	Assert.assertEquals(batext,"Basic Astronomy");
	
	String estext =landingpage.getEs().getText();
	estext.trim().replace("\r","").replace("\n","");
	Assert.assertTrue(landingpage.getEs().isDisplayed());		
	Assert.assertEquals(estext,"Ecosystem");
	
	String hdtext =landingpage.getHd().getText();
	hdtext.trim().replace("\r","").replace("\n","");
	Assert.assertTrue(landingpage.getHd().isDisplayed());		
	Assert.assertEquals(hdtext,"Health and Disease");
	
	String sdtext =landingpage.getSd().getText();
	sdtext.trim().replace("\r","").replace("\n","");
	Assert.assertTrue(landingpage.getSd().isDisplayed());		
	Assert.assertEquals(sdtext,"Sound");
	
	String umtext =landingpage.getUm().getText();
	batext.trim().replace("\r","").replace("\n","");
	Assert.assertTrue(landingpage.getUm().isDisplayed());		
	Assert.assertEquals(umtext,"Understanding Motion");
	
	log.info("Science Modules exists in English Language");
	

}

@Test
public void countScienceModules()
{
	landingpage.getSciencecheckbox().click();
	 List<WebElement> links = driver.findElements(By.xpath("//*[@class=\"module_module\"]/div/span/img"));    //Identify the number of Link on webpage and assign into Webelement List 
     
     int linkCount = links.size();     // Count the total Link list on Web Page
     
     System.out.println("Total Number of Science module count on webpage = "  + linkCount);    //Print the total count of links on webpage

      System.out.println("The number of Science modules is" + linkCount);
    log.info("The number of Science modules is" + linkCount);
    assertEquals(linkCount, 6);
    log.info("Science Modules Checked");
}


	

	

@AfterTest

public void teardown()
{
	driver.close();
}

}




	

	
