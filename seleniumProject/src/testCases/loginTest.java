package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.loginPage;
import Utility.Utility;

public class loginTest {

	WebDriver driver;
	loginPage loginpage;
	
	@BeforeTest
	public void setup() {
		System.setProperty(Utility.chromeDriver, Utility.chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loginpage = new loginPage(driver);
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@Test
	public void testUnsucessfulLogin() {
		loginpage.signIn("invalidUser","invalidPass");
		//Assert
		
	}
	
	@Test
	public void sucessfulLogin() {
		loginpage.signIn("validUser","validPass");
		//assert
	}
}
