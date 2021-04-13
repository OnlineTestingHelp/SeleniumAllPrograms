package Basics;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Reusable.ReusableMethods;

public class AlertsEx extends ReusableMethods {
	
	@Test
	public void alerts() throws InterruptedException {
		launch("https://the-internet.herokuapp.com/javascript_alerts",10);
		
		//First alert having OK button
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(3000);
		//Get the alert text
		String text = driver.switchTo().alert().getText();
		System.out.println("Alert text is "+ text);
		
		//Click on accept
		driver.switchTo().alert().accept();
		String alertmsg=driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']")).getText();
		System.out.println("Alert msg is "+ alertmsg);
		//-------------------------------------------------
		//Second alert having ok and cancel buttons
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		//Get the alert text
		text = driver.switchTo().alert().getText();
		System.out.println("Alert text is "+ text);
		
		//Click on accept
		driver.switchTo().alert().dismiss();
		alertmsg=driver.findElement(By.xpath("//p[text()='You clicked: Cancel']")).getText();
		System.out.println("Alert msg is "+ alertmsg);
		
		//Third alert having text field to enter data along with ok and cancel buttons
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		//Get the alert text
		text = driver.switchTo().alert().getText();
		System.out.println("Alert text is "+ text);
		
		//Enter data into alert
		String name="Venkata Krishna";
		driver.switchTo().alert().sendKeys(name);
		driver.switchTo().alert().accept();
		
		//Verify msg
		////p[contains(text(),'"You entered: "+ name +"')]
		//"You entered: "+ name
		text = driver.findElement(By.xpath("//p[contains(text(),'You entered: "+ name +"')]")).getText();
		
		if(text.contains(name)) {
			System.out.println("Entered text is updated successfuly");
		}
		
		
		
		
	}
	

}
