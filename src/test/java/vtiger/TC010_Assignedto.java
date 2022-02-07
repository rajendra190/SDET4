package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC010_Assignedto {

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
		sel.selectByVisibleText("Assigned To");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("Team Selling");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(4000);
		String s = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[7]")).getText();
		if(s.equals("Team Selling")) {
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
