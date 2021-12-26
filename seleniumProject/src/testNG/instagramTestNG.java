package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Utility;

public class instagramTestNG {
	
	WebDriver driver;
    WebDriverWait wait;

	@BeforeTest (groups="Instagram")
	public void method1 () {
		
		//Connect Java code to Chrome browser
		System.setProperty(Utility.chromeDriver, Utility.chromePath);

		//Invoke Selenium / Open Browser
		driver = new ChromeDriver();
		
    	//Declare wait object
    	wait=new WebDriverWait(driver,15);

		//Maximize the window
		driver.manage().window().maximize();

		//Go to URL
		driver.get("https://www.instagram.com");		
		
	}
	
/*
 * this will send keys to box' login' and 'password'
 */
	
	@Test (groups="Instagram")
	public void method2 () {
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input"))).sendKeys("vdsfv");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input"))).sendKeys("123abc");
 
	}

/*
 * This will click on 'log in'
 */
	@Test (groups="Instagram")
	public void method3 () {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[3]"))).click();
		
	}
	
}
