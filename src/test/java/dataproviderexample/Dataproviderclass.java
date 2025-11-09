package dataproviderexample;

import org.testng.annotations.DataProvider;

public class Dataproviderclass {

	@DataProvider(name="LoginData")
	public Object [][] provideLoginData(){
		return new Object [][] {
			{ "standard_user", "secret_sauce" },
            { "locked_out_user", "secret_sauce" },
            { "problem_user", "secret_sauce" }
		};
	}
	
}
