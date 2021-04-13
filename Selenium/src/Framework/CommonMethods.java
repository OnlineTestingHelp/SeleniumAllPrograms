package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class CommonMethods {
	
	WebDriver driver;
	
	public CommonMethods(WebDriver driver) {
		this.driver=driver;
	}

	public void enterUserName(By by, String UserName) {
		driver.findElement(by).sendKeys(UserName);
	}
	
	public void enterPassword(By by,String Password) {
		driver.findElement(by).sendKeys(Password);
	}
	
	public void clickSubmit(By by) {
		driver.findElement(by).click();
	}
}
