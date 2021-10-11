package cucumberOptions;

import io.cucumber.testng.CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="src/test/java/features",
		glue="stepDefination",
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome=true
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
