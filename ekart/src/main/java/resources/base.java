package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	@BeforeMethod
	public WebDriver initializeBrowser() throws IOException, InterruptedException {
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--disable-notifications");
		driver = new EdgeDriver(option);
		String s= System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		System.out.println(s);
		prop = new Properties();
		FileInputStream fis = new FileInputStream(s);
		prop.load(fis);
		//prop.get
		driver.manage().window().maximize();
		Thread.sleep(5000);
		return driver;
	}
	
	public String getScreenShot(String testcase, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File tgt=new File(System.getProperty("user.dir")+testcase+".png");
		Files.copy(src, tgt);
		return System.getProperty("user.dir")+testcase+".png";
	}
}
