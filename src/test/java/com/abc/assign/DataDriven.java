package com.abc.assign;

import org.testng.annotations.DataProvider;

public class DataDriven {
	
	@DataProvider
	public Object[][] TheData()
	{
//		User name and pwd
		Object myData[][] = { {"standard_user", "secret_sauce"}, {"sfsdf23@gmail.com", "secret_sauce"}, 
				{"standard_user", "Welcome@1234"}, {"oeih", "kjvn"} };
		
		return myData;	
	
	}
}
