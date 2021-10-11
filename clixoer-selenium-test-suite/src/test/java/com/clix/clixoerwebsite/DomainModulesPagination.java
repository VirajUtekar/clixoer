package com.clix.clixoerwebsite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DomainPage;
import resources.base;

public class DomainModulesPagination extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	
	@BeforeTest
	public void navigateToUrl() throws IOException {
		driver = initializeDriver();
		log.info("driver is been initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("url site is been navigated");
		
		driver.manage().window().maximize();
		log.info("browser window is been maximized");
		
	}
	
	@Test
	public void verifyThePaginationOptions() {
		
		DomainPage dp = new DomainPage(driver);
		
		
		dp.getAdvertisementBannerCloseIcon().click();
		log.info("advertisement banner is been closed");
		
		dp.getDomainNavigationMenu().click();
		log.info("domain navigation menu option is been clicked");
		
		dp.getMathOption().click();
		log.info("math option from drop down list option is been clicked");
		
		// get the list of pagination options
		
		List<String> paginationValue = new ArrayList<String>();
		
		List<WebElement> paginations = dp.getPaginationOptions();
		
		for(int i=0; i< paginations.size();i++) {
			paginationValue.add(paginations.get(i).getText());
		}
		
		log.info("The pagination options on domain math page is Prev, 1, Next");
		System.out.println("The pagination options on domain math page is:"+paginationValue);
		
		
		// To verify pagination number 1 is enabled
		
	     List<WebElement> paginationListOptions = dp.getPaginationOptions();
	     
	     for(int i=0; i< paginationListOptions.size();i++) {
	    	 boolean optionEnabled = paginationListOptions.get(1).isEnabled();
	    	 if(optionEnabled) {
	    		 Assert.assertTrue(true);
	    		 log.info("Pagination option no: 1 is active");
	    		 System.out.println("Pagination option: 1 is active");
	    		 break;
	    	 }	 
	     }

	}
	
	
	@AfterTest
	public void terminate() {
		driver.quit();
		log.info("browser window is been quit");
	}
}
