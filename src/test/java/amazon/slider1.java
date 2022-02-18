package amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class slider1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver() ;

		driver.get("http://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		WebElement slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider,300, 00).build().perform();






	}
}
