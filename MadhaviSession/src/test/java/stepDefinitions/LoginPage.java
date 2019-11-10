package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import genericFunction.Property;

public class LoginPage extends BasePage {
	
	public Property loginmap = new Property(System.getProperty("user.dir")+"\\src\\main\\java\\ObjectMapping\\Login.properties");
	
	@When("^User opens browser$")
	public void user_opens_browser() throws Throwable {
		try {
			openBrowser();
			navigateToUrl();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Given("^test data is read from excel \"([^\"]*)\" and \"([^\"]*)\"$")
	public void test_data_is_read_from_excel_and(String scenarioName, String sheetName) throws Throwable { 

		System.out.println(scenarioName);
		System.out.println(sheetName);
		readexceldata(scenarioName, sheetName);
		Thread.sleep(3000);
	}
	
	@And("^user clicks on Home Link$")
	public void user_clicks_on_home_link() throws Throwable {
		clickElement("Homelink", loginmap);
	}
	
	@And("^user enters the username$")
	public void user_enters_the_username() throws Throwable { 
		sendKeys("usernametxt", loginmap, testdataMap.get("Username"));
	}

	@And("^user enters the password$")
	public void user_enters_the_password() throws Throwable { 
		sendKeys("passwordtxt", loginmap, testdataMap.get("Password"));
	}
	
	@And("^user clicks on signin button$")
	public void user_clicks_on_Login() throws Throwable { 
		clickElement("signin", loginmap);
		
	}
	
	@And("^verify the Home Page title$")
	public void verify_the_home_page_title() throws Throwable { 
		String expected = "Find a Flight: Mercury Tours: ";
		Assert.assertEquals(driver.getTitle(), expected);
		
	}

}
