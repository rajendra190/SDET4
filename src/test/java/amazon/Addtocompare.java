package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Addtocompare {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//div[@class='xtXmba'and .='Mobiles']")).click();
		Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@src='https://rukminim1.flixcart.com/flap/240/240/image/f40c586fa2ac65af.jpg?q=90']")).click();
        
	}

}
