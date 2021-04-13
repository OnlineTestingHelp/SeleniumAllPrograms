package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium-Batch-58\\Soft&Jars\\chromedriver_win32\\chromedriver.exe");
		
		//Need to create the object for chrome
		WebDriver driver= new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("userName")).sendKeys("krishna");
		driver.findElement(By.name("password")).sendKeys("krishna");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		Thread.sleep(3000);
		
		boolean status = driver.findElement(By.xpath("//h3[text()='Login Successfully']")).isDisplayed();
		if(status) {
			System.out.println("User is logged in succesffully");
		}
		else {
			System.out.println("User is not logged in");
		}
		
		//title of the page
		System.out.println("Title of the page is "+ driver.getTitle());
		
		
		
		//Click on Register
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
		
		//Enter the data into firstname
		driver.findElement(By.name("firstName")).sendKeys("Venkat");
		
		Thread.sleep(3000);
		String firstname = driver.findElement(By.name("firstName")).getAttribute("value");
		System.out.println("Firstname text field value is "+ firstname);
		
		//Clear the text in text field
		Thread.sleep(2000);
		driver.findElement(By.name("firstName")).clear();
		
		//Fetch the button text
		String Submit = driver.findElement(By.name("submit")).getAttribute("value");
		System.out.println("submit button text is "+ Submit);
		
		
		
		
		driver.close();

	}

}

