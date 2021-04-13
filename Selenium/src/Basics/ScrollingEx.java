package Basics;

import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import Reusable.ReusableMethods;

public class ScrollingEx extends ReusableMethods{

	@Test
	public void scroling() throws InterruptedException {
		launch("http://amazon.in/",10);
		
		//Scrolling down
		for(int i=1;i<=10;i++) {
			((RemoteWebDriver)driver).executeScript("window.scrollBy(0,200)", "");
			Thread.sleep(1000);
		}
		for(int i=1;i<=10;i++) {
			((RemoteWebDriver)driver).executeScript("window.scrollBy(0,-200)", "");
			Thread.sleep(1000);
		}
		
		
	}
}
