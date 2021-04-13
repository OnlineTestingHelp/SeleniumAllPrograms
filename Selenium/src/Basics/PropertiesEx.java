package Basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import Reusable.ReusableMethods;

public class PropertiesEx extends ReusableMethods {

	@Test(enabled=false)
	public void properties() throws IOException {
		File file = new File("./src/env.properties");
		
		FileInputStream fis = new FileInputStream(file);
		Properties props = new Properties();
		props.load(fis);
		
		System.out.println("AppName value is "+ props.getProperty("AppName"));
		System.out.println("URL value is "+ props.getProperty("URL"));
		
		
	}
	
	@Test
	public void readprop() throws IOException {
		System.out.println(ReadProperty("AppName"));
		System.out.println(ReadProperty("URL"));
	}
}
