package com.abc.assign;

import org.testng.annotations.DataProvider;

public class DataForRegistration {
	
	@DataProvider
	public Object[][] Data()
	{
//		User name and pwd
		Object myData[][] = { {"Rama@gmail.com", "secret"}, {"sfsdf23@gmail.com", "popular"}};
		
		return myData;	
	
	}
}
