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
		
		driver.get(prop.getProperty("cooloer"));
		log.info("site url is been navigated");
		
		driver.manage().window().maximize();
		log.info("browser window is been maximized");
	}
	
	
	@Test(dataProvider="contactForm")
	public void CoolOerPageContactFormValidation(String firstname, String lastname, String email, String phone, String message) {
	
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
			if(invalidAlertMessage.contains("Your feedback sent successfully!")) {
				Assert.assertTrue(true);
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
		data[0][2]="utekar26viraj@gmail.com";
		data[0][3]="9292929292";
		data[0][4]="correct";
        data[1][0]="Viraj";
        data[1][1]="Utekar";
        data[1][2]="viraj200";
        data[1][3]="9292929292";
        data[1][4]="Incorrect data";
		return data;
	}
	
	@AfterTest
	public void terminate() {
		driver.quit();
		log.info("browser driver is been quit");
	}
	
	
}
