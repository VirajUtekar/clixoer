package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelpPage {


	public WebDriver driver;
	//constructor to define driver
	public HelpPage(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
}
	private By validatehelp = By.xpath("//*[@id=\"home\"]/div/h1");
	private By mathshelp = By.xpath("/html/body/div[3]/ul/li[2]/a");
	private By sciencehelp = By.xpath("/html/body/div[3]/ul/li[3]/a");
	private By englishhelp = By.xpath("/html/body/div[3]/ul/li[1]/a");
	
	
	public WebElement getHelpPageValidation()
	{
		return driver.findElement(validatehelp);
		
	}
	public WebElement getEnglishHelp()
	 {
		 return driver.findElement(englishhelp);
	 }

	 public WebElement getMathsHelp()
	 {
		 return driver.findElement(mathshelp);
	 }

	 public WebElement getScienceHelp()
	 {
		 return driver.findElement(sciencehelp);
	 }

}
