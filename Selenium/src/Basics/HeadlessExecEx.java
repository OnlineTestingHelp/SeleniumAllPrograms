package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import Reusable.ReusableMethods;

public class HeadlessExecEx{

	
	@Test
	public void headless() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium-Batch-58\\Soft&Jars\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		
		System.out.println("Chrome: Title of the google is "+ driver.getTitle());
	}
	
	@Test
	public void firefoxheadless() {
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium-Batch-58\\Soft&Jars\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://www.google.com/");
		
		System.out.println("Firefox: Title of the google is "+ driver.getTitle());
	}
}
