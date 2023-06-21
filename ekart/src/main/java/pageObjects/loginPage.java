package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="email")
	WebElement uname;
	@FindBy(name="password")
	WebElement pwd;
	@FindBy(xpath="//*[@value=\"Login\"]")
	WebElement loginbtn;
	
	public void login(String name,String pass) {
		uname.sendKeys(name);
		pwd.sendKeys(pass);
		loginbtn.click();
		
		
	}

}
