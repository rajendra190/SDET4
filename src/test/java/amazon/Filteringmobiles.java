package amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Filteringmobiles {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Mobile Phones");
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Oppo']")).click();
	 	List<WebElement> mobnames = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		for(int i=0;i<=mobnames.size();i++) {
			String category = mobnames.get(i).getText().toLowerCase();

			System.out.println(category);

			if(category.contains("oppo")){
				System.out.println("Tc Pass");
			}
			else
				System.out.println("Tc fail");
			driver.close();

		}

	}





}


