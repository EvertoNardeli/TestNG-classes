package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Utility;

public class dataProvider {

	WebDriver driver;

	@BeforeMethod
	public void accessPage() {

		// Connect Java code to Chrome browser
		System.setProperty(Utility.chromeDriver, Utility.chromePath);

		// Invoke Selenium / Open Browser
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		// Go to URL
		driver.get("https://www.facebook.com");
	}
	/*
	 * parameters allows to test the function only against a single value whereas
	 * dataprovider allows us to test the function against multiple values
	 */

	/*
	 * this function provides the data
	 */
	@DataProvider(name = "loginCredentials")
	public Object[][] loginData() throws InterruptedException {
		return new Object[][] { 
			{ "test1", "pass1" }, 
			{ "test2", "pass2" }, 
			{ "test3", "pass3" },
		};
	}

	/*
	 * this function uses the data
	 */
	@Test(priority = 0, dataProvider = "loginCredentials")
	public void unsucessfulLogin1(String username, String password) throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(3000);
	}
	/*
	 * This function uses the external data
	 */
	@Test(dataProvider = "loginCredentialsExternal", dataProviderClass = dataProviderExternal.class)
	public void unsucessfulLogin2(String username, String password) throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(3000);
	}
	
	
	
	
}
