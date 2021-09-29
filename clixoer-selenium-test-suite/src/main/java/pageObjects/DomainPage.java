package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DomainPage {

	public WebDriver driver;
	
	private By advertisementBannerCloseIcon = By.cssSelector("div#Modal > div > div > div:nth-Child(1) > button > span");
	
	private By domainNavigationOption = By.cssSelector("nav#navbar > div > ul > li:nth-Child(4) > a");
	
	private By englishOption = By.cssSelector("nav#navbar > div > ul > li:nth-Child(4) > div > a:nth-Child(1)");
	
	private By englishModulesCount = By.cssSelector("div.container-fluid > div > div > div > div#dogs > div:nth-Child(3) > main > div > div > div > div > div:nth-Child(2)");
	
	private By englishModulesTitle = By.cssSelector("div.container-fluid > div > div > div > div#dogs > div:nth-Child(3) > main > div > div > div > div > div:nth-Child(2) > div:nth-Child(3) > div > div:nth-Child(1)");
	
	private By englishDomainPageLinks = By.xpath("//a");
	
	private By mathOption = By.cssSelector("nav#navbar > div > ul > li:nth-Child(4) > div > a:nth-Child(2)");
	
	private By mathModulesCount = By.cssSelector("div.container-fluid > div > div > div > div#dogs > div:nth-Child(3) > main > div > div > div > div > div:nth-Child(2)");
	
	private By mathDomainPageLinks = By.xpath("//a");
	
	private By mathModulesTitle = By.cssSelector("div.container-fluid > div > div > div > div#dogs > div:nth-Child(3) > main > div > div > div > div > div:nth-Child(2) > div:nth-Child(3) > div > div:nth-Child(1)");
	
	private By scienceOption = By.cssSelector("nav#navbar > div > ul > li:nth-Child(4) > div > a:nth-Child(3)");
	
	private By scienceModulesCount = By.cssSelector("div.container-fluid > div > div > div > div#dogs > div:nth-Child(3) > main > div > div > div > div > div:nth-Child(2)");
	
	private By scienceDomainPageLinks = By.xpath("//a");
	
	private By scienceModulesTitle = By.cssSelector("div.container-fluid > div > div > div > div#dogs > div:nth-Child(3) > main > div > div > div > div > div:nth-Child(2) > div:nth-Child(3) > div > div:nth-Child(1)");
	
	private By availablePaginationOptions = By.cssSelector("div.hello > div > div > div > div > nav > ul > li > a");
	
	
	public DomainPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
      this.driver = driver;
	}

	public WebElement getAdvertisementBannerCloseIcon(){
		return driver.findElement(advertisementBannerCloseIcon);
	}
	
	public WebElement getDomainNavigationMenu() {
		return driver.findElement(domainNavigationOption);
	}
	
	public WebElement getEnglishOption() {
		return driver.findElement(englishOption);
	}
	
	public List<WebElement> getNumberOfEnglishModule(){
		return driver.findElements(englishModulesCount);
	}
	
	public List<WebElement> getEnglishModuleTitle(){
		return driver.findElements(englishModulesTitle);
	}
	
	public List<WebElement> getEnglishDomainPageLinks(){
		return driver.findElements(englishDomainPageLinks);
	}
	
	public WebElement getMathOption() {
		return driver.findElement(mathOption);
	}
	
	public WebElement getScienceOption() {
		return driver.findElement(scienceOption);
	}
	
	public List<WebElement> getNumberOfMathModule(){
		return driver.findElements(mathModulesCount);
	}
	
	public List<WebElement> getMathDomainPageLinks(){
		return driver.findElements(mathDomainPageLinks);
	}
	
	public List<WebElement> getMathModulesTitle(){
		return driver.findElements(mathModulesTitle);
	}
	
	public List<WebElement> getNumberOfScienceModule(){
		return driver.findElements(scienceModulesCount);
	}
	
	public List<WebElement> getNumberOfScienceDomainPageLinks(){
		return driver.findElements(scienceDomainPageLinks);
	}
	
	public List<WebElement> getScienceModulesTitle(){
		return driver.findElements(scienceModulesTitle);
	}
	
	public List<WebElement> getPaginationOptions(){
		return driver.findElements(availablePaginationOptions);
	}
	
	
}
