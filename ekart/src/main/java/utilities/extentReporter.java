package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporter {
	static ExtentReports extent;
	public static ExtentReports getExtentReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\extentreport.html");
		reporter.config().setReportName("results");
		reporter.config().setDocumentTitle("test results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tested by", "varun");
		return extent;
		
				}
}
