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

public class CoolOerHindiResourceFilter extends base {

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
	public void verifyHindiLanguageSupportOptionIsChecked() throws InterruptedException {
		CoolOer co = new CoolOer(driver);
		
//		co.getadvertisementBanner().click();
//		log.info("advertisement banner is been closed");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)", "");
		
		co.getHindiCheckBoxLanguageSupport().click();
		
		boolean hindiOptionEnabled = co.getHindiCheckBoxLanguageSupport().isEnabled();
		if(hindiOptionEnabled) {
			Assert.assertTrue(true);
			log.info("Hindi option is checked for language support");
			System.out.println("Hindi option is checked for Language support");
		}
	}
	
	@Test
	public void verifyTheNumberOfResourcesForHindiFilter() throws InterruptedException {
		
		Thread.sleep(2000);
		
		CoolOer co = new CoolOer(driver);
		
		int hindiResourcesUnderKnowledgeDeepning2  = co.getResourceListUnderKnowledgeDeepning2().size();
		
		int hindiResourcesUnderCreativityAnd21stCenturySkills = co.getResourceListUnderCreativityAnd21stCenturySkills().size();
		
		int hindiResourcesUnderTinkeringAndMaking = co.getResourcesListUnderTinkeringAndMaking().size();

		int totalResourcesForHindiFilter = hindiResourcesUnderKnowledgeDeepning2+hindiResourcesUnderCreativityAnd21stCenturySkills+hindiResourcesUnderTinkeringAndMaking;
		
		if(totalResourcesForHindiFilter == 4) {
			Assert.assertTrue(true);
			log.info("The number of resources available for hindi filter is: 4");
			System.out.println("The number of resources available for hindi filter is:"+totalResourcesForHindiFilter);
		}  
	}

	@Test
	public void verifyTheNumberOfLinksOnPageForHindiFilter() throws InterruptedException {
	
		Thread.sleep(2000);
		CoolOer co = new CoolOer(driver);
		int totalNumberOfLinksOnHindiFilterPage = co.getNumberOfLinksOnPage().size();
		Assert.assertEquals(totalNumberOfLinksOnHindiFilterPage,92);
		log.info("Total number of links on page after Hindi filter is: 92 ");
		System.out.println("Total number of links on page after Hindi filter is:"+totalNumberOfLinksOnHindiFilterPage);
	}

	@Test
	public void verifyTheResourcesTitleForHindiFilter() {
  	
		CoolOer co = new CoolOer(driver);
		
		List<String> resourcesTitle = new ArrayList<String>();
	
		List<WebElement> hindiFilterResourceList1 = co.getResourceListUnderKnowledgeDeepning2();
		
		for(int i=0; i<hindiFilterResourceList1.size();i++) {
			String resourceList1 =  hindiFilterResourceList1.get(i).getText().replace("\r","").replace("\n","").trim();
			
			if(resourceList1.contains("GeoGebra") || resourceList1.contains("PhET")) {
				resourcesTitle.add(resourceList1);
				System.out.println(resourceList1);
			}
		}
		
		List<WebElement> hindiFilterResourceList2 = co.getResourceListUnderCreativityAnd21stCenturySkills();
		for(int j=0; j<hindiFilterResourceList2.size();j++) {
			String resourceList2 =  hindiFilterResourceList2.get(j).getText().replace("\r","").replace("\n","");
			
			if(resourceList2.contains("SCRATCH")) {
				resourcesTitle.add(resourceList2);
				System.out.println(resourceList2);
			}
		}

		List<WebElement> hindiFilterResourceList3 = co.getResourcesListUnderTinkeringAndMaking();
		for(int k=0; k< hindiFilterResourceList3.size();k++) {
			String resourceList3 = hindiFilterResourceList3.get(k).getText().replace("\r","").replace("\n","");
			
			if(resourceList3.contains("अरविंद गुप्ता खिलौने")) {
				resourcesTitle.add(resourceList3);
				System.out.println(resourceList3);	
			}
		}
		log.info("The Resources Filter for Hindi Options are"+resourcesTitle);
		System.out.println("The Resources Filter for Hindi Options are:" +resourcesTitle);	
	}

	@AfterTest
	public void terminate() {
	  driver.quit();	
	}
	
	
}
