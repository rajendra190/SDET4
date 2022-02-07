package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TC001_CreateOrgnization {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("C========");
		 driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//a[.='Organizations']")).click();
		 Thread.sleep(2000);
		 
			driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("C========");
			 Select sele = new Select(driver.findElement(By.xpath("//select[@id='bas_searchfield']")));
			 sele.selectByVisibleText("Organization Name");
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@name='submit']")).click();
			 String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
			 if(value.equals("C========"))
			 {
				 System.out.println("Tc pass");
			 }
			 else {
				 System.out.println("Tc fail");
			 }
		
		Actions action = new Actions(driver);
		WebElement path = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		action.moveToElement(path).build().perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		 
		 
		 
		 
	}

}
