package com.clix.clixoerwebsite;

import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AboutPage;
import pageObjects.LandingPage;
import resources.base;

public class AboutPageTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void bringup() throws IOException
	{
		driver = initializeDriver();
		log.info("driver is been initialized");
		driver.get(prop.getProperty("url"));
		log.info("site url is been navigated");
	}
	@Test(dataProvider="contactForm")
	public void aboutPageContatForm(String firstname,String lastname,String email,String phone,String message) throws IOException
	{
		driver.navigate().refresh();
		log.info("site is been refreshed");
		
		driver.manage().window().maximize();
		log.info("browser window is been maximized");
		
		LandingPage landingpage = new LandingPage(driver);
		
		landingpage.getAbout().click();
		
		AboutPage aboutpage = new AboutPage(driver);
		
		aboutpage.getFirstName().sendKeys(firstname);
		log.info("first name is been entered into field");
		aboutpage.getLastName().sendKeys(lastname);
		log.info("last name is been entered into field");
		aboutpage.getEmail().sendKeys(email);
		log.info("email is been entered into field");
		aboutpage.getPhone().sendKeys(phone);
		log.info("phone number is been entered into field");
		aboutpage.getMessage().sendKeys(message);
		log.info("message is been entered into field");
		aboutpage.getSendButton().click();
		log.info("submit button is been clicked");
		
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
		log.info("browser is been quit");
	}

	

}
