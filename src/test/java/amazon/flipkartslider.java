package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkartslider {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement electronics = driver.findElement(By.xpath("//img[@alt='Electronics']"));
		Actions action = new Actions(driver);
		action.moveToElement(electronics).build().perform();
		driver.findElement(By.xpath("//a[.='Health & Personal Care']")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//span[.='Price']"));
//		Thread.sleep(5000);
		WebElement slider = driver.findElement(By.xpath("//div[@class='_31Kbhn _28DFQy']"));
       action.dragAndDropBy(slider,50,00).build().perform();
       Thread.sleep(2000);
       WebElement slider1 = driver.findElement(By.xpath("//div[@class='_31Kbhn WC_zGJ']"));
       action.dragAndDropBy(slider1,-40,00).build().perform();
	
	}

}
