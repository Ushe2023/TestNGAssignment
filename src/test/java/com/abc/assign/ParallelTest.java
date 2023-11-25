package com.abc.assign;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelTest {

	@Test(dataProvider = "TheData", dataProviderClass = DataForParallel.class)
	public class AddItem {
		public void ValidCredentials(String email, String pwd,String id) throws InterruptedException {
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com");
			driver.findElement(By.id("user-name")).sendKeys(email);
			driver.findElement(By.id("password")).sendKeys(pwd);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.id(id)).click();
			driver.findElement(By.id("shopping_cart_container")).click();
			driver.close();

}
	}
}
