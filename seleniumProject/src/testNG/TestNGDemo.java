package testNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo {

	@BeforeMethod
	  public void beforeMethod() {
		  
		  //create the account
	  }

	  @BeforeTest
	  public void setup() {
		  //open browser
		  //go to url
	  }
	  
	  @Test
	  public void testAddToCart() {
		  //order the product
		  //Compare actual result vs expected result
	  }
	  
	  @AfterTest
	  
	  public void destroy() {
		  //close the browser
	  }
	  
	  @Test
	  public void testPayment() {
		  
	  }
	  
	  @Test
	  public void testOrderConfirmationEmail() {
		  Assert.fail();
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  
		  //delete the account
	  
	  }

	  

	  
	  @BeforeClass
	  public void beforeClass() {
	  }

	  @AfterClass
	  public void afterClass() {
	  }

	  @BeforeTest
	  public void beforeTest() {
	  }

	  @AfterTest
	  public void afterTest() {
	  }

	  @BeforeSuite
	  public void beforeSuite() {
	  }

	  @AfterSuite
	  public void afterSuite() {
	  }

	
}
