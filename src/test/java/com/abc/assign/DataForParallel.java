package com.abc.assign;


import org.testng.annotations.DataProvider;

public class DataForParallel {
	
	@DataProvider(parallel=true)
	public Object[] TheData()
	{
//		Id for Items
		Object myData[][] = { {"standard_user", "secret_sauce","add-to-cart-sauce-labs-backpack"},{"standard_user", "secret_sauce","add-to-cart-sauce-labs-bike-light"}};
		
		return myData;	
	
	}
}
