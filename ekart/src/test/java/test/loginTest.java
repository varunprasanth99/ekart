package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.landingpage;
import pageObjects.loginPage;
import resources.base;

public class loginTest extends base{
	@Test
	public void login() throws IOException, InterruptedException {
		WebDriver driver = initializeBrowser();
		
		driver.get(prop.getProperty("url"));
		landingpage lp = new landingpage(driver);
		lp.myacc().click();
		lp.loginbtn().click();
		loginPage login = new loginPage(driver);
		//login.login("test@abc.com", "test@123");
		login.login("test@abc.com", "test@12");
	
		Assert.assertEquals(driver.getTitle(), "My Account");
		
	}
}
