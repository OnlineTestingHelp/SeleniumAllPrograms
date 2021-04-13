package Basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import Reusable.ReusableMethods;

public class DimentionsEx extends ReusableMethods{

	@Test
	public void dimentions() {
		launch("https://the-internet.herokuapp.com/upload",10);
		
		System.out.println("getPosition:" + driver.manage().window().getPosition());
		System.out.println("getPosition: - X:" + driver.manage().window().getPosition().getX());
		System.out.println("getPosition: - Y" + driver.manage().window().getPosition().getY());
		
		System.out.println("getSize:" + driver.manage().window().getSize());
		System.out.println("getSize: - Width" + driver.manage().window().getSize().getWidth());
		System.out.println("getSize: - Height" + driver.manage().window().getSize().getHeight());
		
		//Set Position
		Point p= new Point(500,100);
		driver.manage().window().setPosition(p);
				
		//Set Size
		Dimension d = new Dimension(200, 300);
		driver.manage().window().setSize(d);
	}
}
