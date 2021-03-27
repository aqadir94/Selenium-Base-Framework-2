package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;

public class Test2 extends Base{
	
	WebDriver driver;
	@BeforeTest
	public void initialized() throws IOException {
		
		
		 driver =initialize();
		
	}
	
	
	@Test
	public void test() {
		
		driver.get("https://www.google.com");
		
		
	}
	
	@AfterTest
	public void terminate() {
		
		driver.quit();
		
		
	}
	
	
	

}
