package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1_Jotform {

	public static void main(String[] args) {
		
		//Connect Java code to Chrome browser
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
				
				//Invoke Selenium / Open browser
				WebDriver driver = new ChromeDriver();
				
				// Go to URL
				driver.get("https://form.jotform.com/210817683634258");
				
				//Find box 'first name' and type in
				driver.findElement(By.xpath("/html/body/form/div[1]/ul/li[2]/div/div/span[1]/input")).sendKeys("John");
				
				//Find box 'middle name' and type in
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/span[2]/input[1]")).sendKeys("Max");
						
				//Find box 'last name' and type in
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/span[3]/input[1]")).sendKeys("Albert");
				
				//Find drop down birth date 'Month' and select one option.
				Select Month = new Select(driver.findElement(By.xpath("/html/body/form/div[1]/ul/li[3]/div/div/span[1]/select")));
				Month.selectByIndex(11);
				
				//Find drop down birth date 'Day' and select one option.
				Select Day = new Select(driver.findElement(By.xpath("/html/body/form/div[1]/ul/li[3]/div/div/span[2]/select")));
				Day.selectByIndex(20);

				//Find drop down birth date 'Year' and select one option.
				Select Year = new Select(driver.findElement(By.xpath("/html/body/form/div[1]/ul/li[3]/div/div/span[3]/select")));
				Year.selectByValue("1980");
				
				//Find drop down 'Gender' and select one option.
				Select Gender = new Select(driver.findElement(By.xpath("/html/body/form/div[1]/ul/li[4]/div/select")));
				Gender.selectByValue("Male");
				
				//Find box 'address' and type in
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[5]/div[1]/div[1]/div[1]/span[1]/span[1]/input[1]")).sendKeys("3412 Avenue Oest");
				
				//Find box 'address line 2' and type in
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[5]/div[1]/div[1]/div[2]/span[1]/span[1]/input[1]")).sendKeys("apt 21");
				
				//Find box 'city' and type in
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[5]/div[1]/div[1]/div[3]/span[1]/span[1]/input[1]")).sendKeys("Montreal");

				//Find box 'state' and type in
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[5]/div[1]/div[1]/div[3]/span[2]/span[1]/input[1]")).sendKeys("Quebec");
				
				//Find box 'postal code' and type in
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[5]/div[1]/div[1]/div[4]/span[1]/span[1]/input[1]")).sendKeys("H4V7Y6");
				
				//Find box 'student email' and type in
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[6]/div[1]/span[1]/input[1]")).sendKeys("John_max@gmail.com");
				
				//Find box 'mobile number' and type in
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[7]/div[1]/span[1]/input[1]")).sendKeys("5142223669");
				
				//Find box 'phone number' and type in
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[8]/div[1]/span[1]/input[1]")).sendKeys("5142224152");
				
				//Find box 'work number' and type in
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[9]/div[1]/span[1]/input[1]")).sendKeys("5142227485");
				
				//Find box 'company' and type in
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[10]/div[1]/input[1]")).sendKeys("MCIT");
				
				//Find drop down 'Courses' and select one option
				Select Courses = new Select(driver.findElement(By.xpath("/html/body/form/div[1]/ul/li[11]/div/select")));
				Courses.selectByValue("Windows 8");
				
				//Find box 'additional comments' and type in
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[12]/div[1]/textarea[1]")).sendKeys("New student");
				
		
	}

}
