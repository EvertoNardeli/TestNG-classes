package seleniumProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.Utility;

public class Sample {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		String URL = "https://www.amazon.ca/";
		
		//Step 1: Connect Java code to Chrome browser
		System.setProperty(Utility.chromeDriver, Utility.chromePath);
		
		//Step 2: Invoke Selenium / Open browser
		WebDriver driver = new ChromeDriver();
		
		//maximize browser window
		driver.manage().window().maximize();
		
		//Step 3: Go to URL
		driver.get(URL);
		
		//implicit timeout; remove the necessity of thread.sleep; this case wait time is at most 3 seconds.
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		/*
		 		 
		//ExplicitWait Timeout; object created; By using class WebDriverWait;
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).click()
		
		//Click on all categories
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/header/div/div[4]/div[1]/a/span"))).click();

		//Click on Fire Tablets
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[8]/a"))).click();
		
		*/
	
		
		
		
		
		
		
		
		
	}
	
	//create a function
	public static void getElementByXpath(String xpathValue) {
		driver.findElement(By.xpath(xpathValue));
	}

}
