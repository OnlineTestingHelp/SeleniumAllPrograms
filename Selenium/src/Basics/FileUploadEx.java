package Basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Reusable.ReusableMethods;

public class FileUploadEx extends ReusableMethods {

	
	@Test
	public void fileupload() throws AWTException, InterruptedException {
		launch("https://the-internet.herokuapp.com/upload",10);
		
		
		//Click on choose profile
		
		//Put the data into CLipboard
		String str = "C:\\Users\\lenovo\\Desktop\\FileUpload.txt";

		WebElement eleChooseFile = driver.findElement(By.id("file-upload"));
		eleChooseFile.sendKeys(str);
		
		Thread.sleep(2000);
		driver.findElement(By.id("file-submit")).click();
		
	}
	
	@Test(enabled=false)
	public void fileupload1() throws AWTException, InterruptedException {
		launch("https://ufile.io/",10);
		
		
		//Click on choose profile
		driver.findElement(By.xpath("//form[@id='upload-window']")).click();
		Thread.sleep(5000);
		//Put the data into CLipboard
		String str = "C:\\Users\\lenovo\\Desktop\\FileUpload.txt";
		StringSelection path = new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
		
		//Paste operation
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		
		Thread.sleep(3000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
}
