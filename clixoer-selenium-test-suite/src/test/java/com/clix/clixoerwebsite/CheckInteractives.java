package com.clix.clixoerwebsite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class CheckInteractives extends base {
	public WebDriver driver;
	public LandingPage landingpage;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void bringup() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");

		driver.get(prop.getProperty("url"));
		log.info("URL is Fetched");

	}

	@Test
	public void checkModuleExist()
	{
		driver.navigate().refresh();
		driver.manage().window().fullscreen();
		landingpage = new LandingPage(driver);
		landingpage.getInteractives().click();
		System.out.println("Interactives = "+ landingpage.getInteractives().getText());
	}
	
	@Test
	public void checkPaginationInteractives() throws InterruptedException

	{
		
		
		driver.navigate().refresh();
		driver.manage().window().fullscreen();
		landingpage = new LandingPage(driver);
		landingpage.getInteractives().click();
		String modulestext= landingpage.getInteractives().getText();
		Assert.assertEquals(modulestext,"Interactives 21");
		log.info("21 Interactives Verified");
	
		Thread.sleep(9000);
		
		int paginationsize = driver.findElements(By.cssSelector("body > nav > ul > li.page-item > a")).size();
		System.out.println("Size of pagination"+paginationsize);
		
		List<WebElement> paginations = driver.findElements(By.cssSelector("body > nav > ul > li.page-item > a"));
		List<String> names = new ArrayList<String>();
		List<String> titlenames = new ArrayList<String>();
		for (WebElement pagination : paginations) {
			names.add(pagination.getText());
			
		}
		System.out.println(names);
		for (int i = 2 ; i<paginationsize;i++)
		{ 
			Thread.sleep(2000);
			String paginationSelector = "body > nav > ul > li:nth-child("+i+")> a";
			driver.findElement(By.cssSelector(paginationSelector)).click();
			Thread.sleep(3000);
			
			List<WebElement> titles = driver.findElements(By.className("text-shadow"));
			
		
			                                                 
			for (WebElement title : titles)
			{
				titlenames.add(title.getText());
				
				
				
			}
		
		}
		titlenames.removeAll(Arrays.asList("", null));
		System.out.println(titlenames);
		System.out.println("Size is"+titlenames.size());
		
		for (String name : titlenames)
		{
			System.out.println(name);
			
			
		}
	
		System.out.println(titlenames.size());
		Assert.assertEquals(titlenames.size(),21);
		}
		
	
	@AfterTest
	public void teardown() {
		driver.quit();
		log.info("browser driver is been quit");
	}
	
}
