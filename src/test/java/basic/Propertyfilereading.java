package basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertyfilereading {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\data\\Documents\\property.txt");
		Properties prop = new Properties();
         prop.load(fis);
         String s1=prop.getProperty("Browser");
         String s2=prop.getProperty("Url");
         String s3=prop.getProperty("username");
         String s4=prop.getProperty("password");
         System.out.println(s1);
         System.out.println(s2);
         System.out.println(s3);
         System.out.println(s4 );
	}

}
