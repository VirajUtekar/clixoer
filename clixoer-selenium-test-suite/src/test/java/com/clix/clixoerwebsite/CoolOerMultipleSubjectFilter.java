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

public class CoolOerMultipleSubjectFilter extends base {

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
	public void verifyMultipleSubjectOptionIsChecked() throws InterruptedException {

		CoolOer co = new CoolOer(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)", "");

		co.getSubjectDomainMultipleSubjectsfilter().click();
		log.info("multiple subjects option under subject domain is been clicked");
		
		boolean optionEnabled = co.getSubjectDomainMultipleSubjectsfilter().isEnabled();
		
		if(optionEnabled) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(true);
		}
	
		Thread.sleep(8000);
	}
	
	@Test
	public void verifyNumberOfResourcesForMultipleSubjectsFilter(){
	
		CoolOer co = new CoolOer(driver);
		
		int creativityAnd21stCenturySkillResource = co.getResourceListUnderCreativityAnd21stCenturySkills().size();
		
		int tinkeringAndMakingResource = co.getResourcesListUnderTinkeringAndMaking().size();
		
		int totalResources = creativityAnd21stCenturySkillResource + tinkeringAndMakingResource;
	
		Assert.assertEquals(totalResources,8);
	    System.out.println("number of resources for multiples subject filter is:" +totalResources);
	    log.info("number of resources for multiples subject filter is"+totalResources);
	}
	
	
	@Test
	public void verifyTheNumberOfLinksForMultipleSubjectFilter() throws InterruptedException {
	
		Thread.sleep(2000);
		
		CoolOer co = new CoolOer(driver);
		
		int linksAvailableOnPage = co.getNumberOfLinksOnPage().size();
		
		Assert.assertEquals(linksAvailableOnPage,148);
		
		System.out.println("total links available on page after multiple subjects filtered:"+linksAvailableOnPage);
		log.info("total links available on page after multiple subjects filtered:"+linksAvailableOnPage);
	}
	
	
	@Test
	public void verifyTheResourceTitleForMultipleSubjectFilter() {

		List<String> values = new ArrayList<String>();
		CoolOer co = new CoolOer(driver);
		
		List<WebElement> resourceList2 = co.getResourceListUnderCreativityAnd21stCenturySkills();
		for(int i=0; i< resourceList2.size();i++) {
			String resourceTitle = resourceList2.get(i).getText().replace("\n","").replace("\r","").trim();	
			if(resourceTitle.contains("SCRATCH") || resourceTitle.contains("स्क्रैच (SCRATCH)")) {
				values.add(resourceTitle);
				System.out.println("The resources title under creativity and 21st century skills are:"+ resourceTitle);
			}		
		}
		
		
		List<WebElement> resourceList3 = co.getResourcesListUnderTinkeringAndMaking();
		for(int j=0; j< resourceList3.size();j++) {
			String resourceTitle2 = resourceList3.get(j).getText().replace("\n","").replace("\r","").trim();	
			if(resourceTitle2.contains("Arvind Gupta Toys") || resourceTitle2.contains("metastudio.org")) {
				values.add(resourceTitle2);
				System.out.println("The resources title under tinkering and making are:"+resourceTitle2);
			}		
		}
		
		System.out.println("The resources available after Multiple Subject filter:"+values);
		log.info("The resources available after Multiple Subject filter:"+values);
		
	}
	
	
	@AfterTest
	public void terminate() {
	
		driver.quit();
		log.info("driver is been quit");
	}
	
}
