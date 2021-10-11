package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoolOer {
	
	public WebDriver driver;

	private By advertisementBannerCloseIcon = By.cssSelector("div#Modal > div > div > div:nth-Child(1) > button > span");

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
	
	
	public CoolOer(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
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
}
