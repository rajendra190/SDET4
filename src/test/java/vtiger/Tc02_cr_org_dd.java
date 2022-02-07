package vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

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

public class Tc02_cr_org_dd {

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
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		FileInputStream fisex=new FileInputStream(IAutoconstants.excelpath);
		Workbook bis =WorkbookFactory.create(fisex);
		String s=bis.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
		
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(s);
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
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(s);
		Select sell=new Select(driver.findElement(By.id("bas_searchfield")));
		sell.selectByVisibleText("Organization Name");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(4000);
		String value=	driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		System.out.println(value);
		if(value.equals(s))
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

}}