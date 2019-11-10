package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import genericFunction.Property;

public class RegisterPage extends BasePage {
	
	public Property regmap = new Property(System.getProperty("user.dir")+"\\src\\main\\java\\ObjectMapping\\register.properties");
	
	@And("^verify the Register Page title$")
	public void verify_the_register_page_title() throws Throwable { 
		String expected = "Register: Mercury Tours";
		Assert.assertEquals(driver.getTitle(), expected);
		
	}
	
	@Then("^user clicks on Register button$")
	public void user_clicks_on_Register_button() throws Throwable {
		clickElement("registerbtn", regmap);
	}
	
	@And("^user enters Contact Information$")
	public void user_enters_Contact_Information() throws Throwable {
		sendKeys("firstnametxt", regmap, testdataMap.get("FirstName"));
		sendKeys("lastnametxt", regmap, testdataMap.get("LastName"));
		sendKeys("phonetxt", regmap, testdataMap.get("Phone"));
		sendKeys("emailtxt", regmap, testdataMap.get("Email"));
	}

	@And("^user enters Mailing Information$")
	public void user_enters_Mailing_Information() throws Throwable {
		sendKeys("addresstxt", regmap, testdataMap.get("Address"));
		sendKeys("citytxt", regmap, testdataMap.get("City"));
		sendKeys("statetxt", regmap, testdataMap.get("State"));
		sendKeys("postalcodetxt", regmap, testdataMap.get("Postal_Code"));
		selectByText("countrytxt", regmap, testdataMap.get("Country"));
	}

	@And("^user enters User Information$")
	public void user_enters_User_Information() throws Throwable {
		sendKeys("usernametxt", regmap, testdataMap.get("Username"));
		sendKeys("passwordtxt", regmap, testdataMap.get("Password"));
		sendKeys("confpasswordtxt", regmap, testdataMap.get("Password"));
	}

	@Then("^user clicks on submit$")
	public void user_clicks_on_submit() throws Throwable {
		clickElement("submitbtn", regmap);
	}

}
