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

public class CoolOerLanguageFilter extends base {

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
	public void verifyTheLanguageFilterOptionIsChecked() throws InterruptedException {
		
		CoolOer co = new CoolOer(driver);
      
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");
 
		co.getLanguageSubjectFilter().click();
		
		log.info("language filter option is been checked");
		
		boolean optionEnabled = co.getLanguageSubjectFilter().isEnabled();
		
		if(optionEnabled) {
			Assert.assertTrue(true);
			System.out.println("language filter option under subject domain is been enabled");
		}
		else
		{
			Assert.assertFalse(true);
		}
		
		Thread.sleep(8000);
	}
	
	@Test
	public void verifyTheNumberOfResourcesForLanguageFilter() {
	
		CoolOer co = new CoolOer(driver);
		
		int knowledgeDeepningResource = co.getResourceListUnderKnowledgeDeepning2().size();
		
		int creativityAnd21stCenturySkillsResource = co.getResourceListUnderCreativityAnd21stCenturySkills().size();
		
		int tinkeringAndMakingResource = co.getResourcesListUnderTinkeringAndMaking().size();
		
		int totalResources = knowledgeDeepningResource+creativityAnd21stCenturySkillsResource+tinkeringAndMakingResource;
		
		Assert.assertEquals(totalResources,2);
		
		System.out.println("number of resources for language filter is:"+totalResources);
		log.info("number of resources for language filter is:"+totalResources);	
	}
	
	@Test
	public void verifyTheNumberOfLanguageForArtFilter() {
	
		CoolOer co = new CoolOer(driver);
		
		int numberOfLinks = co.getNumberOfLinksOnPage().size();
		
		Assert.assertEquals(numberOfLinks,64);
		System.out.println("number of links for language filter is:"+numberOfLinks);
		
	}
	

	@Test
	public void verifyTheResoucesTitleForArtFilter() {
		
		CoolOer co = new CoolOer(driver);

		List<String> value = new ArrayList<String>();
		
		List<WebElement> resourceList2 = co.getResourceListUnderCreativityAnd21stCenturySkills();
		
		for(int i=0; i< resourceList2.size(); i++) {

			String resourceTitle = resourceList2.get(i).getText().replace("\n","").replace("\r","").trim();
			
			if(resourceTitle.contains("Storyweaver") || resourceTitle.contains("ਸਟੋਰੀਵੀਵਰ (Storyweaver)")) {
				value.add(resourceTitle);
				System.out.println("resources list after art filter is:" +resourceTitle);
			}
		}
		
		System.out.println("The resources list after language filter is:"+value);
		log.info("The resources list after language filter is:"+value);
	}


	
	@AfterTest
	public void terminate() {
	
		driver.quit();
		log.info("driver is been quit");
	}
	
}
