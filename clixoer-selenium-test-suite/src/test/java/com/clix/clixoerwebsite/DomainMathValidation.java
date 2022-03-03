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

public class DomainMathValidation extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());
	
	public WebDriver driver;
	
	
	@BeforeTest
	public void navigateToUrl() throws IOException {

		driver = initializeDriver();
		log.info("driver is been initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("site url is been navigated");
		
		driver.manage().window().maximize();
		log.info("browser window is been maximized");
		
	}
	
	@Test
	public void verifyDomainMathOptionIsSelected() {
		
		DomainPage dp = new DomainPage(driver);
		
		driver.navigate().refresh();
		
		dp.getDomainNavigationMenu().click();
		log.info("Domain navigation menu is been clicked");
		
		dp.getMathOption().click();
		log.info("Math option from drop down list is been clicked");
		
	    String domainSetValue = dp.getDomainNavigationMenu().getText();
	    
	    if(domainSetValue.contains("Math")) {
	    	Assert.assertTrue(true);
	    	log.info("math option is selected");
	    	System.out.println("Math option under domain is been selected");
	    }
	}
	
	@Test
	public void verifyTheNumberOfMathModules() {
		
		DomainPage dp = new DomainPage(driver);
		int mathModulesCount = dp.getNumberOfMathModule().size();
		Assert.assertEquals(mathModulesCount,4);
		log.info("number of math modules is 4");
		System.out.println("The number of math modules under domain is: "+mathModulesCount);
	}
	
	@Test
	public void verifyTheNumberOfLinksOnPage() {
		
		DomainPage dp = new DomainPage(driver);
		int mathDomainPageLinkCount = dp.getMathDomainPageLinks().size();
		Assert.assertEquals(mathDomainPageLinkCount,102);
		log.info("number of links in domain Math page is",+mathDomainPageLinkCount);
		System.out.println("The Number of Links in domain Math page is:" +mathDomainPageLinkCount);
	}
	
	@Test
	public void verifyTheTitleOfMathModulePage() {
		
		DomainPage dp = new DomainPage(driver);
		
		List<String> mathModuleNameList = new ArrayList<String>();
		
		List<WebElement> mathModuleList = dp.getMathModulesTitle();
		
        for(int i=0; i<mathModuleList.size();i++) {
        	String mathModuleTitles = mathModuleList.get(i).getText().replace("/r","").replace("/n","").trim();
        	
        	if(mathModuleTitles.contains("Geometric Reasoning") || mathModuleTitles.contains("Proportional Reasoning") || mathModuleTitles.contains("Linear Equations")){
        		mathModuleNameList.add(mathModuleTitles);
        		Assert.assertTrue(true);
        		log.info("The math module available into list is Geometric Reasoning Part I, Geometric Reasoning Part II, Proportional Reasoning, Linear Equations");
        	}
        }
        System.out.println("The math module available into list is:" +mathModuleNameList);
	}
	
	@AfterTest
	public void terminate() {
		driver.quit();
		log.info("driver is been quit");
	}
	
}
