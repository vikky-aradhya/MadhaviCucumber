package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import genericFunction.Property;

public class LoginScenario extends BasePage {
	
	public Property loginmap = new Property(System.getProperty("user.dir")+"\\src\\main\\java\\ObjectMapping\\Login.properties");
	
	@And("^user enters the username as \"([^\"]*)\"$")
	public void user_enters_the_username_as(String name) throws Throwable { 
		sendKeys("usernametxt", loginmap, name);
		Thread.sleep(3000);
	}
	
	@And("^user enters the password as \"([^\"]*)\"$")
	public void user_enters_the_password_as(String pwd) throws Throwable { 
		sendKeys("passwordtxt", loginmap, pwd);
		Thread.sleep(3000);
	}


}
