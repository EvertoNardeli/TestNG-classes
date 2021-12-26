package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Utility;

public class Assignment_exam_TestNG {

	//declaration as Global
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void openBrowser() {
	
	//Connect Java code to Chrome browser
	System.setProperty(Utility.chromeDriver, Utility.chromePath);

	//Invoke Selenium / Open Browser
	driver = new ChromeDriver();

	//Declare wait object
	wait=new WebDriverWait(driver,15);

	//Maximize the window
	driver.manage().window().maximize();

	//Go to URL
	driver.get("http://automationpractice.com/index.php");

}


/*
* This will click on 'Women' box and test whether 'Dresses' is displayed
*/
	
	@Test (priority = 1)
	public void women () {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"))).click();
	String actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div[2]/ul/li[2]/h5/a"))).getText();
	String expectedResult = "DRESSES";
	Assert.assertEquals(expectedResult, actualResult);
}

/*
* this will click on 'Dresses' and test whether 'Summer Dresses' is displayed
*/
	@Test (priority = 2)
	public void dresses() {
		
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a"))).click();
	
	String actualResult1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div[1]/div[1]/div/ul/li[3]/a"))).getText();
	String expectedResult1 = "Summer Dresses";
	Assert.assertEquals(expectedResult1, actualResult1);
}

/*
* this will click on 'Summer Dresses' and test whether summer dresses are displayed
*/

	@Test (priority = 3)
	public void summerDresses() {
		
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div[1]/div[1]/div/ul/li[3]/a"))).click();
	
	String actualResult2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/h5/a"))).getText();
	String expectedResult2 = "Printed Summer Dress";
	Assert.assertEquals(expectedResult2, actualResult2);
}

/*
* this will click on 'Printed Summer Dress' and test whether specific model is displayed
*/

	@Test (priority = 4)
	public void printedSummerDress() {
			
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/h5/a"))).click();
		
	String actualResult3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_reference\"]/span"))).getText();
	String expectedResult3 = "demo_5";
	Assert.assertEquals(expectedResult3, actualResult3);
	}

			
	/*
	* this will click on 'add to cart' and test whether the product was added to cart
	*/

	@Test (priority = 5)
	public void addToCart() {
				
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span"))).click();
			
	String actualResult4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/h2"))).getText();
	String expectedResult4 = "Product successfully added to your shopping cart";
	Assert.assertEquals(expectedResult4, actualResult4);
	}

	/*
	* this will click on 'proceed to checkout' and check quantity on cart
	*/

	@Test (priority = 6)
	public void proceedToCheckout() {
				
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"))).click();
			
	String actualResult5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a/span[1]"))).getText();
	String expectedResult5 = "1";
	Assert.assertEquals(expectedResult5, actualResult5);
	}

	/*
	* this will click on 'proceed to checkout' and check whether 'authentication' page is displayed
	*/

	@Test (priority = 7)
	public void proceedToCheckout2() {
				
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span"))).click();
			
	String actualResult6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/h1"))).getText();
	String expectedResult6 = "AUTHENTICATION";
	Assert.assertEquals(expectedResult6, actualResult6);
	}

	/*
	* this will insert email address and password to login and check whether it was logged 
	*/

	@Test (priority = 8)
	public void login() {
				
	//insert email address
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[1]/input"))).sendKeys("everton@gmail.com");
	
	//insert password 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[2]/span/input"))).sendKeys("123abc");

	//click on 'sign in' 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span"))).click();

	String actualResult7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/div/div[2]/div[1]/ul/li[1]/h3"))).getText();
	String expectedResult7 = "YOUR DELIVERY ADDRESS";
	Assert.assertEquals(expectedResult7, actualResult7);
	}

	/*
	* this will click on 'proceed to checkout' and check whether 'shipping' page is displayed
	*/

	@Test (priority = 9)
	public void proceedToCheckoutShipping() {
				
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span"))).click();
			
	String actualResult8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div/div[2]/p"))).getText();
	String expectedResult8 = "Choose a shipping option for this address: My address";
	Assert.assertEquals(expectedResult8, actualResult8);
	}
												
	
	/*
	* this will click on webElement ' agree' and 'proceed to checkout' and check whether 'Payment' page is displayed
	*/

	@Test (priority = 10)
	public void proceedToCheckoutPayment() {
				
	WebElement agree = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div/p[2]/div/span/input"));
	agree.click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/p/button/span"))).click();
			
	String actualResult9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/h1"))).getText();
	String expectedResult9 = "PLEASE CHOOSE YOUR PAYMENT METHOD";
	Assert.assertEquals(expectedResult9, actualResult9);
	}
												
	/*
	* this will click on 'PayByBankWire' and confirm whether order summary is displayed
	*/

	@Test (priority = 11)
	public void paymentByBankWire() {
				
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a"))).click();
			
	String actualResult10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/h1"))).getText();
	String expectedResult10 = "ORDER SUMMARY";
	Assert.assertEquals(expectedResult10, actualResult10);
	}

	/*
	* this will click on 'I confirm my order' and check whether order is completed
	*/

	@Test (priority = 12)
	public void confirmMyOrder() {
				
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span"))).click();
			
	String actualResult11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/p/strong"))).getText();
	String expectedResult11 = "Your order on My Store is complete.";
	Assert.assertEquals(expectedResult11, actualResult11);
	}

	@AfterTest
	public void close() {
		driver.close();
	}
	
	
}
