package com.abc.assign2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners(MyListener12.class)
public class DataLogin {
	@DataProvider//(parallel=true)
	public Object[][] Mydata()
			{
		Object[][] MYdata= {
				{"test.last2@gmail.com","Welcome@123"},
			};
		return MYdata;
			}
}



/*{"input-email","test.last2@gmail.com","input-password","Welcome@123"},
{"input-email","test.last2@gmail","input-password","Welcome@123"},
{"input-email","test.last2@gmail.com","input-password","Welcome@123"},*/