package Basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectValueFromDropdown {

	public static void main(String[] args) throws InterruptedException {
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

}
