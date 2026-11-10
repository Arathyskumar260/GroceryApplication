package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Report_Utility {
	public static final ExtentReports extentReports = new ExtentReports();// static instance of extent reports that can
	// be shared across the application//two classes for extent reports---predefined class

	public synchronized static ExtentReports createExtentReports() //create ExtentReports is a method
	{

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");//   "./" - for get local path of our project  ,, extent -reports is a folder ,, extent-report.html -- name of the report
		reporter.config().setReportName("7RMartSupermarketProject");//to give report name
		extentReports.attachReporter(reporter);//extentSparkReorter using reference is attached to extentReporter

		extentReports.setSystemInfo("Organization", "Obsqura");//
		extentReports.setSystemInfo("Name", " Arathy S Kumar"); 
		extentReports.setSystemInfo("Designation", "Software Tester");// provides context of the report
		return extentReports;
	}

}
