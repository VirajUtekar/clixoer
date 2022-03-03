package pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoolOer {
	
	public WebDriver driver;

	private By advertisementBannerCloseIcon = By.cssSelector("div#Modal > div > div > div:nth-Child(1) > button");

	private By coolOerMenuOption = By.cssSelector("nav#navbar > div > ul > li:nth-Child(3) > a");
	
	private By englishCheckBoxLanguageSupport = By.cssSelector("div#ci > div:nth-Child(1) > nav > ul > li:nth-Child(6) > div:nth-Child(2) > div:nth-Child(1) > label > div");
	
	private By hindiCheckBoxLanguageSupport = By.cssSelector("div#ci > div:nth-Child(1) > nav > ul > li:nth-Child(6) > div:nth-Child(2) > div:nth-Child(2) > label > div");
	
	private By resourcesCountUnderKnowledgeDeepning2 = By.cssSelector("div#ci > div:nth-Child(3) > div > div:nth-Child(2) > div > div > div > div > a > h6");
	
	private By resourcesCountUnderCreativityAnd21stCenturySkills = By.cssSelector("div#ci > div:nth-Child(3) > div > div:nth-Child(3) > div > div > div > div > a > h6");
	
	private By resourcesCountUnderTinkeringAndMaking = By.cssSelector("div#ci > div:nth-Child(3) > div > div:nth-Child(4) > div > div > div > div > a > h6");
	
	private By numberOfLinkOnPage = By.xpath("//a");
	
	private By marathiCheckBoxLanguageSupport = By.cssSelector("div#ci > div:nth-Child(1) > nav > ul > li:nth-Child(6) > div:nth-Child(2) > div:nth-Child(3) > label > div");
	
	private By teluguCheckBoxLanguageSupport = By.cssSelector("div#ci > div:nth-Child(1) > nav > ul > li:nth-Child(6) > div:nth-Child(2) > div:nth-Child(4) > label > div");
	
	private By tamilCheckBoxLanguageSupport = By.cssSelector("div#ci > div:nth-Child(1) > nav > ul > li:nth-Child(6) > div:nth-Child(2) > div:nth-Child(5) > label > div");
	
	private By punjabiCheckBoxLanguageSupport = By.cssSelector("div#ci > div:nth-Child(1) > nav > ul > li:nth-Child(6) > div:nth-Child(2) > div:nth-Child(6) > label > div");
	
	private By contactFormFirstNameField = By.cssSelector("div.container-contact100 > div > form > div:nth-Child(3) > input");
	
	private By contactFormLastNameField = By.cssSelector("div.container-contact100 > div > form > div:nth-Child(4) > input");
	
	private By contactFormEmailField = By.cssSelector("div.container-contact100 > div > form > div:nth-Child(6) > input");
	
	private By contactFormPhoneField = By.cssSelector("div.container-contact100 > div > form > div:nth-Child(7) > input");
	
	private By contactFormMessageField = By.cssSelector("div.container-contact100 > div > form > div:nth-Child(9) > textarea");
	
	private By contactFormSubmitButton = By.cssSelector("div.container-contact100 > div > form > div:nth-Child(10) > input");
	
	private By alertDisplay = By.cssSelector("div.alert-success");
	
	private By multipleSubjectCheckboxDomainSubject = By.cssSelector("div#domain1 > div:nth-Child(1)  > label > div");
	
	private By artCheckboxDomainSubject = By.cssSelector("div#domain1 > div:nth-Child(2)  > label > div");
	
	private By scienceCheckboxDomainSubject = By.cssSelector("div#domain1 > div:nth-Child(3)  > label > div");
	
	private By languageCheckboxDomainSubject = By.cssSelector("div#domain1 > div:nth-Child(4)  > label > div");
	
	private By mathematicsCheckboxDomainSubject = By.cssSelector("div#domain1 > div:nth-Child(5)  > label > div");
	
	
	public CoolOer(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getCoolOerMenuOption() {
		return driver.findElement(coolOerMenuOption);
	}

	public WebElement getadvertisementBanner() {
		return driver.findElement(advertisementBannerCloseIcon);
	}
	
	public WebElement getEnglishCheckBoxLanguageSupport() {
		return driver.findElement(englishCheckBoxLanguageSupport);
	}
	
	public List<WebElement> getResourceListUnderKnowledgeDeepning2(){
		return driver.findElements(resourcesCountUnderKnowledgeDeepning2);
	}
	
	public List<WebElement> getResourceListUnderCreativityAnd21stCenturySkills(){
		return driver.findElements(resourcesCountUnderCreativityAnd21stCenturySkills);
	}
	
	public List<WebElement> getResourcesListUnderTinkeringAndMaking(){
		return driver.findElements(resourcesCountUnderTinkeringAndMaking);
	}
	
	public List<WebElement> getNumberOfLinksOnPage() {
		return driver.findElements(numberOfLinkOnPage);
	}
	
	public WebElement getHindiCheckBoxLanguageSupport() {
		return driver.findElement(hindiCheckBoxLanguageSupport);
	}
	
	public WebElement getMarathiCheckBoxLanguageSupport() {
		return driver.findElement(marathiCheckBoxLanguageSupport);
	}
	
	public WebElement getTeluguCheckBoxLanguageSupport() {
		return driver.findElement(teluguCheckBoxLanguageSupport);
	}
	
	public WebElement getTamilCheckBoxLanguageSupport() {
		return driver.findElement(tamilCheckBoxLanguageSupport);
	}
	
	public WebElement getPunjabiCheckBoxLanguageSupport() {
		return driver.findElement(punjabiCheckBoxLanguageSupport);
	}
	
	public WebElement getContactFormFirstNameField() {
	    return driver.findElement(contactFormFirstNameField);
	}
	
	public WebElement getContactFormLastNameField() {
		return driver.findElement(contactFormLastNameField);
	}
	
	public WebElement getContactFormEmailField() {
		return driver.findElement(contactFormEmailField);
	}
	
	public WebElement getContactFormPhoneField() {
		return driver.findElement(contactFormPhoneField);
	}
	
	public WebElement getContactFormMessageField() {
		return driver.findElement(contactFormMessageField);
	}
	
	public WebElement getContactFormSubmit() {
		return driver.findElement(contactFormSubmitButton);
	}
	
	
	public WebElement getContactFormAlert() {
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.presenceOfElementLocated(alertDisplay));
		return driver.findElement(alertDisplay);
	}
	
	public WebElement getSubjectDomainMultipleSubjectsfilter() {
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.presenceOfElementLocated(multipleSubjectCheckboxDomainSubject));
		return driver.findElement(multipleSubjectCheckboxDomainSubject);
	}
	
	public WebElement getArtMultipleSubjectsFilter() {
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.presenceOfElementLocated(artCheckboxDomainSubject));
		return driver.findElement(artCheckboxDomainSubject);		
	}
	
	public WebElement getScienceSubjectFilter() {
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.presenceOfElementLocated(scienceCheckboxDomainSubject));
		return driver.findElement(scienceCheckboxDomainSubject);
	}
	
	public WebElement getLanguageSubjectFilter() {
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.presenceOfElementLocated(languageCheckboxDomainSubject));
		return driver.findElement(languageCheckboxDomainSubject);
	}
	
   public WebElement getMathematicsSubjectFilter() {
	   WebDriverWait w = new WebDriverWait(driver,10);
	   w.until(ExpectedConditions.presenceOfElementLocated(mathematicsCheckboxDomainSubject));
	   return driver.findElement(mathematicsCheckboxDomainSubject);
   }	
}
