package com.clix.clixoerwebsite;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DomainPage;
import pageObjects.LandingPage;
import resources.base;

public class DomainContactForm extends base {

	public WebDriver driver;
	public Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void navigateToUrl() throws IOException {
		driver = initializeDriver();
		log.info("driver is been initialized");
		
		driver.get(prop.getProperty("englishDomain"));
		log.info("url site is been navigated");
		
		driver.manage().window().maximize();
		log.info("browser window is been maximized");		
		
	}
	
	
	@Test(dataProvider="contactForm")
	public void domainPageContactFormValidation(String firstname, String lastname, String email, String phone, String message) {


		driver.navigate().refresh();
		
		DomainPage dp = new DomainPage(driver);
		
		driver.navigate().refresh();
		log.info("site is been refreshed");
		
		
		dp.getContactFormFirstNameField().sendKeys(firstname);
		log.info("valid firstname is been entered into field");

		dp.getContactFormLastNameField().sendKeys(lastname);
		log.info("valid lastname is been entered into field");
		
		dp.getContactFormEmailField().sendKeys(email);
		log.info("valid email is been entered into field");
		
		dp.getContactFormPhoneField().sendKeys(phone);
		log.info("valid phone is been entered into field");
		
		dp.getContactFormMessageField().sendKeys(message);
		log.info("valid message is been entered into field");
		
		dp.getContactFormSubmit().click();
		
		boolean alertIsDisplayed = dp.getContactFormAlert().isDisplayed();

		if(alertIsDisplayed) {
			
			String invalidAlert = dp.getContactFormAlert().getText().replace("\n","").replace("\r","").trim();
			
			if(invalidAlert.contains("Your feedback sent successfully!")) {
				Assert.assertTrue(true);
				log.info("alert is been displayed as:"+invalidAlert);
				System.out.println("alert is been displayed as:"+invalidAlert);
			}
			else
			{
				Assert.assertFalse(true);
			}
		}
		
	}

	@DataProvider(name="contactForm")
	public Object[][] getData(){
		
		Object[][] data = new Object[2][5];		
		data[0][0]="Viraj";
		data[0][1]="Utekar";
		data[0][2]="viraj100@gmail.com";
		data[0][3]="9292929292";
		data[0][4]="correct";
		data[1][0] ="Viraj";
		data[1][1]="Utekar";
		data[1][2]="viraj100";
		data[1][3]="9292929292";
		data[1][4]="Incorrect";		

		return data;
	}
	
	@AfterTest
	public void terminate() {
		driver.quit();
		log.info("browser driver is been quit");
	}
		
}
