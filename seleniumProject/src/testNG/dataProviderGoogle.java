package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Utility;

public class dataProviderGoogle {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void accessPage() {

		// Connect Java code to Chrome browser
		System.setProperty(Utility.chromeDriver, Utility.chromePath);

		// Invoke Selenium / Open Browser
		driver = new ChromeDriver();

		// Declare wait object
		wait = new WebDriverWait(driver, 10);

		// Maximize the window
		driver.manage().window().maximize();

		// Go to URL
		driver.get("https://www.google.com");
	}

	/*
	 * this function provides the data
	 */

	@DataProvider(name = "internalSearch")
	public Object[][] searchData() throws InterruptedException {
		return new Object[][] { { "Los Angeles" }, { "Chicago" }, { "San Diego" }, };
	}
	/*
	 * this function uses the data
	 */

	@Test(priority = 0, dataProvider = "internalSearch")
	public void searchCity(String city) throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(city); // send the name of the city provided on above method
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER); // send key 'Enter'
		driver.findElement(By.name("q")).clear(); // clear the name of the city on the search box

		// this will get the page title and compare if it is displayed correctly
		String actualTitle = driver.getTitle();
		String expectedTitle = city + " - Google Search";
		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(1500);	
	}
	/*
	 * Thiss will use external data provider
	 */

	@Test(priority = 0, dataProvider = "externalSearch", dataProviderClass = dataProviderGoogleExternal.class)
	public void searchCityExternal(String city) throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(city); // send the name of the city provided on above method
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER); // send key 'Enter'
		driver.findElement(By.name("q")).clear(); // clear the name of the city on the search box

		// this will get the page title and compare if it is displayed correctly
		String actualTitle = driver.getTitle();
		String expectedTitle = city + " - Google Search";
		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(1500);

	}
	/*
	 * This will check if cities from data provider contain in a determined web page
	 */
	@Test(dataProvider = "internalSearch")
	public void usaCitiesInternal(String city) throws InterruptedException {

		driver.get("https://en.wikipedia.org/wiki/List_of_United_States_cities_by_population");
		String cities = new String(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mw-content-text"))).getText());

		System.out.println("Contains Los Angeles, Chicago, San Diego :" + cities.contains(city));

	}
	/*
	 * This will check if cities from data provider contain in a determined web page
	 */
	@Test(dataProvider = "externalSearch", dataProviderClass = dataProviderGoogleExternal.class)
	public void usaCitiesExternal(String city) throws InterruptedException {
		
		driver.get("https://en.wikipedia.org/wiki/List_of_United_States_cities_by_population");
		String cities = new String(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mw-content-text"))).getText());

		System.out.println("Contains Sao Paulo, Rio de Janeiro, Maceio :" + cities.contains(city));

	}
}
