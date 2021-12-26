package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import Utility.Utility;

public class Assignment_AirCanada {

	//declaration as Global
	WebDriver driver;
	WebDriverWait wait;
	Actions action;

@BeforeTest
	public void openBrowser() {
	
	//Connect Java code to Chrome browser
	System.setProperty(Utility.chromeDriver, Utility.chromePath);

	//Invoke Selenium / Open Browser
	driver = new ChromeDriver();

	//Declare wait object
	wait=new WebDriverWait(driver,12);
		
	// Declare actions object
	action = new Actions(driver);

	//Maximize the window
	driver.manage().window().maximize();

	//Go to URL
	driver.get("https://www.aircanada.com/us/en/aco/home.html#/");
}
/*
 * This will get and compare website title
 */

@Test(priority=1)
public void testPageTitle() {
	
	String actualTitle = driver.getTitle();
	String expectedTitle = "Air Canada - Official website";
	Assert.assertEquals(actualTitle, expectedTitle);
}
/*
 * This will move mouse cursor over 'Book' and check whether 'flight' button is displayed 
 */

@Test(priority=2)
public void mouseOverBook() {
	
	//find button 'Book'
	WebElement book = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[3]/div[1]/div[3]/div/div/nav/div[1]/div[1]/a/span")));
	
	//move mouse cursor over button 'Book'
	action.moveToElement(book).perform();
	
	//check if 'flight' button is displayed 
    String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[3]/div[1]/div[3]/div/div/nav/div[1]/div[2]/section/div/div/div/div[1]/div/section[1]/ul/li[1]/a")))
    .getText();
    String expectedText = "Flight";
    Assert.assertEquals(actualText, expectedText);
}
/*
 * This will move mouse cursor over 'Flight' and check whether flights tab content is displayed 
 */

@Test(priority=3)
public void mouseOverFligh() {
	
	//find button 'flight'
	WebElement flight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[3]/div[1]/div[3]/div/div/nav/div[1]/div[2]/section/div/div/div/div[1]/div/section[1]/ul/li[1]/a")));
	
	//move mouse cursor over button 'flight' and click
	action.moveToElement(flight).click().perform();
	
	//check whether flights tab content is displayed 
	Boolean flightButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tab_magnet_panel_0\"]"))).isDisplayed();
	System.out.println("tab content is displayed: "+flightButton);
}
/*
 * This will click on dropdown 'Round-trip' , select 'Multi-city' and check whether flight option 1 and 2 are displayed
 */
@Ignore
@Test(priority=4)
public void setRoundTrip() {
	
	//find dropdown 'round-trip' and click
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tripTypeLabel\"]/div[2]")))
	.click();

	//find option 'multi-city' and click
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='tripTypeIdtripType_M']")))
	.click();
	
	//check if 'flight 1' is displayed
    String actualText1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"magnet-fields-wrapper\"]/div[1]/div[1]")))
    .getText();
    String expectedText1 = "Flight 1";
   Assert.assertEquals(actualText1, expectedText1);
   
	//check if 'flight 2' is displayed
   String actualText2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"magnet-fields-wrapper\"]/div[2]/div[1]")))
   .getText();
   String expectedText2 = "Flight 2";
  Assert.assertEquals(actualText2, expectedText2);

}
/*
 * This will find and select quantity of passengers, compare results
 */
@Test(priority=5)
public void passengerQuant() {
	
	//find dropdown '1 adult' and click
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passengersInputField\"]/div")))
	.click();

	//find option '2' in passengers and click
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnAdultCountAdd\"]")))
	//.click();

	//find button 'done' and click
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flightPax_dn\"]")))
	.click();
	
	//check if selected quantity of passenger is displayed
    String actualText1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passengersInputField\"]/div/span[1]")))
    .getText();
    String expectedText1 = "1";
   Assert.assertEquals(actualText1, expectedText1);
}
/*
 * this will find and send keys in 'flight to' and check results
 */
@Test(priority=6)
public void flightTo() {
	
	//find box 'flight to'
	WebElement flightTo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("destination_focus_0")));
	
	//move mouse cursor to 'flight to' and send keys 'toronto'
	action.moveToElement(flightTo).click().sendKeys("toronto").perform();
	
	//select Toronto destination
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flightLocationListDestinationId0_locationListItem_1\"]/div/div[3]")))
	.click();
	
	//check if Toronto YYZ is displayed
    String actualText1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"destination_focus_0\"]/span/span[2]")))
    .getText();
    String expectedText1 = "YYZ";
   Assert.assertEquals(actualText1, expectedText1);
}
/*
 * This will find and select travel date
 */
@Test(priority=7)
public void travelDate() {
	
	//find box 'travel date' and click
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"returnDateLabel\"]/div[1]/div/div/span"))).click();

	//select date 'May 15'
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div[2]/table/tbody/tr[3]/td[7]/div[2]/span[1]"))).click();

	//select return date 'May 17'
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div[1]/table/tbody/tr[4]/td[2]/div[2]/span[1]"))).click();
	
	//click on box 'select'
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"calendarSelectActionBtn\"]"))).click();
	
	//check if selected dates are displayed							
    String actualText1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"returnDateLabel\"]/div[1]/div/div/span[1]")))
    .getText();
    String actualText2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"returnDateLabel\"]/div[1]/div/div/span[3]")))
    .getText();
    String expectedText1 = "May 15";
    String expectedText2 = "May 17";
   Assert.assertEquals(actualText1, expectedText1);
   Assert.assertEquals(actualText2, expectedText2);
}
/*
 * this will click on 'find' and check if is displayed
 */
@Test(priority=8)
public void findFlight() {
	
	//click on box 'find'
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"magnet-fields-wrapper\"]/div/div[3]/div/div[2]/input"))).click();

	//check if departing flight is displayed
    String actualText1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"boundTitleGridContainer\"]/div/div[1]/div[2]")))
    .getText();
    String expectedText1 = "Montréal (YUL) to Toronto (YYZ) Saturday, May 15th, 2021";
   Assert.assertEquals(actualText1, expectedText1);
}

/*
 * This will select depart flight and check if is displayed
 */
@Test(priority=9)
public void selectDepartFlight() {

	//select economy flight option
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cabinBtnECO00\"]/div/div/div[2]/div[2]")))
	.click();

	//select standard option
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-fare-element-container\"]/table/tbody/tr[9]/td[2]/fare-family-element-footer/div/button/div[2]")))
	.click();
	
	//select keep standard option
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fareUpgradeLightBox\"]/div/div/div/div[3]/div[1]/button")))
	.click();															
	
	//check if return flight is displayed
    String actualText1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"boundTitleGridContainer\"]/div/div[1]/div[2]")))
    .getText();
    String expectedText1 = "Toronto (YYZ) to Montréal (YUL) Monday, May 17th, 2021";
   Assert.assertEquals(actualText1, expectedText1);
}
/*
 * This will select return flight and check if is displayed
 */
@Test(priority=10)
public void selectReturnFlight() {

	//select economy flight option
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cabinBtnECO01\"]")))
	.click();

	//select standard option
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-fare-element-container\"]/table/tbody/tr[9]/td[2]/fare-family-element-footer/div/button/div[2]")))
	.click();

	//check if flights are displayed
    String actualText1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pageContent\"]/div[4]/app/div[2]/app-farereview/div/div[2]/div/div/div[1]/h2/span[2]")))
    .getText();
    String actualText2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pageContent\"]/div[4]/app/div[2]/app-farereview/div/div[2]/div/div/div[1]/bound-detail-title[1]/div/div/div[1]/div/div/div[1]")))
    .getText();
    String actualText3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pageContent\"]/div[4]/app/div[2]/app-farereview/div/div[2]/div/div/div[1]/fr-bound-details[1]/div/div/div[1]/bound-itinerary/div[3]/div/div/div[1]/div[2]")))
    .getText();
    String actualText4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fare-rules-popup-0\"]/span[1]")))
    .getText();
    String actualText5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pageContent\"]/div[4]/app/div[2]/app-farereview/div/div[2]/div/div/div[1]/fr-bound-details[1]/div/div/div[2]/div/div[1]/div[2]/span")))
    .getText();
    String actualText6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pageContent\"]/div[4]/app/div[2]/app-farereview/div/div[2]/div/div/div[1]/bound-detail-title[2]/div/div/div[1]/div/div/div[1]")))
    .getText();
    String actualText7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pageContent\"]/div[4]/app/div[2]/app-farereview/div/div[2]/div/div/div[1]/fr-bound-details[2]/div/div/div[1]/bound-itinerary/div[3]/div/div/div[1]/div[2]")))
    .getText();
    String actualText8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fare-rules-popup-1\"]/span[1]")))
    .getText();
    String actualText9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pageContent\"]/div[4]/app/div[2]/app-farereview/div/div[2]/div/div/div[1]/fr-bound-details[2]/div/div/div[2]/div/div[1]/div[2]/span")))
    .getText();
    String expectedText1 = "Flight summary";
    String expectedText2 = "Saturday, May 15, 2021";
    String expectedText3 = "Toronto";
    String expectedText4 = "Economy - Standard";
    String expectedText5 = "1 Adult";
    String expectedText6 = "Monday, May 17, 2021";
    String expectedText7 = "Montréal";
    String expectedText8 = "Economy - Standard";
    String expectedText9 = "1 Adult";
   Assert.assertEquals(actualText1, expectedText1);
   Assert.assertEquals(actualText2, expectedText2);
   Assert.assertEquals(actualText3, expectedText3);
   Assert.assertEquals(actualText4, expectedText4);
   Assert.assertEquals(actualText5, expectedText5);
   Assert.assertEquals(actualText6, expectedText6);
   Assert.assertEquals(actualText7, expectedText7);
   Assert.assertEquals(actualText8, expectedText8);
   Assert.assertEquals(actualText9, expectedText9);
}
/*
 * This will select continue as guest check if is displayed
 */
@Test(priority=11)
public void asGuest() {

	//click on box 'continue as guest'
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"submitAvailabilityCTAGuestButton\"]")))
	.click();

	//check if traveler information is displayed
    String actualText1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pageContent\"]/div[4]/app/div[2]/ac-passenger/div[2]/div/section/div/h1/span")))
    .getText();
    String expectedText1 = "Who’s travelling?";
   Assert.assertEquals(actualText1, expectedText1);
}
/*
 * This will type in all passenger's info boxes	
 */
@Test(priority=12)
public void passengerInfo() {

	//click on 'first name' and type in
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FIRST_NAME_0\"]")))
	.sendKeys("John");

	//click on 'middle name' and type in
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MIDDLE_NAME_0\"]")))
	.sendKeys("Marcs");

	//click on 'last name' and type in
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"LAST_NAME_0\"]")))
	.sendKeys("Paul");

	//click on day 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"DOB_DAY_0\"]/div")))
	.click();
	
	//click on day 8
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-option-11\"]/span")))
	.click();	
	
	//click on month
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"DOB_MONTH_0\"]/div")))
	.click();	
	
	//click on April
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-option-38\"]/span")))
	.click();	
	
	//click on year
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"DOB_YEAR_0\"]/div")))
	.click();	
	
	//click on 1990
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-option-62\"]/span")))
	.click();	
	
	//click on gender
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GENDER_0\"]/div")))
	.click();	
	
	//click on male
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-option-131\"]/span")))
	.click();	
	
	//click on loyalty program
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FREQUENT_FLYER_NUMBER_0\"]/div")))
	.click();	
	
	//click on None
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-option-3\"]/span")))
	.click();	

	//click on email
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"EMAIL_INPUT\"]")))
	.sendKeys("Paul24965@gmail.com");
	
	//click on phone number
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"PHONE_NUMBER\"]")))
	.sendKeys("2236641510");
	
	//click on continue
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"continue\"]")))
	.click();	
}
/*
 * This will click on continue on select a seat	
 */
@Test(priority=13)
public void selectSeat1() {

	//click on continue
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"continue_button\"]")))
	.click();	
}
/*
 * This will click on continue on select a seat	
 */
@Test(priority=14)
public void selectSeat2() {

	//click on continue
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"continue_button\"]")))
	.click();	
}
/*
 * This will click on continue
 */
@Test(priority=15)
public void selectSeat3() {

	//click on continue
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"seas-continue-button\"]")))
	.click();	
}
/*
 * This will check payment page
 */
@Test(priority=16)
public void paymentInfo() {

	//check if payment option is displayed
    String actualText1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"purcPayment\"]/div[2]/div[5]/div[1]/h2")))
    .getText();
    String expectedText1 = "Payment";
   Assert.assertEquals(actualText1, expectedText1);
}

}
