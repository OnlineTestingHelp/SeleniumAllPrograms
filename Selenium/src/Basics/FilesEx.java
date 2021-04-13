package Basics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.annotations.Test;

public class FilesEx {
	
	@Test
	public void file() throws IOException {
		File file = new File("./src/Test.txt");
		
		if(!file.exists()) {
			boolean result = file.createNewFile();
			System.out.println("File is created: "+result);
		}

		
		FileOutputStream fos = new FileOutputStream(file,true);
		
		String str = "We all are hard working people\n";
		byte[] b=str.getBytes();
		
		fos.write(b);
		fos.close();
		
		file.delete();
		
	}

}
