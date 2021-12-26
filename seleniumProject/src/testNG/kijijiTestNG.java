package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utility.Utility;

@Listeners(ListenerDemo.class)	 

	public class kijijiTestNG {
	
	    WebDriver driver;
	    WebDriverWait wait;

	 

	    @BeforeTest
		public void openBrowser() {
	    	
	    	//Connect Java code to Chrome browser
	    	System.setProperty(Utility.chromeDriver, Utility.chromePath);

	    	//Invoke Selenium / Open Browser
	    	driver = new ChromeDriver();

	    	//Declare wait object
	    	wait=new WebDriverWait(driver,15);

	    	//Maximize the window
	    	driver.manage().window().maximize();

	    	//Go to URL
	    	driver.get("https://www.kijiji.ca/?siteLocale=en_CA");

	    }	    

 /*
  * This is confirm if KijijiAuto logo is displayed	    
  */
	    
	    @Test(priority = 1) 
	    public void kjijiAutoLink() {
	    	
	    Boolean kijijiAuto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div/header/nav/div/div[1]/a"))).isDisplayed();

	  	System.out.println("KijijiAuto displayed: "+kijijiAuto);

	    }

 /*
 * This will click on jobs then graphic design and confirm whether the page is displayed
 */
	 	    
	    @Test(priority = 2) 
	    public void jobsGraficDesign() {
	    	
	    	//click on 'jobs' box
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div/header/nav/div/ul/li[4]/a")))
            .click();
	        
	        //click on drop down 'graphic & web design'
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cat-menu-item-152")))
            .click();
	    	
	        String actualText = wait
	                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/span[5]/h1")))
	                .getText();
	        String expectedText = "Graphic & Web Design in City of Montréal";
	       Assert.assertEquals(actualText, expectedText);

	    }

/*
 * This will click on available job 'senior designer' and confirm if is displayed	 
 */

	    @Test(priority = 3)
	    public void seniorDesigner() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div[3]/div[3]/div[3]/table[5]/tbody/tr/td[3]/a")))
	                .click();

	        String actualText = wait
	                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[5]/div[1]/div[1]/div/h1")))
	                .getText();
	        String expectedText = "Senior Designer";
	        Assert.assertEquals(actualText, expectedText);

	    }
	    
/*
 * This will click on 'show more' and confirm name of the company displayed
 */

	    @Test(priority = 4)
	    public void showMore() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[5]/div[2]/div[3]/button")))
	                .click();

	        String actualText = wait
	                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[5]/div[2]/div[2]/ul[1]/li/dl/dd")))
	                .getText();
	        String expectedText = "1VALET";
	        Assert.assertEquals(actualText, expectedText);

	    }

/*
 * 	This will get the job description and find the words: 'IBM, HTML, CSS, Deloitte, Selenium'  
 */
	         	    
	    @Test(priority = 5)
	    public void description() {
	    	
	    	String descrip = new String(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[5]/div[2]/div[3]/div[1]/div/div")))
	    	    	.getText());
	    	
	    System.out.println("Contain testIBM: "+descrip.contains("IBM"));
	    System.out.println("Contain testHTML: "+descrip.contains("HTML"));
	    System.out.println("Contain testCSS: "+descrip.contains("CSS"));
	    System.out.println("Contain testSFO: "+descrip.contains("SFO"));
	    System.out.println("Contain testDeloitte: "+descrip.contains("Deloitte"));
	    System.out.println("Contain testSelenium: "+descrip.contains("Selenium"));
	    }
	    
	    @AfterTest
	    public void close() {
	    	driver.close();
	    }
	    
	    
}
