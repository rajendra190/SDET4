package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004_NTWfilter {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		Thread.sleep(2000);
		Select sect=new Select(driver.findElement(By.xpath("//select[@name='viewname']")));
		sect.selectByVisibleText("New This Week");
		driver.findElement(By.xpath("//a[.='Create Filter']")).click();
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys("xem");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Actions aa = new Actions(driver);
		Thread.sleep(1000);
		WebElement path = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		aa.moveToElement(path).build().perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
	}

}
