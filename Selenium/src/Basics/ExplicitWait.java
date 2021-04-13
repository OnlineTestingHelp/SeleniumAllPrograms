package Basics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWait {
	
	@Test
	public void explictwait() throws IOException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium-Batch-58\\Soft&Jars\\chromedriver_win32\\chromedriver.exe");
		
		//Need to create the object for chrome
		WebDriver driver= new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Take the screenshot
		File folder = new File("./src/screenshots");
		if(!folder.exists()) {
			folder.mkdir();
		}
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcfile, new File(".\\src\\screenshots\\file1.png"));
		
		
		
		//Wait for an element
//	
//		WebDriverWait wait = new WebDriverWait(driver,20);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("firstName"))));
		
		
		
		
	}

}
