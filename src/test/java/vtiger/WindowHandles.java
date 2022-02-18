package vtiger;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://business.linkedin.com/marketing-solutions/conversion-tracking");
	
		driver.findElement(By.xpath("//a[contains(text(),'Cookie Policy')]")).click();
	    
		driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'User Agreement')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Accessibility')]")).click();
		
		
		       Set<String> windows = driver.getWindowHandles();
		       for(String s:windows) {
		    	 
		    	String g= driver.switchTo().window(s).getTitle();
                 
		    	if(g.equals("Accessibility")) {
		    		System.out.println(g);
		    		break;
		    	}
		       }
		    String k = driver.findElement(By.xpath("//h2[contains(text(),'Accessibility')]")).getText();
		   System.out.println(k);
	}

	}

