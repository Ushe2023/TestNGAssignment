package com.abc.assign;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTOSwab {
	


ChromeDriver driver= new ChromeDriver();
@Test
public void ValidCredentials() throws InterruptedException {

	driver.get("https://www.saucedemo.com");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	driver.findElement(By.id("shopping_cart_container")).click();
//	driver.close();

}
}