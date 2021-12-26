package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utility.Utility;

public class Assignment_final_exam {

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
	driver.get("https://www.seleniumeasy.com/test/");

}


/*
* This will close the very first popUp and check if start practicing is displayed
*/
	@Test (priority = 0)
	public void popUp ()  {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"at-cv-lightbox-close\"]"))).click();
	String actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btn_basic_example\"]"))).getText();
	String expectedResult = "Start Practising";	//	there is a wrong spelling on the web page 
	Assert.assertEquals(expectedResult, actualResult);
}
/*
 * This will click on start practicing and check if java script alerts are displayed	
 */
	@Test (priority = 1)
	public void startPractising ()  {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btn_basic_example\"]"))).click();
	String actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"basic\"]/div/a[5]"))).getText();
	String expectedResult = "Javascript Alerts";
	Assert.assertEquals(expectedResult, actualResult);
}
/*
 * This will click on java script alerts and check if click me button is displayed	
 */
	@Test (priority = 2)
	public void javaScriptAlert ()  {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"basic\"]/div/a[5]"))).click();
	String actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/button"))).getText();
	String expectedResult = "Click me!";
	Assert.assertEquals(expectedResult, actualResult);
}
/*
 * this will click on 'click me' button	in java script alert box
 */
	@Test (priority = 3)
	public void clickMe ()  {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/button"))).click();
}	
/*
 * This will click on Ok button in alert popUp and check if next click me button is displayed	
 */
	@Test (priority = 4)
	public void alertOk ()  {
	driver.switchTo().alert().accept();
	String actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/button"))).getText();
	String expectedResult = "Click me!";
	Assert.assertEquals(expectedResult, actualResult);
}	
/*
 * this will click on 'click me' button	in java script confirm box
*/	
	@Test (priority = 5)
	public void clickMe2 ()  {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button"))).click();
}
/*
 * this will click on cancel in popUp alert	
 */
	@Test (priority = 6)
	public void alertCancel ()  {
	driver.switchTo().alert().dismiss();	
}
/*
 * this will go to www.seleniumeasy.com	
 */
	@Test (priority = 7)
	public void seleniumEasy ()  {
	driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");	
}
/*
 * this will type in 'fill in' box and check if text is displayed
 */
	@Test (priority = 8)
	public void fillInMessageBox ()  {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user-message\"]"))).sendKeys("Everton"); // type in
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"get-input\"]/button"))).click(); // confirm
	String actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"display\"]"))).getText(); // get info displayed
	String expectedResult = "Everton";
	Assert.assertEquals(expectedResult, actualResult); // checking
}
/*
 * this will type in box 'enter a' and 'enter b' and check if result is displayed correctly	
 */
	@Test (priority = 9)
	public void enterValue ()  {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sum1\"]"))).sendKeys("1"); // input A value '1'
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sum2\"]"))).sendKeys("2"); // input B value '2'
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gettotal\"]/button"))).click(); // click on confirm
	String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"displayvalue\"]"))).getText(); // get result
	int a = 1; // value inserted on input A
	int b = 2; // value inserted on input B
	int sum = a+b; // Sum
	Assert.assertEquals(result, sum); // Compare results
}
	
	
	
	
}