/**
 * 
 */
package gorest.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import gorest.logger.Log;
import gorest.reports.ExtentReport;

/**
 * @author intelligent
 *
 */
public class Listeners implements ITestListener{


	/**
	 * Invoked each time before a test will be invoked. The <code>ITestResult</code> is only partially
	 * filled with the references to class, method, start millis and status.
	 *
	 * @param result the partially filled <code>ITestResult</code>
	 * @see ITestResult#STARTED
	 */
	@Override
	public void onTestStart(ITestResult result) {
		// not implemented

		ExtentReport.setTest(ExtentReport.getReport().createTest(result.getName()));

	}

	/**
	 * Invoked each time a test succeeds.
	 *
	 * @param result <code>ITestResult</code> containing information about the run test
	 * @see ITestResult#SUCCESS
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		// not implemented

		Log.logInfo("from listeners success " + result.getName());
		ExtentReport.getTest().log(Status.PASS, "Pass");


	}

	/**
	 * Invoked each time a test fails.
	 *
	 * @param result <code>ITestResult</code> containing information about the run test
	 * @see ITestResult#FAILURE
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		// not implemented
		Log.logInfo("from listeners  onTestFailure " + result.getName());

		ExtentReport.getTest().log(Status.FAIL, "failed");

	}

	/**
	 * Invoked each time a test is skipped.
	 *
	 * @param result <code>ITestResult</code> containing information about the run test
	 * @see ITestResult#SKIP
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		Log.logInfo("from listeners  onTestSkipped " + result.getName());
		ExtentReport.getTest().log(Status.SKIP, "Skipped");

	}

	/**
	 * Invoked each time a method fails but has been annotated with successPercentage and this failure
	 * still keeps it within the success percentage requested.
	 *
	 * @param result <code>ITestResult</code> containing information about the run test
	 * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Log.logInfo("from listeners onTestFailedButWithinSuccessPercentage " + result.getName());
	}

	/**
	 * Invoked each time a test fails due to a timeout.
	 *
	 * @param result <code>ITestResult</code> containing information about the run test
	 */
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);

		Log.logInfo("from listeners  onTestFailedWithTimeout " + result.getName());
	}

	/**
	 * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt;
	 * tag and calling all their Configuration methods.
	 *
	 * @param context The test context
	 */
	@Override
	public void onStart(ITestContext context) {
		// not implemented

		Log.logInfo("from listeners onStart " + context.getName());



	}

	/**
	 * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
	 * run and all their Configuration methods have been called.
	 *
	 * @param context The test context
	 */
	@Override
	public void onFinish(ITestContext context) {
		// not implemented

		Log.logInfo("from listeners onFinish " + context.getName());



	}


}
