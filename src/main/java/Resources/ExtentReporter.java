package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports getreport() {
	
	String path=System.getProperty("user.dir")+"//reports//"+Base.getTime()+".html";
	ExtentSparkReporter esr= new ExtentSparkReporter(path);
	esr.config().setReportName("Framework Last");
	
	ExtentReports er=new ExtentReports();
	er.attachReporter(esr);
	er.setSystemInfo("Tester", "Abdul");
	
	return er;
	
	}
	
	
}
