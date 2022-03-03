package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage {

	public WebDriver driver;
	private By advertisementBannerCloseIcon = By.cssSelector("div#Modal > div > div > div:nth-Child(1) > button");
	private By aboutfooterLink = By.cssSelector("footer.mainfooter > div > div > div:nth-Child(1) > div:nth-Child(4) > ul > li:nth-Child(1) > a");
    private By aboutPageHeading = By.cssSelector("div.py-5 > div > section > div:nth-Child(1) > div > div > div:nth-Child(2) > div > h5");
	private By creditfooterLink = By.cssSelector("footer.mainfooter > div > div > div:nth-Child(1) > div:nth-Child(4) > ul > li:nth-Child(2) > a");
	private By creaditPageHeading = By.cssSelector("div.container > h1");
	private By termsOfServiceFooterLink = By.cssSelector("footer.mainfooter > div > div > div:nth-Child(1) > div:nth-Child(4) > ul > li:nth-Child(3) > a");
	private By termsOfServicePageHeading = By.cssSelector("div.container > h1");
	private By privacyPolicyFooterLink = By.cssSelector("footer.mainfooter > div > div > div:nth-Child(1) > div:nth-Child(4) > ul > li:nth-Child(4) > a");
	private By privacyPolicyPageHeading = By.cssSelector("div.container > div > h1");
	private By contactUsFooterLink = By.cssSelector("footer.mainfooter > div > div > div:nth-Child(1) > div:nth-Child(4) > ul > li:nth-Child(5) > a");
    private By contactUsPageHeading = By.cssSelector("div.container > h1");
	private By githubFooterLink = By.cssSelector("footer.mainfooter > div > div > div:nth-Child(1) > div:nth-Child(4) > ul > li:nth-Child(6) > a");
	
	
	public FooterPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;		
	}
	
	public WebElement getAdvertisementCloseIcon() {
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(advertisementBannerCloseIcon));
		return driver.findElement(advertisementBannerCloseIcon);
	}

	public WebElement getAboutFooterLink() {
		return driver.findElement(aboutfooterLink);
	}
	
	public WebElement getAboutPageHeading() {
		return driver.findElement(aboutPageHeading);
	}
	
	public WebElement getCreditFooterLink() {
		return driver.findElement(creditfooterLink);
	}
	
	public WebElement getCreditPageHeading() {
		WebDriverWait w =  new WebDriverWait(driver,10);
		w.until(ExpectedConditions.presenceOfElementLocated(creaditPageHeading));
		return driver.findElement(creaditPageHeading);
	}
	
	public WebElement getTermsOfServiceFooterLink() {
		return driver.findElement(termsOfServiceFooterLink);
	}
	
	public WebElement getTermsOfServicePageHeading() {
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.presenceOfElementLocated(termsOfServicePageHeading));
		return driver.findElement(termsOfServicePageHeading);
	}
	
	public WebElement getPrivacyPolicyFooterLink() {
		return driver.findElement(privacyPolicyFooterLink);
	}
	
	public WebElement getPrivacyPolicyPageHeading() {
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.presenceOfElementLocated(privacyPolicyPageHeading));
		return driver.findElement(privacyPolicyPageHeading);
	}
	
	public WebElement getContactUsFooterLink() {
		return driver.findElement(contactUsFooterLink);
	}
	
	public WebElement getContactUsPageHeading() {
		WebDriverWait w = new WebDriverWait(driver,20);
		w.until(ExpectedConditions.presenceOfElementLocated(contactUsPageHeading));
		return driver.findElement(contactUsPageHeading);
	}
	
	public WebElement getGitHubFooterLink() {
		return driver.findElement(githubFooterLink);
	}
	
}
