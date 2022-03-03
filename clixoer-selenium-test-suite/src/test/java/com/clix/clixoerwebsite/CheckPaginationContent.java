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

public class CheckPaginationContent extends base {
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
	public void checkPagnationExists() throws InterruptedException
	
	{
		driver.navigate().refresh();
		driver.manage().window().fullscreen();
		landingpage = new LandingPage(driver);
		landingpage.getModules().click();
		System.out.println("Modules Text = "+ landingpage.getModules().getText());
		String modulestext= landingpage.getModules().getText();
		Assert.assertEquals(modulestext,"Modules 13");
		log.info("13 Modules Verified");
	
		Thread.sleep(9000);
		
		int paginationsize = driver.findElements(By.cssSelector("body > nav > ul > li.page-item> a")).size();
		
		List<WebElement> paginations = driver.findElements(By.cssSelector("body > nav > ul > li.page-item> a"));
		List<String> names = new ArrayList<String>();
		List<String> titlenames = new ArrayList<String>();
		int p = 2;
		for (WebElement pagination : paginations) {
			names.add(pagination.getText());
		}
		
		for (int i = 2 ; i<paginationsize;i++)
		{ 
			Thread.sleep(2000);
			String paginationSelector = "body > nav > ul > li:nth-child("+i+")> a";
			driver.findElement(By.cssSelector(paginationSelector)).click();
			Thread.sleep(3000);
			List<WebElement> titles = driver.findElements(By.className("card-header"));
			p = p+2;
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
		Assert.assertEquals(titlenames.size(),13);
		}
		
	
	@AfterTest
	public void teardown() {
		driver.quit();
		log.info("browser driver is been closed");
	
	}
}
