package Utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static String chromeDriver = "webdriver.chrome.driver";
	public static String chromePath = "C:\\Selenium\\chromedriver_win32\\chromedriver.exe";
	public static String edgeDriver = "webdriver.edge.driver";
	public static String edgePath = "C:\\Selenium\\edgedriverx64\\msedgedriver.exe";

			public static void takescreenshot(WebDriver driver) throws IOException{
			//Create a custom date time format
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH_mm_ss");

			//Get current date and time
			LocalDateTime currentTime = LocalDateTime.now();

			// Create an object 'ts' from class TakesScreenshot
			TakesScreenshot ts=(TakesScreenshot)driver;

			// Call method to capture screenshot
			File source = ts.getScreenshotAs(OutputType.FILE);

			// Copy the file to a location
			FileHandler.copy(source, new File("C://Screenshots//"+(dtf.format(currentTime))+".png"));

	}

}