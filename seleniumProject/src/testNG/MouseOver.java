package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.Utility;

public class MouseOver {

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	
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
		
		
		//declare wait object
		wait = new WebDriverWait(driver,15);
		
		//declare action object
		builder = new Actions(driver);
		
		//maximize the window
		driver.manage().window().maximize();
		
		//go to URL
		driver.get("http://demo.guru99.com/test/newtours/");
	}
/*
 * 	This will get color of 'home' button
 */
	@Test(priority=1)
	public void beforeMouseOver() {
		
		//Get identifier for box next to homebutton
		WebElement homeButton = driver.findElement(By.xpath("//html/body/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr"));
	
		//Before color
		String beforeColor = homeButton.getCssValue("background-color"); //yellow
			
		System.out.println("Before: " + beforeColor);
		
	}
/*
 * This will bring mouse cursor over 'home' button and get color
 */
	@Test(priority=2)
	public void afterMouseOver() {
		
		//Get identifier for Home link button
		WebElement homeLink = driver.findElement(By.linkText("Home"));

		//Define our first action
		Action mouseOver = builder
						.moveToElement(homeLink)
						.build();
		
		//perform the mouse action
		mouseOver.perform();
		
		//Get identifier for box next to homebutton
		WebElement homeButton = driver.findElement(By.xpath("//html/body/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr"));
	
		//After color
		String afterColor = homeButton.getCssValue("background-color"); //blue
		
		System.out.println("After: " + afterColor);
		
	}
/*
 * This will bring mouse cursor over 'sign-on' and click
 */
	@Test(priority=3)
	public void signOn() {
		
		//find button 'signOn'
		WebElement signOn = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a"));
		
		//define mouse action
		Action mouseOver = builder
				.moveToElement(signOn)
				.click()
				.build();
		/*
		.sendKeys("hello")
		.keyUp(Keys.SHIFT) //release the shift key
		.doubleClick()
		.contextClick()   //right click
		*/
		
		//perform the mouse action
		mouseOver.perform();
		
	}
	
	
	
}
