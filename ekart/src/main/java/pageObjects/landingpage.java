package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingpage {
	WebDriver driver;
	public landingpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//*[@title='My Account']")
			WebElement myacc;
	@FindBy(xpath="//*[text()='Login']")
			WebElement loginbtn;
	public WebElement myacc() {
		return myacc;
	}
	
	public WebElement loginbtn() {
		return loginbtn;
	}
	
}
