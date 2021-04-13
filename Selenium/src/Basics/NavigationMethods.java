package Basics;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Reusable.ReusableMethods;

public class NavigationMethods extends ReusableMethods {
	
	@Test
	public void navigation() throws InterruptedException {
		launch("https://www.google.com/",10);
		
		//Click on About
		driver.findElement(By.xpath("//a[text()='About']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
		
		driver.navigate().back();
		Thread.sleep(3000);
		
		driver.navigate().forward();
		Thread.sleep(3000);
		
		driver.navigate().refresh();

	}
}
