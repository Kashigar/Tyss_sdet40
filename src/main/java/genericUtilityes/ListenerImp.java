package genericUtilityes;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImp implements ITestListener {

	private  ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("suma");
		spark.config().setReportName("Facebbok");
		spark.config().setTheme(Theme.STANDARD);
		
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Admin", "suma");
		report.setSystemInfo("OS", "Win11");
		
	}
	public void onTestStart(ITestResult result) {
		 test = report.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+"---> is Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getMethod().getMethodName()+"---> is Failed");
		test.fail(result.getThrowable());// attache exception
		
	}

	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+"---> is Failed");
		test.skip(result.getThrowable());// attache exception
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
		
	}

}
