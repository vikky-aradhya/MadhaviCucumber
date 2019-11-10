package runner;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import stepDefinitions.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"},
		format = {"pretty","html:target/cucumber"},
		features = {"src/test/resources/features"},
		glue = {"stepDefinitions/"},
		tags = {"@calender"},
		monochrome = true,
		dryRun = false
		)

public class TestRunner extends BasePage {
	
	/*@AfterClass
	public static void tearDown() {
		driver.quit();
	}*/
	
	@AfterClass
	public static void tearDown() {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows 10 " + "64-bit");
        Reporter.setTestRunnerOutput("Mercury Tours Report");
        Reporter.assignAuthor(System.getProperty("user.name"));
        BasePage.driver.quit();
        
        try {
			File sourcePath = new File(System.getProperty("user.dir") + "/target/html/ExtentReport.html");
			File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/reports/ExtentReport_"+System.currentTimeMillis()+".html");
			
			Files.copy(sourcePath, destinationPath);   
		} catch (IOException e) {
		}
	}
	
}