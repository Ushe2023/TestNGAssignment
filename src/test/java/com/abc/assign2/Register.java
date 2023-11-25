package com.abc.assign2;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
@Listeners(MyListener12.class)
public class Register {
	ChromeDriver driver = new ChromeDriver();
	
	ExtentReports extentReports = new ExtentReports(); ;
	
	public void createReport(){
//		extentReports 
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./TestNGAssignment/Register");
		extentReports.attachReporter(extentSparkReporter);
	}
	public void push()
	{
		extentReports.flush();
	}
	@Parameters({"Username","Lastname","EmailID"})
	@Test
	public void details(String Username,String Lastname,String EMail) throws IOException
	
//	public void details() throws IOException
	
	{
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ExtentTest extentTest= extentReports.createTest("This is Registering report");
		extentTest.assignAuthor("Ushe");
		extentTest.assignDevice("WindowsXP"+"Chrome");
		extentTest.assignCategory("Functional Testing");
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Username");
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Lastname");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("EmailID");
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("23456789012");
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("23456789012");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Welcome@123");
		driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("Welcome@123");
		extentTest.log(Status.INFO,"Entered all the details");
		
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String message;
		try{
			message =	driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
			if(message.equals("Your Account Has Been Created!")) {
				System.out.println(message);
				
				File Image= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File Destination = new File ("./ScreenshotLogin/RegisteredPass.png");
				FileUtils.copyFile(Image, Destination);
				extentTest.log(Status.PASS,"The Account is successfully created");
				System.out.println("Account created");
				extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/TestNGAssigment/ScreenshotLogin/RegisteredPass.png", " Account Created");
			}
		}catch(NoSuchElementException e) {
			
			File Image= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File Destination = new File ("./ScreenshotLogin/RegisteredFail.png");
			FileUtils.copyFile(Image, Destination);
			
			extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/TestNGAssigment/ScreenshotLogin/RegisteredFail.png", " Account Not Created");
		
			extentTest.log(Status.FAIL,"Please check the details entered.");
			System.out.println("Account is not created");
			
		
	}
	

	}}
