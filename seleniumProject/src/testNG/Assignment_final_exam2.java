package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.Utility;

public class Assignment_final_exam2 {

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
	driver.get("https://www.phptravels.net/home");

}
	/*
	 * This will get and compare web site title
	 */

	@Test(priority=0)
	public void testPageTitle() {
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "PHPTRAVELS | Travel Technology Partner";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

/*
* This will click on login and check if is displayed
*/
	@Test (priority = 1)
	public void myAccount ()  {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mobileMenuMain\"]/nav/ul[2]/li[2]/a"))).click();
 	String actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/section/div/div[1]/div[1]/div/h3"))).getText();
	String expectedResult = "Login"; 
	Assert.assertEquals(expectedResult, actualResult);
}
/*
 * this will type in invalid login and check if message of invalid data is displayed
 */
	@Test (priority = 2)
    @Parameters({"username1", "password1"})
    public void unsucessfulLogin(String username, String password) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginfrm\"]/div[3]/div[1]/label/input"))).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginfrm\"]/div[3]/div[2]/label/input"))).sendKeys(password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginfrm\"]/button"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginfrm\"]/div[3]/div[1]/label/input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginfrm\"]/div[3]/div[2]/label/input"))).clear();
		Thread.sleep(1000);
	 	String actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div"))).getText();
		String expectedResult = "Invalid Email or Password"; 
		Assert.assertEquals(expectedResult, actualResult);
    }
/*
* this will type in the valid login and check if it was logged correctly
*/	
	@Test (priority = 3)
    @Parameters({"username2", "password2"})
    public void sucessfulLogin(String username, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginfrm\"]/div[3]/div[1]/label/input"))).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginfrm\"]/div[3]/div[2]/label/input"))).sendKeys(password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginfrm\"]/div[3]/div[2]/label/input"))).sendKeys(Keys.ENTER);
	 	String actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div/div[1]/div/div[2]/h3"))).getText();
		String expectedResult = "Hi, everton nardeli"; 
		Assert.assertEquals(expectedResult, actualResult);
    }
/*
 * this will click on home page button and check if it is displayed	
 */
	@Test(priority=4)
	public void goToHomePage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mobileMenuMain\"]/nav/ul[1]/li/a"))).click();
		Thread.sleep(3000);
		String actualTitle = driver.getCurrentUrl();
		String expectedTitle = "https://www.phptravels.net/home";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	
	
}
