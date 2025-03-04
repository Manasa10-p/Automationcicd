package Seleniumlearning.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReporterObject() {
		
		String path=System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter Reporter=new ExtentSparkReporter(path);
		Reporter.config().setReportName("Web Automation Results");
		Reporter.config().setDocumentTitle("Test Results");
		
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(Reporter);
		extent.setSystemInfo("tester", "Manasa");
		return extent;
	}

}
