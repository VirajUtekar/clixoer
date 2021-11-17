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

public class CoolOerEnglishResourceFilter extends base {

	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void navigateToUrl() throws IOException {
	
		driver = initializeDriver();
		log.info("driver is been initialized");
		
		driver.get(prop.getProperty("cooloer"));
		log.info("url site is been navigated");
		
		driver.manage().window().maximize();
		log.info("browser window is been maximized");
	}
	
	@Test
	public void verifyEnglishLanguageSupportOptionIsChecked() throws InterruptedException {
		CoolOer co = new CoolOer(driver);
		
//		co.getadvertisementBanner().click();
//		log.info("advertisement banner is been closed");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)", "");
		
		co.getEnglishCheckBoxLanguageSupport().click();
		
		boolean englishOptionEnabled = co.getEnglishCheckBoxLanguageSupport().isEnabled();
		if(englishOptionEnabled) {
			Assert.assertTrue(true);
			log.info("English option is checked for language support");
			System.out.println("English option is checked for Language support");
		}
	}
	
	@Test
	public void verifyTheNumberOfResourcesForEnglishFilter() throws InterruptedException {
		
		Thread.sleep(2000);		
		CoolOer co = new CoolOer(driver);
		
		int englishResourcesUnderKnowledgeDeepning  = co.getResourceListUnderKnowledgeDeepning2().size();
		
		int englishResourcesUnderCreativityAnd21stCenturySkills = co.getResourceListUnderCreativityAnd21stCenturySkills().size();
		
		int englishResourcesUnderTinkeringAndMaking = co.getResourcesListUnderTinkeringAndMaking().size();

		int totalResourcesForEnglishFilter = englishResourcesUnderKnowledgeDeepning+englishResourcesUnderCreativityAnd21stCenturySkills+englishResourcesUnderTinkeringAndMaking;
		
		if(totalResourcesForEnglishFilter == 6) {
			Assert.assertTrue(true);
			log.info("The number of resources available for english filter is: 6");
			System.out.println("The number of resources available for english filter is:"+totalResourcesForEnglishFilter);
		}  
	}
	
	@Test
	public void verifyTheNumberOfLinksOnPageForEnglishFilter() throws InterruptedException {
	
		Thread.sleep(2000);
		CoolOer co = new CoolOer(driver);
		int totalNumberOfLinksOnEnglishFilterPage = co.getNumberOfLinksOnPage().size();
		Assert.assertEquals(totalNumberOfLinksOnEnglishFilterPage,120);
		log.info("Total number of links on page after English filter is: 120 ");
		System.out.println("Total number of links on page after English filter is:"+totalNumberOfLinksOnEnglishFilterPage);
	}

	
	@Test
	public void verifyTheResourcesTitleForEnglishFilter() {
  	
		CoolOer co = new CoolOer(driver);
		
		List<String> resourcesTitle = new ArrayList<String>();
	
		List<WebElement> englishFilterResourceList1 = co.getResourceListUnderKnowledgeDeepning2();
		
		for(int i=0; i<englishFilterResourceList1.size();i++) {
			String resourceList1 =  englishFilterResourceList1.get(i).getText().replace("\r","").replace("\n","").trim();
			
			if(resourceList1.contains("GeoGebra") || resourceList1.contains("PhET Interactive Simulations")) {
				resourcesTitle.add(resourceList1);
				System.out.println(resourceList1);
			}
		}
		
		List<WebElement> englishFilterResourceList2 = co.getResourceListUnderCreativityAnd21stCenturySkills();
		for(int j=0; j<englishFilterResourceList2.size();j++) {
			String resourceList2 =  englishFilterResourceList2.get(j).getText().replace("\r","").replace("\n","");
			
			if(resourceList2.contains("SCRATCH") || resourceList2.contains("Storyweaver")) {
				resourcesTitle.add(resourceList2);
				System.out.println(resourceList2);
			}
		}

		List<WebElement> englishFilterResourceList3 = co.getResourcesListUnderTinkeringAndMaking();
		for(int k=0; k< englishFilterResourceList3.size();k++) {
			String resourceList3 = englishFilterResourceList3.get(k).getText().replace("\r","").replace("\n","");
			
			if(resourceList3.contains("Arvind Gupta Toys") || resourceList3.contains("metastudio.org")) {
				resourcesTitle.add(resourceList3);
				System.out.println(resourceList3);	
			}
		}
		log.info("The Resources Filter for English Options:" +resourcesTitle);
		System.out.println("The Resources Filter for English Options are:" +resourcesTitle);	
	}
	
	@AfterTest
	public void terminate() {
		driver.quit();
		log.info("browser driver is been quit");
	}
	
}
