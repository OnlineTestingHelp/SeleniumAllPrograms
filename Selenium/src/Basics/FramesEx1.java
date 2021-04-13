package Basics;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Reusable.ReusableMethods;

public class FramesEx1 extends ReusableMethods{

	@Test(enabled=false)
	public void Frames1() {
		launch("https://jqueryui.com/autocomplete/", 10);
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='tags']")).sendKeys("Venkat");
		driver.switchTo().defaultContent();
	}
	
	@Test(enabled=false)
	public void Frames2() throws InterruptedException {
		launch("https://the-internet.herokuapp.com/frames", 10);
		driver.findElement(By.xpath("//a[text()='iFrame']")).click();
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.xpath("//body[@id='tinymce']")).clear();
		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Venkata Krishna");
		
		Thread.sleep(4000);
		driver.close();
	}
	
	
	@Test
	public void Frames3() {
		launch("https://the-internet.herokuapp.com/frames", 10);
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		
		//First -switch to top frame
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		String text = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
		System.out.println("Left frame text is "+ text);
		
		//Come out from frame
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-middle");
		text = driver.findElement(By.xpath("//div[@id='content']")).getText();
		System.out.println("Middle frame text is "+ text);
		
		//Right Frame
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-right");
		text = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
		System.out.println("Right frame text is "+ text);
		
		//Come out from all frames
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-bottom");
		text = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
		System.out.println("Bottom frame text is "+ text);
		driver.switchTo().defaultContent();
		
		
	}
}
