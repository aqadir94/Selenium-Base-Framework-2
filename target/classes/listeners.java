package Resources;
import java.io.IOException;
import Resources.ExtentReporter;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class listeners extends Base implements ITestListener {
	
	ExtentReports er=	ExtentReporter.getreport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestSuccess(ITestResult result) {
		
	System.out.println("Test is passing "+result.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		test=er.createTest("First Test");
		extentTest.set(test);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testCaseName=result.getMethod().getMethodName();
		try {
			
		WebDriver	driver= (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			//takeScreenShot(driver,testCaseName);
			
			extentTest.get().addScreenCaptureFromPath(takeScreenShot(driver,testCaseName), testCaseName);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		extentTest.get().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		er.flush();
	}
	
	
	
	
	
	

}
