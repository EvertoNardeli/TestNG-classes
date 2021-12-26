package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import pages.homePage;
import pages.loginPage;

public class homePageTest {
	
	WebDriver driver;
	homePage homePage;
	loginPage loginpage;
	

	@BeforeMethod
	public void setup() {
		System.setProperty(Utility.Utility.chromeDriver, Utility.Utility.chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePage = new homePage(driver);
		loginpage = new loginPage(driver);
		driver.get("http://automationpractice.com/index.php");
	}
	@Ignore
	@Test
	public void testSearchBox() {
		homePage.search("summer");
		homePage.searchClick();
		
		String actualText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText();
		String expectedText = "\"SUMMER\"";
		Assert.assertEquals(actualText, expectedText);
		
		driver.close();
	}

	@Test
	public void testSignInButtom() {
		homePage.signIn();
		loginpage.enterUsername("everton");
		loginpage.enterPassword("123abc");
		/*
		String actualText = driver.findElement(By.xpath("")).getText();
		String expectedText = "";
		Assert.assertEquals(actualText, expectedText);
		*/
		
	}
	@Ignore
	@Test
	public void testContactUsButtom() {
		homePage.contactUs();
		
		String actualText = driver.findElement(By.xpath("")).getText();
		String expectedText = "";
		Assert.assertEquals(actualText, expectedText);
		
		driver.close();
	}
	@Ignore
	@Test
	public void testCartButtom() {
		homePage.cart();
		
		String actualText = driver.findElement(By.xpath("")).getText();
		String expectedText = "";
		Assert.assertEquals(actualText, expectedText);
		
		driver.close();
	}
	@Ignore
	@Test
	public void testWomenButtom() {
		homePage.women();
		
		String actualText = driver.findElement(By.xpath("")).getText();
		String expectedText = "";
		Assert.assertEquals(actualText, expectedText);
		
		driver.close();
	}
	@Ignore
	@Test
	public void testDressesButtom() {
		homePage.dresses();
		
		String actualText = driver.findElement(By.xpath("")).getText();
		String expectedText = "";
		Assert.assertEquals(actualText, expectedText);
		
		driver.close();
	}
	@Ignore
	@Test
	public void testTshirtButtom() {
		homePage.tshirt();
		
		String actualText = driver.findElement(By.xpath("")).getText();
		String expectedText = "";
		Assert.assertEquals(actualText, expectedText);
		
		driver.close();
	}
}
