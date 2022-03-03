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


public class CheckMathsCheckboxContentinEnglish extends base{
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
	public void checkMathsContentChecked()
	{
		landingpage.getMathscheckbox().click();
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#jar > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div:nth-of-type(1)"), "Geometric"));
		System.out.println("Content Checked "+driver.findElement(By.cssSelector("#jar > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div:nth-of-type(1)")).getText());															   
		
		String gr1text =landingpage.getGr1().getText();
		gr1text.trim().replace("\r","").replace("\n","");
		Assert.assertTrue(landingpage.getEb1().isDisplayed());
		String gr1expected1="Geometric Reasoning";
		String gr1expected2="Part I";
		String gr1expected=gr1expected1+"\n"+gr1expected2;
		Assert.assertEquals(gr1text,gr1expected);

		
		String gr2text =landingpage.getGr2().getText();
		gr2text.trim().replace("\r","").replace("\n","");
		Assert.assertTrue(landingpage.getGr2().isDisplayed());
		String gr2expected1="Geometric Reasoning";
		String gr2expected2="Part II";
		String gr2expected=gr2expected1+"\n"+gr2expected2;
		Assert.assertEquals(gr2text,gr2expected);
		
		String letext =landingpage.getLe().getText();
		letext.trim().replace("\r","").replace("\n","");
		Assert.assertTrue(landingpage.getLe().isDisplayed());	
		Assert.assertEquals(letext,"Linear Equations");
		
		String prtext =landingpage.getPr().getText();
		prtext.trim().replace("\r","").replace("\n","");
		Assert.assertTrue(landingpage.getPr().isDisplayed());		
		Assert.assertEquals(prtext,"Proportional Reasoning");
		
		log.info("Maths Modules exists in English Language");
		

	}
	
	@Test
	public void countLinksOnEntirePageAfterFilter()
	{
		 List<WebElement> links = driver.findElements(By.xpath("//a"));    //Identify the number of Link on webpage and assign into Webelement List 
         
         int linkCount = links.size();     // Count the total Link list on Web Page
         
         System.out.println("Total Number of link count on webpage by one class = "  + linkCount);    //Print the total count of links on webpage
	     log.info("The number of links is" + linkCount);
	     
	     Assert.assertEquals(linkCount, 108);
	}


	@Test
	public void countMathsModules()
	{
		landingpage.getMathscheckbox().click();
		 List<WebElement> links = driver.findElements(By.xpath("//*[@class=\"module_module\"]/div/span/img"));    //Identify the number of Link on webpage and assign into Webelement List 
	     
	     int linkCount = links.size();     // Count the total Link list on Web Page
	     
	     System.out.println("Total Number of Maths module count on webpage = "  + linkCount);    //Print the total count of links on webpage

	      System.out.println("The number of Maths modules is" + linkCount);
	    log.info("The number of Maths modules is" + linkCount);
	    assertEquals(linkCount, 4);
	    log.info("Maths Modules Checked in English");
	}


	@Test
	public void verifyMathsmodulesinEnglishcheckbox()
	{
		if (landingpage.getMathscheckbox().isDisplayed())
		{
		log.info("Check Box Exists since its visible"+landingpage.getMathscheckbox().isDisplayed());
		
		
		}		
	}


@AfterTest

public void teardown()
{
	driver.quit();
	log.info("browser driver is been closed");
}

}

	
