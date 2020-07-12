package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Read_Object {
	public Properties object_page() throws IOException{
		//Creating the File Object
		File src=new File("Object.properties");
		//Creating InputStream object to read data
		FileInputStream fis = new FileInputStream(src); 
		//Creating properties object
		Properties obj=new Properties();
		   try {
		    //Reading properties key/values in file
		    obj.load(fis);
		    // Close the InputStream
		    fis.close();
		    } catch (FileNotFoundException e) {
		     System.out.println(e.getMessage());   
		     
		    } catch (IOException e) {
		   System.out.println(e.getMessage());
		  }
		return obj;
	}
}
