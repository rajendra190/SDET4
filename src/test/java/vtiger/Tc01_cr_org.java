package vtiger;

import java.io.FileInputStream;

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



public class Tc01_cr_org {

	public static void main(String[] args) throws Exception {
		FileInputStream Fis = new FileInputStream(IAutoconstants.profilepath);
		Properties prop = new Properties();
		prop.load(Fis);
		String Value = prop.getProperty("URL");
		System.out.println(Value);


		WebDriver driver;
		String Browser = prop.getProperty("Browser");
		if(Browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		else if(Browser.equalsIgnoreCase("Firefox")){
			driver= new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
		}
		else if(Browser.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
			WebDriverManager.edgedriver().setup();
		}
		else{
			driver=new FirefoxDriver();
		}
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(prop.getProperty("UN"));
		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("PW"));
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		FileInputStream  fisexcel = new FileInputStream(IAutoconstants.excelpath);
		Workbook bis=WorkbookFactory.create(fisexcel);
		
		String s=bis.getSheet("Sheet2").getRow(3).getCell(0).getStringCellValue();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(s);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Organizations']")).click();


		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(s);
		Select sele = new Select(driver.findElement(By.xpath("//select[@id='bas_searchfield']")));
		sele.selectByVisibleText("Organization Name");
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(2000);
		String sen = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		
		System.out.println(sen);
	
		if(sen.equals(s))
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





