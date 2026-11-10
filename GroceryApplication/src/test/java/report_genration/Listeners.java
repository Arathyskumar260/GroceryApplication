package report_genration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.Extent_Report_Utility;

public class Listeners implements ITestListener {
	ExtentTest test;
	ExtentReports extent = Extent_Report_Utility.createExtentReports();//Extent report is calling in the Listener class
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {//onTestStart method is used before running a testcase(program) also fetch the method names
		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());//method and methodname fetching
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {

		ITestListener.super.onTestSuccess(result);//after successing the testcase invoke/call the method is called onTestSuccess
		extentTest.get().log(Status.PASS, "Test Passed");//status is passed

	}

	public void onTestFailure(ITestResult result) {

		ITestListener.super.onTestFailure(result);//after the testcase fail the testcase invoke/fail method is called onTestfailure

		extentTest.get().log(Status.FAIL, "Test Failed");//status is failed
		extentTest.get().fail(result.getThrowable());

		WebDriver driver = null;

		String testMethodName = result.getMethod().getMethodName();

		//failing is occur through expection or error
		try {//try - expection code

			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());//
		} catch (IllegalArgumentException e) {//catch --error handle

			e.printStackTrace();// printStackTrace -- used to print the expection or errors
		} catch (IllegalAccessException e) {//illegalAccess

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
		}
	}

	public void onTestSkipped(ITestResult result) {//onTestSkipped -->>invoking method occur when any test case is skipped

		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped");//
		String testMethodName = result.getMethod().getMethodName();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {//if 60%success of a testcase when it is failed at 40% invoking method --->>onTestFailedButWithinSuccessPercentage

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {//failed due to time issue --invoking method is called  onTestFailedWithTimeout

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {//before onTestStart method executing is called onStart(Before onTestStart)

		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {//after all methods calling method is called onFinish

		ITestListener.super.onFinish(context);
		extent.flush();//flush --to check that the report fetching all datas are correctly logging
	}

}
