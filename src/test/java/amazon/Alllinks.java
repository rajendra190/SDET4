package amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alllinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		 List<WebElement> links = driver.findElements(By.tagName("a"));
		 System.out.println(links.size());
		 for(int i=0;i<links.size();i++) {
		String linknames=links.get(i).getAttribute("href");	
		System.out.println(linknames);
		 
			
		}

	}

}
