package Basics;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Reusable.ReusableMethods;

public class FileUploadEx1 extends ReusableMethods {

	@Test(enabled=false)
	public void FileUpload() throws InterruptedException, IOException {
		launch("https://ufile.io/",10);
		
		
		//Click on choose profile
		driver.findElement(By.xpath("//form[@id='upload-window']")).click();
		Thread.sleep(5000);
		
		//Call to the AUTO IT exe file
		Runtime.getRuntime().exec("C:\\Users\\lenovo\\Desktop\\AutoIT\\FileUpload1.exe");
	}
	
	@Test
	public void FileUpload1() throws InterruptedException, IOException {
		launch("https://ufile.io/",10);
		
		
		//Click on choose profile
		driver.findElement(By.xpath("//form[@id='upload-window']")).click();
		Thread.sleep(5000);
		
		//Call to the AUTO IT exe file
		Runtime.getRuntime().exec("C:\\Users\\lenovo\\Desktop\\AutoIT\\FileUpload2.exe C:\\Users\\lenovo\\Desktop\\FileUpload.txt");
	}
}
