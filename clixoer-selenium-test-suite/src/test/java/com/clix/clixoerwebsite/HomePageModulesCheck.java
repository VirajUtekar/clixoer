package com.clix.clixoerwebsite;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class HomePageModulesCheck extends base {
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
		landingpage.getModules().click();
		System.out.println("Modules Text = "+ landingpage.getModules().getText());
	}
	
	@Test
	public void checkPrevPaginationDisabled()
	{
		WebElement prev= landingpage.getPrevButton();
		System.out.println("Hovering on the element...");
		System.out.println("Cursor before hovering on: " + prev.getCssValue("cursor"));

		//Hover the mouse over that element
		Actions builder = new Actions(driver);
		builder.moveToElement(prev);
		builder.build().perform();
		String cursorTypeAfter = prev.getCssValue("cursor");
		System.out.println("Cursor after hovering on: " + cursorTypeAfter);
		Assert.assertTrue(cursorTypeAfter.equalsIgnoreCase("not-allowed"), "Cursor type changed !");
		log.info("Previous Button is disabled");
	}
		
		
	
	@AfterTest

	public void teardown() {
		driver.close();
	}
	
}
