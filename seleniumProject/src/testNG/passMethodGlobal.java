package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Utility;

public class passMethodGlobal {

	
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
    	driver.get("https://www.facebook.com");
    }
/*
 * This will get text; 'add()' function and 'return String' are used to make a global variable.
 */
	public String add() {
		String text = driver.findElement(By.xpath("//*[@id=\"reg_pages_msg\"]/a")).getText();
		return text;
	}
	/*
	 * This uses data shared by other method by using 'add()' function.
	 */
    @Test
	public void compare() {
		Assert.assertEquals("Create a Page", add());
	}

}	
