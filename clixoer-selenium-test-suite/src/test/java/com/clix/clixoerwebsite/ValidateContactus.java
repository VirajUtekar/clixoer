package com.clix.clixoerwebsite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AboutPage;
import pageObjects.LandingPage;
import resources.base;

public class ValidateContactus extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void beforeTest() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is Initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("site url is been navigated");
		
		driver.manage().window().maximize();
		log.info("browser window is been maximized");

		LandingPage landingpage = new LandingPage(driver);

		landingpage.getadvertisementBanner().click();
		log.info("advertisement banner is been closed");
		
		landingpage.getAbout().click();
        log.info("about menu is been clicked");

	}
	@Test(dataProvider="contactForm")
	public void basePageNavigation(String firstname,String lastname,String email,String phone,String message) throws IOException
	{
	        
		
		driver.navigate().refresh();
		
		AboutPage aboutpage = new AboutPage(driver);		
		aboutpage.getFirstName().sendKeys(firstname);
		
		aboutpage.getLastName().sendKeys(lastname);
		aboutpage.getEmail().sendKeys(email);
		aboutpage.getPhone().sendKeys(phone);
		aboutpage.getMessage().sendKeys(message);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		aboutpage.getSendButton().click();
		System.out.println(aboutpage.getMessageAlert().getText());
		
		boolean alertIsDisplayed = aboutpage.getMessageAlert().isDisplayed();
		if(alertIsDisplayed) {
			String successAlert = aboutpage.getMessageAlert().getText().replace("\n", "").replace("\r","").trim();
			if(successAlert.contains("Your feedback sent successfully!")) {
				Assert.assertTrue(true);
				log.info("alert is displayed as:"+successAlert);
				System.out.println("alert is displayed as:"+successAlert);
			}
			else
			{
				Assert.assertFalse(true);
			}
		}	
	}
	
	@DataProvider(name="contactForm")
	public Object[][] getData()
	{
		Object[][] data = new Object[2][5];

		data[0][0]="Vighnesh";
		data[0][1]="Nair";
		data[0][2]="Vighnesh@gmail.com";
		data[0][3]="9987838143";
		data[0][4]="Correct";
		data[1][0]="Brett";
		data[1][1]="Lee";
		data[1][2]="notvighnesh";
		data[1][3]="66565";
		data[1][4]="inCorrect";		

		return data;	
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		log.info("browser driver is been closed");
	}
	
}
