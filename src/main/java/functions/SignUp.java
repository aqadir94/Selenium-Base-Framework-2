package functions;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjects.Common;
import PageObjects.SignInPage;
import Resources.Base;


public class SignUp{
	
	private Logger log= LogManager.getLogger(SignUp.class.getName());
	

	
	public void clientSignup(WebDriver driver, Properties prop) throws IOException {
		
		
		Common h1=new Common(driver);
		WebDriverWait wait=new WebDriverWait(driver,5);
	
		
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
		Assert.assertEquals("Automation Practice Website", hpVerifier);
		log.debug("Website verified");
		
		
		h1.getSignInBtn().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='SubmitCreate']")));
		String signInPageVerifier=driver.findElement(By.xpath("(//h3)[1]")).getText();
	
		
		
		Assert.assertEquals(signInPageVerifier, "CREATE AN ACCOUNT");
		
		
		h1.getSignInEmailtxtbx().sendKeys(email);
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='account_creation']/h3)[1]")));
		String signInInfoVfier=driver.findElement(By.xpath("(//div[@class='account_creation']/h3)[1]")).getText();
		
		Assert.assertEquals(signInInfoVfier, "YOUR PERSONAL INFORMATION");
		
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
		
		log.debug("Customer signup complete");
		
		
		
	}
	
	public void logIn(String email,String passWord, Properties prop,WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,5);
		Common h1=new Common(driver);
		driver.get(prop.getProperty("url"));
		String hpVerifier=driver.findElement(By.xpath("//h1")).getText();
		Assert.assertEquals("Automation Practice Website", hpVerifier);
		log.debug("Website verified");
		
		
		h1.getSignInBtn().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='SubmitCreate']")));
		String signInPageVerifier=driver.findElement(By.xpath("(//h3)[1]")).getText();
	
		
		
		Assert.assertEquals(signInPageVerifier, "CREATE AN ACCOUNT");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(passWord);
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Home']"))));
		log.debug("Succesfully logged in");
		
	}
	

}
