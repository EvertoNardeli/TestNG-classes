package testNG;

import org.testng.annotations.DataProvider;

public class dataProviderGoogleExternal {

	@DataProvider(name = "externalSearch")
	public Object[][] searchData() {
		return new Object[][] { 
			{ "Sao Paulo" }, 
			{ "Rio de Janeiro" }, 
			{ "Maceio" },
		};
	}
	
	
}
