package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicMethods1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium-Batch-58\\Soft&Jars\\chromedriver_win32\\chromedriver.exe");
		
		//Need to create the object for chrome
		WebDriver driver= new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.findElement(By.name("userName")).sendKeys("krishna");
//		driver.findElement(By.name("password")).sendKeys("krishna");
//		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		System.out.println("Register href attribute value is "+ driver.findElement(By.xpath("//a[text()='REGISTER']")).getAttribute("href"));
		
		
		//Button text
		System.out.println("Submit button text is "+driver.findElement(By.name("submit")).getAttribute("value"));

		driver.navigate().to("http://google.com/");
		System.out.println("Gmail link text is "+ driver.findElement(By.xpath("//a[text()='Gmail']")).getText());
	}

}
