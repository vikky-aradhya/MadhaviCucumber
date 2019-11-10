package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {
	
	@After
	public void afterScenario(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshootName = scenario.getName().replace(" ", "_");
			try {
				File sourePath = ((TakesScreenshot)BasePage.driver).getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir")+"/target/cucumber-reports/screenshots/"+screenshootName+System.currentTimeMillis()+".png");
				
				Files.copy(sourePath, destinationPath);
				
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
				
			} catch(IOException e) {
				
			}
		}
	}

}
