package data;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

   static  String path = "C:\\Users\\Amine\\eclipse-workspace\\taf\\src\\main\\java\\properties\\userdata.properties";
   public static Properties userdata = loadProperties(path);

	private static Properties loadProperties(String path) throws FileNotFoundException
	{
		Properties pro = new Properties();
		
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (IOException e) {
		System.out.println("error= "+e.getMessage());
			e.printStackTrace();
		}

		return pro;

	}


}
