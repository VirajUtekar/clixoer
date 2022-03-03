package com.clix.clixoerwebsite;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FooterPage;
import resources.base;

public class FooterContactUsLinkValidation extends base {

	  public WebDriver driver;
	  
	  public static Logger log = LogManager.getLogger(base.class.getName());
	  
	  @BeforeTest
	  public void navigateToUrl() throws IOException {
		  
		  driver = initializeDriver();
		  log.info("driver is been initialized");
		  
		  driver.get(prop.getProperty("url"));
		  log.info("site url is been navigated");
		  
		  driver.manage().window().maximize();
		  log.info("browser window is been maximized");
	  }
	  
	  @Test
	  public void verifyContactUsLinkIsDisplayed() {
		  
		  FooterPage fp = new FooterPage(driver);
		  boolean contactUsLinkInFooterIsDisplayed = fp.getContactUsFooterLink().isDisplayed();
		  if(contactUsLinkInFooterIsDisplayed) {
			  Assert.assertTrue(true);
			  System.out.println("contact us Link is displayed in footer");
			  log.info("contact us link is displayed in footer");
		  }
		  
	  }
	  
	  @Test
	  public void verifyContactUsLinkValidation() {

		  FooterPage fp = new FooterPage(driver);

		  driver.navigate().refresh();

		  fp.getContactUsFooterLink().click();
		  log.info("contact us link in footer is clicked");
		  System.out.println("contact us link in footer is clicked");
		  
		  
		// It will return the parent window name as a String
		  String parent=driver.getWindowHandle();

		  Set<String>s=driver.getWindowHandles();

		  // Now iterate using Iterator
		  Iterator<String> I1= s.iterator();

		  while(I1.hasNext())
		  {

		  String child_window=I1.next();
		  
		  if(!parent.equals(child_window))
		  {
			driver.switchTo().window(child_window);
			
             String contactUsPageHeadingVerify = fp.getContactUsPageHeading().getText().trim();
             if(contactUsPageHeadingVerify.contains("Contact CLIx")) {
            	Assert.assertTrue(true);
            	System.out.println("The page contain heading as"+contactUsPageHeadingVerify);
             }
		    }
		  }	  
	  }
	  
	  @AfterTest
	  public void terminate() {
		driver.quit();
		log.info("driver is been quit");
	  }
		
	
	
	
}
