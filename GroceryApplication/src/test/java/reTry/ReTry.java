package reTry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTry implements IRetryAnalyzer{
	private static final Logger LOG = (Logger) LogManager.getLogger("Retry.class");
	private static final int maxTry = 2;//maxTry is total number of retry--if a testcase failed and it will retry here 2 times
	private int count = 0;//it will take the count of how many times a testcase run --- to get the count

	@Override
	public boolean retry(final ITestResult iTestResult) {//predefined method
	if (!iTestResult.isSuccess()) {
	if (this.count < maxTry) {
	LOG.info("Retrying test " + iTestResult.getName() + " with status "
	+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
	this.count++;
	return true;
	}
	}
	return false;
	}

	public String getResultStatusName(final int status) {
	String resultName = null;
	if (status == 1) {
	resultName = "SUCCESS";
	}
	if (status == 2) {
	resultName = "FAILURE";
	}
	if (status == 3) {
	resultName = "SKIP";
	}
	return resultName;
	}

}
