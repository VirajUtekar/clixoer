package com.clix.clixoerwebsite;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FooterPage;
import resources.base;

public class FooterGitLinkValidation extends base {

	public WebDriver driver;
	
	public Logger log = LogManager.getLogger(base.class.getName());
	
	
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
	public void verifyGitLinkValidation() {
		
		FooterPage fp = new FooterPage(driver);
		
		boolean gitLinkIsDisplayed = fp.getGitHubFooterLink().isDisplayed();
	
		if(gitLinkIsDisplayed) {
	
			System.out.println("The git hub link in footer is displayed");		
	
			driver.navigate().refresh();
			fp.getGitHubFooterLink().click();
			log.info("github link in footer is clicked");
			System.out.println("github link in footer is clicked");
			
			String parentWindow = driver.getWindowHandle();
		    
			Set<String>s = driver.getWindowHandles();
		    
		    Iterator<String> iterator = s.iterator();
		    
		    while(iterator.hasNext()) {
		    	
		    	String childWindow = iterator.next();
		    	
		    	if(!parentWindow.equals(childWindow)) {
		    		
		    		driver.switchTo().window(childWindow);
		    		String currentUrl = driver.getCurrentUrl();	    		
		    		Assert.assertEquals(currentUrl,"https://github.com/CLIxIndia-Dev/clixoer");
		    	}
		    }
		}
	}
	
	@AfterTest
	public void terminate() {
		driver.quit();
		log.info("browser driver is been quit");
	}
	
}
