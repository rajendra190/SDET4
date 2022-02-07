package vtiger;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TC003_Contacts {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		Select sel=new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
		sel.selectByIndex(1);
		Thread.sleep(2000);
		String firstname = "Raj";
		String lastname="Prasad";

		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='account_id']/../img")).click();
		Set<String> ven = driver.getWindowHandles();
		Iterator<String> it=ven.iterator();
		String parent=it.next();
		String child=it.next();
		Thread.sleep(1000);
		driver.switchTo().window(child);
		Thread.sleep(2000);

		driver.findElement(By.id("search_txt")).sendKeys("Ravi");
//		Select sss = new Select(driver.findElement(By.xpath("//input[@name='search_field']")));
//		sss.selectByVisibleText("Organization Name");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[@id='1']")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(firstname);
		Select sl=new Select(driver.findElement(By.id("bas_searchfield")));
		sl.selectByValue("firstname");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();

		Actions aa = new Actions(driver);
		WebElement ss=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		aa.moveToElement(ss).build().perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.close();



	}

}
