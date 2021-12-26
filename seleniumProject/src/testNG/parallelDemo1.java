package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utility.Utility;

public class parallelDemo1 {
	
	WebDriver driver;
	
@Test
public void method1() {
	//Connect Java code to Chrome browser
	System.setProperty(Utility.chromeDriver, Utility.chromePath);

	//Invoke Selenium / Open Browser
	driver = new ChromeDriver();

	//Maximize the window
	driver.manage().window().maximize();

	//Go to URL
	driver.get("https://www.facebook.com");
}

@Test
public void method2() {
	//Connect Java code to Chrome browser
	System.setProperty(Utility.chromeDriver, Utility.chromePath);

	//Invoke Selenium / Open Browser
	driver = new ChromeDriver();

	//Maximize the window
	driver.manage().window().maximize();

	//Go to URL
	driver.get("https://www.instagram.com");
}

@Test
public void method3() {
	//Connect Java code to Chrome browser
	System.setProperty(Utility.chromeDriver, Utility.chromePath);

	//Invoke Selenium / Open Browser
	driver = new ChromeDriver();

	//Maximize the window
	driver.manage().window().maximize();

	//Go to URL
	driver.get("https://www.kijiji.com");
}

}