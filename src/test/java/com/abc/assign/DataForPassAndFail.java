package com.abc.assign;

import org.testng.annotations.DataProvider;

public class DataForPassAndFail {
	
	@DataProvider(parallel = true)
	public Object[][] TheData()
	{
//		ID of password and password
		Object myData[][] = { {"password", "secret_sauce"}, {"pwd", "secret_sauce"}, 
				{"password", "Welcome@1234"}};
		
		return myData;	
	
	}
}
