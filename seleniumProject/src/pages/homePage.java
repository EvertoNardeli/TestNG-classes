package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
	
	WebDriver homePageDriver;
	public static String chromeDriver = "webdriver.chrome.driver";
	public static String chromePath = "C:\\Selenium\\chromedriver_win32\\chromedriver.exe";
	public static String URL = "http://automationpractice.com/index.php";

	/*TextBoxes*/
	
	By searchingBox = By.id("search_query_top");
	By ClickSearchingBox = By.xpath("//*[@id=\"searchbox\"]/button");
	
	/*Buttons*/
	
	By signInButton = By.className("login");
	By contactUsButton = By.id("contact-link");
	By cartButton = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");
	By womenButton = By.linkText("Women");
	By dressesButton = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
	By tShirtsButton = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a");
	
	/*Methods*/
	
	public homePage(WebDriver driver) {
		homePageDriver = driver;
	}
	
	public void search(String string) {
		homePageDriver.findElement(searchingBox).sendKeys(string);
	}
	
	public void searchClick() {
		homePageDriver.findElement(ClickSearchingBox).click();
	}
	
	public void signIn() {
		homePageDriver.findElement(signInButton).click();
	}
	
	public void contactUs() {
		homePageDriver.findElement(contactUsButton).click();
	}
	
	public void cart() {
		homePageDriver.findElement(cartButton).click();
	}
	
	public void women() {
		homePageDriver.findElement(womenButton).click();
	}
	
	public void dresses() {
		homePageDriver.findElement(dressesButton).click();
	}
	
	public void tshirt() {
		homePageDriver.findElement(tShirtsButton).click();
	}
}
