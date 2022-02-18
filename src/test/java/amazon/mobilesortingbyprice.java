package amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mobilesortingbyprice {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Mobile phones under 20000",Keys.ENTER);
       
	   List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        for(int i=0;i<prices.size();i++) {
        	 String price = prices.get(i).getText();
        	String[] pri= price.split(",");
        	String pr=pri[0]+pri[1];
        	int p=Integer.parseInt(pr);
        	
        	if(p<20000) {
        		System.out.println("price: "+p);
        		System.out.println("Tc pass");
        		
        	}
        		else
        		{
        			
        		}
        		
        	}
        }
        
       
	
	
	
	
	}


