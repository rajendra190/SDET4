package amazon;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class linkverification {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		 List<WebElement> links = driver.findElements(By.tagName("a"));
		 System.out.println(links.size());
		 for(int i=0;i<links.size();i++) 
		 {
		String linknames=links.get(i).getAttribute("href");	
		System.out.println(linknames);
		verifyLinkActive(linknames);
		 
		 }
		}

	

	public static void verifyLinkActive(String linkurl)	{
	
	
		try {
			URL url =new URL(linkurl);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setConnectTimeout(3000);
			urlconnection.connect();
			if(urlconnection.getResponseCode()==200) {
				System.out.println(urlconnection.getResponseMessage());
			}
			else if(urlconnection.getResponseCode()==urlconnection.HTTP_NOT_FOUND) {
				System.out.println(urlconnection.getResponseMessage());
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	

	
	}

}