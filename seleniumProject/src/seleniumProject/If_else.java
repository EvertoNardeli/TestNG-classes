package seleniumProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.Utility;

public class If_else {

	public static void main(String[] args) {
		
		String URL = "https://www.opensubtitles.org/en/search/subs";
		
		//Step 1: Connect Java code to Chrome browser
		System.setProperty(Utility.chromeDriver, Utility.chromePath);
		
		//Step 2: Invoke Selenium / Open browser
		WebDriver driver = new ChromeDriver();
		
		//maximize browser window
		driver.manage().window().maximize();
		
		//Step 3: Go to URL
		driver.get(URL);
		
		//implicit timeout; remove the necessity of thread.sleep; this case wait time is at most 3 seconds.
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		//find box 'advanced search' and click on it
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/a")).click();
			
		//find webElement 'search only in movies' and get text
		String oly = driver.findElement(By.xpath("/html/body/div[1]/div[7]/form/div[2]/fieldset[1]/table/tbody/tr[1]/td[1]")).getText();
		
		// clickable webElement 'search only in movies'
		WebElement clk = driver.findElement(By.xpath("/html/body/div[1]/div[7]/form/div[2]/fieldset[1]/table/tbody/tr[1]/td[2]/input"));
		
		if(oly.equals("Search only in Movies:")) {
			clk.click();
		}
		else {
			//click on 'upload' box
			driver.findElement(By.xpath("//*[@id=\"subtitles_body\"]/div[1]/div[4]/ul/li[3]/a")).click();
		}
		
		

	}

}
