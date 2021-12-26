package testNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.Utility;
import pages.loginPage;

public class crossBrowser {

	WebDriver driver;
	loginPage loginpage;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		
		if(browser.contentEquals("Chrome")) {
		System.setProperty(Utility.chromeDriver, Utility.chromePath);
		driver = new ChromeDriver();
		}else if(browser.contentEquals("Edge")) {
		System.setProperty(Utility.edgeDriver, Utility.edgePath);
		driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loginpage = new loginPage(driver);
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}
	
	@Test
	public void sucessfulLogin() {
		loginpage.signIn("validUser","validPass");
		//assert
	}
	
	
	
	
	
}