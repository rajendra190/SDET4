package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_CreateOrg_dd {



	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver .get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		String orgname ="S6";
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		WebElement industrydd =driver.findElement(By.xpath("//select[@name='industry']"));
		Select select = new Select(industrydd);
		select.selectByValue("Hospitality");
		Thread.sleep(3000);
		WebElement ratingdd=driver.findElement(By.xpath("//select[@name='rating']"));
		Select selet = new Select(ratingdd);
		selet.selectByIndex(2);
		WebElement typedd= driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select sel= new Select(typedd);
		sel.selectByVisibleText("Integrator");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);
		Select sell=new Select(driver.findElement(By.id("bas_searchfield")));
		sell.selectByVisibleText("Organization Name");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(4000);
		String value=	driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		System.out.println(value);
		if(value.equals(orgname))
		{
			System.out.println("Tc pass");
		}
		else {
			System.out.println("Tc fail");
		}
		Actions aa = new Actions(driver);
		WebElement ss=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		aa.moveToElement(ss).build().perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.close();




	}

}
