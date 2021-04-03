package functions;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class checkOut {
	
	public void checkoutItem(WebDriver driver,WebDriverWait wait, Actions act,Logger log) throws InterruptedException {
		
		
		
		act.moveToElement(driver.findElement(By.xpath("//a[contains(@title,'View my shopp')]"))).build().perform();;
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='button_order_cart']")));
		
		
		List<WebElement> prices=driver.findElements(By.xpath("//span[@class='price']"));
		
		DecimalFormat df=new DecimalFormat();
		double total=0;
		String shippingCost=df.format(Double.parseDouble( driver.findElement(By.xpath("//span[contains(@class,'shipping_cost')]")).getText().substring(1).trim()));
		double shipCost=Double.parseDouble(shippingCost);
		for (WebElement price:prices){
			
		double p=Double.parseDouble(price.getText().substring(1).trim());
		
			total=total+p;
		}
		double totall=Double.parseDouble(df.format(total));
		
		double totalCost=totall+shipCost;
		System.out.println(totalCost);
		
		String sysTotal=driver.findElement(By.xpath("//span[contains(@class,'cart_block_total')]")).getText().substring(1).trim();
		double formsysTotal=Double.parseDouble( df.format(Double.parseDouble(sysTotal)));
		
		Assert.assertEquals(totalCost, formsysTotal);
		log.debug("Asserted totals hovering cart " + totalCost+" vs "+formsysTotal);
		
		driver.findElement(By.xpath("//a[@id='button_order_cart']")).click();
		
		WebElement tcpg=driver.findElement(By.xpath("//span[@id='total_price']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='total_price']")));
		
		String totalChkPg=df.format( Double.parseDouble( tcpg.getText().substring(1).trim()));
		double totalChkPg1=Double.parseDouble(totalChkPg);
		Assert.assertEquals(totalCost, totalChkPg1);
		log.debug("Asserted totals checkout page1 " + totalCost+" vs "+totalChkPg1);
		
		
		driver.findElement(By.xpath("//i[@class='icon-trash']")).click();
		log.debug("First item removed");
		
		Thread.sleep(3000);
		
		List<WebElement> modTotals=driver.findElements(By.xpath("//td[@class='cart_total']/span"));
		
		double nTotal=0;
		for (int i=0;i<modTotals.size();i++) {
			
	nTotal=nTotal+Double.parseDouble(modTotals.get(i).getText().substring(1).trim());

			
		}
		
	double fTotal=	Double.parseDouble(df.format(nTotal));
	
	double shipping=Double.parseDouble(driver.findElement(By.xpath("//td[@id='total_shipping']")).getText().substring(1).trim());
	double fShipping=Double.parseDouble( (df.format(shipping)));
	
	double tPrice=Double.parseDouble( driver.findElement(By.xpath("//span[@id='total_price']")).getText().substring(1).trim());
	double ftPrice	=Double.parseDouble(df.format(tPrice));
	
	double fcost=fTotal+fShipping;
	Assert.assertEquals(fcost, ftPrice);
	log.debug("Asserted totals checkout page1 after removal " + fcost+" vs "+ftPrice);
	
		
	}

}
