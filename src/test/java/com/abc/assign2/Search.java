package com.abc.assign2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Listeners(MyListener12.class)
public class Search {
	ChromeDriver driver = new ChromeDriver();
@Parameters({"Username","Password","Item"})
@Test
	public void search(String Username, String Password,String item) {
	
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://tutorialsninja.com/demo/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[@title='My Account']")).click();
	driver.findElement(By.xpath("//a[text()='Login']")).click();
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Username);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	
	driver.findElement(By.xpath("//input[@name='search']")).sendKeys(item);
	driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//a[text()='iPod Shuffle']")).click();
	
	
	driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
	System.out.println("Item added successfully");
	driver.findElement(By.xpath("//span[@id='cart-total']")).click();
	driver.findElement(By.xpath("//span[text()='Checkout']")).click();
}
@AfterTest
	public void checkout(){
	try {
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("test");
	}
		catch(ElementNotInteractableException e)
		{
			driver.findElement(By.xpath("//label[text()='I want to use a new address']")).click();
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("last");
		driver.findElement(By.xpath("//input[@name='address_1']")).sendKeys("Hennur");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("560010");
		WebElement DropDwon= driver.findElement(By.id("input-payment-country"));
		Select  Country= new Select(DropDwon);
		Country.selectByValue("222");
		
		Select State = new Select(driver.findElement(By.id("input-payment-zone")));
		State.selectByValue("3513");
		driver.findElement(By.id("button-payment-address")).click();
		driver.findElement(By.id("button-shipping-address")).click();
		driver.findElement(By.id("button-shipping-method")).click();
		
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.id("button-payment-method")).click();
		
		driver.findElement(By.id("button-confirm")).click();
		
	}
	
}}

