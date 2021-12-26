package seleniumProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.Utility;

public class Try_catch {

	public static void main(String[] args) {
		
		String URL = "https://www.cinemamontreal.com/eng";
		
		//connect java to chrome browser
		System.setProperty(Utility.chromeDriver, Utility.chromePath);
		
		//invoke selenium; open browser
		WebDriver driver = new ChromeDriver();
		
		//maximize browser
		driver.manage().window().maximize();
		
		//go to url
		driver.get(URL);
		
		//implicit timeout
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		

		try {			
			//find box 'choose a cinema' and access by SendKey'Enter'
			driver.findElement(By.id("headoptions")).sendKeys(Keys.ENTER);
		}
		catch(Exception e) {
			//find box 'choose a movie'
			driver.findElement(By.xpath("/html/body/div[17]/div[2]/a[2]")).click();
		}
		finally {
			System.out.println("couldn't access by SendKey'Enter'");
		}
		

		
	}

}
