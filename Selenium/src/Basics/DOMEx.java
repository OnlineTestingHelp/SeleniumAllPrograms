package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Reusable.ReusableMethods;

public class DOMEx extends ReusableMethods{

	
	@Test
	public void DOM() {
		launch("http://demo.guru99.com/test/newtours/",10);
		
		//Title of the page using DOM
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;","").toString();
		System.out.println("Title of the app is "+ title);
		
		//URL
		String Url = js.executeScript("return document.domain;", "").toString();
		System.out.println("Domain is "+ Url);
		
		//Identifying element using name
		WebElement eleUN = (WebElement) js.executeScript("return document.getElementsByName('userName')[0];");
		eleUN.sendKeys("Venkat");
		
		driver.navigate().to("https://jqueryui.com/autocomplete/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		
		WebElement eleId = (WebElement) js.executeScript("return document.getElementById('tags')");
		eleId.sendKeys("Krishna");
		
	}
}
