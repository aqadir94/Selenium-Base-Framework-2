package Tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import PageObjects.Common;
import PageObjects.SignInPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Resources.Base;

public class Test1 extends Base {
	
	private Logger log= LogManager.getLogger(Test1.class.getName());
	private WebDriver driver;
	SoftAssert sa=new SoftAssert();
	
	
	ExtentReports er =new ExtentReports();
	
	@BeforeTest
	public void initialized() throws IOException {
		
		 driver=initialize();
		 
		 
		
		
	}
	
	@Test
	public void test() throws InterruptedException {
		
		
		
		
		
		Common h1=new Common(driver);
	
		
		String path=System.getProperty("user.dir");
		JSONParser parser= new JSONParser();
		JSONObject jsonObj=null;
		try {
			Object obj=parser.parse(new FileReader(path+"\\src\\main\\java\\Resources\\newUser.json"));
			 jsonObj=(JSONObject)obj;
			
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		driver.get(prop.getProperty("url"));
		
		
		String email=(String)jsonObj.get("email");
		String title=(String)jsonObj.get("title");
		String fname=(String)jsonObj.get("fname");
		String lname=(String)jsonObj.get("lname");
		String pword=(String)jsonObj.get("pword");
		String bday=(String)jsonObj.get("bday");
		String bmonth=(String)jsonObj.get("bmonth");
		String byear=(String)jsonObj.get("byear");
		String nletter=(String)jsonObj.get("nletter");
		String soffer=(String)jsonObj.get("soffer");
		String company=(String)jsonObj.get("company");
		String address=(String)jsonObj.get("Address");
		String city=(String)jsonObj.get("city");
		String state=(String)jsonObj.get("state");
		String postal=(String)jsonObj.get("postal");
		String mphone=(String)jsonObj.get("mphone");
		String aalias=(String)jsonObj.get("aalias");
		SignInPage sip=new SignInPage(driver);
		
		
		String hpVerifier=driver.findElement(By.xpath("//h1")).getText();
		sa.assertEquals("Automation Practice Website", hpVerifier);
		log.debug("Website verified");
		
		
		h1.getSignInBtn().click();
		
		String signInPageVerifier=driver.findElement(By.xpath("(//h3)[1]")).getText();
	
		
		
		sa.assertEquals(signInPageVerifier, "CREATE AN ACCOUNT");
		
		
		h1.getSignInEmailtxtbx().sendKeys(email);
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		
		Thread.sleep(2000);
		String signInInfoVfier=driver.findElement(By.xpath("//h1")).getText();
		
		Assert.assertEquals(signInInfoVfier, "CREATE AN ACCOUN");
		
		if(title.contentEquals("mr")) {
			
			sip.getSalMr().click();
			
			
		}
		
		else if(title.contentEquals("mrs")) {
			
			sip.getSalMrs().click();
		}
		
		sip.getfirstName().sendKeys(fname);
		sip.getlastName().sendKeys(lname);
		sip.getpassWord().sendKeys(pword);
		sip.selectDOB(bday);
		sip.selectDOM(bmonth);
		sip.selectDOY(byear);
		
		if(nletter.equalsIgnoreCase("yes")) {
		
		sip.getnewsLetter().click();
		
		}
		
		
		
		
		sip.getaddFName().sendKeys(fname);
		sip.getaddLName().sendKeys(lname);
		sip.getcompany().sendKeys(company);
		sip.getaddL1().sendKeys(address);
		sip.getcity().sendKeys(city);
		sip.selectState(state);
		sip.getpostCode().sendKeys(postal);
		sip.getmobilePn().sendKeys(mphone);
		sip.getaddAlias().sendKeys(aalias);
		sip.getregister().click();
		
	
	
	}



	@AfterTest
	public void terminate() throws InterruptedException {
		sa.assertAll();
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}
}