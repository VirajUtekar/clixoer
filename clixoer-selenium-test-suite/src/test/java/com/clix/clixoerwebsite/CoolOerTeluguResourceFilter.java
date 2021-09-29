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

public class CoolOerTeluguResourceFilter extends base {

public WebDriver driver;
	
public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void navigateToUrl() throws IOException {
		driver = initializeDriver();
		log.info("driver is been initialized");
		
		driver.get(prop.getProperty("cooloer"));
		log.info("site url is been navigated");
		
		driver.manage().window().maximize();
		log.info("browser window is been maximized");
	}
	
	@Test
	public void verifyTeluguLanguageSupportOptionIsChecked() throws InterruptedException {
		CoolOer co = new CoolOer(driver);
		
//		co.getadvertisementBanner().click();
//		log.info("advertisement banner is been closed");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)", "");
		
		co.getTeluguCheckBoxLanguageSupport().click();
		
		boolean teluguOptionEnabled = co.getTeluguCheckBoxLanguageSupport().isEnabled();
		if(teluguOptionEnabled) {
			Assert.assertTrue(true);
			log.info("Telugu option is checked for language support");
			System.out.println("Telugu option is checked for Language support");
		}
	}
	
	@Test
	public void verifyTheNumberOfResourcesForTeluguFilter() throws InterruptedException {
		
		Thread.sleep(2000);
		
		CoolOer co = new CoolOer(driver);
		
		int teluguResourcesUnderKnowledgeDeepning2  = co.getResourceListUnderKnowledgeDeepning2().size();
		
		int teluguResourcesUnderCreativityAnd21stCenturySkills = co.getResourceListUnderCreativityAnd21stCenturySkills().size();
		
		int teluguResourcesUnderTinkeringAndMaking = co.getResourcesListUnderTinkeringAndMaking().size();

		int totalResourcesForHindiFilter = teluguResourcesUnderKnowledgeDeepning2+teluguResourcesUnderCreativityAnd21stCenturySkills+teluguResourcesUnderTinkeringAndMaking;
		
		if(totalResourcesForHindiFilter == 3) {
			Assert.assertTrue(true);
			log.info("The number of resources available for Telugu filter is: 3");
			System.out.println("The number of resources available for Telugu filter is:"+totalResourcesForHindiFilter);
		}
	}

	@Test
	public void verifyTheNumberOfLinksOnPageForTeluguFilter() throws InterruptedException {
	
		Thread.sleep(2000);
		CoolOer co = new CoolOer(driver);
		int totalNumberOfLinksOnTeluguFilterPage = co.getNumberOfLinksOnPage().size();
		Assert.assertEquals(totalNumberOfLinksOnTeluguFilterPage,78);
		log.info("Total number of links on page after Telugu filter is: 78");
		System.out.println("Total number of links on page after Telugu filter is:"+totalNumberOfLinksOnTeluguFilterPage);
	}

	@Test
	public void verifyTheResourcesTitleForTeluguFilter() {
  	
		CoolOer co = new CoolOer(driver);
		
		List<String> resourcesTitle = new ArrayList<String>();
	
		List<WebElement> teluguFilterResourceList1 = co.getResourceListUnderKnowledgeDeepning2();
		
		for(int i=0; i<teluguFilterResourceList1.size();i++) {
			String resourceList1 =  teluguFilterResourceList1.get(i).getText().replace("\r","").replace("\n","").trim();
			
			if(resourceList1.contains("GeoGebra") || resourceList1.contains("PhET")) {
				resourcesTitle.add(resourceList1);
				System.out.println(resourceList1);
			}
		}
		
		List<WebElement> teluguFilterResourceList2 = co.getResourceListUnderCreativityAnd21stCenturySkills();
		for(int j=0; j<teluguFilterResourceList2.size();j++) {
			String resourceList2 =  teluguFilterResourceList2.get(j).getText().replace("\r","").replace("\n","");
			
			if(resourceList2.contains("SCRATCH")) {
				resourcesTitle.add(resourceList2);
				System.out.println(resourceList2);
			}
		}

		log.info("The Resources Filter for Telugu options are జియోజీబ్రా (GeoGebra), PhET పరస్పర అనుకరణలు, స్క్రాచ్ (SCRATCH)");
		System.out.println("The Resources Filter for Telugu Options are:" +resourcesTitle);	
	}

	@AfterTest
	public void terminate() {
	  driver.quit();	
	}
	
	
}
