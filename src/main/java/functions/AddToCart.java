package functions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
	
public void add(WebDriver driver, String product) throws InterruptedException {
	
	Logger log=LogManager.getLogger(AddToCart.class.getName());
	
	Actions act=new Actions(driver);
	WebDriverWait wait=new WebDriverWait(driver,5);
	List<WebElement> products=driver.findElements(By.xpath("//div[@class='product-container']/div[2]/h5/a"));
	
	
	for(int i=0;i<products.size();i++) {
		
		if(products.get(i).getText().contains(product)) {
			
			act.moveToElement(products.get(i)).build().perform();
			
			
			driver.findElements(By.xpath("//a[@title='Add to cart']")).get(i).click();
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@title='Continue shopping']"))));
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Continue shopping']/span")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@title='Continue shopping']/span")).click();
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Women']"))));
			log.debug(product+ " added to cart");
			break;
		}
		
	} 
	
	
}


/*
act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Printed Dress')]"))).build().perform();;
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Printed Dress')]/parent::h5/following-sibling::div[2]/a)[1]")));
driver.findElement(By.xpath("(//a[contains(text(),'Printed Dress')]/parent::h5/following-sibling::div[2]/a)[1]")).click();

*/

}
