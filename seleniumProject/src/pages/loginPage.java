package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	WebDriver loginDriver;
	public static String chromeDriver = "webdriver.chrome.driver";
	public static String chromePath = "C:\\Selenium\\chromedriver_win32\\chromedriver.exe";
	public static String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	
	/*TextBoxes*/
	
	By createEmail = By.id("email_create");
	By registeredEmail = By.id("email");
	By registeredPass = By.id("passwd");
	
	/*Buttons*/
	
	By createAccountButton = By.id("SubmitCreate");
	By signInButton = By.id("SubmitLogin");
	
	/*Methods*/
	
	public loginPage(WebDriver driver) {
		loginDriver = driver;
	}
	
	public void enterUsername(String uname) {
		loginDriver.findElement(registeredEmail).sendKeys(uname);
	}
	
	public void enterPassword(String pwd) {
		loginDriver.findElement(registeredPass).sendKeys(pwd);
	}
	
	public void clickSignin() {
		loginDriver.findElement(signInButton).click();
	}
	
	public void signIn(String username,String password) {
		enterUsername(username);
		enterPassword(password);
		clickSignin();
	}
	
}
