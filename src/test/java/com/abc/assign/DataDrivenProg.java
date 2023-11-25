package com.abc.assign;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


@Test(dataProvider = "TheData", dataProviderClass = DataDriven.class)
public class DataDrivenProg {
	public void ValidCredentials(String User,String Password) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys(User);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("login-button")).click();
		driver.close();
		
	}
}
