package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableEx {
	
	@Test
	public void webtable() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium-Batch-58\\Soft&Jars\\chromedriver_win32\\chromedriver.exe");
		
		//Need to create the object for chrome
		WebDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/tables");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Row count
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Rows count is "+ rows);
		
		//Column count
		int cols = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();
		System.out.println("Columns count is "+ cols);
		
		//Get the data from each row and each column
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<cols;j++) {
				String text = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
				System.out.println("row: "+ i +" Column: "+ j +" value: "+ text);
			}
		}
		
		
		
		
		
	}

}
