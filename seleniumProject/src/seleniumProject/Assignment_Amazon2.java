package seleniumProject;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Utility.Utility;

public class Assignment_Amazon2 {

	public static void main(String[] args) throws InterruptedException, IOException {

		String URL = "https://www.amazon.ca/";
		
		//Step 1: Connect Java code to Chrome browser
		System.setProperty(Utility.chromeDriver, Utility.chromePath);
		
		//Step 2: Invoke Selenium / Open browser
		WebDriver driver = new ChromeDriver();
		
		//maximize browser window
		driver.manage().window().maximize();
		
		//Step 3: Go to URL
		driver.get(URL);
		
		//find categories 'all' and click on it
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[4]/div[1]/a[1]/i[1]")).click();
		
		//wait 1 sec
		Thread.sleep(1000);
		
		//click on category 'fire tablets'
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/ul[1]/li[8]/a[1]")).click();
		
		//wait 1 sec
		Thread.sleep(1000);
		
		//click on categorie 'fire 7'
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/ul[3]/li[3]/a")).click();
	
		//wait 2 sec
		Thread.sleep(2000);
		
		//find and click to change storage capacity of item
		driver.findElement(By.tagName("button")).click();
		
		//wait 2 sec
		Thread.sleep(2000);
		
		//find drop down 'change the quantity' and click on it
		Select qa = new Select(driver.findElement(By.name("quantity")));
		qa.selectByValue("2");
		
		//take screenshot
		Utility.takescreenshot(driver);
		
		//wait 1 sec
		Thread.sleep(1000);
		
		//find box 'add to cart' and click on it
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//wait 1 sec
		Thread.sleep(1000);
		
		//get and print quantity in the cart 
		WebElement getquant1 = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]"));
		System.out.println(getquant1.getText());	//result: Cart subtotal (2 items):
		
		//take screenshot
		Utility.takescreenshot(driver);
		
		//find box 'cart' and click on it
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/div[1]/div/div/div[4]/div/div/div/span[1]/span/span/a")).click();
		
		//get and print quantity in drop down
		WebElement getquant2 = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div[7]/div/div[2]/div[2]/div/form/div[2]/div[3]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[1]/span/span[1]/span/span/span/span"));
		System.out.println(getquant2.getText());	//result: Qty: 2
		
		//get and print total price on screen box 'subtotal' 
		WebElement getquant3 = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div[7]/div/div[2]/div[2]/div/form/div[3]/span[2]/span"));
		System.out.println(getquant3.getText());	//result: $139.98
		
		//take screenshot
		Utility.takescreenshot(driver);
		
	}
	
}
