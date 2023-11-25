package com.abc.assign;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Snapshot {
	ExtentReports extentReports;
//	=new ExtentReports();
	
	
	@BeforeTest
	public void createReport() {
		extentReports=new ExtentReports();
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./MyReport/Assign");
		extentReports.attachReporter(extentSparkReporter);
		
	}
	@AfterTest
	public void push() {
		extentReports.flush();
	}

//	@Test(dataProvider = "TheData", dataProviderClass = DataForParallel.class)
	@Test
	public class AddItem {
		public void ValidCredentials() throws InterruptedException, IOException {
			ChromeDriver driver = new ChromeDriver();
			
			System.out.println("Opening the browser");
			ExtentTest extentTest = extentReports.createTest("This is my e-commerce report");
			extentTest.assignAuthor("Ushe");
			extentTest.assignDevice("Windows"+"Chrome");
			extentTest.assignCategory("Functional Test");
			
			extentTest.log(Status.INFO,"Logging to the Website");
			driver.get("https://www.saucedemo.com");
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			extentTest.log(Status.INFO,"UserName Entered");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			extentTest.log(Status.INFO,"Password Entered");
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(3000);
			System.out.println("Logged in");
			
			driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
			extentTest.log(Status.INFO,"Selected the item");
			driver.findElement(By.id("shopping_cart_container")).click();
			
			System.out.println("Item added");
			File Image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File Destination= new File("./Screenshot/Item.png");
			FileUtils.copyFile(Image, Destination);
			
			extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/TestNGAssigment/Screenshot/Item.png", "Item Present");
			driver.close();
			extentTest.log(Status.INFO,"Passed the test");

}
	}
}
