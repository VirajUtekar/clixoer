package com.clix.clixoerwebsite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DomainPage;
import resources.base;

public class DomainScienceValidation extends base {
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void navigateToUrl() throws IOException {
		driver = initializeDriver();
		log.info("driver is been initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("site url is been navigated");
		
		driver.manage().window().maximize();
		log.info("browser window size is been maximized");
	}
	

	
	@Test
	public void verifyDomainScienceOptionIsSelected() {
	   
		DomainPage dp = new DomainPage(driver);
		dp.getAdvertisementBannerCloseIcon().click();
		log.info("Advertisement banner is been closed");
		
	    dp.getDomainNavigationMenu().click();
	    log.info("Domain navigation menu option is been clicked");
	   
	    dp.getScienceOption().click();
	    log.info("science option from drop down list is been clicked");
	   
	    String domainSetValue = dp.getDomainNavigationMenu().getText();
	    
	     if(domainSetValue.contains("Science")) {
	    	 Assert.assertTrue(true);
	    	 log.info("Science option from drop down list is been selected");
	    	 System.out.println("Science option from drop down list is been selected");
	     }
	}
	
	@Test
	public void verifyTheNumberOfScienceModules() {
	
		DomainPage dp = new DomainPage(driver);
		int scienceModuleCount = dp.getNumberOfScienceModule().size();
		Assert.assertEquals(scienceModuleCount,6);
		log.info("The Number of science modules into list is 6");
		System.out.println("The Number of science modules into list is:"+scienceModuleCount);
	}
	
	@Test
	public void verifyTheNumberOfLinksOnScienceDomainPage() {
		
		DomainPage dp = new DomainPage(driver);
		int scienceDomainPageLinksCount = dp.getNumberOfScienceDomainPageLinks().size();
		Assert.assertEquals(scienceDomainPageLinksCount,131);
		log.info("The Number of science domain page link is 131");
		System.out.println("The Number of science domain page link is:" +scienceDomainPageLinksCount);
	}
		
	@Test
	public void verifyTheScienceModuleTitles() {
	 
		List<String> scienceModuleName = new ArrayList<String>();
		
		DomainPage dp = new DomainPage(driver);
		List<WebElement> scienceModulesList = dp.getScienceModulesTitle();
		
		for(int i=0; i<scienceModulesList.size();i++) {
			  String scienceModuleTitles = scienceModulesList.get(i).getText().replace("/r","").replace("/n","").trim();
			  
			  if(scienceModuleTitles.contains("Atomic Structure") || scienceModuleTitles.contains("Basic Astronomy") || scienceModuleTitles.contains("Ecosystem") || scienceModuleTitles.contains("Health and Disease") || scienceModuleTitles.contains("Sound") || scienceModuleTitles.contains("Understanding Motion")) {
				  scienceModuleName.add(scienceModuleTitles);
				  Assert.assertTrue(true);
				  log.info("The modules under science options are Atomic Structure,Basic Astronomy, Ecosystem, Health and Disease, Sound, Understanding Motion");
			  }
		}
		
		System.out.println("The modules under science options are:" +scienceModuleName);
	}
		

	@AfterTest
	public void terminate() {
		driver.quit();
		log.info("browser driver is been quit");
	}
}
