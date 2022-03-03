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

import pageObjects.CoolOer;
import resources.base;

public class CoolOerScienceFilter extends base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void navigateToUrl() throws IOException {
	
		driver = initializeDriver();
		log.info("driver is been initialized");
	
		driver.get(prop.getProperty("cooloer"));
		log.info("site is been navigated");
		
		driver.manage().window().maximize();
		log.info("browser window is been maximized");
		
	}
	
	@Test
	public void verifyTheScienceFilterOptionIsChecked() throws InterruptedException {
		
		CoolOer co = new CoolOer(driver);
      
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");

		co.getScienceSubjectFilter().click();
		log.info("science filter option is been checked");
		
		boolean optionEnabled = co.getScienceSubjectFilter().isEnabled();
		
		if(optionEnabled) {
			Assert.assertTrue(true);
			System.out.println("science filter option under subject domain is been enabled");
		}
		else
		{
			Assert.assertFalse(true);
		}
	
         Thread.sleep(8000);       		
	 
	}
	
	@Test
	public void verifyTheNumberOfResourcesForScienceFilter() {
	
		CoolOer co = new CoolOer(driver);
		
		int knowledgeDeepningResource = co.getResourceListUnderKnowledgeDeepning2().size();
		
		int creativityAnd21stCenturySkillsResource = co.getResourceListUnderCreativityAnd21stCenturySkills().size();
		
		int tinkeringAndMakingResource = co.getResourcesListUnderTinkeringAndMaking().size();
		
		int totalResources = knowledgeDeepningResource+creativityAnd21stCenturySkillsResource+tinkeringAndMakingResource;
		
		Assert.assertEquals(totalResources,8);
		
		System.out.println("number of resources for science filter is:"+totalResources);
		log.info("number of resources for science filter is:"+totalResources);	
	}

	@Test
	public void verifyTheNumberOfLinksForScienceFilter() {
	
		CoolOer co = new CoolOer(driver);
		int numberOfLinks = co.getNumberOfLinksOnPage().size();
		
		Assert.assertEquals(numberOfLinks,148);
		System.out.println("number of links for science filter is:"+numberOfLinks);		
	}

	@Test
	public void verifyTheResoucesTitleForScienceFilter() {
		
		CoolOer co = new CoolOer(driver);

		List<String> value = new ArrayList<String>();
		
		List<WebElement> resourceList1 = co.getResourceListUnderKnowledgeDeepning2();
		
		for(int i=0; i< resourceList1.size();i++) {
			
			String resourcesTitle = resourceList1.get(i).getText().replace("\n","").replace("\r","").trim();
			
			 if(resourcesTitle.contains("GeoGebra") || resourcesTitle.contains("जियोजेब्रा (GeoGebra)")) {
				 value.add(resourcesTitle);
				 System.out.println("resources title for science filter is:"+resourcesTitle);
			 }
		}
		
		System.out.println("resources title for science filter is:"+value);
		log.info("resources title for science filter is:"+value);
	}


	
	@AfterTest
	public void terminate() {
	
		driver.quit();
		log.info("driver is been quit");
	}

}
