package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import Reusable.ReusableMethods;

public class ActionsEx extends ReusableMethods{

	@Test(enabled=false)
	public void Actions() throws InterruptedException {
		launch("https://the-internet.herokuapp.com/hovers",10);
		
		By user3 = By.xpath("(//div[@id='content']//img)[3]");
		By username = By.xpath("//h5[text()='name: user3']");
		
		WebElement user3ele = driver.findElement(user3);
		WebElement user3name = driver.findElement(username);
		
		Actions a = new Actions(driver);
		a.moveToElement(user3ele).build().perform();
		Thread.sleep(5000);
		
		//Get the user name
		String text = user3name.getText();
		System.out.println("text is "+ text);
		
	}
	
	@Test(enabled=false)
	public void ActionsInnerMenus() throws InterruptedException {
		launch("https://the-internet.herokuapp.com/jqueryui/menu",10);
		
		WebElement enabled = driver.findElement(By.xpath("//a[text()='Enabled']"));
		WebElement downloads = driver.findElement(By.xpath("//a[text()='Downloads']"));
		WebElement Excel = driver.findElement(By.xpath("//a[text()='Excel']"));
		
		Actions a =new Actions(driver);
		a.moveToElement(enabled).pause(2000).moveToElement(downloads).pause(2000).moveToElement(Excel).click().build().perform();
		
//		a.moveToElement(enabled).build().perform();
//		a.moveToElement(downloads).build().perform();
//		a.moveToElement(Excel).build().perform();

		driver.close();
	}
	
	@Test(enabled=false)
	public void ActionsDragAndDrop() throws InterruptedException {
		launch("https://jqueryui.com/droppable/",10);
		
		driver.switchTo().frame(0);
		WebElement itemtodrop = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement wheretodrop = driver.findElement(By.xpath("//div[@id='droppable']"));

		
		Actions a =new Actions(driver);
		a.dragAndDrop(itemtodrop, wheretodrop).build().perform();
	
	}
	
	@Test(enabled=false)
	public void ActionsDragAndDropBy() {
		launch("https://jqueryui.com/slider/",10);
		
		driver.switchTo().frame(0);
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
		
		Actions a =new Actions(driver);
		a.dragAndDropBy(slider, 300, 0).build().perform();
	}
	
	@Test(enabled=false)
	public void ActionsKeysEx() throws InterruptedException {
		launch("https://www.google.com/",10);
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@name='q']"));
		
		
		Actions a =new Actions(driver);
		a.sendKeys(searchbox, "Selenium Automation").build().perform();
		Thread.sleep(3000);
		a.sendKeys(Keys.DOWN,Keys.DOWN,Keys.DOWN,Keys.DOWN,Keys.ENTER).build().perform();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='q']")).click();
		a.keyDown(Keys.CONTROL).sendKeys("a").pause(3000).keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
	}
	
	@Test
	public void ActionsClickAndHold() throws InterruptedException {
		launch("https://jqueryui.com/selectable/",10);
		
		((RemoteWebDriver)driver).executeScript("window.scrollBy(0,200)", "");
		
		driver.switchTo().frame(0);
		List<WebElement> allitems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		
		
		Actions a =new Actions(driver);
		Thread.sleep(3000);
		a.clickAndHold(allitems.get(0)).pause(2000).moveToElement(allitems.get(5)).release().build().perform();
		
	}
}
