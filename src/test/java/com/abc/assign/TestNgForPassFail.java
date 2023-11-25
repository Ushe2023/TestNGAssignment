package com.abc.assign;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

import org.testng.annotations.Parameters;

public class TestNgForPassFail {
	ExtentReports extentReports;
//	=new ExtentReports();
	
	
	@BeforeTest
	public void createReport() {
		extentReports=new ExtentReports();
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./MyReport1/AssignPassFail");
		extentReports.attachReporter(extentSparkReporter);
		
	}
	@AfterTest
	public void push() {
		extentReports.flush();
	}
	
	@Parameters({"user-name","password"})
	
	@Test//(dataProvider = "TheData", dataProviderClass = DataForPassAndFail.class)
//	@Test
	public class AddItem {
		public void ValidCredentials(String username, String Password) throws InterruptedException, IOException {
			ChromeDriver driver = new ChromeDriver();
			
			System.out.println("Opening the browser");
			ExtentTest extentTest = extentReports.createTest("This is my e-commerce report");
			extentTest.assignAuthor("Ushe");
			extentTest.assignDevice("Windows"+"Chrome");
			extentTest.assignCategory("Functional Test");
			
			extentTest.log(Status.INFO,"Logging to the Website");
			driver.get("https://www.saucedemo.com");
			driver.findElement(By.id("user-name")).sendKeys(username);
			extentTest.log(Status.INFO,"UserName Entered");
			
			try {
				driver.findElement(By.id("password")).sendKeys(Password);
				extentTest.log(Status.INFO,"Password Entered");
				driver.findElement(By.id("login-button")).click();
				
			}catch(NoSuchElementException e) {
				extentTest.log(Status.FAIL,"Password ID is incorrect");
				File Image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File Destination= new File("./Screenshot1/Fail.png");
				FileUtils.copyFile(Image, Destination);
				extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/TestNGAssigment/Screenshot1/Fail.png", "Password ID is incorrect");
				
			}
			
			
//			driver.findElement(By.id(id)).sendKeys(Password);
//			extentTest.log(Status.INFO,"Password Entered");
//			driver.findElement(By.id("login-button")).click();
	Thread.sleep(3000);
			
			try {
				driver.findElement(By.xpath("//div[@class='app_logo']"));
				extentTest.log(Status.INFO,"Logged in Successfully");
				System.out.println("Logged in");
			}catch(NoSuchElementException e){
				File Image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File Destination= new File("./Screenshot1/Fail1.png");
				FileUtils.copyFile(Image, Destination);
				extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/TestNGAssigment/Screenshot1/Fail1.png", "Incorrect Credentials");
				
				extentTest.log(Status.FAIL,"Entered Incorrect Credentials");
				
			}
			
			
			driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
			extentTest.log(Status.INFO,"Selected the item");
			driver.findElement(By.id("shopping_cart_container")).click();
			
			System.out.println("Item added");
			File Image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File Destination= new File("./Screenshot1/Pass.png");
			FileUtils.copyFile(Image, Destination);
			
			extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/TestNGAssigment/Screenshot1/Pass.png", "Item Present");
			driver.close();
			extentTest.log(Status.INFO,"Passed the test");

}
	}
}
