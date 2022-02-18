package amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lenskart {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lenskart.com/");
		driver.findElement(By.xpath("//input[@placeholder='What are you looking for ']")).click();
	 Thread.sleep(2000);
		List<WebElement> search = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']/li"));
	    Thread.sleep(2000);
	   for (WebElement searchresult : search) {
	    String names=searchresult.getText();
	    	 	System.out.println(names);
			
		}
	
	}

}
