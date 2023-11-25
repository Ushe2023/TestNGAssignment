package com.abc.assign2;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
@Listeners(MyListener12.class)
public class LoginCopy {
	ChromeDriver driver= new ChromeDriver();
	ExtentReports extentReport = new ExtentReports();
	
	@BeforeTest
	public void createReport() {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./TestNGAssigment/ReportTestngPass");
		extentReport.attachReporter(extentSparkReporter);
		
		ExtentSparkReporter extentSparkReporter2 = new ExtentSparkReporter("./TestNGAssigment/ReportTestngFail");
		extentReport.attachReporter(extentSparkReporter2);
		
		extentSparkReporter.filter().statusFilter().as(new Status[] {Status.PASS}).apply();
		extentSparkReporter2.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
	}
	
@AfterTest
	public void push() {
		extentReport.flush();
	}

//@Parameters("Username")
	@Test(dataProvider="Mydata", dataProviderClass= DataLogin.class)
	public void signIn(String Email,String Pwd) throws IOException, InterruptedException{
	
//	public void signIn(String Email) throws IOException, InterruptedException{
		
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	ExtentTest extentTest = extentReport.createTest("This is E-Commerce Website Report");
	extentTest.assignAuthor("Ushe");
	extentTest.assignDevice("Windows "+" Chrome");
	extentTest.assignCategory("Funtional Testing");
	
	driver.get("https://tutorialsninja.com/demo//");
	
	driver.manage().window().maximize();
//	Thread.sleep(3000);
	extentTest.log(Status.INFO,"Opened the Website");
	System.out.println("Opened the website");
	driver.findElement(By.xpath("//a[@title='My Account']")).click();
	WebElement Link= driver.findElement(By.xpath("//a[text()='Login']"));
	try {
	Link.click();
	}
	catch(StaleElementReferenceException e)
	{
		Thread.sleep(3000);
		
		WebElement Link1= driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a[text()='Login']"));
		
		Link1.click();
	}
	try {
	driver.findElement(By.id("input-email")).sendKeys(Email);
	extentTest.log(Status.PASS,"Email field is correctly identified");
	System.out.println("Email field is correctly identified");

	}
	catch(NoSuchElementException e) {
		extentTest.log(Status.FAIL,"Email ID is not identified information");
		System.out.println("Email ID is not identified information");
	}
	
	
	try {
	driver.findElement(By.id("input-password")).sendKeys(Pwd);
	extentTest.log(Status.PASS,"Password field is correctly identified");
	System.out.println("Password field is correctly identified");
	}
	catch(NoSuchElementException e) {
		extentTest.log(Status.FAIL,"Password Field is not identified information");
		System.out.println("Password Field is not identified information");
	}
	
	extentTest.log(Status.INFO,"Entered user and password information");
	System.out.println("Entered user and password information");
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	
	
	try {
		driver.findElement(By.xpath("//h2[text()='My Account']")).getText();
		
	File Image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File Destination= new File ("./ScreenshotLogin/LoggedSuccess.png");
	FileUtils.copyFile(Image, Destination);
	extentTest.log(Status.PASS,"Logged in Successfully");
	System.out.println("Logged in Successfully");
	driver.findElement(By.xpath("//a[@title='My Account']")).click();
	driver.findElement(By.xpath("//a[text()='Logout']")).click();
	extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/TestNGAssigment/ScreenshotLogin/LoggedSuccess.png", "Logged in Successfully");
	}
	
	catch(NoSuchElementException e)
	{
		File Image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination= new File ("./ScreenshotLogin/LoggedFail.png");
		FileUtils.copyFile(Image, Destination);
		extentTest.log(Status.FAIL,"Entered incorrect Credentials");
		System.out.println("Entered incorrect Credentials");
	
		extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/TestNGAssigment/ScreenshotLogin/LoggedFail.png", "Incorrect Credentials");
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	driver.quit();
}
}