package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver;
	
	public Properties prop;
	
	public WebDriver initialize() throws IOException {
		
		String sysPath=System.getProperty("user.dir");
		prop=new Properties();
		FileInputStream fis=new FileInputStream(sysPath+"\\src\\main\\java\\Resources\\options.properties");
		prop.load(fis);
		String browser=prop.getProperty("browser");
		
		if(browser.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		}
		
		else {
			
			
		//
		}
		
		return driver;
		
		
		
		
		
		
	}

	public String takeScreenShot(WebDriver driver, String testCase) throws IOException {
		
		TakesScreenshot tks=(TakesScreenshot)driver;
		File scr=tks.getScreenshotAs(OutputType.FILE);
		String filePath=System.getProperty("user.dir")+"//reports//screenshots//"+testCase+getTime()+".png";
		FileUtils.copyFile(scr,new File(filePath));
		
		return filePath;
		
	}
	
	public static String getTime() {
		
		
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		return timeStamp;
	}
	

}
