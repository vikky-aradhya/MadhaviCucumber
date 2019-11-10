package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.listener.Reporter;

import genericFunction.GenericFunction;
import genericFunction.Property;

public class BasePage {
	public static LinkedHashMap<String, String> testdataMap;
	public static String scenarioName;
	public static String description;
	public static int rownum=1;
	public static WebDriver driver;
	
	GenericFunction gf = new GenericFunction();
	
	public static void openBrowser() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void navigateToUrl() throws Exception {
		FileInputStream in = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ObjectMapping\\config.properties");
		Properties config = new Properties();
		config.load(in);
		driver.get(config.getProperty("calenderUrl"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void clickElement(String element, Property locator) throws Exception {
		Thread.sleep(1000);
		
		try {
			driver.findElement(locator.getLocator(element)).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void sendKeys(String element, Property locator, String value) throws Exception {
		Thread.sleep(1000);
		
		try {
			driver.findElement(locator.getLocator(element)).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectByText(String element, Property locator, String value) throws Exception {
		Thread.sleep(3000);
		
		Select select = new Select(driver.findElement(locator.getLocator(element)));
		try {
			select.selectByVisibleText(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectByValue(String element, Property locator, String value) throws Exception {
		Thread.sleep(3000);
		
		Select select = new Select(driver.findElement(locator.getLocator(element)));
		try {
			select.selectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectByIndex(String element, Property locator, int value) throws Exception {
		Thread.sleep(3000);
		
		Select select = new Select(driver.findElement(locator.getLocator(element)));
		try {
			select.selectByIndex(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void acceptAlert() throws Exception {
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert() throws Exception {
		Thread.sleep(2000);
		
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToFrame(String frameID) throws Exception {
		Thread.sleep(2000);
		
		try {
			driver.switchTo().frame(frameID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dragAndDrop(String source, String destination, Property locator) throws Exception{
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		WebElement sourceValue = driver.findElement(locator.getLocator(source));
		WebElement target = driver.findElement(locator.getLocator(destination));
		try {
			action.dragAndDrop(sourceValue, target).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mouseHover(String element, Property locator) throws Exception {
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		try {
			action.moveToElement(driver.findElement(locator.getLocator(element))).build().perform();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void uploadFile(String location) throws Exception {
		Thread.sleep(3000);
		
		try {
			Runtime.getRuntime().exec(location);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String getText(String element, Property locator) throws Exception {
		Thread.sleep(3000);
		
		String text = null;
		try {
			text = driver.findElement(locator.getLocator(element)).getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return text;
	}
	
	public void readexceldata(String ScenarioName, String SheetName) throws Exception {
		testdataMap = gf.getTestDataListByScenario(System.getProperty("user.dir")+"\\src\\test\\resources\\supporting_files", "TestData_V2", SheetName, ScenarioName).get(rownum-1);
		System.out.println(testdataMap);
		System.out.println(testdataMap.get("Username"));
		System.out.println(testdataMap.get("Scenario"));
		scenarioName = testdataMap.get("Scenario");
		description = testdataMap.get("Description");
	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//screenshots//" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}
	
	
	
	public void closeBrowser() {
		driver.quit();
	}
	
	
}
