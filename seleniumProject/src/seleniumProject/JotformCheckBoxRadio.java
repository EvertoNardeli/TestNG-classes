package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JotformCheckBoxRadio {

	public static void main(String[] args) {
		
		//Step 1: Connect Java code to Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		
		//Step 2: Invoke Selenium / Open browser
		WebDriver driver = new ChromeDriver();
		
		//Step 3: Go to URL
		driver.get("https://www.jotform.com/build/210837653960259");
		
		//select check box 1
		WebElement box = driver.findElement(By.xpath("/html/body/form/div[1]/ul/li[2]/div/div/div/div[3]/span[1]/div/div[1]/div/input"));
		box.click();
		
		//verify that checkbox is checked or not
		Boolean result = box.isSelected();
		System.out.println(result); // returns 'True'
		
		//uncheck the checkbox
		box.click();
		System.out.println(box.isSelected()); // returns 'false'	
		
		//create and execute javascript object to scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		//find checkbox 'send gift' and click on it.
		WebElement gift = driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[9]/div[1]/div[1]/span[2]/label[1]"));
		gift.click();
		
		//execute javascript object to scroll up
		//js.executeScript("window.scrollBy(0,-2000)");

		
		
		
		
		
		
	}

}
