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

public class CoolOerPunjabiResourceFilter extends base {

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
	public void verifyPunjabiLanguageSupportOptionIsChecked() throws InterruptedException {
		CoolOer co = new CoolOer(driver);
		
//		co.getadvertisementBanner().click();
//		log.info("advertisement banner is been closed");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)", "");
		
		co.getPunjabiCheckBoxLanguageSupport().click();
		
		boolean punjabiOptionEnabled = co.getPunjabiCheckBoxLanguageSupport().isEnabled();
		if(punjabiOptionEnabled) {
			Assert.assertTrue(true);
			log.info("Punjabi option is checked for language support");
			System.out.println("Punjabi option is checked for Language support");
		}
	}
	
	@Test
	public void verifyTheNumberOfResourcesForPunjabiFilter() throws InterruptedException {
		
		Thread.sleep(2000);
		
		CoolOer co = new CoolOer(driver);
		
		int punjabiResourcesUnderKnowledgeDeepning2  = co.getResourceListUnderKnowledgeDeepning2().size();
		
		int punjabiResourcesUnderCreativityAnd21stCenturySkills = co.getResourceListUnderCreativityAnd21stCenturySkills().size();
		
		int punjabiResourcesUnderTinkeringAndMaking = co.getResourcesListUnderTinkeringAndMaking().size();

		int totalResourcesForHindiFilter = punjabiResourcesUnderKnowledgeDeepning2+punjabiResourcesUnderCreativityAnd21stCenturySkills+punjabiResourcesUnderTinkeringAndMaking;
		
		if(totalResourcesForHindiFilter == 2) {
			Assert.assertTrue(true);
			log.info("The number of resources available for punjabi language filter is: 2");
			System.out.println("The number of resources available for punjabi language filter is:"+totalResourcesForHindiFilter);
		}  
	}

	@Test
	public void verifyTheNumberOfLinksOnPageForPunjabiFilter() throws InterruptedException {
	
		Thread.sleep(2000);
		CoolOer co = new CoolOer(driver);
		int totalNumberOfLinksOnPunjabiFilterPage = co.getNumberOfLinksOnPage().size();
		Assert.assertEquals(totalNumberOfLinksOnPunjabiFilterPage,64);
		log.info("Total number of links on page after Punjabi filter is: 64 ");
		System.out.println("Total number of links on page after Punjabi filter is:"+totalNumberOfLinksOnPunjabiFilterPage);
	}

	@Test
	public void verifyTheResourcesTitleForPunjabiFilter() {
  	
		CoolOer co = new CoolOer(driver);
		
		List<String> resourcesTitle = new ArrayList<String>();
	
//		List<WebElement> punjabiFilterResourceList1 = co.getResourceListUnderKnowledgeDeepning2();
//		
//		for(int i=0; i<punjabiFilterResourceList1.size();i++) {
//			String resourceList1 =  punjabiFilterResourceList1.get(i).getText().replace("\r","").replace("\n","").trim();
//			
//			if(resourceList1.contains("GeoGebra") || resourceList1.contains("PhET")) {
//				resourcesTitle.add(resourceList1);
//				System.out.println(resourceList1);
//			}
//		}
		
		List<WebElement> punjabiFilterResourceList2 = co.getResourceListUnderCreativityAnd21stCenturySkills();
		for(int j=0; j<punjabiFilterResourceList2.size();j++) {
			String resourceList2 =  punjabiFilterResourceList2.get(j).getText().replace("\r","").replace("\n","").trim();
			
			if(resourceList2.contains("SCRATCH") || resourceList2.contains("Storyweaver")) {
				resourcesTitle.add(resourceList2);
				System.out.println(resourceList2);
			}
			else
			{
				System.out.println("no");
			}
		}

//		List<WebElement> hindiFilterResourceList3 = co.getResourcesListUnderTinkeringAndMaking();
//		for(int k=0; k< hindiFilterResourceList3.size();k++) {
//			String resourceList3 = hindiFilterResourceList3.get(k).getText().replace("\r","").replace("\n","");
//			
//			if(resourceList3.contains("अरविंद गुप्ता खिलौने")) {
//				resourcesTitle.add(resourceList3);
//				System.out.println(resourceList3);	
//			}
//		}

		log.info("The Resources Filter for Punjabi Language  Options are ਸਕ੍ਰੈਚ (SCRATCH),  ਸਟੋਰੀਵੀਵਰ (Storyweaver)");
		System.out.println("The Resources Filter for Punjabi Language Options are:" +resourcesTitle);	
	}

	@AfterTest
	public void terminate() {
	  driver.quit();
	  log.info("browser driver is been closed");
	}
	
}
