package Basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Reusable.ReusableMethods;

public class WindowsEx extends ReusableMethods {

	@Test(enabled=false)
	public void windows() throws InterruptedException {
		launch("https://the-internet.herokuapp.com/windows",10);
		
		String mainwindow = driver.getWindowHandle();
		
		//Click on click here for opening the new windows
		for(int i=1;i<=5;i++) {
			driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		}
		
		//Get the total no of tabs opening by script
		List<String> allhandles = new ArrayList<String>(driver.getWindowHandles());
		
		//Dispaly no of tabs opening by scripts
		System.out.println("My handles size is "+ allhandles.size());
		
		for(int i=0;i<allhandles.size();i++) {
			
			String text = allhandles.get(i);
			if(!mainwindow.contains(text)) {
			
			driver.switchTo().window(allhandles.get(i));
			Thread.sleep(2000);
			driver.close();
			}
		}
		
	}
	
	@Test
	public void windowsIrctc() throws InterruptedException {
		launch("https://www.irctc.co.in/nget/train-search",10);
		
		By Okbtn= By.xpath("//button[text()='OK']");
		By buseslnk = By.xpath("//a[contains(text(),'BUSES')]");
		By flightslnk = By.xpath("//a[contains(text(),'FLIGHTS')]");
		By BusTickets = By.xpath("//a[@class='active']/span");	
		By Flightickets = By.xpath("//span[text()='Flights']");
		By FlightSignin = By.xpath("//button[text()='Sign In']");
		
		String mainwindow = driver.getWindowHandle();
		
		//Click on Ok Button
		driver.findElement(Okbtn).click();
		driver.findElement(buseslnk).click();
		driver.findElement(flightslnk).click();
		
		
		
		//Switch to buses window
		List<String> allhandles = new ArrayList<String>(driver.getWindowHandles());
		for(int i=0;i<allhandles.size();i++) {
			String text = allhandles.get(i);
			
			if(!mainwindow.contains(text)) {

					driver.switchTo().window(allhandles.get(i));
					
					String title =  driver.getTitle();
					
					if(title.contains("Bus")) {
						Thread.sleep(2000);
						System.out.println("Title is "+ driver.getTitle());
						
						driver.findElement(BusTickets).click();
					}
					else if(title.contains("Flight")) {
						Thread.sleep(2000);
						System.out.println("Title is "+ driver.getTitle());
						
						driver.findElement(FlightSignin).click();
					}


				}
		}
		
		driver.quit();
	}
}

