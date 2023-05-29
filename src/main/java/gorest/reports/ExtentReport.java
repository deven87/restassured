package gorest.reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {


	static ExtentReports er;
	static ExtentSparkReporter reporter;
	static ExtentTest test;

	public static void startReporting() {


		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");

		String date = sdf.format(new Date());

		er = new ExtentReports();
		reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentreport_" + date + ".html");

		reporter.config().setReportName("my go rest suite report");
		reporter.config().setDocumentTitle("RestAssuredSuite");
		reporter.config().setTheme(Theme.DARK);
		er.attachReporter(reporter);
		er.setSystemInfo("Application", "RestAssuredSuite");
		er.setSystemInfo("os", System.getProperty("os.name"));
		er.setSystemInfo("user", System.getProperty("user.name"));
		er.setSystemInfo("environment", "QA");




	}

	public static ExtentReports getReport() {

		return er;
	}

	public static ExtentTest getTest() {

		return test;
	}

	public static void setTest(ExtentTest extentTest) {
		test = extentTest;

	}



}
