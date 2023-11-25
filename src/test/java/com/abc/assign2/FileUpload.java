//created on nov-6th for integrating desktop application with selenium

package com.abc.assign2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FileUpload {
@Test
	public void open() throws IOException {
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		WebElement file = driver.findElement(By.id("file-upload"));
		
		Actions a = new Actions(driver);
		a.moveToElement(file).click().perform();
		
//		exec(C:\\Users\\Chukki\\Desktop\\html\\fileupload.exe C:\Users\Chukki\image.png)
		
		Runtime.getRuntime().exec("C:\\Users\\Chukki\\Desktop\\html\\fileupload.exe"+ " "+"C:\\Users\\Chukki\\Hello.txt");
		
	}

}