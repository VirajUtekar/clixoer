package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	 
	public WebDriver driver;
	//constructor to define driver
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	// Nav Bar Page Objects
	private By englishlanguage = By.xpath("//*[@id=\"dropdownMenuLink\"]");
	private By hindilanguage = By.xpath("/html/body/nav[1]/div/ul/div/div/li[2]/form/input[4]");
	private By telegulanguage = By.xpath("/html/body/nav[1]/div/ul/div/div/li[3]/form/input[4]");
	private By englishcheckbox = By.xpath("//*[@id=\"English\"]");
	private By mathscheckbox = By.xpath("//*[@id=\"Mathematics\"]");
	private By sciencecheckbox = By.xpath("//*[@id=\"Science\"]");
	private By i2ccheckbox = By.xpath("//*[@id=\"digital\"]");
	private By elibrary =By.cssSelector("a[href*='e-library']");
	private By tisscool =By.cssSelector("a[href*='cool']");
	private By cooloer =By.cssSelector("a[href*='oer']");
	private By domain =By.id("dropdown04");
	private By about =By.cssSelector("a[href*='about']");
	private By help =By.cssSelector("a[href*='help']");
	private By language =By.id("dropdownMenuLink");
	private By eb1 =By.xpath("//*[@id=\"jar\"]/div/div[1]/div/div[2]/div/div[1]");
	private By eb2 = By.xpath("//*[@id=\"jar\"]/div/div[2]/div/div[2]/div/div[1]");
	private By links =By.tagName("a");
	private By gr1 = By.xpath("//*[@id=\"jar\"]/div/div[1]/div/div[2]/div/div[1]");
	private By gr2 = By.xpath("//*[@id=\"jar\"]/div/div[2]/div/div[2]/div/div[1]");
	private By pr = By.xpath("//*[@id=\"jar\"]/div/div[3]/div/div[2]/div/div[1]");
	private By le = By.xpath("//*[@id=\"jar\"]/div/div[4]/div/div[2]/div/div[1]");
	private By as = By.xpath("//*[@id=\"jar\"]/div/div[1]/div/div[2]/div/div[1]");
	private By ba = By.xpath("//*[@id=\"jar\"]/div/div[2]/div/div[2]/div/div[1]");
	private By es = By.xpath("//*[@id=\"jar\"]/div/div[3]/div/div[2]/div/div[1]");
	private By hd = By.xpath("//*[@id=\"jar\"]/div/div[4]/div/div[2]/div/div[1]");
	private By sd = By.xpath("//*[@id=\"jar\"]/div/div[5]/div/div[2]/div/div[1]");
	private By um = By.xpath("//*[@id=\"jar\"]/div/div[6]/div/div[2]/div/div[1]");

	 // END of Nav Bar Page Objects
	 
	public WebElement getEnglishLanguage()
	 {
		 return driver.findElement(englishlanguage);
		 
	 }
	public WebElement getHindiLanguage()
	 {
		 return driver.findElement(hindilanguage);
		 
	 }
	public WebElement getTeleguLanguage()
	 {
		 return driver.findElement(telegulanguage);
		 
	 }
	 
	 
	
	
	public WebElement getElibrary()
	 {
		 return driver.findElement(elibrary);
		 
	 }
	 public WebElement getTisscool()
	 {
		 return driver.findElement(tisscool);
	 }
	 public WebElement getCooloer()
	 {
		 return driver.findElement(cooloer);
	 }
	 public WebElement getDomain()
	 {
		 return driver.findElement(domain);
	 }
	 public WebElement getAbout()
	 {
		 return driver.findElement(about);
	 }
	 public WebElement getHelp()
	 {
		 return driver.findElement(help);
	 }
	 public WebElement getLanguage()
	 {
		 return driver.findElement(language);
	 }
	 public WebElement getEb1()
	 {
		 return driver.findElement(eb1);
		 
	 }
	 public WebElement getEb2()
	 {
		 return driver.findElement(eb2);
		 
	 }
	 @SuppressWarnings("unchecked")
	public List<WebElement> getLinks()
	 {
		 return (List<WebElement>) driver.findElement(links);
		 
	 }
	 public WebElement getEnglishcheckbox()
	 {
		 return driver.findElement(englishcheckbox);
		 
	 }
	 public WebElement getMathscheckbox()
	 {
		 return driver.findElement(mathscheckbox);
		 
	 }
	 public WebElement getSciencecheckbox()
	 {
		 return driver.findElement(sciencecheckbox);
		 
	 }
	 public WebElement geti2ccheckbox()
	 {
		 return driver.findElement(i2ccheckbox);
		 
	 }
	 
	
	 public WebElement getGr1()
	 {
		 return driver.findElement(gr1);
	 }
	 public WebElement getGr2()
	 {
		 return driver.findElement(gr2);
	 }
	 public WebElement getPr()
	 {
		 return driver.findElement(pr);
	 }
	 public WebElement getLe()
	 {
		 return driver.findElement(le);
	 }
	 
	 public WebElement getAs()
	 {
		 return driver.findElement(as);
	 }
	 public WebElement getBa()
	 {
		 return driver.findElement(ba);
	 }
	 public WebElement getEs()
	 {
		 return driver.findElement(es);
	 }
	 public WebElement getHd()
	 {
		 return driver.findElement(hd);
	 }
	 public WebElement getSd()
	 {
		 return driver.findElement(sd);
	 }
	 public WebElement getUm()
	 {
		 return driver.findElement(um);
	 }
	
	 
	 
}
