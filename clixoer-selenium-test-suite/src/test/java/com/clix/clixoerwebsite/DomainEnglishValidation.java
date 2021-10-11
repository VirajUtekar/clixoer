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

public class DomainEnglishValidation extends base{
	
	public WebDriver driver;

    public static Logger log = LogManager.getLogger(base.class.getName());	

    
	@BeforeTest
	public void navigateToUrl() throws IOException {
	  driver = initializeDriver();
	  log.info("driver is been intialized");
	  
	  driver.get(prop.getProperty("url"));
	  log.info("site url is been navigated");
	  
	  driver.manage().window().maximize();
	  log.info("window size is been maximized");

	}
	
	@Test
	public void verifyEnglishOptionUnderDomainIsSelected() {
		
		DomainPage dp = new DomainPage(driver);
		dp = new DomainPage(driver);
		dp.getAdvertisementBannerCloseIcon().click();
		log.info("Advertisement Banner is closed");

		dp.getDomainNavigationMenu().click();
		log.info("Domain Navigation Menu Option is been clicked");
	
		dp.getEnglishOption().click();
		log.info("english option under domain is clicked");
	
		String selectedDomainOption = dp.getDomainNavigationMenu().getText();
		
		if(selectedDomainOption.trim().contains("English")) {
			Assert.assertTrue(true);
			log.info("english option under domain is selected");
			System.out.println("English option under domain is selected");
		}
		
	}
	
	@Test
	public void verifyTheNumberOfEnglishModules() {
	   
		DomainPage dp = new DomainPage(driver); 
		int modulesCount  = dp.getNumberOfEnglishModule().size();
		Assert.assertEquals(modulesCount, 2);
		log.info("number of english modules is 2");
		System.out.println("The Number of English Modules is"+modulesCount);
	}
	
	@Test
	public void verifyNumberOfLinkOnPage() {
		
		DomainPage dp = new DomainPage(driver);
		int pageLinks = dp.getEnglishDomainPageLinks().size();
		Assert.assertEquals(pageLinks, 71);
		System.out.println("The available links on domain English page is" +pageLinks);
		log.info("The number of link available under domain english page is 71");
	}
	
	@Test
	public void verifyTheNameOfEnglishModules() throws InterruptedException {
		
		DomainPage dp = new DomainPage(driver);
		List<String> titlenames = new ArrayList<String>();
		
		List<WebElement> moduleList = dp.getEnglishModuleTitle();

		for(int i=0; i< moduleList.size();i++) {
		     
			String moduleTitle = moduleList.get(i).getText();
		     
		     String moduleTitleFinal = moduleTitle.trim().replace("\r","").replace("\n","");
		     
		     if(moduleTitleFinal.equals("Communicative English: Level I") || moduleTitleFinal.equals("Communicative English: Level II")) {
		    	 
		    	 titlenames.add(moduleTitleFinal);
		
		    	 Assert.assertTrue(true);
		    	 
		    	 log.info("modules title that are available into list are Communicative English: Level I and Communicative English: Level II");
		     }
		}
		System.out.println("The Module title that are available into list:" +titlenames);
    }
	
	@AfterTest
	public void terminate() {
		driver.quit();
		log.info("driver is been quit");
	}
}
