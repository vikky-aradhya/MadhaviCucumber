package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class webtablepage extends BasePage {
	
	@When("^user enters the company$")
	public void user_give_company_name() {
		String currentPrice;
		List<WebElement> table = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		for(int i=1; i<table.size();i++) {
			WebElement companyName =driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+ i + "]/td/a"));
			if (companyName.getText().equalsIgnoreCase(testdataMap.get("companyname"))) {
				currentPrice = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+ i + "]/td[4]")).getText();
				System.out.println(currentPrice);
				break;
			}
		}
	}
	
	@And("^user enters the group$")
	public void user_gives_group_name() {
		String companyName;
		List<WebElement> table = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		for(int i=1; i<table.size();i++) {
			WebElement groupNames =driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+ i + "]/td[2]"));
			if(groupNames.getText().equalsIgnoreCase(testdataMap.get("groupname"))) {
				companyName = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+ i + "]/td/a")).getText();
				System.out.println(companyName);
			}
		}
	}
	
}
