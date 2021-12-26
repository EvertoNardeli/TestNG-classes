package testNG;

import org.testng.annotations.DataProvider;

public class dataProviderExternal {


	@DataProvider(name = "loginCredentialsExternal")
	public Object[][] searchData() {
		return new Object[][] { 
			{ "test4", "pass4" },
			{ "test5", "pass5" }
		};
	}
	
}
