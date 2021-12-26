package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.Utility;

public class parametersDemo {

	WebDriver driver;
	
	@BeforeTest
	public void accessPage () {
		
		//Connect Java code to Chrome browser
		System.setProperty(Utility.chromeDriver, Utility.chromePath);

		//Invoke Selenium / Open Browser
		driver = new ChromeDriver();

		//Maximize the window
		driver.manage().window().maximize();

		//Go to URL
		driver.get("https://www.facebook.com");
	}
	
	/*
	 * parameters allows to test the function only against a single value
	 * whereas dataprovider allows us to test the function against multiple values
	 */
	
	@Test
    @Parameters({"username", "password"})
    public void unsucessfulLogin(@Optional("DefaultUsername") String username, @Optional("DefaultPassword") String password) {
		//@Optional("") means: ("") will be shown if there is no parameter on xml file
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);
    }

	
}
