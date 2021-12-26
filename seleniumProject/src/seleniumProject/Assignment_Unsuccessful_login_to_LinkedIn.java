package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_Unsuccessful_login_to_LinkedIn {

	public static void main(String[] args) throws InterruptedException {
		
		
		//Connect Java code to Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		
		//Invoke Selenium / Open browser
		WebDriver driver = new ChromeDriver();
		
		// Go to URL
		driver.get("https://www.linkedin.com/home");
		
		//Find box 'sign in' and click on it
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		
		//wait 2 sec
		Thread.sleep(2000);
		
		//Find box 'email' and type in
		driver.findElement(By.xpath("/html/body/div/main/div[2]/div[1]/form/div[1]/input")).sendKeys("John_max@gmail.com");

		//Find box 'password' and type in
		driver.findElement(By.xpath("/html/body/div/main/div[2]/div[1]/form/div[2]/input")).sendKeys("vf678v@");

		//Find box 'sign in' and click on it
		driver.findElement(By.xpath("/html/body/div/main/div[2]/div[1]/form/div[3]/button")).click();
		

	}

}
