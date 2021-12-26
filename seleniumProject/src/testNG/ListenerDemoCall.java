package testNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerDemo.class)


public class ListenerDemoCall {
	
	@Test
	public void testPass () {
		int a = 5;
		int b = 10;
		int sum = a+b;
		Assert.assertEquals(15, sum);
	}

	
	
	
}
