package seleniumProject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Utility;

public class Midterm_exam {

	public static void main(String[] args) throws InterruptedException {
		
		String URL = "http://automationpractice.com/index.php";
		
		//Step 1: Connect Java code to Chrome browser
		System.setProperty(Utility.chromeDriver, Utility.chromePath);
		
		//Step 2: Invoke Selenium / Open browser
		WebDriver driver = new ChromeDriver();
		
		//Step 3: maximize browser window
		driver.manage().window().maximize();
		
		//Step 4: Go to URL
		driver.get(URL);
		
		//Step 5: ExplicitWait Timeout; object created; By using class WebDriverWait;
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		//Step 6: click on 'Sign in'
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]"))).click();
		
		//Step 7a: Create a custom date time format
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");

		//Step 7b: Get current date and time
		LocalDateTime currentTime = LocalDateTime.now();
		
		//Step 7: click on 'email address' on create an account field  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[2]/input"))).sendKeys("Everton"+(dtf.format(currentTime))+"@gmail.com");
		
		//Step 8: click on 'create an account'
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button/span"))).click();
		
		//Step 9: wait 5 seconds
		Thread.sleep(5000);
		
		//Step 10: Click on webElement 'title Mr.'
		WebElement Mr = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[1]/div[1]/label/div/span/input"));
		Mr.click();
	
		//Step 11: click on 'first name' and type in
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[2]/input"))).sendKeys("Everton");
		
		//Step 12: click on 'Last name' and type in
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[3]/input"))).sendKeys("Nardeli");
			
		//Step 13: click on 'password' and type in
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[5]/input"))).sendKeys("123abc");
		
		//Step 14:find dropdown and select 'day' of birth
		Select day = new Select(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[1]/div/select")));
		day.selectByValue("17");
		
		//Step 15:find dropdown and select 'month' of birth
		Select month = new Select(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[2]/div/select")));
		month.selectByValue("11");
		
		//Step 16:find dropdown and select 'year' of birth
		Select year = new Select(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[3]/div/select")));
		year.selectByValue("1986");
		
		//Step 17: create and execute javascript to scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		
		//Step 18: click on 'address' and type in
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[4]/input"))).sendKeys("2020 avenue west");
		
		//Step 19: click on 'address 2' and type in
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[5]/input"))).sendKeys("B");
		
		//Step 20: click on 'city' and type in
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[6]/input"))).sendKeys("Montreal");
		
		//Step 21: find dropdown and select 'state'
		Select state = new Select(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[7]/div/select")));
		state.selectByValue("10");
		
		//Step 22: click on 'postal code' and type in
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[8]/input"))).sendKeys("12345");
		
		//Step 23: find box 'additional information' and type in
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[10]/textarea"))).sendKeys("good");
		
		//Step 24: click on 'mobile phone' and type in
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[13]/input"))).sendKeys("5142223344");
				
		//Step 25: click on 'register'
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[4]/button/span"))).click();
	
		//Step 26: click on 'dresses'
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a"))).click();
			
		//Step 27: click on 'summer dresses'
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div[1]/div[1]/div/ul/li[3]/a"))).click();
		
		Thread.sleep(2000);
		
		//Step 28: click on first dress
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/h5/a")).click();
		
		//Step 29: click on 'add to cart'
		driver.findElement(By.id("add_to_cart")).click();
		
		//Step 30: Click on Proceed to checkout
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"))).click();
		
		//Step 31: Click on Proceed to checkout
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span"))).click();
				
		//Step 32: Click on Proceed to checkout
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span"))).click();
		
		//Step 33: click on webElement 'I agree'
		WebElement agree = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div/p[2]/div/span/input"));
		agree.click();
		
		//Step 34: Click on Proceed to checkout
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/p/button/span"))).click();
		
		//Step 35: Click on 'pay by bank wire'
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a"))).click();
						
		//Step 36: Click on 'I confirm my order'
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span"))).click();
				

	}

}
