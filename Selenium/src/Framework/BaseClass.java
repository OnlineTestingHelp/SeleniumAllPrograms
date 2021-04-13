package Framework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Reusable.ReusableMethods;

public class BaseClass extends ReusableMethods {

	@Test
	public void login() throws IOException {
		String URL = ReadProperty("URL");
		String UserName = ReadProperty("UserName");
		String Password = ReadProperty("Password");
		
		launch(URL,10);
		By UserNam = By.id("txtUsername");
		By Passwor = By.id("txtPassword");
		By Submit = By.name("Submit");
		
		
		
		CommonMethods cm = new CommonMethods(driver);
		cm.enterUserName(UserNam, UserName);
		cm.enterPassword(Passwor, Password);
		cm.clickSubmit(Submit);
	}
	
}
