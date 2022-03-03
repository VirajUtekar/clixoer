package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;

	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		String file = System.getProperty("user.dir") + "/src/main/java/resources/data.properties";
		
		FileInputStream fis = new FileInputStream(file);
		
	    prop = new Properties();
		
		prop.load(fis);
		
		//String browserName = System.getProperty("browser");
		
		String browserName = prop.getProperty("browser");
		
		System.out.println(browserName);

		if (browserName.contains("chrome")) {

			// execute in chrome
			
			String ch = System.getProperty("user.dir") + "/src/main/java/resources/chromedriver";
			
			System.setProperty("webdriver.chrome.driver",ch);

			if (browserName.contains("chromeheadless")) {

				ChromeOptions options = new ChromeOptions();

				options.addArguments("headless");

				driver = new ChromeDriver(options);

			}

			else {

			 driver = new ChromeDriver();

			}

		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.out.println("Tests to run in Firefox Browser");
			// System Property for FirefoxDriver
			System.setProperty("webdriver.gecko.driver",
					(System.getProperty("user.dir") + "/src/main/java/resources/geckodriver"));

			// Instantiate a FirefoxDriver class.
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("IE")) {
			System.out.println("Tesst to run in Internet Explorers");
			// System Property for IEDriver
			System.setProperty("webdriver.ie.driver",
					(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\IEdriverServer.exe"));

			// Instantiate a IEDriver class.
			driver = new InternetExplorerDriver();
		}

		else

		{
			System.out.println("Define browser correctly");
		}

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		return driver;
	}

	public static void main(String[] args) throws IOException {
		/*
		 * base b = new base(); b.initializeDriver();
		 */
		// TODO Auto-generated method stub

	}

	public String TakeScreenshot(String testname, WebDriver driver) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File Source = ss.getScreenshotAs(OutputType.FILE);
		String Destination = System.getProperty("user.dir") + "\\reports\\" + testname + ".png";
		FileUtils.copyFile(Source, new File(Destination));
		return Destination;
	}
}
