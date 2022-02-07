package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005_login_ivaliddata {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://localhost:8888/");
	 driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	 driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("amin");
	driver.findElement(By.id("submitButton")).click();
	Thread.sleep(2000);
	 String ss = driver.findElement(By.xpath("//div[@class='errorMessage']")).getText();
	 Thread.sleep(2000);
	if(ss.equals("You must specify a valid username and password.")) {
		System.out.println("Tcpass");
	}
	else {
		System.out.println("Tc fail");
	}
         driver.close();
}
}