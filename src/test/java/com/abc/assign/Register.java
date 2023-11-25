package com.abc.assign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Register {
	ChromeDriver driver = new ChromeDriver();
	@Test
	public void details()
	{
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("test1");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("test.last1");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test.last2@gmail.com");
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("23456789012");
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("23456789012");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Welcome@123");
		driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("Welcome@123");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String message=	driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
	
		if(message.equals("Your Account Has Been Created!")) {
			System.out.println(message);
		}
		
	}
	

}
