package seleniumProject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.Utility;


public class FindElements {

	public static void main(String[] args) {
		
		
		
		//Step 1: Connect Java code to Chrome browser
		System.setProperty(Utility.chromeDriver, Utility.chromePath);
		
		//Step 2: Invoke Selenium / Open browser
		WebDriver driver = new ChromeDriver();
		
		//maximize browser window
		driver.manage().window().maximize();
		
		
		/*
		driver.get("http://demo.guru99.com/test/ajax.html");
		
		List<WebElement> elements = driver.findElements(By.name("name"));
	    System.out.println("Number of elements:" +elements.size());

	    for (int i=0; i<elements.size();i++){
	      System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
	    }
	    */
		
		driver.get("http://amazon.com");
		
	    //List is necessary because FindElements returns multiple variables; returned values are stored as a List;
		
		//capture all inputs on the webpage; handling multiple elements;
	    List<WebElement> inputs = driver.findElements(By.tagName("input"));
	    
	    for (WebElement we : inputs) {
	    	System.out.println(we.toString());
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}

}
