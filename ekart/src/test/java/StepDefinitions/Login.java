package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.landingpage;
import pageObjects.loginPage;
import resources.base;

public class Login extends base {
	WebDriver driver;
	landingpage lp;
	loginPage login;
	@Given("Open any browser")
	public void open_any_browser() throws IOException, InterruptedException {
		 driver = initializeBrowser();
		 driver.get(prop.getProperty("url"));
			lp = new landingpage(driver);
			lp.myacc().click();
			lp.loginbtn().click();
	}

	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String uid, String pwd) {
		login = new loginPage(driver);
		login.login(uid, pwd);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	   	}

	@Then("User is able to login successfully")
	public void user_is_able_to_login_successfully() {
		Assert.assertEquals(driver.getTitle(), "My Account");
	}



}
