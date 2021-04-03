package Tests;

import java.io.FileNotFoundException;
import functions.AddToCart;
import functions.SignUp;
import functions.checkOut;

import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import PageObjects.Common;
import PageObjects.SignInPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	public void test() throws IOException, InterruptedException {
		
		
		
		SignUp client1=new SignUp();
		
		//client1.clientSignup(driver,prop);
		driver.manage().window().maximize();
		client1.logIn("asd123asdfa@gmail.com", "123456", prop, driver);
		Actions act=new Actions(driver);
		
		WebElement lnk_Women=driver.findElement(By.xpath("//a[@title='Women']"));
		
		
		WebDriverWait wait=new WebDriverWait(driver,5);
		
		
		lnk_Women.click();
		//Thread.sleep(5000);
		
	AddToCart add=new AddToCart();
	add.add(driver, "Blouse");
	add.add(driver, "Faded Short Sleeve T-shirts");
	add.add(driver, "Printed Chiffon Dress");
	
	checkOut c1=new checkOut();
	c1.checkoutItem(driver, wait, act, log);
	
	
	
	}



	@AfterTest
	public void terminate() throws InterruptedException {
		//sa.assertAll();
		
		Thread.sleep(5000);
		//driver.quit();
		
		
	}
}