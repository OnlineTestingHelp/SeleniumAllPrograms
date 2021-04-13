package Basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

public class NotepadEx {
	
	@Test
	public void Notepad() throws IOException, InterruptedException, AWTException {
		
		StringSelection text = new StringSelection("We are all intelligent people");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(text, null);
		
		Runtime.getRuntime().exec("notepad.exe");
		
		Thread.sleep(3000);
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(3000);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(3000);
		
		File file = new File("C:\\Users\\lenovo\\Desktop\\FileUpload3.txt");
		String filePath = file.getAbsolutePath();
		System.out.println("Absolute path is "+ filePath);
		
		StringSelection Path = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Path, null);
		
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(3000);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_ALT);
		
		
		
	}

}
