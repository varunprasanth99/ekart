package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.base;
import utilities.extentReporter;

public class Listeners extends base implements ITestListener {
	
	ExtentReports extent = extentReporter.getExtentReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getName());
		 thread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//thread.log(Status.PASS, result.getName());
		thread.get().log(Status.PASS, result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// WebDriver driver = null;
		
		thread.get().fail(result.getThrowable());
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
    	String path = null;
		try {
			path= getScreenShot(result.getName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.get().addScreenCaptureFromPath(path, result.getName());

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
