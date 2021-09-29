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

public class CoolOerTamilResourceFilter extends base{

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
		public void verifyTamilLanguageSupportOptionIsChecked() throws InterruptedException {
			CoolOer co = new CoolOer(driver);
			
//			co.getadvertisementBanner().click();
//			log.info("advertisement banner is been closed");

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,650)", "");
			
			co.getTamilCheckBoxLanguageSupport().click();
			
			boolean tamilOptionEnabled = co.getTamilCheckBoxLanguageSupport().isEnabled();
			if(tamilOptionEnabled) {
				Assert.assertTrue(true);
				log.info("Tamil option is checked for language support");
				System.out.println("Tamil option is checked for Language support");
			}
		}
		
		@Test
		public void verifyTheNumberOfResourcesForTamilFilter() throws InterruptedException {
			
			Thread.sleep(2000);
			
			CoolOer co = new CoolOer(driver);
			
			int tamilResourcesUnderKnowledgeDeepning2  = co.getResourceListUnderKnowledgeDeepning2().size();
			
			int tamilResourcesUnderCreativityAnd21stCenturySkills = co.getResourceListUnderCreativityAnd21stCenturySkills().size();
			
			int tamilResourcesUnderTinkeringAndMaking = co.getResourcesListUnderTinkeringAndMaking().size();

			int totalResourcesForHindiFilter = tamilResourcesUnderKnowledgeDeepning2+tamilResourcesUnderCreativityAnd21stCenturySkills+tamilResourcesUnderTinkeringAndMaking;
			
			if(totalResourcesForHindiFilter == 3) {
				Assert.assertTrue(true);
				log.info("The number of resources available for Tamil filter is: 3");
				System.out.println("The number of resources available for Tamil filter is:"+totalResourcesForHindiFilter);
			}
		}

		@Test
		public void verifyTheNumberOfLinksOnPageForTamilFilter() throws InterruptedException {
		
			Thread.sleep(2000);
			CoolOer co = new CoolOer(driver);
			int totalNumberOfLinksOnTamilFilterPage = co.getNumberOfLinksOnPage().size();
			Assert.assertEquals(totalNumberOfLinksOnTamilFilterPage,78);
			log.info("Total number of links on page after Tamil filter is: 78");
			System.out.println("Total number of links on page after Tamil filter is:"+totalNumberOfLinksOnTamilFilterPage);
		}

		@Test
		public void verifyTheResourcesTitleForTamilFilter() {
	  	
			CoolOer co = new CoolOer(driver);
			
			List<String> resourcesTitle = new ArrayList<String>();
		
			List<WebElement> tamilFilterResourceList1 = co.getResourceListUnderKnowledgeDeepning2();
			
			for(int i=0; i<tamilFilterResourceList1.size();i++) {
				String resourceList1 =  tamilFilterResourceList1.get(i).getText().replace("\r","").replace("\n","").trim();
				
				if(resourceList1.contains("GeoGebra") || resourceList1.contains("PhET")) {
					resourcesTitle.add(resourceList1);
					System.out.println(resourceList1);
				}
			}
			
			List<WebElement> tamilFilterResourceList2 = co.getResourceListUnderCreativityAnd21stCenturySkills();
			for(int j=0; j<tamilFilterResourceList2.size();j++) {
				String resourceList2 =  tamilFilterResourceList2.get(j).getText().replace("\r","").replace("\n","");
				
				if(resourceList2.contains("SCRATCH")) {
					resourcesTitle.add(resourceList2);
					System.out.println(resourceList2);
				}
			}

			log.info("The Resources Filter for Tamil options are ஜியோஜீப்ரா (GeoGebra), PhET ஊடாடும் உருவகப்படுத்துதல்கள்,ஸ்க்ராட்ச் (SCRATCH)");
			System.out.println("The Resources Filter for Tamil are:" +resourcesTitle);	
		}

		@AfterTest
		public void terminate() {
		  driver.quit();	
		}
	
}
