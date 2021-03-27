package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Common {
	
	private WebDriver driver;
	
	
	public Common(WebDriver driver) {
		
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//a[@class='login']")
	private WebElement btn_SignIn;
	
	public WebElement getSignInBtn() {
		
		return btn_SignIn;
		
	}
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement txtbx_SignInEmail;
	
	
	public WebElement getSignInEmailtxtbx() {
		
		return txtbx_SignInEmail;
	}
	
	

}
