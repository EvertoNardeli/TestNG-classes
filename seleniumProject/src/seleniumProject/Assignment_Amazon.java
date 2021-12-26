package seleniumProject;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Assignment_Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		//Step 1: Connect Java code to Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		
		//Step 2: Invoke Selenium / Open browser
		WebDriver driver = new ChromeDriver();
		
		//Step 3: Go to URL
		driver.get("https://www.amazon.ca/");
		
		//find on Head 'hello, sign in' and click on it
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[3]/div[1]/a[2]/div[1]/span[1]")).click();
		
		//wait 2 seconds
		Thread.sleep(2000);	
		
		//find box 'e-mail address' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("aaaaaa");
		
		//find box 'continue' and click on it
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/span[1]/span[1]/input[1]")).click();
		
		//wait 2 seconds
		Thread.sleep(2000);

		//take screenshot
		File scrShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrShot, new File ("error.jpeg"));
		
		//find box 'create your amazon account' and click on it
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[1]/span[1]/a[1]")).click();
		
		//wait 2 seconds
		Thread.sleep(2000);
		
		//find box 'your name' and click on it
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("aaaaaa");
		
		//find box 'email' and click on it
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys("aaaaa");

		//find box 'password' and click on it
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/input[1]")).sendKeys("aaaaa");

		//find box 'password again' and click on it
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[3]/div[2]/input[1]")).sendKeys("aaaaaa");

		//find box 'create your amazon account' and click on it
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[4]/span[1]/span[1]/input[1]")).click();
	
		//take screenshot
		File scrShot2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrShot2, new File ("error2.jpeg"));
	
		
		/*
		 //another way to take screenshot
		 TakesScreenshot ts=(TakesScreenshot)driver;   // create reference of takesscreenshot
		 File source=ts.getScreenshotAs(OutputType.FILE);   // call method to capture screenshot
		 FileHandler.copy(source, new File("C://Screenshot/test.png"));		// copy the file to a location
		 */
		
		//get current date and time
		//LocalDateTime now = LocalDateTime.now();
		
		
		
	}
}
