package seleniumProject;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Popup_Handling {

	public static void main(String[] args) throws IOException {
		
		
		//popup handling
		
		//website address
		String URL = "http://demo.guru99.com/test/delete_customer.php";	
		
		//Step 1: Connect Java code to Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		
		//Step 2: Invoke Selenium / Open browser
		WebDriver driver = new ChromeDriver();
		
		//maximize browser window
		driver.manage().window().maximize();
		
		//Go to URL
		driver.get(URL);
		
		//find box 'customer id' and type in
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("aaa");
		
		//click on 'submit'
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
		
		//switch to pop-up alert box and click ok/accept
		driver.switchTo().alert().accept();
		
		//close the window
		//driver.close();

	}

}
