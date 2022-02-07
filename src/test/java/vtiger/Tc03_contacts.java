package vtiger;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.IAutoconstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc03_contacts {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(IAutoconstants.profilepath);
		Properties prop = new Properties();
		prop.load(fis);
       WebDriver driver;
       String Browser=prop.getProperty("Browser");
       if(Browser.equals("Chrome")) {
    	   WebDriverManager.chromedriver().setup();
    	   driver=new ChromeDriver();
    	   
       }
       
       else  if(Browser.equals("Firefox")) {
    	   driver=new FirefoxDriver();
    	   WebDriverManager.firefoxdriver().setup();
	}
       else  if(Browser.equals("Edge")) {
    	   driver=new EdgeDriver();
    	   WebDriverManager.firefoxdriver().setup();
}
       else  {
    	   driver=new FirefoxDriver();
    	   WebDriverManager.firefoxdriver().setup();
	}
       driver.manage().window().maximize();
       driver .get(prop.getProperty("URL"));
		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("UN"));
		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("PW"));
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		Select sel=new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
		sel.selectByIndex(1);
		Thread.sleep(2000);
//		String firstname = "Ram";
//		String lastname="Prasad";
		FileInputStream bis = new FileInputStream(IAutoconstants.excelpath);
		Workbook bk= WorkbookFactory.create(bis);
		String s=bk.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
		

		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys(s);
		String f=bk.getSheet("Sheet1").getRow(4).getCell(0).getStringCellValue();
		driver.findElement(By.name("lastname")).sendKeys(f);
		driver.findElement(By.xpath("//input[@name='account_id']/../img")).click();
		Set<String> ven = driver.getWindowHandles();
		Iterator<String> it=ven.iterator();
		String parent=it.next();
		String child=it.next();
		Thread.sleep(1000);
		driver.switchTo().window(child);
		Thread.sleep(2000);
		String g=bk.getSheet("Sheet1").getRow(6).getCell(0).getStringCellValue();
		Thread.sleep(2000);
		driver.findElement(By.id("search_txt")).sendKeys(g);
	
		driver.findElement(By.xpath("//input[@name='search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='1']")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(s);
		Select sl=new Select(driver.findElement(By.id("bas_searchfield")));
		sl.selectByValue("firstname");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		if(s.equals("sjdsdj"))
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
