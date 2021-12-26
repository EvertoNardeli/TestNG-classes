package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_JotForm_Checkbox_Radio {

	public static void main(String[] args) throws InterruptedException {
		
		
		//Step 1: Connect Java code to Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		
		//Step 2: Invoke Selenium / Open browser
		WebDriver driver = new ChromeDriver();
		
		//Step 3: Go to URL
		driver.get("https://www.jotform.com/build/210837653960259");
		
		//select check box 'product t-shirt'
		WebElement box1 = driver.findElement(By.xpath("/html/body/form/div[1]/ul/li[2]/div/div/div/div[3]/span[1]/div/div[1]/div/input"));
		box1.click();
	
		//verify if checkbox is checked or not
		boolean res1= box1.isSelected();
		System.out.println(res1);
		
		//find drop down 'quantity' and select one option
		Select quan = new Select(driver.findElement(By.xpath("/html/body/form/div[1]/ul/li[2]/div/div/div/div[3]/span[1]/div/div[3]/span[2]/span/select")));
		quan.selectByValue("2");

		//find drop down 'color' and select one option
		Select color = new Select(driver.findElement(By.xpath("/html/body/form/div[1]/ul/li[2]/div/div/div/div[3]/span[1]/div/div[3]/span[3]/span/select")));
		color.selectByValue("Grey");

		//find drop down 'size' and select one option
		Select size = new Select(driver.findElement(By.xpath("/html/body/form/div[1]/ul/li[2]/div/div/div/div[3]/span[1]/div/div[3]/span[4]/span/select")));
		size.selectByValue("XL");

		//create and execute javascript to scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		//find box 'first name' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/span[1]/input[1]")).sendKeys("John");
		
		//find box 'last name' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/span[2]/input[1]")).sendKeys("Mcain");
		
		//find box 'e-mail' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[4]/div[1]/span[1]/input[1]")).sendKeys("J.mcain@gmail.com");
		
		//find box 'contact number' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[5]/div[1]/span[1]/input[1]")).sendKeys("4382225858");
		
		//find box 'street address' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[6]/div[1]/div[1]/div[1]/span[1]/span[1]/input[1]")).sendKeys("2222 avenue west");
		
		//find box 'street address line 2' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[6]/div[1]/div[1]/div[2]/span[1]/span[1]/input[1]")).sendKeys("ap 32");
		
		//find box 'city' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[6]/div[1]/div[1]/div[3]/span[1]/span[1]/input[1]")).sendKeys("Ottawa");
		
		//find box 'state' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[6]/div[1]/div[1]/div[3]/span[2]/span[1]/input[1]")).sendKeys("Ontario");
		
		//find box 'postal code' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[6]/div[1]/div[1]/div[4]/span[1]/span[1]/input[1]")).sendKeys("H7Y8I9");
		
		//find drop down 'country' and select an option
		Select country = new Select(driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[6]/div[1]/div[1]/div[4]/span[2]/span[1]/select[1]")));
		country.selectByValue("Canada");
		
		//execute javascript to scroll down
		js.executeScript("window.scrollBy(0,500)");
		
		//find and select check box 'shipping address same as billing?'
		WebElement box2 = driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[7]/div[1]/div[1]/span[1]/label[1]"));
		box2.click();
		
		//find and select check box 'send gift?'
		WebElement box3 = driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[9]/div[1]/div[1]/span[1]/label[1]"));
		box3.click();
		
		//wait 2 seconds
		Thread.sleep(2000);
		
		//verify if checkbox 'shipping address same as billing?' is checked or not
		boolean res2 = box2.isSelected();
		System.out.println(res2);  /**********************returning wrong false result, box is checked******************/
		
		//verify if checkbox 'send gift?' is checked or not
		boolean res3 = box3.isSelected();
		System.out.println(res3);    /**********************returning wrong false result, box is checked******************/
		
		//find box 'first name' where 'send gift' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[10]/div[1]/div[1]/span[1]/input[1]")).sendKeys("Suzan");
		
		//find box 'last name' where 'send gift' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[10]/div[1]/div[1]/span[2]/input[1]")).sendKeys("Holis");
		
		//find box 'gift message' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[11]/div[1]/textarea[1]")).sendKeys("HappyBirthday");
		
		//execute javascript to scroll down
		js.executeScript("window.scrollBy(0,500)");
		
		//find box 'special instructions' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[12]/div[1]/textarea[1]")).sendKeys("Note");
		
		//find check box 'payment methods' and select 'debit'
		WebElement box4 = driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[13]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]"));
		box4.click();
		
		//wait 2 seconds
		Thread.sleep(2000);
		
		//execute javascript to scroll down
		js.executeScript("window.scrollBy(0,500)");
		
		
		//find box 'first name' on 'payment methods' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[13]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/span[1]/input[1]")).sendKeys("John");
		
		//find box 'last name' on 'payment methods' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[13]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/input[1]")).sendKeys("Mcain");
		
		//find box 'credit card number' on 'payment methods' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[13]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/span[1]/div[1]"));
		/*******************box not interactive, not possible insert value********************/
		
		//find box 'security code' on 'payment methods' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[13]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/span[1]/div[1]"));
		/*******************box not interactive, not possible insert value********************/		
		
		//find box 'card expiration' on 'payment methods' and type in
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/ul[1]/li[13]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[1]/span[1]/div[1]"));
		/*******************box not interactive, not possible insert value********************/		
			
	}

}
