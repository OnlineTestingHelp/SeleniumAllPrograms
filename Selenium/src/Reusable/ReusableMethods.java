package Reusable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReusableMethods {
	public WebDriver driver;
	
	public void launch(String URL, int time) {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium-Batch-58\\Soft&Jars\\chromedriver_win32\\chromedriver.exe");
		
		//Need to create the object for chrome
		driver= new ChromeDriver();
		driver.get(URL);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public String ReadProperty(String KeyName) throws IOException {
		File file = new File("./src/env.properties");
		
		FileInputStream fis = new FileInputStream(file);
		Properties props = new Properties();
		props.load(fis);
		
		return props.getProperty(KeyName);
	}
	

}
