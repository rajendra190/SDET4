package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Validatinggiventext {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
  WebElement txt = driver.findElement(By.id("twotabsearchtextbox"));
		  txt.sendKeys("Remotes");
		  Thread.sleep(3000);
		String giventxt = txt.getAttribute("value");
		System.out.println(giventxt);
	}

}
