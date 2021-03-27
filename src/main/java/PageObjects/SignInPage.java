package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignInPage {
	
	private WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='id_gender1']")
	private WebElement mr;
	
	public WebElement getSalMr() {
		
		return mr;
		
	}
	
	@FindBy(xpath="//input[@id='id_gender2']")
	private WebElement mrs;
	public WebElement getSalMrs() {
		
		return mrs;
		
	}
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	private WebElement lastName;
	public WebElement getlastName() {
		
		return lastName;
		
	}
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	private WebElement firstName;
	public WebElement getfirstName() {
		
		return firstName;
		
	}
	
	@FindBy(xpath="//input[@id='passwd']")
	private WebElement passWord;
	public WebElement getpassWord() {
		
		return passWord;
		
	}
	
	public void selectDOB(String day) {
		
		
		Select select=new Select(driver.findElement(By.xpath("//select[@id='days']")));
		select.selectByValue(day);
		
		
	}
	
	public void selectDOM(String month) {
		
		
		Select select=new Select(driver.findElement(By.xpath("//select[@id='months']")));
		select.selectByValue(month);
		
		
	}
	
	
public void selectDOY(String year) {
		
		
		Select select=new Select(driver.findElement(By.xpath("//select[@id='years']")));
		select.selectByValue(year);
		
		
	}


	@FindBy(xpath="//input[@id='newsletter']")
	private WebElement newsLetter;
	
	public WebElement getnewsLetter() {
		
		
		return newsLetter;
	}
	
	
	@FindBy(xpath="//input[@id='firstname']")
	private WebElement addFName;
	
	public WebElement getaddFName() {
		
		
		return addFName;
	}
	
	@FindBy(xpath="//input[@id='lastname']")
	private WebElement addLName;
	
	public WebElement getaddLName() {
		
		
		return addLName;
	
	
}
	
	@FindBy(xpath="//input[@id='company']")
	private WebElement company;
	
	public WebElement getcompany() {
		
		
		return company;
	
	
}
	

	@FindBy(xpath="//input[@id='address1']")
	private WebElement addL1;
	
	public WebElement getaddL1() {
		
		
		return addL1;
	
	
}

	@FindBy(xpath="//input[@id='city']")
	private WebElement city;
	
	public WebElement getcity() {
		
		
		return city;
	
	
}
	
	
	public void selectState(String state) {
		
		Select select =new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		
		select.selectByVisibleText(state);
		
	}
	
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement postCode;

	public WebElement getpostCode() {
		
		
		return postCode;
		
	}
	

	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement mobPhone;

	public WebElement getmobilePn() {
		
		
		return mobPhone;
		
	}
	
	
	@FindBy(xpath="//input[@id='alias']")
	WebElement aAlias;

	public WebElement getaddAlias() {
		
		
		return aAlias;
		
	}
	
	@FindBy(xpath="//button[@id='submitAccount']")
	WebElement register;

	public WebElement getregister() {
		
		
		return register;
		
	}


}
