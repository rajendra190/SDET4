package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007_Phone {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		Thread.sleep(2000);
		Select sel = new Select(driver.findElement(By.id("bas_searchfield")));
		sel.selectByVisibleText("Phone");
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		String s = driver.findElement(By.xpath("//td[.=1234567890 ]")).getText();
		if(s.equals("1234567890")) {
			System.out.println("Tc pass");
		}
		else
			System.out.println("Tc fail");
		
	}
}
