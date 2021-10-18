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
	
	@Test(dataProvider="getValidData")
	public void domainPageContactFormValidationWithValidRecords(String firstname, String lastname, String email, String phone, String message) {
	
		DomainPage dp = new DomainPage(driver);
//		dp.getAdvertisementBannerCloseIcon().click();
//		log.info("advertisement banner is been closed");
//	
//		dp.getDomainNavigationMenu().click();
//		log.info("domain navigation menu is been clicked");
//		
//		dp.getMathOption().click();
//		log.info("math option under domain is selected");
		
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
			
			String successAlert = dp.getContactFormAlert().getText().replace("\n","").replace("\r","").trim();
			
			if(successAlert.contains("Your feedback sent successfully!")){
				Assert.assertTrue(true);
				log.info("alert is been displayed as:"+successAlert);
			}
			else
			{
				Assert.assertFalse(true);
			}
			
		}
		
	}
	
	@Test(dataProvider="getInvalidData")
	public void domainPageContactFormValidationWithInvalidRecords(String firstname, String lastname, String email, String phone, String message) {
		
		driver.navigate().refresh();
		
		DomainPage dp = new DomainPage(driver);
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
			
			if(invalidAlert.contains("xYour feedback sent successfully!")) {
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

	@DataProvider
	public Object[][] getValidData(){
		
		Object[][] data = new Object[1][5];
		
		data[0][0]="Viraj";
		data[0][1]="Utekar";
		data[0][2]="utekar29viraj@gmail.com";
		data[0][3]="9292929292";
		data[0][4]="correct";
		
		return data;
	}
	
	
	@DataProvider
	public Object[][] getInvalidData(){
	
		Object[][] data = new Object[1][5];
		
		data[0][0] ="Viraj";
		data[0][1]="Utekar";
		data[0][2]="utekar29viraj@gmail.com";
		data[0][3]="9292929292";
		data[0][4]="Incorrect";
	  
		return data;
	}
	
	
	@AfterTest
	public void terminate() {
		driver.quit();
		log.info("browser driver is been quit");
	}
		
}
