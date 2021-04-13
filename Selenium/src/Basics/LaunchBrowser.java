package Basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LaunchBrowser {

	@Test(priority=1, enabled=false)
	public void launchBrowser() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium-Batch-58\\Soft&Jars\\chromedriver_win32\\chromedriver.exe");
		
		//Need to create the object for chrome
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Venkata Krishna");
		
		Thread.sleep(3000);
		System.out.println("Title of the app "+ driver.getTitle());
		
		System.out.println("Search button existence "+ driver.findElement(By.name("btnK")).isDisplayed());
		
		
		//Total no of links in a page
		int links = driver.findElements(By.tagName("a")).size();
		System.out.println("Total no of links are "+ links);
		
		
		driver.close();
		
		
	}
	
	@Test(priority=2,enabled=false)
	public void dropdown() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium-Batch-58\\Soft&Jars\\chromedriver_win32\\chromedriver.exe");
		
		//Need to create the object for chrome
		WebDriver driver= new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
		
		//Select value from dropdown
		Select dd = new Select(driver.findElement(By.name("country")));
		dd.selectByIndex(5);
		Thread.sleep(2000);
		dd.selectByValue("CAYMAN ISLANDS");
		Thread.sleep(2000);
		dd.selectByVisibleText("ESTONIA");
		Thread.sleep(2000);
		
		System.out.println("------------------------------------------");
		
		//Get all the values from the dropdown
		List<WebElement> eles = dd.getOptions(); 
		for(int i=0;i<eles.size();i++) {
			System.out.println("Items are "+ eles.get(i).getText());
		}
		
		
		
		driver.close();
	}
	
	
	@Test(enabled=false)
	public void radiogroup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium-Batch-58\\Soft&Jars\\chromedriver_win32\\chromedriver.exe");
		
		//Need to create the object for chrome
		WebDriver driver= new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on Flightd
		driver.findElement(By.xpath("//a[text()='Flights']")).click();
		
		//Select the radio button
		WebElement ele = driver.findElement(By.xpath("//input[@name='tripType'][@value='oneway']"));
		ele.click();
		
		Thread.sleep(2000);
		
		//Verify whether is it selected or not
		Boolean status = ele.isSelected();
		System.out.println("Oneway is selected "+ status);
		
	}
	
	@Test
	public void radiobutton() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium-Batch-58\\Soft&Jars\\chromedriver_win32\\chromedriver.exe");
		
		//Need to create the object for chrome
		WebDriver driver= new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//Click on Flightd
		driver.findElement(By.xpath("//a[text()='Flights']")).click();
		
		List<WebElement> radio = driver.findElements(By.xpath("//input[@name='servClass']"));
		radio.get(2).click();
		
		
	}
	
	
	
	
}
