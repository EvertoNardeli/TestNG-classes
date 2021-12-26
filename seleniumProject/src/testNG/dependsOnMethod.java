package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Utility;

public class dependsOnMethod {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void openBrowser() {

		System.setProperty(Utility.chromeDriver, Utility.chromePath);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
		driver.get("https://www.kijiji.ca/?siteLocale=en_CA");
	}
	/*
	 * This will click on jobs then graphic design and confirm whether the page is
	 * displayed
	 */

	@Test
	public void jobsGraficDesign() {

		// click on 'jobs' box
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div/header/nav/div/ul/li[4]/a")))
				.click();
	}

	/*
	 * This will click on available job 'senior designer' and confirm if is
	 * displayed
	 */

	@Test(dependsOnMethods= {"jobsGraficDesign"}, alwaysRun=true) // depends On means another method need to be executed first
	public void seniorDesigner() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[3]/div[3]/div[3]/div[3]/div[3]/table[5]/tbody/tr/td[3]/a"))).click();
	}
}
