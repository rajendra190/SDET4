package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC008_Website {

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
		sel.selectByVisibleText("Website");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("www.aha.com");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(4000);
		String s = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[5]")).getText();
		if(s.equals("www.aha.com")) {
			System.out.println("Tc pass");
		}
		else
			System.out.println("Tc fail");
		Thread.sleep(2000);
		Actions aa = new Actions(driver);
		Thread.sleep(1000);
		WebElement path = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		aa.moveToElement(path).build().perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
		
		
	}

	
}
