package com.abc.assign;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DataRegisteration {

	
	@Test(dataProvider="Data", dataProviderClass=DataForRegistration.class)
	public void ValidCredentials(String user, String pwd) throws InterruptedException {
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.findElement(By.id("signin2")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("sign-username")).sendKeys(user);
		driver.findElement(By.id("sign-password")).sendKeys(pwd);
		Thread.sleep(2000);
		WebElement Login = driver.findElement(By.xpath("//button[@onclick='register()']"));
		Login.click();		
	}
}
