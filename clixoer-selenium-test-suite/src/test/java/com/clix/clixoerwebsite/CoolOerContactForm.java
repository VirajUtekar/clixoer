package com.clix.clixoerwebsite;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CoolOer;
import resources.base;

public class CoolOerContactForm extends base {

	public WebDriver driver;
	
	public Logger log = LogManager.getLogger(base.class.getName());
	
	
	@BeforeTest
	public void navigateToUrl() throws IOException {
		driver = initializeDriver();
		log.info("driver is been initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("site url is been navigated");
		
		driver.manage().window().maximize();
		log.info("browser window is been maximized");
	}
	
	@Test(dataProvider="getCorrectData")
	public void CoolOerPageContactFormValidationWithCorrectRecords(String firstname,String lastname,String email,String phone,String message) {
		
		CoolOer co = new CoolOer(driver);
		co.getadvertisementBanner().click();
		log.info("advertisement banner is been closed");
		
		co.getCoolOerMenuOption().click();
		log.info("cool oer navigation menu option is been clicked");
		
		co.getContactFormFirstNameField().sendKeys(firstname);
		log.info("valid first name is entered into field");
		
		co.getContactFormLastNameField().sendKeys(lastname);
		log.info("valid last name is entered into field");
		
		co.getContactFormEmailField().sendKeys(email);
		log.info("valid email is entered into field");
		
		co.getContactFormPhoneField().sendKeys(phone);
		log.info("valid phone is entered into field");
		
		co.getContactFormMessageField().sendKeys(message);
		log.info("valid message is entered into field");
		
		co.getContactFormSubmit().click();
		
		boolean alertMessage = co.getContactFormAlert().isDisplayed();
		
		if(alertMessage) {
			String successAlertMessage = co.getContactFormAlert().getText().replace("\n", "").replace("\r","").trim();
			if(successAlertMessage.contains("Your feedback sent successfully!")) {
				Assert.assertTrue(true);
			}
		}	
	}
	
	
	@Test(dataProvider="getIncorrectData")
	public void CoolOerPageContactFormValidationWithInCorrectRecords(String firstname, String lastname, String email, String phone, String message) {
	
		driver.navigate().refresh();
		
		CoolOer co = new CoolOer(driver);
		
		co.getContactFormFirstNameField().sendKeys(firstname);
		log.info("invalid first name is entered into field");
		
		co.getContactFormLastNameField().sendKeys(lastname);
		log.info("invalid last name is entered into field");
		
		co.getContactFormEmailField().sendKeys(email);
		log.info("invalid email is entered into field");
		
		co.getContactFormPhoneField().sendKeys(phone);
		log.info("invalid phone is entered into field");
		
		co.getContactFormMessageField().sendKeys(message);
		log.info("invalid message is entered into field");
		
		co.getContactFormSubmit().click();
		
		boolean alertMessage = co.getContactFormAlert().isDisplayed();
	 
		if(alertMessage) {
			String invalidAlertMessage = co.getContactFormAlert().getText().replace("\n", "").replace("\r","").trim();
			if(invalidAlertMessage.contains("xYour feedback sent successfully!")) {
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertFalse(true);
			}
		}		
	}
	
	
	
	@DataProvider
	public Object[][] getCorrectData(){
	
		Object[][] data = new Object[1][5];
		
		data[0][0]="Viraj";
		data[0][1]= "Utekar";
		data[0][2]="utekar26viraj@gmail.com";
		data[0][3]="9292929292";
		data[0][4]="correct";
		
		return data;
	}
	
	@DataProvider
	public Object[][] getIncorrectData(){
		
		Object[][]data = new Object[1][5];
		
		data[0][0]="Viraj";
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
